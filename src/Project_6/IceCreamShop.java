package Project_6;

public class IceCreamShop {
    public static void main(String[] args) {
        Customer caroline = new Customer("Budwell", "Caroline", "804-937-8111", "ccbudwell@vcu.edu");
        Customer zach = new Customer("Whitten", "Zach", "555-222-1111", "zwhitten@vcu.edu");

        IceCream carolineOrder1 = new IceCream(Size.DOUBLE);
        carolineOrder1.setFlavor(Flavor.ROCKY_ROAD);
        carolineOrder1.setSauce(Sauce.CARAMEL);

        IceCream carolineOrder2 = new IceCream(Size.SUNDAE);
        carolineOrder2.setFlavor(Flavor.VANILLA);
        carolineOrder2.setSauce(Sauce.HOT_FUDGE);
        carolineOrder2.setTopping(Topping.SPRINKLES);

        caroline.orderIceCream(carolineOrder1);
        caroline.orderIceCream(carolineOrder2);

        IceCream zachOrder = new IceCream(Size.SINGLE);
        zachOrder.setFlavor(Flavor.OREO);
        zachOrder.setTopping(Topping.CANDY);

        zach.orderIceCream(zachOrder);

        System.out.println(caroline.toString());
        System.out.println(zach.toString());
    }
}
