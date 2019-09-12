package Lab_3;

public class VariableDefinitions {
    public static void main(String[] args) {
        System.out.println("Patrick Yeadon\nJonathan Fung\nCMSC-255-001");

        byte numPeople = 3;
        double itemPrice = 32.2;
        boolean flag = false;
        char dVal = 'a';

        System.out.println("The numPeople variable now has a value of " + numPeople);
        System.out.println("The itemPrice variable now has a value of " + itemPrice);
        System.out.println("The flag variable now has a value of " + flag);
        System.out.println("The dVal variable now has a value of " + dVal);

        final int AGE = 19;
        final double PI = 3.141592;
        final byte COST = 120;
        final boolean COMPUTER = true;

        System.out.println("The AGE constant now has a value of " + AGE);
        System.out.println("The PI constant now has a value of " + PI);
        System.out.println("The COST constant now has a value of " + COST);
        System.out.println("The COMPUTER constant now has a value of " + COMPUTER);

        // PI = 3;
    }
}