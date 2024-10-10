package org.example;

public  class Variant12 {

    public int[] getEvenIndexedElements(int[] A) {
        int n = A.length / 2;
        int[] result = new int[n];
        for (int i = 0, j = 1; i < n; i++, j += 2) {
            result[i] = A[j];
        }
        return result;
    }

    // Boolean12 Task
    public boolean areAllPositive(int A, int B, int C) {
        return A > 0 && B > 0 && C > 0;
    }

}