import java.util.Scanner;

public class HWeighteen {
     public static void main(String[] args) {
          Grid gameBoard = new Grid(3,3);
          String winner = null;
          Scanner scanner = new Scanner(System.in);
          int Xcoord, Ycoord;
          while(winner == null) {
               //start each round with the grid
               gameBoard.printGrid();

               //player x turn
               System.out.print("player X enter your x coordinate 1-3");
               Xcoord = scanner.nextInt();
               System.out.print("enter your y coordinate 1-3");
               Ycoord = scanner.nextInt();
               gameBoard.setPosition(Xcoord, Ycoord, "X");
               gameBoard.printGrid();

               //player o turn
               System.out.print("player O enter your x coordinate 1-3");
               Xcoord = scanner.nextInt();
               System.out.print("enter your y coordinate 1-3");
               Ycoord = scanner.nextInt();
               gameBoard.setPosition(Xcoord, Ycoord, "O");
               gameBoard.printGrid();

               //check winner
               if(gameBoard.full()){
                    winner = "nobody, its a tie";
               }
               if (winner == null) {
                    winner = checkWinner(gameBoard, "X");
               }
               if(winner == null) {
                    winner = checkWinner(gameBoard, "O");
               }
               if(winner == null) {
                    System.out.println("no winners, next round:");
               }
               else {
                    System.out.println("winner: " + winner);
               }
          }

     }
     public static String checkWinner(Grid gameBoard, String player) {
          String[][] grid = gameBoard.getGrid();
          //straight lines
          for (int i = 0; i < grid.length; i++) {
               if (grid[i][0].equals(player)&&grid[i][1].equals(player)&&grid[i][2].equals(player)) {
                    return player;
               }
               if (grid[0][i].equals(player)&&grid[1][i].equals(player)&&grid[2][i].equals(player)) {
                    return player;
               }
          }
          //diagonals
          if(grid[0][0].equals(player)&&grid[1][1].equals(player)&&grid[2][2].equals(player)) {
               return player;
          }
          if(grid[0][2].equals(player)&&grid[1][1].equals(player)&&grid[2][0].equals(player)) {
               return player;
          }
          return null;
     }
}
