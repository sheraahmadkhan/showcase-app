// Created by sherakhan

package com.practice.gameoflife;

import java.util.Map;

public interface Printable {
    void print(int rows, int cols, Map<String, Cell> cells);
}
