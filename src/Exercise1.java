public class Exercise1 {
    private static final int MAX_NUMBER = 100;
    public static void main(String[] args) {
                printNumbers(MAX_NUMBER);
    }

    public static void printNumbers(int maxNumber) {
        for (int i = 1; i <= maxNumber; i++) {
            String output = "";
            if (i % 3 == 0) {
                output += "Visual ";
            }
            if (i % 5 == 0) {
                output += "Nuts";
            }
            if (output.isEmpty()) {
                System.out.println(i);
            } else {
                System.out.println(output.trim());
            }
        }
    }
}