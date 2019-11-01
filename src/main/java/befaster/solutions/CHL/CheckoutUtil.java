package befaster.solutions.CHL;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class CheckoutUtil {


    private PriceService priceService = new PriceService();
    private OfferService offerService = new OfferService();
    private MathUtil mathUtil = new MathUtil();


    public Integer getTotalPrice(String skus) {
        Map<String, Long> itemWiseCount = Arrays.asList(skus.split("")).stream().collect(groupingBy(Function.identity(), counting()));
        Integer grandTotal = 0;
        try {
            Map<String, Long> refinedItemWiseCount = applyBuyGetOffer(itemWiseCount);

            grandTotal = refinedItemWiseCount.entrySet().stream()
                    .mapToInt(entry -> calculateTotalForSku(entry.getKey(), refinedItemWiseCount.get(entry.getKey()).intValue())).sum();
        } catch (Exception e) {
            return -1;
        }
        return grandTotal;
    }

    private Map<String, Long> applyBuyGetOffer(Map<String, Long> originalOrder) {
        Map<String, Long> refinedItemWiseCount = originalOrder;
        for (BuyGetOffer buyGetOffer : offerService.getAllBuyGetOffers()) {
            String buySku = buyGetOffer.getBuySku();
            Integer buyCount = buyGetOffer.getBuyCount();
            String freeSku = buyGetOffer.getFreeSku();
            Integer freeCount = buyGetOffer.getFreeCount();
            if (originalOrder.containsKey(buySku) && originalOrder.containsKey(freeSku) && originalOrder.get(buySku) >= buyCount) {
                if (buySku.equals(freeSku)) {
                    refinedItemWiseCount.put((buySku,
                            getBillableCountForSameSku(originalOrder.get(buySku).intValue(), buyCount, freeCount).longValue()
                    );
                } else {
                    Integer quotient = mathUtil
                            .getResult(refinedItemWiseCount.get(buySku).intValue(), buyGetOffer.getBuyCount())
                            .getQuotient();
                    originalOrder.put(freeSku, originalOrder.get(freeSku) - (quotient * freeCount));
                }
            }
        }
        return refinedItemWiseCount;
    }

    private Integer getBillableCountForSameSku(Integer inCart, Integer buyCount, Integer freeCount) {
        Integer toBill = 0, toProcess = inCart;
        while (true) {
            if (toProcess > buyCount) {
                toBill += buyCount;
                toProcess = toProcess - buyCount - freeCount;
            } else {
                toBill += toProcess;
                break;
            }
        }
        return toBill;
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


//    Map<String, Integer> removeFreeItems(Map<String, Integer> itemWiseCount) {
//        Map<String, Integer> refinedItemWiseCount = itemWiseCount;
//
//        Map<String, Integer> freeItems = offerService.getFreeItems(itemWiseCount);
//
//        for (String thisFreeItemSku : freeItems.keySet()) {
//            if (refinedItemWiseCount.containsKey(thisFreeItemSku)) {
//                Integer currentCount = refinedItemWiseCount.get(thisFreeItemSku);
//                Integer offerCount = freeItems.get(thisFreeItemSku);
//                Integer toRemove = 0;
//
//                System.out.println("******");
//                System.out.println(thisFreeItemSku + " " + currentCount + " " + offerCount);
//
//                if (currentCount % offerCount == 0)
//                    toRemove = currentCount - freeItems.get(thisFreeItemSku) + 1;
//                else
//                    toRemove = currentCount - freeItems.get(thisFreeItemSku);
//
//                System.out.println("toRemove= " + toRemove);
//                if (currentCount.equals(offerCount)) toRemove = 0;
//                System.out.println("toRemove= " + toRemove);
//                System.out.println("Math.max(0, toRemove)= " + Math.max(0, toRemove));
//
//
//                refinedItemWiseCount.put(thisFreeItemSku, Math.max(0, toRemove));
//            }
//        }
//        return refinedItemWiseCount.entrySet().stream().filter(item -> item.getValue() > 0)
//                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
//    }

}

