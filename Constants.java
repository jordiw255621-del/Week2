public class Constants {

    final double INTEREST_RATE; // This value be changed no matter what
    double principal;
    int years;

    Constants(double interestRate, double principal, int years) {
        this.INTEREST_RATE = interestRate;
        this.principal = principal;
        this.years = years;

    }
}