// Created by sherakhan

package com.practice.gameoflife;

public class GameOfLife implements Runnable {

    private Board board;

    public GameOfLife(int rows, int cols) {
        this.board = new Board(rows, cols);
    }

    @Override
    public void run() {
        try {
            board.initialize();
            board.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new GameOfLife(5, 5).run();
    }
}
