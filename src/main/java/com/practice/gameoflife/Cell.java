// Created by sherakhan

package com.practice.gameoflife;

public class Cell implements SurroundingAware {
    private Position position;
    private boolean alive;

    public Cell(int x, int y) {
        this.position = new Position(x, y);
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public Position currentPosition() {
        return position;
    }

    @Override
    public Position next() {
        Position newPosition = new Position(currentPosition());
        newPosition.incY();
        return newPosition;
    }

    @Override
    public Position previous() {
        Position newPosition = new Position(currentPosition());
        newPosition.decY();
        return newPosition;
    }

    @Override
    public Position above() {
        Position newPosition = new Position(currentPosition());
        newPosition.decX();
        return newPosition;
    }

    @Override
    public Position below() {
        Position newPosition = new Position(currentPosition());
        newPosition.incX();
        return newPosition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cell cell = (Cell) o;

        return cell.currentPosition().getX() == this.currentPosition().getX() &&
         cell.currentPosition().getY() == this.currentPosition().getY();
    }

    @Override
    public int hashCode() {
        return 31 * position.getX() + position.getY();
    }

    @Override
    public String toString() {
        if(alive){
            return "*";
        }else {
            return "-";
        }
    }
}
