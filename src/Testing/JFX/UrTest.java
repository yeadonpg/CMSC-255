package Testing.JFX;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UrTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    @Before
    public void setUp() throws Exception {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    /** Returns System.out lines as an array of strings **/
    private String[] getOutputLines() {
        String rawOutput = outContent.toString();
        return  rawOutput.split("\n");
    }

    /** Sets up pieces in starting positions;
     * For use at the beginning of each MoveTest **/
    private void setUpPieces() {
        Ur.whiteOnBoard[3][2] = true;
        Ur.blackOnBoard[3][0] = true;
    }

    @Test
    /** Attempting to land on occupied rosette space **/
    public void MoveTest1() {
        setUpPieces();
        Ur.movePiece(new int[] {3, 0}, 7);
        Ur.movePiece(new int[] {3, 2}, 7);
        assertTrue(Ur.whiteOnBoard[3][2]);
    }

    @Test
    /** Attempting to move  **/
    public void MoveTest2() {
        setUpPieces();
    }

    @After
    public void tearDown() throws Exception {
        System.setOut(null);
        System.setErr(null);
    }
}