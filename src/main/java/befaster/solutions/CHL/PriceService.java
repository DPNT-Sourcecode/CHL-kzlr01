package befaster.solutions.CHL;

import java.util.HashMap;
import java.util.Map;

class PriceService {

    //Ideally from a persistance
    private Map<String,Integer> priceList = new HashMap<String,Integer>(){
        {
            put("A",50);
            put("B",30);
            put("C",20);
            put("D",15);
            put("E",40);
        }
    };

    Map<String, Integer> getPriceList() {
        return priceList;
    }

}
