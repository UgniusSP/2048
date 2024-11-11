package MovementTests;

import org.example.Logic.Model.Tile;
import org.example.Logic.Movement.MoveRight;
import org.example.Logic.Utils.TileMerger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;

public class MoveRightTest {

    private MoveRight moveRight;
    private TileMerger tileMerger;
    private Tile[][] tiles;

    @BeforeEach
    public void MoveRightTestInit() {
        tileMerger = mock(TileMerger.class);
        moveRight = new MoveRight(tileMerger);
        tiles = new Tile[4][4];
    }

    @Test
    public void testMoveRightWithoutMerge() {
        tiles[0][1] = new Tile(2);
        tiles[1][1] = new Tile(2);
        tiles[2][1] = new Tile(2);

        moveRight.move(tiles);

        assertNull(tiles[0][1]);
        assertNull(tiles[1][1]);
        assertNull(tiles[2][1]);
        assertEquals(2, tiles[0][3].getValue());
        assertEquals(2, tiles[1][3].getValue());
        assertEquals(2, tiles[2][3].getValue());
    }

    @Test
    public void testMoveRightWithMerge(){
        tiles[0][2] = new Tile(2);
        tiles[0][1] = new Tile(2);

        TileMerger tileMerger = spy(TileMerger.class);
        MoveRight moveRight = new MoveRight(tileMerger);

        moveRight.move(tiles);

        assertNull(tiles[0][1]);
        assertEquals(4, tiles[0][3].getValue());
    }

    @Test
    public void testMoveRightWithMergeWithThreeTilesHorizontally(){
        tiles[0][0] = new Tile(2);
        tiles[0][1] = new Tile(2);
        tiles[0][2] = new Tile(2);

        TileMerger tileMerger = spy(TileMerger.class);
        MoveRight moveRight = new MoveRight(tileMerger);

        moveRight.move(tiles);

        assertNull(tiles[0][0]);
        assertNull(tiles[0][1]);
        assertEquals(4, tiles[0][3].getValue());
        assertEquals(2, tiles[0][2].getValue());
    }
}
