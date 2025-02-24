import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void getBoard(char[][] board){
        System.out.println(board[0][0] + "|" +  board[0][1] + "|" +  board[0][2] );
        System.out.println("-+-+-");
        System.out.println(board[1][0] + "|" +  board[1][1] + "|" +  board[1][2] );
        System.out.println("-+-+-");
        System.out.println(board[2][0] + "|" +  board[2][1] + "|" +  board[2][2] );

    }
    public static void move(char[][] board, String position, char symbol) {
        switch (position) {
            case "1":
                board[0][0] = symbol;
                break;
            case "2":
                board[0][1] = symbol;
                break;
            case "3":
                board[0][2] = symbol;
                break;
            case "4":
                board[1][0] = symbol;
                break;
            case "5":
                board[1][1] = symbol;
                break;
            case "6":
                board[1][2] = symbol;
                break;
            case "7":
                board[2][0] = symbol;
                break;
            case "8":
                board[2][1] = symbol;
                break;
            case "9":
                board[2][2] = symbol;
                break;
        }
    }
    public static boolean isAvailableCell(char[][] board, String position) {

        switch (position) {
            case "1":
                return (board[0][0] == ' ');
            case "2":
                return (board[0][1] == ' ');
            case "3":
                return (board[0][2] == ' ');
            case "4":
                return (board[1][0] == ' ');
            case "5":
                return (board[1][1] == ' ');
            case "6":
                return (board[1][2] == ' ');
            case "7":
                return (board[2][0] == ' ');
            case "8":
                return (board[2][1] == ' ');
            case "9":
                return (board[2][2] == ' ');
            default:
                return false;
        }
    }

    public static void player(char[][] board) {
        Scanner scanner = new Scanner(System.in);
        String input;
        while(true) {
            System.out.println("Where do you want to play? (1-9)");
            input = scanner.next();
            if(isAvailableCell(board, input)){
                break;
            } else{
                System.out.println("not a valid move");
            }
        }
        move(board, input, 'X');
    }
    public static void computer(char[][] board) {
        Random random = new Random();
        int computerPlay;
        while(true) {
            computerPlay = random.nextInt((9) + 1);
            if(isAvailableCell(board, Integer.toString(computerPlay))){
                break;
            }
        }
        move(board, Integer.toString(computerPlay), 'O');
        System.out.println("Computer chose: " + computerPlay);
    }


    public static boolean isWinner(char[][] board, char symbol) {
        if ((board[0][0] == symbol && board[0][1] == symbol && board[0][2] == symbol) ||
            (board[1][0] == symbol && board[1][1] == symbol && board[1][2] == symbol) ||
            (board[2][0] == symbol && board[2][1] == symbol && board[2][2] == symbol) ||

            (board[0][0] == symbol && board[1][0] == symbol && board[2][0] == symbol) ||
            (board[0][1] == symbol && board[1][1] == symbol && board[2][1] == symbol) ||
            (board[0][2] == symbol && board[1][2] == symbol && board[2][2] == symbol) ||

            (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) ||
            (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol)) {
            return true;
        }
        return false;
    }

    public static boolean isGameEnded(char[][] board) {

        if(isWinner(board, 'X')) {
            getBoard(board);
            System.out.println("You won");
            return true;
        }

        if(isWinner(board, 'O')){
            getBoard(board);
            System.out.println("Computer won");
            return true;
        }
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (board[i][j] == ' ') {
                        return false;
                    }
                }
            }

            System.out.println("The game is draw");
            return true;
        }

    public static void main(String[] args) {

        char[][] board = new char[][] {{' ',' ',' '}, {' ', ' ', ' '}, {' ', ' ',' '}};
        char[][] numberedBoard = new char[][] {{'1', '2', '3'},
                                                {'4', '5', '6'},
                                                {'7', '8', '9'}};

        getBoard(numberedBoard);

        while (true) {
            player(board);
            if(isGameEnded(board)) {
                break;
            }
            computer(board);
            if(isGameEnded(board)) {
                break;
            }
            getBoard(board);
        }

    }
}
