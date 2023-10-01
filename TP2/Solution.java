
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Random;

public class Solution {
    public int[] bits;
    public String binaryString;
    public BigInteger fitness;

    public Solution() {
        bits = new int[35];
        Random random = new Random();
        for (int i = 0; i < bits.length; i++) {
            bits[i] = random.nextInt(2);
        }

        binaryString = Arrays.toString(bits)
                .replaceAll(", ", "") // Remove commas and spaces
                .replace("[", "") // Remove opening bracket
                .replace("]", ""); // Remove closing bracket

        fitness = new BigInteger(binaryString, 2);

    }

    public void updateSolution(int[] _bits) {

        bits = _bits;
        binaryString = Arrays.toString(bits)
                .replaceAll(", ", "") // Remove commas and spaces
                .replace("[", "") // Remove opening bracket
                .replace("]", ""); // Remove closing bracket

        fitness = new BigInteger(binaryString, 2);

    }

    public void ShowSolution() {
        System.out.println(binaryString + " " + fitness);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.ShowSolution();
    }
}
