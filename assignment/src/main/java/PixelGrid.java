public class PixelGrid {
    private int[][] grid;

    private int cursorRow = 0;
    private int cursorCol = 0;

    public PixelGrid(){
        this.grid = new int[8][8];
    }

    public void moveUp(){
        if(cursorRow > 0){
            cursorRow--;
        }
    }

    public void moveDown(){
        if(cursorRow < 7){
            cursorRow++;
        }
    }

    public void moveLeft(){
        if(cursorCol > 0){
            cursorCol--;
        }
    }

    public void moveRight(){
        if(cursorCol < 7){
            cursorCol++;
        }
    }

    public void togglePixel(){
        grid[cursorRow][cursorCol] = (grid[cursorRow][cursorCol] == 0) ? 1 : 0;
    }


    public int[][] getGrid(){
        return this.grid;
    }

    public int getCursorRow(){
        return this.cursorRow;
    }

    public int getCursorCol(){
        return this.cursorCol;
    }
    
}
