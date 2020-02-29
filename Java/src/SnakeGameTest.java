import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SnakeGameTest {

    @Test
    public void snakeGameTest(){ //wanted to test just the neighbors
        boolean[][] arr = {{true, false, false},
                {true, true, false},
                {false, true, false}};


        SnakeGame snake = new SnakeGame(arr,0,0);
        assertEquals(4,snake.neighbors(arr));

    }

    @Test
    public void snakeGameTest2(){//wanted to test the recursive method
        boolean[][] arr = {{false, false, false},
                {true, true, true},
                {false, false, false}};

        SnakeGame snake = new SnakeGame(arr,1,0);
        snake.neighbors(arr);
        assertArrayEquals(new int[]{1,2},snake.findTailRecursive());
    }

    @Test
    public void snakeGameTest3(){//i wanted to see the outcome if the 2D array wasn't the same size.
        boolean[][] arr = {{false, true},
                {false, true},
                {false, true}};

        SnakeGame snake = new SnakeGame(arr,0,1);
        snake.neighbors(arr);
        assertArrayEquals(new int[]{2,1,3},snake.findTailExhaustive());
    }

    @Test
    public void snakeGameTest4(){// wanted to see the outcome if the 2D array was on a smaller grid.
        boolean[][] arr = {{true, false},
                {true, true}};

        SnakeGame snake = new SnakeGame(arr,1,1);
        snake.neighbors(arr);
        assertArrayEquals(new int[]{0,0,3},snake.findTailExhaustive());
    }

    @Test
    public void snakeGameTest5(){ // wanted to see the outcome if snake was longer
        boolean[][] arr = {{true, false, false, false},
                {true, true, false, false},
                {false, true, false, false},
                {false, true, true, false}};

        SnakeGame snake = new SnakeGame(arr,0,0);
        snake.neighbors(arr);
        assertArrayEquals(new int[]{3,2,6},snake.findTailExhaustive());
    }

    @Test
    public void snakeGameTest6(){ //used this test case because I wanted to see what would it initialize if the snake head is at the corner where the left and upper place is out of bounds
        boolean[][] arr = {{true, false, false},
                {true, true, false},
                {false, false, false}};

        SnakeGame snake = new SnakeGame(arr,0,0);
        snake.neighbors(arr);
        assertArrayEquals(new int[]{1,1,3},snake.findTailExhaustive());
    }

    @Test
    public void snakeGameTest7(){ // small grid with no false spaces
        boolean[][] arr = {{true, true},
                {true, true}};

        SnakeGame snake = new SnakeGame(arr,1,0);
        snake.neighbors(arr);
        assertArrayEquals(null,snake.findTailRecursive(new int[] {0,0}, new int[] {0,1}));
    }

    @Test
    public void snakeGameTest8(){ //wanted to see if it would pass or fail if there was no tail to be found
        boolean[][] arr = {{false, false, false},
                {false, true, false},
                {false, false, false}};

        SnakeGame snake = new SnakeGame(arr,1,1);
        snake.neighbors(arr);
        assertArrayEquals(null,snake.findTailRecursive(new int[] {0,1}, new int[] {0,1}));
    }

    @Test
    public void snakeGameTest9(){ // Test to see what it would return if there is only a head and a tail in the middle of the grid
        boolean[][] arr = {{false, false, false, false},
                {false, false, false, false},
                {false, true, true, false},
                {false, false, false, false}};

        SnakeGame snake = new SnakeGame(arr,2,2);
        snake.neighbors(arr);
        assertArrayEquals(new int[]{2,1,2},snake.findTailExhaustive());
    }

    @Test
    public void snakeGameTest10(){ //what would it return if the a large snake has multiple true blocks around the tail
        boolean[][] arr = {{false, false, false, false, false, false},
                {false, true, true, true , true, false},
                {false, false, false, true, true, false},
                {false, false, false, true, true, false},
                {false, false, false, false, false, false},
                {false, false, false, false, false, false}};

        SnakeGame snake = new SnakeGame(arr,1,1);
        snake.neighbors(arr);
        assertArrayEquals(new int[]{2,5,8},snake.findTailExhaustive());
    }


}
