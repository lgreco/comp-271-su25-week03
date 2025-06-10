import java.util.Arrays; // for printing only, using toString()

public class MinHeap_Implement {

    // ANSI escape codes for terminal print formatting
    public static final String RED = "\u001B[31m";
    public static final String BOLD = "\u001B[1m";
    public static final String MAGENTA = "\u001B[35m";
    public static final String RESET = "\u001B[0m";

    // Test constants
    final static int[] TEST_DATA_1 = { 40, 30, 20, 10 };
    final static int[] TEST_DATA_2 = { 3, 2, 1 };
    final static String PASS = "pass", FAIL = "fail";
    final static String GOOD = BOLD + MAGENTA + "Good work!" + RESET;
    final static String FIX = BOLD + RED + "Need to fix something?" + RESET;

    /** Naive testing for MinHeap class */
    public static void main(String[] args) {
        // Set up a minheap object and populate with first round of test data
        MinHeap demo = new MinHeap();
        for (int value : TEST_DATA_1) {
            demo.add(value);
        }
        // Set up test variables
        boolean[] naiveTest = new boolean[TEST_DATA_1.length - 1 + TEST_DATA_2.length];
        boolean allTests = true;
        // Run and report on first round of tests
        for (int i = 0; i < TEST_DATA_1.length - 1; i++) {
            naiveTest[i] = demo.getSmallest() == TEST_DATA_1[TEST_DATA_1.length - 1 - i];
            allTests = allTests && naiveTest[i];
            System.out.printf("\nTest %02d: %s", i, (naiveTest[i]) ? PASS : FAIL);
        }
        // Populate minheap with second round of test data
        for (int value : TEST_DATA_2) {
            demo.add(value);
        }
        // Run and report on second round of tests
        for (int i = 0; i < TEST_DATA_2.length; i++) {
            naiveTest[TEST_DATA_2.length + i] = demo.getSmallest() == TEST_DATA_2[TEST_DATA_2.length - 1 - i];
            allTests = allTests && naiveTest[TEST_DATA_2.length + i];
            System.out.printf("\nTest %02d: %s", TEST_DATA_2.length + i,
                    (naiveTest[TEST_DATA_2.length - 1 + i]) ? PASS : FAIL);
        }
        // Final test report
        System.out.printf("\n%s\n\n", (allTests) ? GOOD : FIX);
    }
} // class MinHeap_Implement