package befaster.solutions.CHL;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class CheckoutUtil {


    private PriceService priceService = new PriceService();
    private OfferService offerService = new OfferService();
    private MathUtil mathUtil = new MathUtil();


    public Integer getTotalPrice(String skus) {

        Integer grandTotal = 0;

        Map<String, Integer> priceList = priceService.getPriceList();

        Map<String, Integer> refinedItemWiseCount = removeFreeItems(getSkuCountMap(skus));

        for (String thisSku : refinedItemWiseCount.keySet()) {

            List<CountOffer> countOffers = offerService.getCountOffersFor(thisSku);

            Integer thisLineValue = 0;

            if (!countOffers.isEmpty()) {

                for (CountOffer countOffer : countOffers) {
                    CountOffer thisCountOffer = maybeOffer.get();
                    Result result = mathUtil.getResult(itemWiseCount.get(thisSku), thisCountOffer.getOfferCount());
                    thisLineValue = (result.getOfferCount() * thisCountOffer.getOfferPrice()) + (result.getRemainder() * priceList.get(thisSku));

                }

                if (priceList.containsKey(thisSku)) {
                    thisLineValue = itemWiseCount.get(thisSku) * priceList.get(thisSku);
                } else {
                    return -1;
                }

            } else {
                if (priceList.containsKey(thisSku)) {
                    thisLineValue = itemWiseCount.get(thisSku) * priceList.get(thisSku);
                } else {
                    return -1;
                }
            }

            grandTotal = grandTotal + thisLineValue;
        }

        return grandTotal;
    }


    Map<String, Integer> removeFreeItems(Map<String, Integer> itemWiseCount) {
        Map<String, Integer> refinedItemWiseCount = itemWiseCount;

        Map<String, Integer> freeItems = offerService.getFreeItems(itemWiseCount);

        for (String thisFreeItemSku : freeItems.keySet()) {
            if (refinedItemWiseCount.containsKey(thisFreeItemSku)) {
                Integer currentCount = refinedItemWiseCount.get(thisFreeItemSku);
                Integer toRemove = currentCount - freeItems.get(thisFreeItemSku);
                refinedItemWiseCount.put(thisFreeItemSku, Math.max(0, toRemove));
            }
        }
        return refinedItemWiseCount.entrySet().stream().filter(item -> item.getValue() > 0)
                .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue));
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



