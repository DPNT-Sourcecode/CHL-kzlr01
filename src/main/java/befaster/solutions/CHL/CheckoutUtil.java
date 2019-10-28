package befaster.solutions.CHL;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CheckoutUtil {


    private PriceService priceService = new PriceService();
    private OfferService offerService = new OfferService();
    private MathUtil mathUtil = new MathUtil();


    public Integer getTotalPrice(String skus) {
        Integer grandTotal = 0;
        try {
            Map<String, Integer> refinedItemWiseCount = removeFreeItems(getSkuCountMap(skus));
            for (String thisSku : refinedItemWiseCount.keySet()) {
                grandTotal += calculateTotalForSku(thisSku, refinedItemWiseCount.get(thisSku));
            }
        } catch (Exception e) {
            return -1;
        }
        return grandTotal;
    }


    private Integer calculateTotalForSku(String thisSku, Integer count) {
        Integer total = 0;
        Map<String, Integer> priceList = priceService.getPriceList();
        List<CountOffer> countOffers = offerService.getCountOffersFor(thisSku);
        Integer currentReminder = count;
        for (CountOffer offer : countOffers) {
            if (currentReminder >= offer.getOfferCount()) {
                Result result = mathUtil.getResult(currentReminder, offer.getOfferCount());
                total += (result.getQuotient() * offer.getOfferPrice());
                currentReminder = result.getReminder();
            }
        }
        total += currentReminder * priceList.get(thisSku);
        return total;
    }


    Map<String, Integer> removeFreeItems(Map<String, Integer> itemWiseCount) {
        Map<String, Integer> refinedItemWiseCount = itemWiseCount;

        Map<String, Integer> freeItems = offerService.getFreeItems(itemWiseCount);

        for (String thisFreeItemSku : freeItems.keySet()) {
            if (refinedItemWiseCount.containsKey(thisFreeItemSku)) {
                Integer currentCount = refinedItemWiseCount.get(thisFreeItemSku);
                Integer offerCount = freeItems.get(thisFreeItemSku);
                Integer toRemove = currentCount - freeItems.get(thisFreeItemSku);

                Integer finalValue =0;
                System.out.println(currentCount);
                System.out.println(offerCount);
                System.out.println(toRemove);

                if(currentCount % offerCount == 0)
                    finalValue = Math.max(0, toRemove) ;
                else
                    finalValue = Math.max(0, toRemove) +1;

                refinedItemWiseCount.put(thisFreeItemSku, finalValue );
            }
        }
        return refinedItemWiseCount.entrySet().stream().filter(item -> item.getValue() > 0)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }


    private Map<String, Integer> getSkuCountMap(String skus) {
        Map<String, Integer> result = new HashMap<>();

        String[] items = skus.split("");
        //A,B,C,D,A
        for (String thisSku : items) {
            if (result.containsKey(thisSku)) {
                result.put(thisSku, result.get(thisSku) + 1);
            } else {
                result.put(thisSku, 1);
            }
        }
        return result;

    }


}

