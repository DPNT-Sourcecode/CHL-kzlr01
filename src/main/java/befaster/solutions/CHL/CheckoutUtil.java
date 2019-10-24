package befaster.solutions.CHL;

import java.util.HashMap;
import java.util.Map;

class CheckoutUtil {

    private Result getResult(Integer total, Integer offer) {
        return new Result(total / offer, total % offer);
    }

    public Integer getTotalPrice(String skus){


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
