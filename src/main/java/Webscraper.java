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
        String nextLine = urlScanner.nextLine();
        urlScanner.close();

        String actualContents = urlToString(nextLine);
        System.out.print(actualContents);

        int wordCount = 0;

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
