public class SnakeGame {
    private boolean[][] game;
    private int[] headposition;
    private static int exhaustiveCheck;
    private static int recursiveCheck;

    public SnakeGame (){
    boolean[] game = new boolean [1];
    }

    public SnakeGame(boolean[][] snakeGame, int x, int y){
       for(x = 0; x< game.length; x++){
           for(y = 0; y<game[0].length;y++){
               game[x][y] = snakeGame[x][y];
           }
       }
       headposition = new int[]{x, y};

    }

    public int neighbors(){
        int count = 0;
        int[][] arr;
        for(int i = 0; i< arr.length;i++){
            for (int j = 0; i <arr[0].length;j++){
                if(arr[i-1][j] = true){
                    count++;
                }if (arr[i+1][j-1] = true){
                    count++;
                }
            }
        }
        return count;
    }

    public int[] finalTailExhaustive(){//finds the tail of the snake by searching the whole grid, keeps track of how many cells searched. Stop when it finds the tail.
        resetCounters();
        int snakeLength = 0;
        int[] findTail = {0,0,0};
        //checking neighbors means i = current position. i+1 = , i-1 = ,

        for(int i =0; i<game.length;i++){
            for(int j = 0; j< game[i].length;j++){
                if(i==headposition[0] && j==headposition[1]) {
                    if (game[i][j] = true) { //if part of snake
                        snakeLength++;
                        count++;
                    }
                    if(game[i][j]){
                        if()
                    }
                }//if not foundTail
                       // if tail + not head +1neighbor
                            //return i,j,length
                            //foundTail = true
                    //else foundTail
                        //exhaust check --
            }
        }
    }


    public int[] finalTailRecursive(){ //Starts the search to look for the tail using the head position.
        resetCounters();
        return finalTailRecursive(headposition,headposition);
    }

    public int[] finalTailRecursive(int[] currentPosition, int[] previousPosition){//for actual checking.
        resetCounters();
        if((neighbors() == 1) && (currentPosition != headposition) && (previousPosition!= currentPosition)){
            return finalTailRecursive(headposition, headposition);
        }else if (neighbors() ==1){
           return finalTailRecursive(previousPosition)
        }


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
