package com.example.webapp;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import java.util.Random;

@State(Scope.Thread)
public class BubbleSortBenchmark {
    private int[] numbers;

    public BubbleSortBenchmark() {
        numbers = new Random().ints(1000, 0, 10000).toArray();
    }

    @Benchmark
    public void testBubbleSort() {
        int[] copy = numbers.clone();
        bubbleSort(copy);
    }

    @Benchmark
    public void testOptimizedSort() {
        int[] copy = numbers.clone();
        java.util.Arrays.sort(copy);
    }

    private void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
} 