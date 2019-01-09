package I.HashTable.Easy.CommonNumbersOfTwoSortedArrays;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CommonNumbersOfTwoSortedArraysTest {
    private static CommonNumbersOfTwoSortedArrays commonNumbers;
    private List<Integer> A;
    private List<Integer> B;

    @BeforeAll
    static void setInstance() {
        commonNumbers = new CommonNumbersOfTwoSortedArrays();
    }

    @BeforeEach
    void setUp() {
        A = null;
        B = null;
    }

    @AfterEach
    void tearDown() {
    }


    @Test
    void testNullAndEmpty() {
        // Both A and B are null
        List<Integer> expected = new ArrayList<>();
        assertEquals(expected, commonNumbers.common(A, B));
        assertEquals(expected, commonNumbers.commonAlt(A, B));
        // A is null while B is not
        B = new ArrayList<>(Collections.singletonList(0));
        assertEquals(expected, commonNumbers.common(A, B));
        assertEquals(expected, commonNumbers.commonAlt(A, B));
        // A is not null while B is
        B = null;
        A = new ArrayList<>(Collections.singletonList(0));
        assertEquals(expected, commonNumbers.common(A, B));
        assertEquals(expected, commonNumbers.commonAlt(A, B));
        // A is empty while B is not
        A = new ArrayList<>();
        B = new ArrayList<>(Collections.singletonList(0));
        assertEquals(expected, commonNumbers.common(A, B));
        assertEquals(expected, commonNumbers.commonAlt(A, B));
        // A is not empty while B is
        A = new ArrayList<>(Collections.singletonList(0));
        B = new ArrayList<>();
        assertEquals(expected, commonNumbers.common(A, B));
        assertEquals(expected, commonNumbers.commonAlt(A, B));
    }

    @Test
    void testOne() {
        /* Method 1 */
        A = new ArrayList<>(Arrays.asList(1, 1, 2, 2, 3));
        B = new ArrayList<>(Arrays.asList(1, 1, 2, 5, 6));
        List<Integer> result = commonNumbers.common(A, B);
        List<Integer> expected = new ArrayList<>(Arrays.asList(1, 1, 2));
        System.out.println("List A = " + A);
        System.out.println("List B = " + B);
        System.out.println("Expected result = " + expected);
        System.out.println("Actual result   = " + result);
        /* Method 2 */
        List<Integer> resultAlt = commonNumbers.commonAlt(A, B);
        List<Integer> expectedAlt = new ArrayList<>(Arrays.asList(1, 1, 2));
        System.out.println("List A = " + A);
        System.out.println("List B = " + B);
        System.out.println("Expected result = " + expected);
        System.out.println("Actual result   = " + result);
    }

    @Test
    void testTwo() {
        /* Method 1 */
        A = new ArrayList<>(Arrays.asList(1, 1, 1, 1));
        B = new ArrayList<>(Arrays.asList(1, 1, 1,1));
        List<Integer> result = commonNumbers.common(A, B);
        List<Integer> expected = new ArrayList<>(Arrays.asList(1, 1, 1,1));
        System.out.println("List A = " + A);
        System.out.println("List B = " + B);
        System.out.println("Expected result = " + expected);
        System.out.println("Actual result   = " + result);
        /* Method 2 */
        A = new ArrayList<>(Arrays.asList(1, 1, 1, 1));
        B = new ArrayList<>(Arrays.asList(1, 1, 1,1));
        List<Integer> resultAlt = commonNumbers.commonAlt(A, B);
        List<Integer> expectedAlt = new ArrayList<>(Arrays.asList(1, 1, 1,1));
        System.out.println("List A = " + A);
        System.out.println("List B = " + B);
        System.out.println("Expected result = " + expected);
        System.out.println("Actual result   = " + result);
    }
}
