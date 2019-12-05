package Projects.Project_7;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class FlightTest {


    @Test
        public void instanceCountTest(){
        Flight testFlight = new Flight();
        @SuppressWarnings("rawtypes")
        Class c = testFlight.getClass();
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
        public void instanceVariablesTest(){
        Flight testFlight = new Flight();
        instanceVariablePrivate("year",testFlight);
        instanceVariablePrivate("startCity",testFlight);
        instanceVariablePrivate("endCity",testFlight);
        instanceVariablePrivate("price",testFlight);
        instanceVariablePrivate("distance",testFlight);

        instanceVariableStatic("year",testFlight);
        instanceVariableStatic("startCity",testFlight);
        instanceVariableStatic("endCity",testFlight);
        instanceVariableStatic("price",testFlight);
        instanceVariableStatic("distance",testFlight);

        instanceVariableCorrectType("year",String.class,testFlight);
        instanceVariableCorrectType("startCity", String.class,testFlight);
        instanceVariableCorrectType("endCity",String.class,testFlight);
        instanceVariableCorrectType("price",double.class,testFlight);
        instanceVariableCorrectType("distance",int.class,testFlight);
    }

    @Test
        public void defaultConstructorTest() {
        Flight testFlight = new Flight();
        constructorsPublic(testFlight);
        testVariable("year",testFlight,"1970","When checking the value of year we");
        testVariable("startCity",testFlight,"Boston","When checking the value of startCity we");
        testVariable("endCity",testFlight,"Richmond","When checking the value of endCity we");
        testVariable("price",testFlight,40.0,"When checking the value of price we");
        testVariable("distance",testFlight,900,"When checking the value of year we");

    }

    @Test
        public void parameterizedConstructorTest() {

        Flight testFlight = new Flight("2017","Boston, MA (Metropolitan Area)","Richmond, VA",132.355884,395);
        constructorsPublic(testFlight);
        testVariable("year",testFlight,"2017","When checking the value of year we");
        testVariable("startCity",testFlight,"Boston, MA (Metropolitan Area)","When checking the value of startCity we");
        testVariable("endCity",testFlight,"Richmond, VA","When checking the value of endCity we");
        testVariable("price",testFlight,132.355884,"When checking the value of price we");
        testVariable("distance",testFlight,395,"When checking the value of year we");

    }


    @Test
        public void getYearTest() {
        Flight testFlight = createFlight("2017","Boston, MA (Metropolitan Area)","Richmond, VA",132.355884,395);
        assertEquals("With an Flight object who's year instance variable is 2017, when calling getYear we","2017",testFlight.getYear());
    }

    @Test
        public void setYearTest() {
        Flight testFlight = createFlight("2017","Boston, MA (Metropolitan Area)","Richmond, VA",132.355884,395);
        testFlight.setYear("2020");
        testVariable("year",testFlight,"2020","After calling Flight's setYear method with an argument of 2020, for the value of year we");
    }

    @Test
        public void getStartCityTest() {
        Flight testFlight = createFlight("2017","Boston, MA (Metropolitan Area)","Richmond, VA",132.355884,395);
        assertEquals("With an Flight object who's startCity instance variable is Boston, MA (Metropolitan Area), when calling getStartCity we","Boston, MA (Metropolitan Area)",testFlight.getStartCity());
    }

    @Test
        public void setStartCityTest() {
        Flight testFlight = createFlight("2017","Boston, MA (Metropolitan Area)","Richmond, VA",132.355884,395);
        testFlight.setStartCity("Albuquerque, NM");
        testVariable("startCity",testFlight,"Albuquerque, NM","After calling Flight's setStartCity method with an argument of Albuquerque, NM, for the value of startCity we");
    }

    @Test
        public void getEndCityTest() {
        Flight testFlight = createFlight("2017","Boston, MA (Metropolitan Area)","Richmond, VA",132.355884,395);
        assertEquals("With an Flight object who's endCity instance variable is Richmond, VA, when calling getEndCity we","Richmond, VA",testFlight.getEndCity());
    }

    @Test
        public void setEndCityTest() {
        Flight testFlight = createFlight("2017","Boston, MA (Metropolitan Area)","Richmond, VA",132.355884,395);
        testFlight.setEndCity("Albuquerque, NM");
        testVariable("endCity",testFlight,"Albuquerque, NM","After calling Flight's setEndCity method with an argument of Albuquerque, NM, for the value of endCity we");
    }

    @Test
        public void getPriceTest() {
        Flight testFlight = createFlight("2017","Boston, MA (Metropolitan Area)","Richmond, VA",132.355884,395);
        assertEquals("With an Flight object who's price instance variable is 132.355884, when calling getPrice we",132.355884,testFlight.getPrice(),.1);
    }

    @Test
        public void setPriceTest() {
        Flight testFlight = createFlight("2017","Boston, MA (Metropolitan Area)","Richmond, VA",132.355884,395);
        testFlight.setPrice(172.388734);
        testVariable("price",testFlight,172.388734,"After calling Flight's setPrice method with an argument of 172.388734, for the value of price we");
    }

    @Test
        public void getDistanceTest() {
        Flight testFlight = createFlight("2017","Boston, MA (Metropolitan Area)","Richmond, VA",132.355884,395);
        assertEquals("With an Flight object who's distance instance variable is NONE, when calling getDistance we",395,testFlight.getDistance());
    }

    @Test
        public void setDistanceTest() {
        Flight testFlight = createFlight("2017","Boston, MA (Metropolitan Area)","Richmond, VA",132.355884,395);
        testFlight.setDistance(600);
        testVariable("distance",testFlight,600,"After calling Flight's setDistance method with an argument of WHIPPED_CREAM_AND_CHERRY, for the value of distance we");
    }


    @Test
        public void toStringTest() {
        Flight testFlight = createFlight("2017","Boston, MA (Metropolitan Area)","Richmond, VA",132.355884,395);
        assertEquals(  "2017 Boston, MA (Metropolitan Area) Richmond, VA 132.355884 395", testFlight.toString());

        testFlight = createFlight("2016","Boston, MA (Metropolitan Area)","Buffalo, NY",139.2092115,474);
        assertEquals(  "2016 Boston, MA (Metropolitan Area) Buffalo, NY 139.2092115 474", testFlight.toString());
    }

    @Test
        public void equalsTest() {
        Flight testFlight = createFlight("2017","Boston, MA (Metropolitan Area)","Richmond, VA",132.355884,395);
        Flight anotherTestFlight = createFlight("2016","Boston, MA (Metropolitan Area)","Buffalo, NY",139.2092115,474);
        Flight thirdTestFlight = createFlight("2016","Boston, MA (Metropolitan Area)","Buffalo, NY",139.2092115,474);
        String notFlight = "Hello I should return false!";

        assertTrue(  "When using .equals to compare a Flight with itself we", testFlight.equals(testFlight));
        assertFalse(  "When using .equals to compare a Flight with a logically different Flight we", testFlight.equals(anotherTestFlight));
        assertTrue(  "When using .equals to compare a Flight with a logically equivalent Flight we", anotherTestFlight.equals(thirdTestFlight));
        assertTrue(  "When using .equals to compare a Flight with a logically equivalent Flight (reflexive test) we", thirdTestFlight.equals(anotherTestFlight));
        assertFalse(  "When using .equals to compare a Flight with a String we", testFlight.equals(notFlight));


    }



    private Flight createFlight(String aYear, String aStartCity, String anEndCity, double aPrice, int aDistance){
        Flight testFlight = new Flight();
        @SuppressWarnings("rawtypes")
        Class c = testFlight.getClass();

        try {
            Field year = c.getDeclaredField("year");
            year.setAccessible(true);
            year.set(testFlight, aYear);

            Field startCity = c.getDeclaredField("startCity");
            startCity.setAccessible(true);
            startCity.set(testFlight, aStartCity);

            Field endCity = c.getDeclaredField("endCity");
            endCity.setAccessible(true);
            endCity.set(testFlight, anEndCity);

            Field price = c.getDeclaredField("price");
            price.setAccessible(true);
            price.set(testFlight, aPrice);

            Field distance = c.getDeclaredField("distance");
            distance.setAccessible(true);
            distance.set(testFlight, aDistance);

        } catch (Exception e) {
            fail(e.toString());
        }

        return testFlight;
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

    private void constructorsPublic(Object testObject) {
        @SuppressWarnings("rawtypes")
        Class c = testObject.getClass();
        try {
            for(Constructor aCon : c.getDeclaredConstructors()){
                assertTrue("You must make your constructors public.", Modifier.isPublic(aCon.getModifiers()));
            }
        }catch (Exception e) {
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


            }
            else{
                assertEquals(message, expected, fieldValue);
            }

        }
        catch (Exception e) {
            fail(e.toString());
        }
    }
}
