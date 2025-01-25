import java.util.Arrays;

public class AnagramChecker {
    public boolean areAnagrams(String str1, String str2) {
        if (str1 == null || str2 == null) return false;

        char[] chars1 = str1.replaceAll("\\s", "").toLowerCase().toCharArray();
        char[] chars2 = str2.replaceAll("\\s", "").toLowerCase().toCharArray();

        Arrays.sort(chars1);
        Arrays.sort(chars2);

        return Arrays.equals(chars1, chars2);
    }
}
