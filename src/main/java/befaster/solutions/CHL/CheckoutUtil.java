package befaster.solutions.CHL;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class CheckoutUtil {


    private PriceService priceService = new PriceService();
    private OfferService offerService = new OfferService();
    private MathUtil mathUtil = new MathUtil();


    public Integer getTotalPrice(String skus) {

        Integer grandTotal = 0;

        Map<String, Integer> priceList = priceService.getPriceList();

        Map<String, Integer> itemWiseCount = getSkuCountMap(skus);


        for (String thisSku : itemWiseCount.keySet()) {
            // apply Special offer
            // apply count offer
            // calculate remaining individual price

//            if (maybeOffer.isPresent()) {
//                CountOffer thisCountOffer = maybeOffer.get();
//                Result result = mathUtil.getResult(itemWiseCount.get(thisSku), thisCountOffer.getOfferCount());
//                thisLineValue = (result.getOfferCount() * thisCountOffer.getOfferPrice()) + (result.getRemainder() * priceList.get(thisSku));
//            } else {
//                if(priceList.containsKey(thisSku)) {
//                    thisLineValue = itemWiseCount.get(thisSku) * priceList.get(thisSku);
//                }else{
//                    return -1;
//                }
//            }
//
            grandTotal = grandTotal;
        }
        return grandTotal;
    }


    private Map<String, Integer> removeFreeItems(Map<String, Integer> itemWiseCount) {
        Map<String, Integer> refinedItemWiseCount = itemWiseCount;

        Map<String, Integer> freeItems = offerService.getFreeItems(itemWiseCount);

        for ( String freeItemSku: freeItems.keySet()){
               if(refinedItemWiseCount.containsKey(freeItemSku)) {

                   Integer currentCount = refinedItemWiseCount.get(freeItemSku);
                   Integer toRemove = currentCount - freeItems.get(freeItemSku);

                   refinedItemWiseCount.put(freeItemSku, Math.max(0, toRemove));




               }
        }
        return refinedItemWiseCount;
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


