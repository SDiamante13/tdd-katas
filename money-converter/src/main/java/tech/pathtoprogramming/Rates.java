package tech.pathtoprogramming;

class Rates {
    private final double EUR;
    private final double USD;
    private final double GBP;

    public Rates(double EUR, double USD, double GBP) {
        this.EUR = EUR;
        this.USD = USD;
        this.GBP = GBP;
    }

    public double exchangeRate(Currency targetCurrency) { // TODO: Need to fix this design issue
        if (targetCurrency.equals(Currency.EUR)) {
            return EUR;
        } else if (targetCurrency.equals(Currency.USD)) {
            return USD;
        } else {
            return GBP;
        }
    }
}
