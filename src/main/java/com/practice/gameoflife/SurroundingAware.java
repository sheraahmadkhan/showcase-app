// Created by sherakhan

package com.practice.gameoflife;


public interface SurroundingAware {
    Position next();

    Position previous();

    Position above();

    Position below();
}
