package befaster.solutions.CHL;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class CheckoutUtil {


    private PriceService priceService = new PriceService();
    private OfferService offerService = new OfferService();


    Integer getTotalPrice(String skus){

        Map<String, Integer> priceList = priceService.getPriceList();
        Set<Offer> currentOffer = offerService.getCurrentOffer();

        Map<String,Integer> itemWiseCount = getSkuCountMap(skus);






    }

    private Result getResult(Integer total, Integer offer) {
        return new Result(total / offer, total % offer);
    }



    private Map<String,Integer> getSkuCountMap(String skus){

        Map<String,Integer> result = new HashMap<>();

        String[] items = skus.split("");
        //A,B,C,D,A
        for(String thisSku: items){
            if(result.containsKey(thisSku)){
                result.put(thisSku, result.get(thisSku) + 1);
            }else{
                result.put(thisSku, 1);
            }
        }
        return result;
    }


}


