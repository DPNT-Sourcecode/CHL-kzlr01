package befaster.solutions.CHL;

class Result {
    private Integer quotient;
    private Integer remainder;

    Result(Integer quotient, Integer remainder) {
        this.quotient = quotient;
        this.remainder = remainder;
    }

    public Integer getQuotient() {
        return quotient;
    }

    public void setQuotient(Integer quotient) {
        this.quotient = quotient;
    }

    public Integer getRemainder() {
        return remainder;
    }

    public void setRemainder(Integer remainder) {
        this.remainder = remainder;
    }
}