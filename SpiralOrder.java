import java.util.*;

public class SpiralOrder {
    public static void printSpiralOrder(Object[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return;

        int top = 0, bottom = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;

        List<Object> result = new ArrayList<>();

        while (top <= bottom && left <= right) {
            // Traverse from left to right
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++;

            // Traverse from top to bottom
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;

            // Traverse from right to left
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }

            // Traverse from bottom to top
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }

        System.out.println(result);
    }

    public static void main(String[] args) {
        Object[][] matrix = {
            {33, 75, 18},
            {16, 42, 12}
        };

        printSpiralOrder(matrix);
    }
}
