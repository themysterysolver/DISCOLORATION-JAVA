import java.util.Scanner;

public class GameLogic {
    public int[][] board;
    public int n;
    int [][] directions=new int[][]{{0,1},{1,0},{-1,0},{0,-1},{0,0}};
    public GameLogic(int n){
        //System.out.println("Game LEVEL-"+n);
        board=new int[n][n];
        this.n=n;
        //display();
        //startGame();
    }

    private void startGame() {
        Scanner input=new Scanner(System.in);
        while(gameIsNotOver()){
            System.out.println("Enter position:");
            int position=input.nextInt();
            clickTile(position);
            display();
        }
        if(n==6){
            System.exit(1);
        }
        new GameLogic(n+1);
    }

    private void clickTile(int position) {
        int row=position/n;
        int col=position%n;
        surroundTile(row,col);
    }
    public void clickTile(int x,int y) {
        surroundTile(x,y);
    }

    private void surroundTile(int row, int col) {
        for(int[] d:directions){
            int x=d[0];
            int y=d[1];
            int nx=row+x;
            int ny=col+y;
            if(nx<0||ny<0||nx>=n||ny>=n){
                continue;
            }else{
                if(board[nx][ny]==1){
                    board[nx][ny]=0;
                }else{
                    board[nx][ny]=1;
                }
            }
        }

    }

    public boolean gameIsNotOver() {
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==1){count++;}
            }
        }
        return count!=(n*n);
    }

    private void display(){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

}
