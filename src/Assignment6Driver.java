import java.io.File;
import java.util.Scanner;

public class Assignment6Driver {

    public static void main(String[] args) {

        //testGame();
        playGame("moves1.txt");
        System.out.println();
        playGame("moves2.txt");
    }

    private static void playGame(String filename) {
        HexGame game = new HexGame(11);
        boolean redTurn = false;
        File file = new File(filename);
        try (Scanner input = new Scanner(file)) {
            while (input.hasNextLine()) {
                if (redTurn) {
                    game.playRed(Integer.parseInt(input.next()), false);
                    redTurn = false;
                }
                else {
                    game.playBlue(Integer.parseInt(input.next()), false);
                    redTurn = true;
                }
            }
            printGrid(game);
        }
        catch (java.io.IOException ex) {
            System.out.println("An error occurred trying to read the moves file: " + ex);
        }
    }

    //
    // TODO: You can use this to compare with the output show in the assignment while working on your code
    private static void testGame() {
        HexGame game = new HexGame(11);

        System.out.println("--- red ---");
        game.playRed(1, true);
        game.playRed(11, true);
        game.playRed(110, true);
        game.playRed(111, true);
        game.playRed(112, true);
        game.playRed(121, true);
        game.playRed(61, true);

        System.out.println("--- blue ---");
        game.playBlue(1, true);
        game.playBlue(2, true);
        game.playBlue(11, true);
        game.playBlue(12, true);
        game.playBlue(121, true);
        game.playBlue(122 - 11, true);
        game.playBlue(62, true);

        printGrid(game);
    }

        // TODO: Complete this method
    private static void printGrid(HexGame game) {

        System.out.println();
        String ANSI_RESET = "\u001B[0m";
        String ANSI_RED = "\u001B[31m";
        String ANSI_BLUE = "\u001B[34m";

        int size = game.getSize();
        int spaceNum = 1;
        System.out.print(" ");

        for (int i = 0; i < size*size; i++) {
            if (game.grid[i] == "B"){
                System.out.print(ANSI_BLUE + game.grid[i] + " " + ANSI_RESET);
            }
            else if (game.grid[i] == "R"){
                System.out.print(ANSI_RED + game.grid[i] + " " + ANSI_RESET);
            }
            else{
                System.out.print(game.grid[i] + " ");
            }
            if (i % (size) == 10) {
                System.out.println();
                for (int x = 0; x <= spaceNum; x++) {
                    System.out.print(" ");
                }
                spaceNum = spaceNum + 1;
            }
        }
    }

}



