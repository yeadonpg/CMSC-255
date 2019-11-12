package Projects.Project_6;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class CustomerTests {

    @Test
    public void Customer_instanceCountTest(){
        Customer testCustomer = new Customer();
        @SuppressWarnings("rawtypes")
        Class c = testCustomer.getClass();
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
    public void Customer_instanceVariablesTest(){
        Customer testCustomer = new Customer();
        instanceVariablePrivate("lastName",testCustomer);
        instanceVariablePrivate("firstName",testCustomer);
        instanceVariablePrivate("phone",testCustomer);
        instanceVariablePrivate("email",testCustomer);
        instanceVariablePrivate("iceCream",testCustomer);

        instanceVariableStatic("lastName",testCustomer);
        instanceVariableStatic("firstName",testCustomer);
        instanceVariableStatic("phone",testCustomer);
        instanceVariableStatic("email",testCustomer);
        instanceVariableStatic("iceCream",testCustomer);

        instanceVariableCorrectType("lastName",String.class,testCustomer);
        instanceVariableCorrectType("firstName",String.class,testCustomer);
        instanceVariableCorrectType("phone",String.class,testCustomer);
        instanceVariableCorrectType("email",String.class,testCustomer);
        instanceVariableCorrectType("iceCream",ArrayList.class,testCustomer);
    }

    @Test
    public void Customer_defaultConstructorTest() {
        Customer testCustomer = new Customer();

        testVariable("lastName",testCustomer,null,"When checking the value of lastName we");
        testVariable("firstName",testCustomer,null,"When checking the value of firstName we");
        testVariable("phone",testCustomer,null,"When checking the value of phone we");
        testVariable("email",testCustomer,null,"When checking the value of email we");
        testVariable("iceCream",testCustomer,new ArrayList<>(),"When checking the value of iceCream we");

    }

    @Test
    public void Customer_parameterizedConstructorTest() {
        Customer testCustomer = new Customer("Budwell","Caroline","804-937-8111","ccbudwell@vcu.edu");

        testVariable("lastName",testCustomer,"Budwell","When checking the value of lastName we");
        testVariable("firstName",testCustomer,"Caroline","When checking the value of firstName we");
        testVariable("phone",testCustomer,"804-937-8111","When checking the value of phone we");
        testVariable("email",testCustomer,"ccbudwell@vcu.edu","When checking the value of email we");
        testVariable("iceCream",testCustomer,new ArrayList<>(),"When checking the value of iceCream we");

    }

    @Test
    public void Customer_getLastNameTest() {
        ArrayList<IceCream> someIceCream = new ArrayList<>();
        Customer testCustomer = createCustomer("Sparks","Zach","978-281-8911","zwhitten@vcu.edu",someIceCream);
        assertEquals("With a Customer object who's lastName instance variable is Sparks, when calling getLastName we","Sparks",testCustomer.getLastName());
    }

    @Test
    public void Customer_setLastNameTest() {
        ArrayList<IceCream> someIceCream = new ArrayList<>();
        Customer testCustomer = createCustomer("Whitten","Zach","978-281-8911","zwhitten@vcu.edu",someIceCream);

        testCustomer.setLastName("Sparks");
        testVariable("lastName",testCustomer,"Sparks","After calling Customer's setLastName method with an argument of Sparks, for the value of lastName we");
    }

    @Test
    public void Customer_getFirstNameTest() {
        ArrayList<IceCream> someIceCream = new ArrayList<>();
        Customer testCustomer = createCustomer("Whitten","Zach","978-281-8911","zwhitten@vcu.edu",someIceCream);
        assertEquals("With a Customer object who's firstName instance variable is Zach, when calling getFirstName we","Zach",testCustomer.getFirstName());
    }

    @Test
    public void Customer_setFirstNameTest() {
        ArrayList<IceCream> someIceCream = new ArrayList<>();
        Customer testCustomer = createCustomer("Sparks","Zach","978-281-8911","zwhitten@vcu.edu",someIceCream);

        testCustomer.setFirstName("Clare");
        testVariable("firstName",testCustomer,"Clare","After calling Customer's setFirstName method with an argument of Clare, for the value of firstName we");
    }

    @Test
    public void Customer_getPhoneTest() {
        ArrayList<IceCream> someIceCream = new ArrayList<>();
        Customer testCustomer = createCustomer("Whitten","Zach","978-281-8911","zwhitten@vcu.edu",someIceCream);
        assertEquals("With a Customer object who's phone instance variable is 978-281-8911, when calling getPhone we","978-281-8911",testCustomer.getPhone());
    }

    @Test
    public void Customer_setPhoneTest() {
        ArrayList<IceCream> someIceCream = new ArrayList<>();
        Customer testCustomer = createCustomer("Whitten","Zach","978-281-8911","zwhitten@vcu.edu",someIceCream);

        testCustomer.setPhone("978-750-9785");
        testVariable("phone",testCustomer,"978-750-9785","After calling Customer's setPhone method with an argument of 978-750-9785, for the value of phone we");
    }

    @Test
    public void Customer_getEmailTest() {
        ArrayList<IceCream> someIceCream = new ArrayList<>();
        Customer testCustomer = createCustomer("Whitten","Zach","978-281-8911","zwhitten@vcu.edu",someIceCream);
        assertEquals("With a Customer object who's email instance variable is zwhitten@vcu.edu, when calling getEmail we","zwhitten@vcu.edu",testCustomer.getEmail());
    }

    @Test
    public void Customer_setEmailTest() {
        ArrayList<IceCream> someIceCream = new ArrayList<>();
        Customer testCustomer = createCustomer("Whitten","Zach","978-281-8911","zwhitten@vcu.edu",someIceCream);

        testCustomer.setEmail("zachary.whitten.11@cnu.edu");
        testVariable("email",testCustomer,"zachary.whitten.11@cnu.edu","After calling Customer's setEmail method with an argument of zachary.whitten.11@cnu.edu, for the value of email we");
    }

    @Test
    public void Customer_getNumIceCreamTest() {
        ArrayList<IceCream> someIceCream = new ArrayList<>();
        someIceCream.add(createIceCream(Size.TRIPLE,Flavor.CHOCOLATE,Sauce.NONE,Topping.SPRINKLES,ToppingSun.NONE));
        someIceCream.add(createIceCream(Size.TRIPLE,Flavor.STRAWBERRY,Sauce.STRAWBERRY,Topping.SPRINKLES,ToppingSun.NONE));
        Customer testCustomer = createCustomer("Whitten","Zach","978-281-8911","zwhitten@vcu.edu",someIceCream);
        assertEquals("With a Customer object who's iceCream instance variable is has two elements, when calling getNumIceCream we",2,testCustomer.getNumIceCream());
    }

    @Test
    public void Customer_getIceCreamTest() {
        ArrayList<IceCream> someIceCream = new ArrayList<>();
        someIceCream.add(createIceCream(Size.TRIPLE,Flavor.CHOCOLATE,Sauce.NONE,Topping.SPRINKLES,ToppingSun.NONE));
        someIceCream.add(createIceCream(Size.TRIPLE,Flavor.STRAWBERRY,Sauce.STRAWBERRY,Topping.SPRINKLES,ToppingSun.NONE));

        ArrayList<IceCream> expectedIceCream = new ArrayList<>();
        expectedIceCream.add(createIceCream(Size.TRIPLE,Flavor.CHOCOLATE,Sauce.NONE,Topping.SPRINKLES,ToppingSun.NONE));
        expectedIceCream.add(createIceCream(Size.TRIPLE,Flavor.STRAWBERRY,Sauce.STRAWBERRY,Topping.SPRINKLES,ToppingSun.NONE));

        Customer testCustomer = createCustomer("Whitten","Zach","978-281-8911","zwhitten@vcu.edu",someIceCream);
        testIceCreamArray("With a Customer object who's iceCream instance variable is has two elements, when calling getIceCream we",expectedIceCream,testCustomer.getIceCream());
    }

    @Test
    public void Customer_orderIceCreamOneIceCreamTest() {
        ArrayList<IceCream> someIceCream = new ArrayList<>();

        ArrayList<IceCream> expectedIceCream = new ArrayList<>();
        expectedIceCream.add(createIceCream(Size.TRIPLE,Flavor.CHOCOLATE,Sauce.NONE,Topping.SPRINKLES,ToppingSun.NONE));
        Customer testCustomer = createCustomer("Whitten","Zach","978-281-8911","zwhitten@vcu.edu",someIceCream);

        testCustomer.orderIceCream(createIceCream(Size.TRIPLE,Flavor.CHOCOLATE,Sauce.NONE,Topping.SPRINKLES,ToppingSun.NONE));

        testVariable("iceCream",testCustomer,expectedIceCream,"After a Customer object orders a single ice cream, when checking the iceCream instance variable we");

    }

    @Test
    public void Customer_orderIceCreamFourIceCreamTest() {
        ArrayList<IceCream> someIceCream = new ArrayList<>();

        ArrayList<IceCream> expectedIceCream = new ArrayList<>();
        expectedIceCream.add(createIceCream(Size.TRIPLE,Flavor.CHOCOLATE,Sauce.NONE,Topping.SPRINKLES,ToppingSun.NONE));
        expectedIceCream.add(createIceCream(Size.DOUBLE,Flavor.ROCKY_ROAD,Sauce.CARAMEL,Topping.GUMMIES,ToppingSun.NONE));
        expectedIceCream.add(createIceCream(Size.SINGLE,Flavor.BUTTER_PECAN,Sauce.HOT_FUDGE,Topping.CHOCOLATE_FLAKES,ToppingSun.NONE));
        expectedIceCream.add(createIceCream(Size.SUNDAE,Flavor.VANILLA,Sauce.STRAWBERRY,Topping.CHOCOLATE_FLAKES,ToppingSun.WHIPPED_CREAM_AND_CHERRY));
        Customer testCustomer = createCustomer("Whitten","Zach","978-281-8911","zwhitten@vcu.edu",someIceCream);


        testCustomer.orderIceCream(createIceCream(Size.TRIPLE,Flavor.CHOCOLATE,Sauce.NONE,Topping.SPRINKLES,ToppingSun.NONE));
        testCustomer.orderIceCream(createIceCream(Size.DOUBLE,Flavor.ROCKY_ROAD,Sauce.CARAMEL,Topping.GUMMIES,ToppingSun.NONE));
        testCustomer.orderIceCream(createIceCream(Size.SINGLE,Flavor.BUTTER_PECAN,Sauce.HOT_FUDGE,Topping.CHOCOLATE_FLAKES,ToppingSun.NONE));
        testCustomer.orderIceCream(createIceCream(Size.SUNDAE,Flavor.VANILLA,Sauce.STRAWBERRY,Topping.CHOCOLATE_FLAKES,ToppingSun.WHIPPED_CREAM_AND_CHERRY));

        testVariable("iceCream",testCustomer,expectedIceCream,"After a Customer object orders a single ice cream, when checking the iceCream instance variable we");

    }

    @Test
    public void Customer_toStringTest() {
        ArrayList<IceCream> someIceCream = new ArrayList<>();
        someIceCream.add(createIceCream(Size.TRIPLE,Flavor.CHOCOLATE,Sauce.NONE,Topping.SPRINKLES,ToppingSun.NONE));
        Customer testCustomer = createCustomer("Whitten","Zach","978-281-8911","zwhitten@vcu.edu",someIceCream);


        assertEquals(  "Zach Whitten\n" +
                "978-281-8911\n" +
                "zwhitten@vcu.edu\n" +
                "Ice Cream Order:\n\n" +
                "\tTRIPLE\n" +
                "\tCHOCOLATE\n" +
                "\tNONE\n" +
                "\tSPRINKLES\n" +
                "\tNONE\n" , testCustomer.toString());


        someIceCream = new ArrayList<>();
        someIceCream.add(createIceCream(Size.TRIPLE,Flavor.CHOCOLATE,Sauce.NONE,Topping.SPRINKLES,ToppingSun.NONE));
        someIceCream.add(createIceCream(Size.DOUBLE,Flavor.ROCKY_ROAD,Sauce.CARAMEL,Topping.GUMMIES,ToppingSun.NONE));
        someIceCream.add(createIceCream(Size.SINGLE,Flavor.BUTTER_PECAN,Sauce.HOT_FUDGE,Topping.CHOCOLATE_FLAKES,ToppingSun.NONE));
        someIceCream.add(createIceCream(Size.SUNDAE,Flavor.VANILLA,Sauce.STRAWBERRY,Topping.CHOCOLATE_FLAKES,ToppingSun.WHIPPED_CREAM_AND_CHERRY));
        testCustomer = createCustomer("Sparks","Clare","978-281-8911","sparks.clare@gmail.com",someIceCream);


        assertEquals(  "Clare Sparks\n" +
                "978-281-8911\n" +
                "sparks.clare@gmail.com\n" +
                "Ice Cream Order:\n" +
                "\n" +
                "\tTRIPLE\n" +
                "\tCHOCOLATE\n" +
                "\tNONE\n" +
                "\tSPRINKLES\n" +
                "\tNONE\n" +
                "\n" +
                "\tDOUBLE\n" +
                "\tROCKY_ROAD\n" +
                "\tCARAMEL\n" +
                "\tGUMMIES\n" +
                "\tNONE\n" +
                "\n" +
                "\tSINGLE\n" +
                "\tBUTTER_PECAN\n" +
                "\tHOT_FUDGE\n" +
                "\tCHOCOLATE_FLAKES\n" +
                "\tNONE\n" +
                "\n" +
                "\tSUNDAE\n" +
                "\tVANILLA\n" +
                "\tSTRAWBERRY\n" +
                "\tCHOCOLATE_FLAKES\n" +
                "\tWHIPPED_CREAM_AND_CHERRY\n", testCustomer.toString());
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