public class SnakeGame {
    private boolean[][] game;
    private int[] headposition;
    private static int exhaustiveCheck;
    private static int recursiveCheck;

    public SnakeGame (){
    boolean[] game = new boolean [1];
    }

    public SnakeGame(boolean[][] snakeGame, int x, int y){
       for(x = 0; x < snakeGame.length; x++){
           for(y = 0; y<snakeGame[0].length;y++){
              snakeGame[x][y] = game[x][y];
           }
       }
       headposition = new int[]{x, y};

    }

    public int neighbors(boolean[][] arr){
        int count = 0;

        for(int i = 0; i< arr.length;i++){
            for (int j = 0; i <arr[0].length;j++){
                if(arr[i-1][j+1] = true){
                    count++;
                }if(arr[i+1][j-1] = true){
                    count++;
                }if(arr[i-1][j] = true){
                    count++;
                }if(arr[i+1][j] = true){
                    count++;
                }
            }
        }
        return count;
    }

    public int[] findTailExhaustive(){//finds the tail of the snake by searching the whole grid, keeps track of how many cells searched. Stop when it finds the tail.
        resetCounters();
        int snakeLength = 0;
        int[] findTail = {0,0,0};
        //checking neighbors

        for(int i =0; i<game.length;i++){
            for(int j = 0; j< game[i].length;j++){
                if(game[i][j]) {
                    if (i==headposition[0] && j==headposition[1]) { //if part of snake
                        snakeLength++;
                    }
                }
                if((neighbors(game) == 1)&&(i!=headposition[0] && j!=headposition[1])){
                    findTail[0] = i;
                    findTail[1] = j;
                    findTail[2] = snakeLength;
                    break;
                }else{
                    exhaustiveCheck--;
                }
            }
        }
        return findTail;
    }

    public int[] findTailRecursive(){ //Starts the search to look for the tail using the head position.
        resetCounters();
        return findTailRecursive(headposition,headposition);
    }

    public int[] findTailRecursive(int[] currentPosition, int[] previousPosition){//for actual checking.
        resetCounters();
        if((neighbors(game) == 1) && (currentPosition != headposition) && (previousPosition!= currentPosition)){
            return findTailRecursive(headposition, headposition);
        }else if (neighbors(game) ==1){
           return findTailRecursive(new int[]{0, 0},currentPosition);
        }
        return findTailRecursive(currentPosition,previousPosition);
    }

    private void resetCounters(){
        int count = 0;
    }

    public static int getExhaustiveCheck(){
        return exhaustiveCheck;
    }

    public static int getRecursiveCheck(){
        return recursiveCheck;
    }
}
