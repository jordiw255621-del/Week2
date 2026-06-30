enum Model {
    PRO, PRO_MAX
}

enum Colour {
    NATURAL, BLUE, WHITE, BLACK
}

public class Menu {

    // the model that user selected
    Model model;
    // the colour that user selected
    Colour colour;

    void runMainMenu() {
        System.out.println("--- iPhone 15 Pro Order page ---");
        while (true) {
            System.out.println("Select an option:");
            System.out.println("  1. Choose model");
            System.out.println("  2. Choose colour");
            System.out.println("  3. Checkout");
            System.out.println("  4. Exit");
            int choice = In.nextInt();
            if (choice == 1) {
                runChooseModel();
            } else if (choice == 2) {
                runChooseColour();
            } else if (choice == 3) {
                runCheckout();
            } else if (choice == 4) {
                break;
            } else {
                System.out.println("Pick an option 1, 2, or 3");
            }
        }

        System.out.println("Exiting...");
    }

    void runCheckout() {

        if (this.model == null) {
            System.out.println("YOU DIDN'T SELECT A MODEL");
        } else if (this.colour == null) {
            System.out.println("YOU DIDN'T SELECT A COLOUR");
        } else {
            // User has selected all options, ready to compute price.
            // .....
        }
    }

    void runChooseModel() {
        System.out.println("--- Choose model ---");
        while (true) {
            System.out.println("Select an option:");
            System.out.println("  1. iPhone 15 Pro");
            System.out.println("  2. iPhone 15 Pro MAX");
            System.out.println("  3. Back to main menu");
            int choice = In.nextInt();
            if (choice == 1) {
                System.out.println("  Chosen PRO");
                this.model = Model.PRO;
                break;
            } else if (choice == 2) {
                System.out.println("  Chosen MAX");
                this.model = Model.PRO_MAX;
                break;
            } else if (choice == 3) {
                break;
            } else {
                System.out.println("Pick an option 1, 2, or 3");
            }
        }
        System.out.println("Back to main menu...");
    }

    void runChooseColour() {
        System.out.println("--- Choose colour ---");
        while (true) {
            System.out.println("Select an option:");
            System.out.println("  1. Natural titanium");
            System.out.println("  2. Blue titanium");
            System.out.println("  3. White titanium");
            System.out.println("  4. Black titanium");
            System.out.println("  5. Back to main menu");
            int choice = In.nextInt();
            if (choice == 1) {
                this.colour = Colour.NATURAL;
                break;
            } else if (choice == 2) {
                this.colour = Colour.BLUE;
                break;
            } else if (choice == 3) {
                this.colour = Colour.WHITE;
                break;
            } else if (choice == 4) {
                this.colour = Colour.BLACK;
                break;
            } else {
                System.out.println("Pick an option 1, 2, 3 or 4");
            }
        }
        System.out.println("Back to main menu...");
    }

    public static void main(String[] args) {
        Menu menu = new Menu();

        menu.runMainMenu();
    }
}