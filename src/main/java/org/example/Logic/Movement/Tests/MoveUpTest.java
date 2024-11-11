package org.example.Logic.Movement.Tests;

import org.example.Logic.Model.Tile;
import org.example.Logic.Movement.MoveUp;
import org.example.Logic.Utils.TileMerger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

public class MoveUpTest {

    private MoveUp moveUp;
    private TileMerger tileMerger;
    private Tile[][] tiles;

    @BeforeEach
    public void MoveUpTestInit() {
        tileMerger = mock(TileMerger.class);
        moveUp = new MoveUp(tileMerger);
        tiles = new Tile[4][4];
    }

    @Test
    public void testMoveUpWithoutMerge() {
        tiles[1][0] = new Tile(2);
        tiles[1][1] = new Tile(2);
        tiles[1][2] = new Tile(2);

        moveUp.move(tiles);

        assertNull(tiles[1][0]);
        assertNull(tiles[1][1]);
        assertNull(tiles[1][2]);
        assertEquals(2, tiles[0][0].getValue());
        assertEquals(2, tiles[0][1].getValue());
        assertEquals(2, tiles[0][2].getValue());
    }

    @Test
    public void testMoveUpWithMerge(){
        tiles[0][0] = new Tile(2);
        tiles[1][0] = new Tile(2);

        TileMerger tileMerger = spy(TileMerger.class);
        MoveUp moveUp = new MoveUp(tileMerger);

        moveUp.move(tiles);

        assertNull(tiles[1][0]);
        assertEquals(4, tiles[0][0].getValue());
    }

    @Test
    public void testMoveUpWithMergeWithThreeTilesVertically(){
        tiles[0][0] = new Tile(2);
        tiles[1][0] = new Tile(2);
        tiles[2][0] = new Tile(2);

        TileMerger tileMerger = spy(TileMerger.class);
        MoveUp moveUp = new MoveUp(tileMerger);

        moveUp.move(tiles);

        assertNull(tiles[2][0]);
        assertEquals(4, tiles[0][0].getValue());
        assertEquals(2, tiles[1][0].getValue());
    }

}
