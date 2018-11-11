import java.util.Random;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println();
        System.out.println("----------------\nПанасовский Д.Д.\n----------------\n");

        System.out.print("Введите N: ");
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        double[][] matrix = new double[N][N];

        Random rand = new Random();
        double rangeMin = 0;
        double rangeMax = 100;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = rangeMin + (rangeMax - rangeMin) * rand.nextDouble();
            }
        }
        System.out.println();
        System.out.println("Начальная матрица:");
        printMatrix(matrix);

        System.out.println();
        System.out.println("Повернутая матрица:");

        rotateMatrixClockwise(matrix);

        printMatrix(matrix);
        System.out.println();
    }

    private static void rotateMatrixClockwise(double[][] matrix) {
        double tmp;
        int n = matrix.length;

        for(int i=0; i<n/2; i++)
        {
            for(int j=i; j<n-1-i; j++)
            {
                tmp = matrix[i][j];
                matrix[i][j] = matrix[n-j-1][i];
                matrix[n-j-1][i] = matrix[n-i-1][n-j-1];
                matrix[n-i-1][n-j-1] = matrix[j][n-i-1];
                matrix[j][n-i-1] = tmp;
            }
        }
    }

    private static void printMatrix(double[][] matrix){
        DecimalFormat df = new DecimalFormat("###.###");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(df.format(matrix[i][j]) + "\t");
            }
            System.out.println();
        }
    }
}
