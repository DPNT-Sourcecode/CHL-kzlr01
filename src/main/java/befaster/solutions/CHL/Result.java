package befaster.solutions.CHL;

class Result {
    private Integer quotient;
    private Integer reminder;

    Result(Integer quotient, Integer reminder) {
        this.quotient = quotient;
        this.reminder = reminder;
    }

    public Integer getQuotient() {
        return quotient;
    }

    public void setQuotient(Integer quotient) {
        this.quotient = quotient;
    }

    public Integer getReminder() {
        return reminder;
    }

    public void setReminder(Integer reminder) {
        this.reminder = reminder;
    }
}