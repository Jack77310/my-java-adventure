import java.util.Scanner;
import java.util.Arrays;

public class Calculator{
    public static void main(String[] args) {
        char[][] board = new char[3][3];  // 3x3 empty board
        initBoard(board);                 // Fill with spaces
        
        char currentPlayer = 'X';         // X starts
        boolean gameWon = false;
        int moves = 0;
        
        Scanner sc = new Scanner(System.in);
        
        while (!gameWon && moves < 9) {
            printBoard(board);
            
            // Get move
            int row = getValidInput(sc, "Enter row (1-3): ", 1, 3);
            int col = getValidInput(sc, "Enter column (1-3): ", 1, 3);
            
            // Convert to array index (0-2)
            row--;
            col--;
            
            // Check if spot taken
            if (board[row][col] != ' ') {
                System.out.println("Spot taken! Try again.");
                continue;
            }
            
            // Place mark
            board[row][col] = currentPlayer;
            moves++;
            
            // Check win
            if (checkWin(board, currentPlayer)) {
                printBoard(board);
                System.out.println(currentPlayer + " WINS! 🎉");
                gameWon = true;
            } else if (moves == 9) {
                printBoard(board);
                System.out.println("It's a DRAW! 🤝");
            } else {
                // Switch player
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            }
        }
        
        sc.close();
    }
    
    // Initialize board with spaces
    static void initBoard(char[][] board) {
        for (int i = 0; i < 3; i++) {
            Arrays.fill(board[i], ' ');
        }
    }
    
    // Print board nicely
    static void printBoard(char[][] board) {
        System.out.println("\n   1   2   3");
        System.out.println("1  " + board[0][0] + " | " + board[0][1] + " | " + board[0][2]);
        System.out.println("  -----------");
        System.out.println("2  " + board[1][0] + " | " + board[1][1] + " | " + board[1][2]);
        System.out.println("  -----------");
        System.out.println("3  " + board[2][0] + " | " + board[2][1] + " | " + board[2][2]);
        System.out.println();
    }
    
    // Get valid number input (loops until good)
    static int getValidInput(Scanner sc, String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            if (sc.hasNextInt()) {
                int num = sc.nextInt();
                if (num >= min && num <= max) {
                    return num;
                } else {
                    System.out.println("Please enter " + min + "-" + max + "!");
                }
            } else {
                sc.next();  // Clear bad input
                System.out.println("Please enter a number!");
            }
        }
    }
    
    // Check if current player won
    static boolean checkWin(char[][] board, char player) {
        // Rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true;
            }
        }
        // Columns
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
                return true;
            }
        }
        // Diagonals
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }
        return false;
    }
}