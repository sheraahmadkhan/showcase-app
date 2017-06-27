package com.practice.gameoflife;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BoardTest {

    @Test(expected = IllegalArgumentException.class)
    public void throwIllegalArgsForInvalidRowNumber() {
        new Board(0, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwIllegalArgsForInvalidColNumber() {
        new Board(1, -1);
    }

    @Test
    public void boardMustInitializeWith4CellsFor2Rows2Cols() {
        Board board = new Board(2, 2);
        board.initialize();

        assertEquals(4, board.getOldStateOfCells().size());
    }

    @Test
    public void boardMustInitializeWith9CellsFor3Rows3Cols() {
        Board board = new Board(3, 3);
        board.initialize();

        assertEquals(9, board.getOldStateOfCells().size());
    }
}