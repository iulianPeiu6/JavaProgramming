/***
 * @author Peiu Iulian-Cosmin
 */

package lab1package;

public class Language {

    private int getDigitSum(int number) {
        int digitSum = 0;
        while (number != 0) {
            digitSum += number % 10;
            number /= 10;
        }
        return digitSum;
    }

    public void run() {
        System.out.print("Hello world!\n");

        String[] languages = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
        int n = (int) (Math.random() * 1_000_000);

        int result = n * 3;
        result += Integer.parseInt("10101", 2);
        result += Integer.parseInt("FF", 16);
        result *= 6;

        while (result > 9)
            result = getDigitSum(result);

        System.out.print("Willy-nilly, this semester I will learn " + languages[result] + "\n");
    }
}
