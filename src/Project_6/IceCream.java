package Project_6;

enum Size {
    SINGLE,
    DOUBLE,
    TRIPLE,
    SUNDAE
}

enum Flavor {
    VANILLA,
    CHOCOLATE,
    ROCKY_ROAD,
    STRAWBERRY,
    MINT_CHOCOLATE_CHIP,
    OREO,
    BUTTER_PECAN
}

enum Sauce {
    NONE,
    HOT_FUDGE,
    CARAMEL,
    STRAWBERRY
}

enum Topping {
    NONE,
    SPRINKLES,
    NUTS,
    CHOCOLATE_FLAKES,
    GUMMIES,
    CANDY
}

enum ToppingSun {
    NONE,
    WHIPPED_CREAM_AND_CHERRY
}

public class IceCream {

    private Size SIZE;
    private Flavor FLAVOR;
    private Sauce SAUCE;
    private Topping TOPPING;
    private ToppingSun TOPPINGSUN;

    public IceCream(Size size) {
        SIZE = size;
        FLAVOR = Flavor.VANILLA;
        SAUCE = Sauce.NONE;
        TOPPING = Topping.NONE;
        if (SIZE == Size.SUNDAE) {
            TOPPINGSUN = ToppingSun.WHIPPED_CREAM_AND_CHERRY;
        } else {
            TOPPINGSUN = ToppingSun.NONE;
        }
    }

    public Size getSize() {
        return SIZE;
    }

    public void setSize(Size aSize) {
        SIZE = aSize;
    }

    public Flavor getFlavor() {
        return FLAVOR;
    }

    public void setFlavor(Flavor aFlavor) {
        FLAVOR = aFlavor;
    }

    public Sauce getSauce() {
        return SAUCE;
    }

    public void setSauce(Sauce aSauce) {
        SAUCE = aSauce;
    }

    public Topping getTopping() {
        return TOPPING;
    }

    public void setTopping(Topping aTopping) {
        TOPPING = aTopping;
    }

    public ToppingSun getToppingSun() {
        return TOPPINGSUN;
    }

    public void setToppingSun(ToppingSun aToppingSun) {
        TOPPINGSUN = aToppingSun;
    }
}
