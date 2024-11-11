package org.example.Logic.Model;

public class Tile {
    private int value;

    public Tile(int value) {
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

    public int getValue() {
        return value;
    }
}
