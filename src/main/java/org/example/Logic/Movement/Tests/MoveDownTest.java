package org.example.Logic.Movement.Tests;

import org.example.Logic.Model.Tile;
import org.example.Logic.Movement.MoveDown;
import org.example.Logic.Utils.TileMerger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

public class MoveDownTest {

    private MoveDown moveDown;
    private TileMerger tileMerger;
    private Tile[][] tiles;

    @BeforeEach
    public void MoveUpTestInit() {
        tileMerger = mock(TileMerger.class);
        moveDown = new MoveDown(tileMerger);
        tiles = new Tile[4][4];
    }

    @Test
    public void testMoveDownWithoutMerge() {
        tiles[0][0] = new Tile(2);
        tiles[0][1] = new Tile(2);
        tiles[0][2] = new Tile(2);

        moveDown.move(tiles);

        assertNull(tiles[0][0]);
        assertNull(tiles[0][1]);
        assertNull(tiles[0][2]);
        assertEquals(2, tiles[3][0].getValue());
        assertEquals(2, tiles[3][1].getValue());
        assertEquals(2, tiles[3][2].getValue());
    }

    @Test
    public void testMoveDownWithMerge(){
        tiles[1][0] = new Tile(2);
        tiles[2][0] = new Tile(2);

        TileMerger tileMerger = spy(TileMerger.class);
        MoveDown moveDown = new MoveDown(tileMerger);

        moveDown.move(tiles);

        assertNull(tiles[1][0]);
        assertNull(tiles[2][0]);
        assertEquals(4, tiles[3][0].getValue());
    }

    @Test
    public void testMoveUpWithMergeWithThreeTilesVertically(){
        tiles[1][0] = new Tile(2);
        tiles[2][0] = new Tile(2);
        tiles[3][0] = new Tile(2);

        TileMerger tileMerger = spy(TileMerger.class);
        MoveDown moveDown = new MoveDown(tileMerger);

        moveDown.move(tiles);

        assertNull(tiles[1][0]);
        assertEquals(4, tiles[3][0].getValue());
        assertEquals(2, tiles[2][0].getValue());
    }

}
