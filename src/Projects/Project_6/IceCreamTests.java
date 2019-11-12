package Projects.Project_6;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class IceCreamTests {

    @Test
    public void IceCream_instanceCountTest(){
        IceCream testFan = new IceCream();
        @SuppressWarnings("rawtypes")
        Class c = testFan.getClass();
        try {
            assertEquals(
                    "You must only have the instance variables specified. When looking at the number of instance variables we",
                    5, c.getDeclaredFields().length);
        }
        catch (Exception e) {
            fail("Something weird went wrong");
        }
    }

    @Test
    public void IceCream_instanceVariablesTest(){
        IceCream testIceCream = new IceCream();
        instanceVariablePrivate("size",testIceCream);
        instanceVariablePrivate("flavor",testIceCream);
        instanceVariablePrivate("sauce",testIceCream);
        instanceVariablePrivate("topping",testIceCream);
        instanceVariablePrivate("toppingSun",testIceCream);

        instanceVariableStatic("size",testIceCream);
        instanceVariableStatic("flavor",testIceCream);
        instanceVariableStatic("sauce",testIceCream);
        instanceVariableStatic("topping",testIceCream);
        instanceVariableStatic("toppingSun",testIceCream);

        instanceVariableCorrectType("size",Size.class,testIceCream);
        instanceVariableCorrectType("flavor",Flavor.class,testIceCream);
        instanceVariableCorrectType("sauce",Sauce.class,testIceCream);
        instanceVariableCorrectType("topping",Topping.class,testIceCream);
        instanceVariableCorrectType("toppingSun",ToppingSun.class,testIceCream);
    }

    @Test
    public void IceCream_defaultConstructorTest() {
        IceCream testIceCream = new IceCream();

        testVariable("size",testIceCream,Size.SINGLE,"When checking the value of size we");
        testVariable("flavor",testIceCream,Flavor.VANILLA,"When checking the value of flavor we");
        testVariable("sauce",testIceCream,Sauce.NONE,"When checking the value of sauce we");
        testVariable("topping",testIceCream,Topping.NONE,"When checking the value of topping we");
        testVariable("toppingSun",testIceCream,ToppingSun.NONE,"When checking the value of size we");

    }

    @Test
    public void IceCream_parameterizedConstructorTest() {
        IceCream testIceCream = new IceCream(Size.TRIPLE);

        testVariable("size",testIceCream,Size.TRIPLE,"When checking the value of size we");
        testVariable("flavor",testIceCream,Flavor.VANILLA,"When checking the value of flavor we");
        testVariable("sauce",testIceCream,Sauce.NONE,"When checking the value of sauce we");
        testVariable("topping",testIceCream,Topping.NONE,"When checking the value of topping we");
        testVariable("toppingSun",testIceCream,ToppingSun.NONE,"When checking the value of size we");

    }

    @Test
    public void IceCream_getSizeTest() {
        IceCream testIceCream = createIceCream(Size.TRIPLE,Flavor.CHOCOLATE,Sauce.NONE,Topping.SPRINKLES,ToppingSun.NONE);
        assertEquals("With an IceCream object who's size instance variable is TRIPLE, when calling getSize we",Size.TRIPLE,testIceCream.getSize());
    }

    @Test
    public void IceCream_setSizeTest() {
        IceCream testIceCream = createIceCream(Size.TRIPLE,Flavor.CHOCOLATE,Sauce.NONE,Topping.SPRINKLES,ToppingSun.NONE);
        testIceCream.setSize(Size.DOUBLE);
        testVariable("size",testIceCream,Size.DOUBLE,"After calling IceCream's setSize method with an argument of DOUBLE, for the value of size we");
    }

    @Test
    public void IceCream_getFlavorTest() {
        IceCream testIceCream = createIceCream(Size.TRIPLE,Flavor.CHOCOLATE,Sauce.NONE,Topping.SPRINKLES,ToppingSun.NONE);
        assertEquals("With an IceCream object who's flavor instance variable is CHOCOLATE, when calling getFlavor we",Flavor.CHOCOLATE,testIceCream.getFlavor());
    }

    @Test
    public void IceCream_setFlavorTest() {
        IceCream testIceCream = createIceCream(Size.TRIPLE,Flavor.CHOCOLATE,Sauce.NONE,Topping.SPRINKLES,ToppingSun.NONE);
        testIceCream.setFlavor(Flavor.STRAWBERRY);
        testVariable("flavor",testIceCream,Flavor.STRAWBERRY,"After calling IceCream's setFlavor method with an argument of STRAWBERRY, for the value of flavor we");
    }

    @Test
    public void IceCream_getSauceTest() {
        IceCream testIceCream = createIceCream(Size.TRIPLE,Flavor.CHOCOLATE,Sauce.NONE,Topping.SPRINKLES,ToppingSun.NONE);
        assertEquals("With an IceCream object who's sauce instance variable is NONE, when calling getSauce we",Sauce.NONE,testIceCream.getSauce());
    }

    @Test
    public void IceCream_setSauceTest() {
        IceCream testIceCream = createIceCream(Size.TRIPLE,Flavor.CHOCOLATE,Sauce.NONE,Topping.SPRINKLES,ToppingSun.NONE);
        testIceCream.setSauce(Sauce.STRAWBERRY);
        testVariable("sauce",testIceCream,Sauce.STRAWBERRY,"After calling IceCream's setSauce method with an argument of STRAWBERRY, for the value of sauce we");
    }

    @Test
    public void IceCream_getToppingTest() {
        IceCream testIceCream = createIceCream(Size.TRIPLE,Flavor.CHOCOLATE,Sauce.NONE,Topping.SPRINKLES,ToppingSun.NONE);
        assertEquals("With an IceCream object who's topping instance variable is SPRINKLES, when calling getTopping we",Topping.SPRINKLES,testIceCream.getTopping());
    }

    @Test
    public void IceCream_setToppingTest() {
        IceCream testIceCream = createIceCream(Size.TRIPLE,Flavor.CHOCOLATE,Sauce.NONE,Topping.SPRINKLES,ToppingSun.NONE);
        testIceCream.setTopping(Topping.CHOCOLATE_FLAKES);
        testVariable("topping",testIceCream,Topping.CHOCOLATE_FLAKES,"After calling IceCream's setTopping method with an argument of CHOCOLATE_FLAKES, for the value of topping we");
    }

    @Test
    public void IceCream_getToppingSunTest() {
        IceCream testIceCream = createIceCream(Size.TRIPLE,Flavor.CHOCOLATE,Sauce.NONE,Topping.SPRINKLES,ToppingSun.NONE);
        assertEquals("With an IceCream object who's toppingSun instance variable is NONE, when calling getToppingSun we",ToppingSun.NONE,testIceCream.getToppingSun());
    }

    @Test
    public void IceCream_setToppingSunTest() {
        IceCream testIceCream = createIceCream(Size.TRIPLE,Flavor.CHOCOLATE,Sauce.NONE,Topping.SPRINKLES,ToppingSun.NONE);
        testIceCream.setToppingSun(ToppingSun.WHIPPED_CREAM_AND_CHERRY);
        testVariable("toppingSun",testIceCream,ToppingSun.WHIPPED_CREAM_AND_CHERRY,"After calling IceCream's setToppingSun method with an argument of WHIPPED_CREAM_AND_CHERRY, for the value of toppingSun we");
    }

    @Test
    public void IceCream_toStringTest() {
        IceCream testIceCream = createIceCream(Size.TRIPLE,Flavor.CHOCOLATE,Sauce.NONE,Topping.SPRINKLES,ToppingSun.NONE);
        assertEquals(  "\n\tTRIPLE\n" +
                "\tCHOCOLATE\n" +
                "\tNONE\n" +
                "\tSPRINKLES\n" +
                "\tNONE\n", testIceCream.toString());

        testIceCream = createIceCream(Size.SUNDAE,Flavor.ROCKY_ROAD,Sauce.HOT_FUDGE,Topping.GUMMIES,ToppingSun.WHIPPED_CREAM_AND_CHERRY);
        assertEquals(  "\n\tSUNDAE\n" +
                "\tROCKY_ROAD\n" +
                "\tHOT_FUDGE\n" +
                "\tGUMMIES\n" +
                "\tWHIPPED_CREAM_AND_CHERRY\n", testIceCream.toString());
    }

    private Customer createCustomer(String aLastName, String aFirstName, String aPhone, String anEmail, ArrayList<IceCream> someIceCream){
        Customer testCustomer = new Customer();
        @SuppressWarnings("rawtypes")
        Class c = testCustomer.getClass();

        try {
            Field size = c.getDeclaredField("lastName");
            size.setAccessible(true);
            size.set(testCustomer, aLastName);

            Field flavor = c.getDeclaredField("firstName");
            flavor.setAccessible(true);
            flavor.set(testCustomer, aFirstName);

            Field sauce = c.getDeclaredField("phone");
            sauce.setAccessible(true);
            sauce.set(testCustomer, aPhone);

            Field topping = c.getDeclaredField("email");
            topping.setAccessible(true);
            topping.set(testCustomer, anEmail);

            Field toppingSun = c.getDeclaredField("iceCream");
            toppingSun.setAccessible(true);
            toppingSun.set(testCustomer, someIceCream);

        } catch (Exception e) {
            fail(e.toString());
        }

        return testCustomer;
    }

    private IceCream createIceCream(Size aSize, Flavor aFlavor, Sauce aSauce, Topping aTopping, ToppingSun aToppingSun){
        IceCream testIceCream = new IceCream();
        @SuppressWarnings("rawtypes")
        Class c = testIceCream.getClass();

        try {
            Field size = c.getDeclaredField("size");
            size.setAccessible(true);
            size.set(testIceCream, aSize);

            Field flavor = c.getDeclaredField("flavor");
            flavor.setAccessible(true);
            flavor.set(testIceCream, aFlavor);

            Field sauce = c.getDeclaredField("sauce");
            sauce.setAccessible(true);
            sauce.set(testIceCream, aSauce);

            Field topping = c.getDeclaredField("topping");
            topping.setAccessible(true);
            topping.set(testIceCream, aTopping);

            Field toppingSun = c.getDeclaredField("toppingSun");
            toppingSun.setAccessible(true);
            toppingSun.set(testIceCream, aToppingSun);

        } catch (Exception e) {
            fail(e.toString());
        }

        return testIceCream;
    }

    private void instanceVariablePrivate(String aField, Object testObject) {
        @SuppressWarnings("rawtypes")
        Class c = testObject.getClass();
        try {
            c.getDeclaredField(aField);

            assertTrue("You must make your instance variables private.", Modifier.isPrivate(c.getDeclaredField(aField).getModifiers()));

        } catch (NoSuchFieldException e) {
            fail("Could not find the " + e.getLocalizedMessage() + " instance variable");
        } catch (Exception e) {
            fail("Something weird went wrong");
        }
    }

    private void instanceVariableStatic(String aField, Object testObject) {
        @SuppressWarnings("rawtypes")
        Class c = testObject.getClass();
        try {
            c.getDeclaredField(aField);

            assertEquals("Your instance variables must NOT be static.", false,
                    Modifier.isStatic(c.getDeclaredField(aField).getModifiers()));

        } catch (NoSuchFieldException e) {
            fail("Could not find the " + e.getLocalizedMessage() + " instance variable");
        } catch (Exception e) {
            fail("Something weird went wrong");
        }
    }

    private void instanceVariableCorrectType(String aField, Class<?> aClass,  Object testObject) {
        @SuppressWarnings("rawtypes")
        Class c = testObject.getClass();
        try {
            c.getDeclaredField(aField);

            assertEquals("You must make the speed instance variable of type"+ aClass.toString() +".", aClass, c.getDeclaredField(aField).getType());

        } catch (NoSuchFieldException e) {
            fail("Could not find the " + e.getLocalizedMessage() + " instance variable");
        } catch (Exception e) {
            fail("Something weird went wrong");
        }
    }

    private void testVariable(String aField, Object testObject, Object expected, String message){
        @SuppressWarnings("rawtypes")
        Class c = testObject.getClass();
        try {
            Field field = c.getDeclaredField(aField);
            field.setAccessible(true);
            Object fieldValue = field.get(testObject);

            if(expected == null){
                assertNull(message,fieldValue);
            }
            //If class is a double we have a special Junit assert to run
            else if(expected.getClass().equals(Double.class)){
                double doubleFieldValue = (double) fieldValue;
                double doubleExpected = (double) expected;
                assertEquals(message, doubleExpected, doubleFieldValue, .01);
            }
            //Array of some kind yay
            else if(expected.getClass().isArray()){

            }
            else if(expected.getClass().equals(ArrayList.class)){
                //CUSTOM FOR PROJECT6TESTS!!!
                testIceCreamArray(message,(ArrayList) expected, (ArrayList) fieldValue);
            }
            else{
                assertEquals(message, expected, fieldValue);
            }

        }
        catch (Exception e) {
            fail(e.toString());
        }
    }

    private void testIceCreamArray(String message, ArrayList expected, ArrayList actual){
        assertEquals(message + " looked at the size and ",expected.size(),actual.size());

        for(int i = 0; i < expected.size(); i++) {
            if (!IceCreamIsEqual(expected.get(i), actual.get(i))) {
                assertEquals(message, expected, actual);
            }
        }
    }

    private boolean IceCreamIsEqual(Object o1, Object o2){
        @SuppressWarnings("rawtypes")
        Class c = o1.getClass();
        try {
            Field sizeFieldo1 = c.getDeclaredField("size");
            sizeFieldo1.setAccessible(true);
            Object sizeo1 = sizeFieldo1.get(o1);

            Field sizeFieldo2 = c.getDeclaredField("size");
            sizeFieldo2.setAccessible(true);
            Object sizeo2 = sizeFieldo2.get(o2);

            Field flavorFieldo1 = c.getDeclaredField("flavor");
            flavorFieldo1.setAccessible(true);
            Object flavoro1 = flavorFieldo1.get(o1);

            Field flavorFieldo2 = c.getDeclaredField("flavor");
            flavorFieldo2.setAccessible(true);
            Object flavoro2 = flavorFieldo2.get(o2);

            Field sauceFieldo1 = c.getDeclaredField("sauce");
            sauceFieldo1.setAccessible(true);
            Object sauceo1 = sauceFieldo1.get(o1);

            Field sauceFieldo2 = c.getDeclaredField("sauce");
            sauceFieldo2.setAccessible(true);
            Object sauceo2 = sauceFieldo2.get(o2);

            Field toppingFieldo1 = c.getDeclaredField("topping");
            toppingFieldo1.setAccessible(true);
            Object toppingo1 = toppingFieldo1.get(o1);

            Field toppingFieldo2 = c.getDeclaredField("topping");
            toppingFieldo2.setAccessible(true);
            Object toppingo2 = toppingFieldo2.get(o2);

            Field toppingSunFieldo1 = c.getDeclaredField("toppingSun");
            toppingSunFieldo1.setAccessible(true);
            Object toppingSuno1 = toppingSunFieldo1.get(o1);

            Field toppingSunFieldo2 = c.getDeclaredField("toppingSun");
            toppingSunFieldo2.setAccessible(true);
            Object toppingSuno2 = toppingSunFieldo2.get(o2);


            if(sizeo1.equals(sizeo2) && flavoro1.equals(flavoro2) && sauceo1.equals(sauceo2) && toppingo1.equals(toppingo2) && toppingSuno1.equals(toppingSuno2)){
                return true;
            }
            else{
                return false;
            }


        } catch (NoSuchFieldException e) {
            fail("Could not find the " + e.getLocalizedMessage() + " instance variable");
        } catch (Exception e) {
            fail("Something weird went wrong");
        }

        return false;
    }

}