package com.example.webapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class DemoController {
    @GetMapping("/sort")
    public List<Integer> sortNumbers() {
        int[] numbers = {5, 2, 9, 1, 5, 6};
        optimizedSort(numbers);
        return Arrays.stream(numbers).boxed().collect(Collectors.toList());
    }

    private void optimizedSort(int[] arr) {
        java.util.Arrays.sort(arr);
    }
} 