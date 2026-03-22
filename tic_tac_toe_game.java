import java.util.Scanner;
public class tic_tac_toe_game {
    static char[][] board = {{'1','2','3'},{'4','5','6'},{'7','8','9'}};
    static char player1 ='X';

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int moves = 0;
        boolean gameOver = false;

        System.out.println("========================================");
        System.out.println("            TIC TAC TOE GAME            ");
        System.out.println("========================================");
        System.out.println();
        System.out.println("          Player X  vs  Player O        ");

        while (!gameOver) {
            printBoard();
            System.out.println("Player " +player1+ " , Enter position(1-9) : ");
            int choice = sc.nextInt();
            if(placemove(choice))
            {
                moves++;
                if(checkwin()){
                    printBoard();
                    System.out.println("Congratulations player "+player1+" wins");
                    gameOver = true;
                }
                else if(moves == 9){
                    printBoard();
                    System.out.println("It's a Draw!");
                    gameOver = true;
                }
                else
                {
                    switchplayer();
                }
            }
            else{
                System.out.println("Invalid move! Try again");

            }
        }
        sc.close();
    }
    static void printBoard(){
        System.out.println();
        for(int i=0;i<3;i++){
            System.out.println(board[i][0]+" | "+board[i][1]+" | "+board[i][2]);
            if(i<2)
                System.out.println("--+---+--");
            } 
            System.out.println();
        }
        static boolean placemove(int choice)
        {
            int row = (choice-1)/3;
            int col = (choice-1)%3;

            if(choice<1 || choice>9 || board[row][col] == 'X'||board[row][col] == 'O')
            {
                return false;
            }
            board[row][col]= player1;
            return true;
        }

        static void switchplayer(){
            player1 =(player1 == 'X'?'O':'X');
        }

        static boolean checkwin() {
            for(int i=0;i<3;i++){
                if(board[i][0]== player1 && board[i][1]==player1 && board[i][2]==player1){
                    return true;
                }
                if(board[0][i]==player1 && board[1][i]==player1 && board[2][i]==player1)
                    return true;
            }

            if(board[0][0]==player1 && board[1][1]==player1 && board[2][2]==player1)
                return true;
            if(board[2][0]==player1 && board[1][1]==player1 && board[0][2]==player1)
                return true;
            return false;
        }
    }

