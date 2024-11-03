package org.example.Logic.Model;

public class Tile {
    private int x;
    private int y;
    private int value;

    public Tile(int x, int y, int value) {
        this.x = x;
        this.y = y;
        this.value = value;
    }

    public boolean canMerge(Tile other) {
        return this.value == other.value;
    }

    public void merge(Tile other) {
        if(canMerge(other)) {
            other.value *= 2;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getValue() {
        return value;
    }
}
