package BeginnerJavaProjects.StringManipulation;
import java.util.Scanner;

/**
 * Takes a word or string and then 'crushes' it by finding the longest substring
 * that starts and ends with the same character and removing that substring
 *
 * @author Riley Simmons
 */
public class WordCrusher {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a word / string: ");
        String str = scan.nextLine();

        String[] userSentance = str.split("\s");
        String crushedSentance = "";
        for (String s : userSentance) {
            String crushedWord = findLongest(s);
            crushedSentance += (crushedWord + " ");
        }

        System.out.println("Crushed: " + crushedSentance);
    }

    /**
     * Takes the word and performs operations to crush the word
     */
    private static String findLongest(String str) {
        String longest = "";
        String crushed = "";
        for (int i = 0; i < str.length(); i++) {
            char character = str.charAt(i);
            int lastPos = str.lastIndexOf(character);
            if ((lastPos) - i > longest.length()) {
                longest = str.substring(i, lastPos + 1);
                crushed = str.substring(0, i + 1) + str.substring(lastPos);
            }
        }

        if (crushed.equals("")) {
            crushed = str;
        }

        return crushed;
    }
}
