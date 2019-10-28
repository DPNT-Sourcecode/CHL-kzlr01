package befaster.solutions.CHL;

public class BuyGetOffer {

    private String buySku;
    private Integer buyCount;

    private String freeSku;
    private Integer freeCount;

    public BuyGetOffer(String buySku, Integer buyCount, String freeSku, Integer freeCount) {
        this.buySku = buySku;
        this.buyCount = buyCount;
        this.freeSku = freeSku;
        this.freeCount = freeCount;
    }

    public String getBuySku() {
        return buySku;
    }

    public void setBuySku(String buySku) {
        this.buySku = buySku;
    }

    public Integer getBuyCount() {
        return buyCount;
    }

    public void setBuyCount(Integer buyCount) {
        this.buyCount = buyCount;
    }

    public String getFreeSku() {
        return freeSku;
    }

    public void setFreeSku(String freeSku) {
        this.freeSku = freeSku;
    }

    public Integer getFreeCount() {
        return freeCount;
    }

    public void setFreeCount(Integer freeCount) {
        this.freeCount = freeCount;
    }
}

