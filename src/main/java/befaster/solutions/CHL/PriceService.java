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
            put("F",10);
            put("G",20);
            put("H",10);
            put("I",35);
            put("J",60);
            put("K",80);
            put("L",90);
            put("M",15);
            put("N",40);
            put("O",10);
            put("P",50);
            put("Q",30);
            put("R",50);
            put("S",30);
            put("T",20);
            put("U",40);
            put("V",50);
            put("W",20);
            put("X",90);
            put("Y",10);
            put("Z",50);
        }
    };

    Map<String, Integer> getPriceList() {
        return priceList;
    }

}

