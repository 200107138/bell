import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numRows = scanner.nextInt();
        int numCols = scanner.nextInt();

        String[][] grid = new String[numRows][numCols];

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                grid[i][j] = scanner.next();
            }
        }

        // Print out the grid to verify it was stored correctly
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}