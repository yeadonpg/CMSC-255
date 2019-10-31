package Project_6;

public class IceCream {

    private Size size;
    private Flavor flavor;
    private Sauce sauce;
    private Topping topping;
    private ToppingSun toppingSun;

    public IceCream() {
        size = Size.SINGLE;
        flavor = Flavor.VANILLA;
        sauce = Sauce.NONE;
        topping = Topping.NONE;
        toppingSun = ToppingSun.NONE;
    }

    public IceCream(Size aSize) {
        size = aSize;
        flavor = Flavor.VANILLA;
        sauce = Sauce.NONE;
        topping = Topping.NONE;
        if (size == Size.SUNDAE) {
            toppingSun = ToppingSun.WHIPPED_CREAM_AND_CHERRY;
        } else {
            toppingSun = ToppingSun.NONE;
        }
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size aSize) {
        size = aSize;
    }

    public Flavor getFlavor() {
        return flavor;
    }

    public void setFlavor(Flavor aFlavor) {
        flavor = aFlavor;
    }

    public Sauce getSauce() {
        return sauce;
    }

    public void setSauce(Sauce aSauce) {
        sauce = aSauce;
    }

    public Topping getTopping() {
        return topping;
    }

    public void setTopping(Topping aTopping) {
        topping = aTopping;
    }

    public ToppingSun getToppingSun() {
        return toppingSun;
    }

    public void setToppingSun(ToppingSun aToppingSun) {
        toppingSun = aToppingSun;
    }

    public String toString() {
        String output = "\n";
        output += String.format("\t%s\n", getSize());
        output += String.format("\t%s\n", getFlavor());
        output += String.format("\t%s\n", getSauce());
        output += String.format("\t%s\n", getTopping());
        output += String.format("\t%s\n", getToppingSun());
        return output;
    }
}
