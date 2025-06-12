public class TrainLine_Implementation {
    public static void main(String[] args) {
        TrainLine redLineSB = new TrainLine("Red Line Southbound");
        redLineSB.add("Howard");
        redLineSB.add("Jarvis");
        redLineSB.add("Morse");
        redLineSB.add("Loyola");
        System.out.println(redLineSB);
        // Naive testing ... magic numbers ok
        boolean[] test = new boolean[6];
        final String PASS = "Pass", FAIL = "Fail";
        final String GOOD = "Good Work", BAD = "Need some more work";
        test[0] = redLineSB.indexOf("Jarvis") == 1;
        test[1] = redLineSB.contains("Morse");
        test[2] = redLineSB.indexOf("Kimball") == -1;
        test[3] = !redLineSB.contains("Ridgeland");
        TrainLine demo = new nfs_TrainLine();
        test[4] = demo.indexOf("Loyola") == -1;
        test[5] = !demo.contains("Granville");
        boolean cumulativeTest = true;
        for (int i = 0; i < test.length; i++) {
            cumulativeTest = cumulativeTest && test[i];
            System.out.printf("\nTest %d: %s", i, (test[i]?PASS:FAIL));
        }
        System.out.printf("\n\n%s\n\n", (cumulativeTest?GOOD:BAD));
    } // method main
} // class TrainLine_Implementation
