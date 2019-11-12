package Labs.Lab_12;

public class DebitCard extends Card {

    private int cardNumber, pin;

    public DebitCard() {
        super("Jane Doe");
        this.cardNumber = 00000000;
        this.pin = 0;
    }

    public DebitCard(String name, int cardNumber, int pin) {
        super(name);
        this.cardNumber = cardNumber;
        this.pin = pin;
    }

    public String toString() {
        return super.toString() + " Card Number: " + this.cardNumber;
    }
}
