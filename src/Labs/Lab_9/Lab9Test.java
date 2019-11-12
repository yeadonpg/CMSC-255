package Labs.Lab_9;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class Lab9Test {

    @Test
    public void testIsEmpty() {
        int[][] actual = {};
        int[][] expected = {};
        Lab9.addTo10(actual);
        assertArrayEquals("Incorrect result", expected, actual);
    }

    @Test
    public void testOneRow() {
        int[][] actual = { { 1, 3, 0, 1 } };
        int[][] expected = { { 1, 3, 5, 1 } };
        Lab9.addTo10(actual);
        assertArrayEquals("Incorrect result", expected, actual);
    }

    @Test
    public void testSeveralRows1() {
        int[][] actual = { { 0, 1, 2, 3, 4 }, { 1, 1, 0, 1, 1 }, { 5, 3, 1, 2, 0 } };
        int[][] expected = { { 0, 1, 2, 3, 4 }, { 1, 1, 6, 1, 1 }, { 5, 3, 1, 2, -1 } };
        Lab9.addTo10(actual);
        assertArrayEquals("Incorrect result", expected, actual);
    }

    @Test
    public void testSeveralRows2() {
        int[][] actual = { { 0, 1 }, { 9, 0 }, { 0, 19 }, { -1, 0 } };
        int[][] expected = { { 9, 1 }, { 9, 1 }, { -9, 19 }, { -1, 11 } };
        Lab9.addTo10(actual);
        assertArrayEquals("Incorrect result", expected, actual);
    }

    @Test
    public void testSeveralRowsOfVariousLengths() {
        // Hint: Use the number of elements on each row independently!
        int[][] actual = { { 0, 1, 1, 1 }, { 2, 0 }, { 3, 3, 0, 3, 3 } };
        int[][] expected = { { 7, 1, 1, 1 }, { 2, 8 }, { 3, 3, -2, 3, 3 } };
        Lab9.addTo10(actual);
        assertArrayEquals("Incorrect result", expected, actual);
    }

    @Test
    public void testSetHintNumbersOneMine() {
        int[][] actual = { { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 }, { 0, 0, -1, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 } };
        int[][] expected = { { 0, 0, 0, 0, 0, 0 }, { 0, 1, 1, 1, 0, 0 }, { 0, 1, -1, 1, 0, 0 }, { 0, 1, 1, 1, 0, 0 },
                { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 } };
        Lab9.setHints(actual);
        assertArrayEquals("Incorrect result", expected, actual);
    }

    @Test
    public void testSetHintNumbersTwoMinesAwayFromThemselvesAndBoundaries() {
        int[][] array = { { 0, 0, 0, 0, 0, 0 }, { 0, -1, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, -1, 0 }, { 0, 0, 0, 0, 0, 0 } };
        int[][] expected = { { 1, 1, 1, 0, 0, 0 }, { 1, -1, 1, 0, 0, 0 }, { 1, 1, 1, 0, 0, 0 }, { 0, 0, 0, 1, 1, 1 },
                { 0, 0, 0, 1, -1, 1 }, { 0, 0, 0, 1, 1, 1 } };
        Lab9.setHints(array);
        assertArrayEquals("Incorrect result", expected, array);
    }

    @Test
    public void testSetHintNumbersThreeMinesCloseToThemselvesAndBoundaries() {
        int[][] array = { { 0, -1, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 }, { -1, 0, 0, 0, 0, 0 }, { -1, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 } };
        int[][] expected = { { 1, -1, 1, 0, 0, 0 }, { 2, 2, 1, 0, 0, 0 }, { -1, 2, 0, 0, 0, 0 }, { -1, 2, 0, 0, 0, 0 },
                { 1, 1, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 } };
        Lab9.setHints(array);
        assertArrayEquals("Incorrect result", expected, array);
    }

    @Test
    public void testSetHintNumbersSeveralMines() {
        int[][] array = { { -1, 0, 0, 0, 0, -1 }, { 0, 0, 0, 0, 0, 0 }, { 0, 0, -1, -1, 0, 0 }, { 0, 0, -1, -1, 0, 0 },
                { 0, 0, 0, 0, 0, 0 }, { -1, 0, 0, 0, 0, -1 } };
        int[][] expected = { { -1, 1, 0, 0, 1, -1 }, { 1, 2, 2, 2, 2, 1 }, { 0, 2, -1, -1, 2, 0 },
                { 0, 2, -1, -1, 2, 0 }, { 1, 2, 2, 2, 2, 1 }, { -1, 1, 0, 0, 1, -1 } };
        Lab9.setHints(array);
        assertArrayEquals("Incorrect result", expected, array);
    }

}