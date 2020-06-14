package com.t0ha.algorithms.chapter1.section1.exercise11;

public class TwoDimensionalBooleanPrinter {
    public static final String NEWLINE = System.getProperty("line.separator");

    public static String generateString(boolean[][] a) {
        return appendRowsWithValues(appendColumns(new StringBuilder(), a), a).toString();
    }

    private static StringBuilder appendColumns(StringBuilder buf, boolean[][] a) {
        buf.append("  ");
        for (int n = 0; n < findMaxRowLen(a); n++) spaced(buf, n);
        buf.append(NEWLINE);
        return buf;
    }

    private static StringBuilder appendRowsWithValues(StringBuilder buf, boolean[][] a) {
        for (int row = 0; row < a.length; row++) {
            spaced(buf, row);
            for (int col = 0; col < rowLen(a, row); col++) spaced(buf, represent(a[row][col]));
            buf.append(NEWLINE);
        }
        return buf;
    }

    private static int findMaxRowLen(boolean[][] a) {
        int maxLen = 0;
        for (int row = 0; row < a.length; row++) {
            int rowLen = rowLen(a, row);
            if (rowLen > maxLen) maxLen = rowLen;
        }
        return maxLen;
    }

    private static void spaced(StringBuilder buf, int i) {
        buf.append(i).append(' ');
    }

    private static void spaced(StringBuilder buf, char c) {
        buf.append(c).append(' ');
    }

    private static int rowLen(boolean[][] a, int row) {
        return a[row].length;
    }

    private static char represent(boolean b) {
        return b ? '*' : ' ';
    }
}
