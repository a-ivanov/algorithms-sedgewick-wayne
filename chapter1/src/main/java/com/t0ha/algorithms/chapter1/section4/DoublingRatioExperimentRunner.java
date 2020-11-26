package com.t0ha.algorithms.chapter1.section4;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

public class DoublingRatioExperimentRunner {
    private final int start;
    private final int stop;

    public DoublingRatioExperimentRunner(int start, int stop) {
        this.start = start;
        this.stop = stop;
    }

    public void run(ProgramFactory programFactory) {
        double prev = timeTrial(programFactory, start);
        for (int n = start + start; n > 0 && n <= stop; n += n) {
            double time = timeTrial(programFactory, n);
            StdOut.printf("%10d %7.1f %5.1f\n", n, time, time / prev);
            prev = time;
        }
    }

    private double timeTrial(ProgramFactory programFactory, int n) {
        Runnable program = programFactory.create(n);
        Stopwatch timer = new Stopwatch();
        program.run();
        return timer.elapsedTime();
    }

    @FunctionalInterface
    public interface ProgramFactory {
        Runnable create(int inputSize);
    }
}
