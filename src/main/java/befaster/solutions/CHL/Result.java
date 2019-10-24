package befaster.solutions.CHL;

class Result {
    private Integer offerCount;
    private Integer remainingCount;

    public Result(Integer offerCount, Integer remainingCount) {
        this.offerCount = offerCount;
        this.remainingCount = remainingCount;
    }

    public Integer getOfferCount() {
        return offerCount;
    }

    public void setOfferCount(Integer offerCount) {
        this.offerCount = offerCount;
    }

    public Integer getRemainingCount() {
        return remainingCount;
    }

    public void setRemainingCount(Integer remainingCount) {
        this.remainingCount = remainingCount;
    }
}