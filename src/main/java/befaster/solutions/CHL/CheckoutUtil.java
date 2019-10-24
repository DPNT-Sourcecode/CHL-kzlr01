package befaster.solutions.CHL;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

class CheckoutUtil {


    private PriceService priceService = new PriceService();
    private OfferService offerService = new OfferService();


    Integer getTotalPrice(String skus) {

        Integer grandTotal = 0;

        Map<String, Integer> priceList = priceService.getPriceList();

        Map<String, Integer> itemWiseCount = getSkuCountMap(skus);

        for (String thisSku : itemWiseCount.keySet()) {
            Integer thisLineValue = 0;
            Optional<Offer> maybeOffer = offerService.getOfferFor(thisSku);

            if (maybeOffer.isPresent()) {
                Offer thisOffer = maybeOffer.get();
                Result result = getResult(itemWiseCount.get(thisSku), thisOffer.getOfferCount());
                thisLineValue = (result.getOfferCount() * thisOffer.getOfferPrice()) + (result.getRemainingCount() * priceList.get(thisSku));
            } else {
                if(priceList.containsKey(thisSku)) {
                    thisLineValue = itemWiseCount.get(thisSku) * priceList.get(thisSku);
                }else{
                    return 0;
                }
            }

            grandTotal = grandTotal + thisLineValue;
        }
        return grandTotal;
    }


    private Result getResult(Integer total, Integer offer) {
        return new Result(total / offer, total % offer);
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

