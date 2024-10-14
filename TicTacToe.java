import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) {
        char[][] board = { {' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '} };
        char currentPlayer = 'X';
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printBoard(board);
            playerMove(board, currentPlayer, scanner);
            if (checkWinner(board)) {
                printBoard(board);
                System.out.println("Player " + currentPlayer + " wins!");
                break;
            }
            if (isBoardFull(board)) {
                printBoard(board);
                System.out.println("It's a draw!");
                break;
            }
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X'; // Switch player
        }
    }

    public static void printBoard(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
                if (j < 2) System.out.print("|");
            }
            System.out.println();
            if (i < 2) System.out.println("-----");
        }
    }

    public static void playerMove(char[][] board, char player, Scanner scanner) {
        int row, col;
        while (true) {
            System.out.println("Player " + player + ", enter row and column (0, 1, 2): ");
            row = scanner.nextInt();
            col = scanner.nextInt();
            if (board[row][col] == ' ') {
                board[row][col] = player;
                break;
            } else {
                System.out.println("Spot taken, try again.");
            }
        }
    }

    public static boolean checkWinner(char[][] board) {
        // Check rows, columns, and diagonals
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != ' ') return true;
            if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] != ' ') return true;
        }
        return (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != ' ') ||
               (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != ' ');
    }

    public static boolean isBoardFull(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') return false;
            }
        }
        return true;
    }
}
