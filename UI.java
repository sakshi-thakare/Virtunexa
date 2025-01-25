import java.util.Scanner;

public class UI {
    private final AnagramChecker anagramChecker = new AnagramChecker();

    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Anagram Checker Application");

        while (true) {
            System.out.println("\nEnter first string (or type 'exit' to quit):");
            String str1 = scanner.nextLine();
            if (str1.equalsIgnoreCase("exit")) break;

            System.out.println("Enter second string:");
            String str2 = scanner.nextLine();

            boolean result = anagramChecker.areAnagrams(str1, str2);
            System.out.println(result ? "The strings are anagrams!" : "The strings are NOT anagrams.");
        }

        scanner.close();
        System.out.println("Application closed.");
    }
}
