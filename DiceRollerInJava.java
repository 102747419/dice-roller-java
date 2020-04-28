import java.util.Random;
import java.util.Scanner;

// dice roller java source code
// Also outputs the dice face as ASCII art
public class DiceRollerInJava {

    // This has printing information for all numbers
    // For each number,3x3 matrix represents the face
    int[][][] faceConfig = { { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } },
                           { { 0, 0, 1 }, { 0, 0, 0 }, { 1, 0, 0 } },
                           { { 0, 0, 1 }, { 0, 1, 0 }, { 1, 0, 0 } },
                           { { 1, 0, 1 }, { 0, 0, 0 }, { 1, 0, 1 } },
                           { { 1, 0, 1 }, { 0, 1, 0 }, { 1, 0, 1 } },
						   { { 1, 0, 1 }, { 1, 0, 1 }, { 1, 0, 1 } },
						   { { 1, 0, 1 }, { 1, 1, 1 }, { 1, 0, 1 } },
						   { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } },
						   { { 1, 1, 1 }, { 1, 1, 1 }, { 1, 1, 1 } } };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DiceRollerInJava dice = new DiceRollerInJava();

        int num = 0;
        int high = 0;
        int sum = 0;
        System.out.println("Do you want to roll die ???");
        while (true) {
            int result = dice.roll();

            sum = sum + result;
            if (high < result)
            {
                high = result;
            }
            num = num + 1;

            System.out.println("dice face value:" + result);
            dice.draw(result);
            
            System.out.println("Number of rolls:" + num);
            System.out.println("Highest number achieved:" + high);
            System.out.println("Sum of total outcomes:" + sum);
            System.out.println("Roll again? (type no to quit):");

            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("y") || input.equalsIgnoreCase("Yes")) {
                int result = dice.roll();
                System.out.println("dice face value:" + result);
                dice.draw(result);

                System.out.println("Roll again? (type no to quit):");
			} else if (input.equalsIgnoreCase("n") || input.equalsIgnoreCase("no")) {
                System.out.println("Bye!");
                scanner.close();
                return;
            }
        }
    }

    // Draw the dice face using ascii characters
    private void draw(int value) {
        int[][] displayVal = faceConfig[value - 1];
        System.out.println("-----");

        for (int i = 0; i < 3; i++) {
            System.out.print("|");
            for (int j = 0; j < 3; j++) {
                if (displayVal[i][j] == 1) {
                    System.out.print("o");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println("|");
        }
        System.out.println("-----");

    }

    // Roll the dice in Java
    private int roll() {
        Random r = new Random();
        return r.nextInt(9) + 1;
    }
}