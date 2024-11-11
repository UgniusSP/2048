package MovementTests;

import org.example.Logic.Model.Tile;
import org.example.Logic.Movement.MoveLeft;
import org.example.Logic.Utils.TileMerger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;

public class MoveLeftTest {

    private MoveLeft moveLeft;
    private TileMerger tileMerger;
    private Tile[][] tiles;

    @BeforeEach
    public void MoveLeftTestInit() {
        tileMerger = mock(TileMerger.class);
        moveLeft = new MoveLeft(tileMerger);
        tiles = new Tile[4][4];
    }

    @Test
    public void testMoveLeftWithoutMerge() {
        tiles[0][3] = new Tile(2);
        tiles[1][3] = new Tile(2);
        tiles[2][3] = new Tile(2);

        moveLeft.move(tiles);

        assertNull(tiles[0][3]);
        assertNull(tiles[1][3]);
        assertNull(tiles[2][3]);
        assertEquals(2, tiles[0][0].getValue());
        assertEquals(2, tiles[1][0].getValue());
        assertEquals(2, tiles[1][0].getValue());
    }

    @Test
    public void testMoveLeftWithMerge(){
        tiles[0][0] = new Tile(2);
        tiles[0][1] = new Tile(2);

        TileMerger tileMerger = spy(TileMerger.class);
        MoveLeft moveLeft = new MoveLeft(tileMerger);

        moveLeft.move(tiles);

        assertNull(tiles[0][1]);
        assertEquals(4, tiles[0][0].getValue());
    }

    @Test
    public void testMoveLeftWithMergeWithThreeTilesHorizontally(){
        tiles[0][0] = new Tile(2);
        tiles[0][1] = new Tile(2);
        tiles[0][2] = new Tile(2);

        TileMerger tileMerger = spy(TileMerger.class);
        MoveLeft moveLeft = new MoveLeft(tileMerger);

        moveLeft.move(tiles);

        assertNull(tiles[0][2]);
        assertEquals(2, tiles[0][1].getValue());
        assertEquals(4, tiles[0][0].getValue());

    }
}
