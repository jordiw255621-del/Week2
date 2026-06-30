enum Topping {
    BACON(2.25),
    BEEF(2.25),
    CHEESE(2.25),
    CHICKEN(3.25);

    private double price;

    Topping(double price) {
        this.price = price;
    }

    double getPrice() {
        return this.price;
    }

    public String toString() {
        if (this == BACON) {
            return "Bacon ($" + price + ")";
        } else if (this == BEEF) {
            return "Bacon ($" + price + ")";
        } else if (this == CHEESE) {
            return "Cheese ($" + price + ")";
        } else {
            return "Chicken ($" + price + ")";
        }
    }
}

class Pizza {
    final double BASE_PRICE;
    final Topping[] includedToppings;
    ArrayList<Topping> extraToppings;
    double discountInDollars;

    Pizza(Topping[] includedToppings, double basePrice) {
        this.includedToppings = includedToppings;
        this.BASE_PRICE = basePrice;
        this.extraToppings = new ArrayList<>();
        this.discountInDollars = 0.0;
    }

    void addTopping(Topping topping) {
        this.extraToppings.add(topping);
    }

    double calculateBasePrice() {
        double price = this.BASE_PRICE;
        for (Topping t : this.includedToppings) {
            price += t.getPrice();
        }

        for (Topping t : this.extraToppings) {
            price += t.getPrice();
        }

        return price;
    }

    double calculatePrice() {
        return calculateBasePrice() - this.discountInDollars;
    }

    void applyDiscount(double discountRate) {
        if (discountRate >= 0.0 && discountRate <= 1.0) {
            this.discountInDollars = discountRate * calculateBasePrice();
        }
    }

    void applyDiscount(int dollarDiscount) {
        this.discountInDollars -= dollarDiscount;
    }
}