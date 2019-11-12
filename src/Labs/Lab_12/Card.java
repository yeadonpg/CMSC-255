package Labs.Lab_12;

public class Card {

    private String name;

    public Card() {
        this.name = "";
    }

    public Card(String name) {
        this.name = name;
    }

    public String toString() {
        return "Card Holder: " + this.name;
    }

}
