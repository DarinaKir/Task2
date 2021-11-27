import java.util.Scanner;
public class Exercise7 {
    final static int BOARD_POSITION_AMOUNT=9;
    final static char [] symbols = {'X','0'};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char [] gameBoard = new char[BOARD_POSITION_AMOUNT];
        int turn = 0;
        int position = -1;
        boolean gameOver = false;
        printBoard(gameBoard);
        do {
            System.out.println("Player of "+symbols[turn%2]+", your turn:");
            position =getPositionFromUser(gameBoard);
            if (placeSymbolOnBoard(gameBoard,position-1,symbols[turn%2])){
                gameOver = true;
            }
            turn++;

        }while (!gameOver && turn<9);
        System.out.println("Game over !");
    }

    public static void printBoard (char [] gameBoard){
        for (int i = 0; i < gameBoard.length; i++) {
            System.out.print(gameBoard[i]+" ");
            if ((i+1)%3==0){
                System.out.println("");
            }
        }
    }

    public static boolean isAvailable (char[] gameBoard, int index){
        boolean available = true;
        if (gameBoard[index]=='X' || gameBoard[index]=='0'){
            available=false;
        }
        return available;
    }

    public static int getPositionFromUser (char[] gameBoard){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type a number of position, where you want to place your step (1-9) :");
        int position = scanner.nextInt();
        while (position<1 || position>9 || !(isAvailable(gameBoard,position-1))){
            if (position<1 || position>9){
                System.out.println("The number is not in the range of options (1-9). Try again :");
                position=scanner.nextInt();
                continue;
            }else if (!(isAvailable(gameBoard,position-1))){
                System.out.println("This position is already occupied. Try again :");
                position=scanner.nextInt();
            }
        }
        return position;
    }

    public static char checkWinner (char[] gameBoard){
        char winnerSymbol = '-';
        boolean slantWinner=false;
        boolean linesWinner = false;
        boolean columnsWinner = false;
        for (int i = 0; i < 3; i++) {
            if (!isAvailable(gameBoard,i)){
                slantWinner = (i%2 == 0);
                linesWinner = true;
            }
            columnsWinner = (!isAvailable(gameBoard,i*3));

            for (int j = 1; j < 3 && (linesWinner || columnsWinner || slantWinner); j++) {
                columnsWinner=(gameBoard[i*3]==gameBoard[(i*3)+j] && columnsWinner);
                linesWinner = (gameBoard[i]==gameBoard[i+(3*j)] && linesWinner);
                slantWinner=(gameBoard[i]==gameBoard[i+(4*j)-(j*i)] && slantWinner);
            }
            if (linesWinner || columnsWinner || slantWinner){
                winnerSymbol = gameBoard[i];
                break;
            }
        }
        return winnerSymbol;
    }

    public static boolean placeSymbolOnBoard (char[] gameBoard, int index, char symbol){
        boolean hasWinner = false;
        gameBoard[index]=symbol;
        printBoard(gameBoard);
        if (checkWinner(gameBoard)!='-'){
            hasWinner = true;
            System.out.println("The winner is : "+symbol+" !");
        }
        return  hasWinner;
    }
}
