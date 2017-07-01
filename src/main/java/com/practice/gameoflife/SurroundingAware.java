// Created by sherakhan

package com.practice.gameoflife;


public interface SurroundingAware {
    Position next();

    Position previous();

    Position above();

    Position below();

    Position belowLeftDiagonal();

    Position belowRightDiagonal();

    Position aboveLeftDiagonal();

    Position aboveRightDiagonal();
}
