// Created by sherakhan

package com.practice.gameoflife;

import java.util.Map;
import java.util.stream.IntStream;

public class ConsolePrinter implements Printable {
    @Override
    public void print(int rows, int cols, Map<String, Cell> cells) {
//        System.out.println("\n\t>>>>>>>>>>>");
        IntStream.range(0, rows).forEach(row -> {
            System.out.print("\n");
            IntStream.range(0, cols).forEach(col -> {
                Cell cell = cells.get(row + "-" + col);
                System.out.print(cell);
            });
        });
    }
}
