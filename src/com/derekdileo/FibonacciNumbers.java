package com.derekdileo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/** Class to calculate fibonacci numbers with main method to execute and compare iterative and recursive execution times
 * @author Derek DiLeo
 */
public class FibonacciNumbers {

    /** runTime = endTime - startTime using System.nanoTime() method
     */
    public static long startTime, endTime, runTime;

    /** value = fibonacci number at position && position = nth fibonacci number
     */
    public static int value, position;

    /** Map<Integer, Long> to store positions and times for each method call
      */

    public static Map<Integer, Long> recursiveTimes = new LinkedHashMap<>();
    public static Map<Integer, Long> iterativeTimes = new LinkedHashMap<>();

    /** Main method to run the methods created to return fibonacci number of nth position
      * @param args mandatory String[] array for console line arguments of data type String
     */
    public static void main(String[] args) {

        // position is the desired fibonacci number to be calculated
        position = 10;

        // Print results of fibRecursive(i) && fibIterative(i) for 0 <= i < position
        // [to compare and plot differences in execution times]

        for (int i = 0; i < position; i++) {
            recursiveTimes.put(i, printRecursive(i));
            iterativeTimes.put(i, printIterative(i));
        }
    }

    /** Method to call fibIterative(), record execution time and print results
      * @param position is the nth fibonacci number requested (zero-index)
     */
    private static long printIterative(int position) {
        startTime = System.nanoTime();
        value = fibIterative(position);
        endTime = System.nanoTime();
        runTime = endTime - startTime;
        System.out.println("Iterative runtime for: " + position + " is: " + runTime + " nanoSeconds. Value is: " + value);
        return runTime;
    }

    /** Method to call fibRecursive(), record execution time and print results
     * @param position is the nth fibonacci number requested (zero-index)
     */
    private static long printRecursive(int position) {
        startTime = System.nanoTime();
        value = fibRecursive(position);
        endTime = System.nanoTime();
        runTime = endTime - startTime;
        System.out.println("Recursive runtime for: " + position + " is: " + runTime + " nanoSeconds. Value is: " + value);
        return runTime;
    }

    /** Method uses a for loop to iterate through fibonacci numbers and return value at nth position.
     * @author Derek DiLeo
     * @param position is the nth fibonacci number requested (zero-index)
     * @return value of nth fibonacci number requested
     **/
    public static int fibIterative(int position) {

        /* twoBack = (position - 2), oneBack = (position - 1)
         * current = twoBack + oneBack (with starting value == 1)
         */
        int twoBack, oneBack = 0;
        int current = 1;

        if (position < 0) { // Validate input
            return -1;
        }
        for(int i = 1; i < position; i++) {
            twoBack = oneBack;
            oneBack = current;
            current = twoBack + oneBack;
        }
    return current;
    }

    /** Method uses a recursion to return the nth fibonacci value.
     * @author Derek DiLeo
     * @param position is the nth fibonacci number requested (zero-index)
     * @return value of nth fibonacci number requested
     */
    public static int fibRecursive(int position) {
        if (position < 0) { // Validate input
            return -1;
        }
        if (position == 0) {
            return 0;
        }
        if (position == 1 || position == 2) {
            return 1;
        }
        return fibRecursive(position - 2) + fibRecursive(position - 1);
    }

}
