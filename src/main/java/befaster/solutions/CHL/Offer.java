package befaster.solutions.CHL;

public class Offer {
    private String sku;
    private Integer offerCount;
    private Integer offerPrice;

    public Offer(String sku, Integer offerCount, Integer offerPrice) {
        this.sku = sku;
        this.offerCount = offerCount;
        this.offerPrice = offerPrice;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public Integer getOfferCount() {
        return offerCount;
    }

    public void setOfferCount(Integer offerCount) {
        this.offerCount = offerCount;
    }

    public Integer getOfferPrice() {
        return offerPrice;
    }

    public void setOfferPrice(Integer offerPrice) {
        this.offerPrice = offerPrice;
    }
}
