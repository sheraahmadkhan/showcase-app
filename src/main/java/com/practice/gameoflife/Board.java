// Created by sherakhan

package com.practice.gameoflife;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class Board {
    private Map<String, Cell> oldStateOfCells;
    private int rows;
    private int cols;
    private Random random;

    public Board(int rows, int cols) {
        throwIf(rows < 1, IllegalArgumentException::new);
        throwIf(cols < 1, IllegalArgumentException::new);
        this.rows = rows;
        this.cols = cols;
        this.random = new Random();
        oldStateOfCells = new LinkedHashMap<>();
    }

    public void initialize() {
        IntStream.range(0, rows).forEach(row ->
                IntStream.range(0, cols).forEach(col -> {
                    Cell cell = new Cell(row, col);
                    cell.setAlive(random.nextBoolean());
                    oldStateOfCells.put(row + "-" + col, cell);
                }));
    }

    public void run() throws Exception {
        while (true) {
//            Thread.sleep(1000);
//            int xPosition = random.nextInt(rows - 1);
//            int yPosition = random.nextInt(cols - 1);
//            Cell cell = oldStateOfCells.get(xPosition + "-" + yPosition);
            oldStateOfCells.values().forEach(cell -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Position currentPosition = cell.currentPosition();
                Position nextPosition = cell.next();
                Position previousPosition = cell.previous();
                Position abovePosition = cell.above();
                Position belowPosition = cell.below();
                Collection<Boolean> states = new ArrayList<>();
                if (oldStateOfCells.containsKey(nextPosition.getX() + "-" + nextPosition.getY())) {
                    Cell nextCell = oldStateOfCells.get(nextPosition.getX() + "-" + nextPosition.getY());
                    states.add(nextCell.isAlive());
                }

                if (oldStateOfCells.containsKey(previousPosition.getX() + "-" + previousPosition.getY())) {
                    Cell previousCell = oldStateOfCells.get(previousPosition.getX() + "-" + previousPosition.getY());
                    states.add(previousCell.isAlive());
                }

                if (oldStateOfCells.containsKey(abovePosition.getX() + "-" + abovePosition.getY())) {
                    Cell aboveCell = oldStateOfCells.get(abovePosition.getX() + "-" + abovePosition.getY());
                    states.add(aboveCell.isAlive());
                }

                if (oldStateOfCells.containsKey(belowPosition.getX() + "-" + belowPosition.getY())) {
                    Cell belowCell = oldStateOfCells.get(belowPosition.getX() + "-" + belowPosition.getY());
                    states.add(belowCell.isAlive());
                }

                long aliveOnes = states.stream().filter(s -> s).count();
//                System.out.printf("Live Ones %d", aliveOnes);
                if (aliveOnes == 0L) {
                    return;
                }

                Cell currentCell = new Cell(currentPosition.getX(), currentPosition.getY());
                if (currentCell.isAlive()) {
                    if (aliveOnes < 2 || aliveOnes > 3) {
                        currentCell.setAlive(false);
                    } else if (aliveOnes == 2 || aliveOnes == 3) {
                        currentCell.setAlive(true);
                    }
                } else {
                    if (aliveOnes == 3) {
                        currentCell.setAlive(true);
                    }
                }
                oldStateOfCells.put(currentPosition.getX() + "-" + currentPosition.getY(), currentCell);
                new ConsolePrinter().print(rows, cols, oldStateOfCells);
            });
        }
    }

    private static void throwIf(boolean requirement, Supplier<? extends RuntimeException> supplier) {
        if (requirement) {
            throw supplier.get();
        }
    }

    public Map<String, Cell> getOldStateOfCells() {
        return oldStateOfCells;
    }
}
