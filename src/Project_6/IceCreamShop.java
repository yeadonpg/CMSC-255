package Project_6;

public class IceCreamShop {
    public static void main(String[] args) {
        Customer caroline = new Customer("Budwell", "Caroline", "804-937-8111", "ccbudwell@vcu.edu");
        Customer zach = new Customer("Whitten", "Zach", "555-222-1111", "zwhitten@vcu.edu");

        IceCream carolineOrder1 = new IceCream(Size.DOUBLE);
        carolineOrder1.setFlavor(Flavor.ROCKY_ROAD);
        carolineOrder1.setSauce(Sauce.CARAMEL);
        IceCream carolineOrder2 = new IceCream(Size.SUNDAE);


        IceCream zachOrder = new IceCream(Size.SINGLE);

        caroline.orderIceCream(carolineOrder1);
        caroline.orderIceCream(carolineOrder2);

        zach.orderIceCream(zachOrder);

        System.out.println(caroline.toString());
        System.out.println(zach.toString());
    }
}
