package Labs.Lab_8;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class ArrayTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final String newLine = System.lineSeparator();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @Test
    public void firstArrayTest(){
        String[] args = {"Beth,Jerry,Rick,Summer,Morty"};
        Array.main(args);
        String[] rawOutput = outContent.toString().split(newLine);

        assertEquals("When checking the first element of the first array (the 1st line of standard output, we","Beth",rawOutput[0]);
        assertEquals("When checking the second element of the first array (the 2nd line of standard output, we","Jerry",rawOutput[1]);
        assertEquals("When checking the third element of the first array (the 3ed line of standard output, we","Rick",rawOutput[2]);
        assertEquals("When checking the fourth element of the first array (the 4th line of standard output, we","Summer",rawOutput[3]);
        assertEquals("When checking the fifth element of the first array (the 5th line of standard output, we","Morty",rawOutput[4]);
        assertEquals("When checking the sixth element of the first array (the 6th line of standard output, we","null",rawOutput[5]);
        assertEquals("When checking the seventh element of the first array (the 7th line of standard output, we","null",rawOutput[6]);
    }

    @Test
    public void secondArrayTest() {
        String[] args = {"Beth,Jerry,Rick,Summer,Morty"};
        Array.main(args);
        String[] rawOutput = outContent.toString().split(newLine);

        assertEquals("When checking the first element of the second array (the 9th line of standard output, we","Beth",rawOutput[8]);
        assertEquals("When checking the second element of the second array (the 10th line of standard output, we","Jerry",rawOutput[9]);
        assertEquals("When checking the third element of the second array (the 11th line of standard output, we","Rick",rawOutput[10]);
        assertEquals("When checking the fourth element of the second array (the 12th line of standard output, we","Rick",rawOutput[11]);
        assertEquals("When checking the fifth element of the second array (the 13th line of standard output, we","Jessica",rawOutput[12]);
        assertEquals("When checking the sixth element of the second array (the 14th line of standard output, we","Summer",rawOutput[13]);
        assertEquals("When checking the seventh element of the second array (the 15th line of standard output, we","Morty",rawOutput[14]);

    }

    @Test
    public void thirdArrayTest() {
        String[] args = {"Beth,Jerry,Rick,Summer,Morty"};
        Array.main(args);
        String[] rawOutput = outContent.toString().split(newLine);

        assertEquals("When checking the first element of the third array (the 17th line of standard output, we","Beth",rawOutput[16]);
        assertEquals("When checking the second element of the third array (the 18th line of standard output, we","Jerry",rawOutput[17]);
        assertEquals("When checking the third element of the third array (the 19th line of standard output, we","Jessica",rawOutput[18]);
        assertEquals("When checking the fourth element of the third array (the 20th line of standard output, we","Summer",rawOutput[19]);
        assertEquals("When checking the fifth element of the third array (the 21st line of standard output, we","Morty",rawOutput[20]);
        assertEquals("When checking the sixth element of the third array (the 22nd line of standard output, we","null",rawOutput[21]);
        assertEquals("When checking the seventh element of the third array (the 23rd line of standard output, we","null",rawOutput[22]);
    }

    @Test
    public void fourthArrayTest() {
        String[] args = {"Beth,Jerry,Rick,Summer,Morty"};
        Array.main(args);
        String[] rawOutput = outContent.toString().split(newLine);

        assertEquals("When checking the first element of the fourth array (the 25th line of standard output, we","null",rawOutput[24]);
        assertEquals("When checking the second element of the fourth array (the 26th line of standard output, we","null",rawOutput[25]);
        assertEquals("When checking the third element of the fourth array (the 27th line of standard output, we","Morty",rawOutput[26]);
        assertEquals("When checking the fourth element of the fourth array (the 28th line of standard output, we","Summer",rawOutput[27]);
        assertEquals("When checking the fifth element of the fourth array (the 29th line of standard output, we","Jessica",rawOutput[28]);
        assertEquals("When checking the sixth element of the fourth array (the 30th line of standard output, we","Jerry",rawOutput[29]);
        assertEquals("When checking the seventh element of the fourth array (the 31st line of standard output, we","Beth",rawOutput[30]);

    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }

}