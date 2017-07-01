package com.practice.gameoflife;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CellTest {

    @Test
    public void cellShouldKnowItsNextCell() {
        Position givenPosition = new Position(0, 0);
        Cell cell = new Cell(0, 0);

        Cell expectedNextCell = new Cell(0, 1);

        Position result = cell.next();

        assertEquals(expectedNextCell.currentPosition(), result);
        assertEquals(givenPosition, cell.currentPosition());
    }

    @Test
    public void cellShouldKnowItsPreviousCell() {
        Cell cell = new Cell(0, 0);

        Cell expectedPreviousCell = new Cell(0, -1);

        Position result = cell.previous();

        assertEquals(expectedPreviousCell.currentPosition(), result);
        assertEquals(new Position(0, 0), cell.currentPosition());
    }

    @Test
    public void cellShouldKnowItsAboveCell() {
        Cell cell = new Cell(0, 0);

        Cell expectedAboveCell = new Cell(-1, 0);

        Position result = cell.above();

        assertEquals(expectedAboveCell.currentPosition(), result);
        assertEquals(new Position(0, 0), cell.currentPosition());
    }

    @Test
    public void cellShouldKnowItsBelowCell() {
        Cell cell = new Cell(0, 0);

        Cell expectedAboveCell = new Cell(1, 0);

        Position result = cell.below();

        assertEquals(expectedAboveCell.currentPosition(), result);
        assertEquals(new Position(0, 0), cell.currentPosition());
    }

    @Test
    public void cellShouldKnowItsBelowLeftDiagonalCell() {
        Cell cell = new Cell(0, 0);

        Cell expectedCell = new Cell(1, -1);

        Position result = cell.belowLeftDiagonal();

        assertEquals(expectedCell.currentPosition(), result);
        assertEquals(new Position(0, 0), cell.currentPosition());
    }

    @Test
    public void cellShouldKnowItsBelowRightDiagonalCell() {
        Cell cell = new Cell(0, 0);

        Cell expectedCell = new Cell(1, 1);

        Position result = cell.belowRightDiagonal();

        assertEquals(expectedCell.currentPosition(), result);
        assertEquals(new Position(0, 0), cell.currentPosition());
    }

    @Test
    public void cellShouldKnowItsAboveLeftDiagonalCell() {
        Cell cell = new Cell(0, 0);

        Cell expectedCell = new Cell(-1, -1);

        Position result = cell.aboveLeftDiagonal();

        assertEquals(expectedCell.currentPosition(), result);
        assertEquals(new Position(0, 0), cell.currentPosition());
    }

    @Test
    public void cellShouldKnowItsAboveRightDiagonalCell() {
        Cell cell = new Cell(0, 0);

        Cell expectedCell = new Cell(-1, 1);

        Position result = cell.aboveRightDiagonal();

        assertEquals(expectedCell.currentPosition(), result);
        assertEquals(new Position(0, 0), cell.currentPosition());
    }
}