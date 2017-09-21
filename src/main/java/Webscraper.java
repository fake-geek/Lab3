import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
/**
 * Scrape information form the web.
 * @author apple
 *
 */
public class Webscraper {

    /**
     * word counting.
     * @param args contents
     */
    public static void main(final String[] args) {
        // TODO Auto-generated method stub
        Scanner urlScanner = new Scanner(System.in);
        String uRL = urlScanner.nextLine();
        urlScanner.close();

        String actualContents = urlToString(uRL);
        System.out.print(count(actualContents));
    }



    public static int count(String word) {
        if (word == null || word.isEmpty()) {
            return 0;
        }

        int wordCount = 0;

        boolean isWord = false;
        int endOfLine = word.length() - 1;
        char[] characters = word.toCharArray();

        for (int i = 0; i < characters.length; i++) {
            if (Character.isLetter(characters[i]) && i != endOfLine) {
                isWord = true;
            }else if (!Character.isLetter(characters[i]) && isWord) {
                wordCount++;
                isWord = false;
            }else if (Character.isLetter(characters[i]) && i == endOfLine) {
                wordCount++;
            }
        }
        return wordCount;
    }




    /**
     * the method that convert URL to string.
     * @param url URL
     * @return contents.
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        System.out.print(contents);
        return contents;
    }
}
