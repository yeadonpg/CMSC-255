package Project_6;


import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class EnumTests {

    @Test
    public void SizeTest() {
        try {
            Size.valueOf("SINGLE");
            Size.valueOf("DOUBLE");
            Size.valueOf("TRIPLE");
            Size.valueOf("SUNDAE");
        }
        catch(IllegalArgumentException e) {
            fail(e.getLocalizedMessage());
        }
        assertEquals("When looking at the number of values in the Size enum, we",4,Size.values().length);
    }

    @Test
    public void SauceTest() {
        try {
            Sauce.valueOf("NONE");
            Sauce.valueOf("HOT_FUDGE");
            Sauce.valueOf("CARAMEL");
            Sauce.valueOf("STRAWBERRY");
        }
        catch(IllegalArgumentException e) {
            fail(e.getLocalizedMessage());
        }
        assertEquals("When looking at the number of values in the Sauce enum, we",4,Sauce.values().length);
    }

    @Test
    public void ToppingTest() {
        try {
            Topping.valueOf("NONE");
            Topping.valueOf("SPRINKLES");
            Topping.valueOf("NUTS");
            Topping.valueOf("CHOCOLATE_FLAKES");
            Topping.valueOf("GUMMIES");
            Topping.valueOf("CANDY");
        }
        catch(IllegalArgumentException e) {
            fail(e.getLocalizedMessage());
        }
        assertEquals("When looking at the number of values in the Topping enum, we",6,Topping.values().length);
    }

    @Test
    public void ToppingSunTest() {
        try {
            ToppingSun.valueOf("NONE");
            ToppingSun.valueOf("WHIPPED_CREAM_AND_CHERRY");
        }
        catch(IllegalArgumentException e) {
            fail(e.getLocalizedMessage());
        }
        assertEquals("When looking at the number of values in the ToppingSun enum, we",2,ToppingSun.values().length);
    }

}