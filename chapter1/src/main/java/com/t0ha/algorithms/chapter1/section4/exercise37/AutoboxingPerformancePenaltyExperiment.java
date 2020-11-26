package com.t0ha.algorithms.chapter1.section4.exercise37;

import com.t0ha.algorithms.chapter1.section4.DoublingRatioExperimentRunner;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * <em>Autoboxing performance penalty</em>. Run experiments to determine the performance
 * penalty on your machine for using autoboxing and auto-unboxing. Develop an
 * implementation {@code FixedCapacityStackOfInts} and use a client such as {@code DoublingRatio}
 * to compare its performance with the generic {@code FixedCapacityStack<Integer>}, for a
 * large number of {@code push()} and {@code pop()} operations.
 */
public class AutoboxingPerformancePenaltyExperiment {
    private static final int MAXIMUM_INTEGER = 1_000_000;

    public static void main(String[] args) {
        DoublingRatioExperimentRunner runner = new DoublingRatioExperimentRunner(200_000, 1_638_400_000);
        StdOut.println("Primitive stack implementation:");
        runner.run(inputSize -> {
            int[] input = createRandomIntInput(inputSize);
            FixedCapacityStackOfInts stack = new FixedCapacityStackOfInts(1);
            return () -> {
                for (int i = 0; i < inputSize; i++) {
                    stack.push(input[i]);
                    stack.pop();
                }
            };
        });
        StdOut.println();
        StdOut.println("Generic stack implementation:");
        runner.run(inputSize -> {
            int[] input = createRandomIntInput(inputSize);
            FixedCapacityStack<Integer> stack = new FixedCapacityStack<>(1);
            return () -> {
                for (int i = 0; i < inputSize; i++) {
                    stack.push(input[i]);
                    stack.pop();
                }
            };
        });
    }

    private static int[] createRandomIntInput(int inputSize) {
        int[] input = new int[inputSize];
        for (int i = 0; i < inputSize; i++) {
            input[i] = StdRandom.uniform(-MAXIMUM_INTEGER, MAXIMUM_INTEGER);
        }
        return input;
    }
}
