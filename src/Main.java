import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by Maciek on 2015-11-29.
 */
public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static RSSList rssList = new RSSList();
    private static RSSReader rssReader = RSSReader.getInstance();

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        MENU();
    }

    public static void MENU() throws IOException, ClassNotFoundException {
        int choice;
        System.out.println("MENU:");
        System.out.println(" 1 = Print RSS");
        System.out.println(" 2 = Show RSS List");
        System.out.println(" 3 = Add new RSS URL");
        System.out.println(" 4 = Delete RSS");
        System.out.println(" 5 = Print History");
        System.out.println("5 = EXIT");
        choice = scanner.nextInt();

        switch (choice) {
            case 1:
                rssList.readCurrentlyList();
                printRSS();
                MENU();
                break;
            case 2:
                rssList.readCurrentlyList();
                showRSSList();
                MENU();
                break;
            case 3:
                rssList.readCurrentlyList();
                addNewURL();
                MENU();
                break;
            case 4:
                deleteURL();
                MENU();
                break;
            case 5:
                showHistory();
                MENU();
                break;
        }
    }

    private static void printRSS() throws IOException, ClassNotFoundException {
        URL url;
        for (int i = 0; i < rssList.RSSList.size(); i++) {
            url = new URL(rssList.RSSList.get(i));
            rssReader.setUrl(url);
            rssReader.writeFeed();
            for (int g = 0; g < rssReader.feed.NewsList.size(); g++) {
                System.out.println(rssReader.feed.NewsList.get(g));
            }
        }
    }

    private static void showRSSList() throws IOException, ClassNotFoundException {
        for (int i = 0; i < rssList.RSSList.size(); i++) {
            System.out.println(rssList.RSSList.get(i));
        }
    }

    public static void addNewURL() throws IOException, ClassNotFoundException {
        System.out.println("Enter new link:");
        scanner.nextLine();
        String check = scanner.nextLine();
        boolean thereIsAlready = false;
        for (int i = 0; i < rssList.RSSList.size(); i++) {
            if (check.equals(rssList.RSSList.get(i))) {
                thereIsAlready = true;
                System.out.println("Juz jest taki!");
            }
        }
        if (thereIsAlready == false) {
            rssList.RSSList.add(check);
            rssList.saveCurrentlyList();
            rssList.readHistory();
            rssList.RSSList.add(check);
            rssList.saveHistory();
        }
    }
    private static void deleteURL() throws IOException, ClassNotFoundException {
        rssList.readCurrentlyList();
        System.out.println("Ktory z nich chcesz usunac?");
        for (int i = 0; i < rssList.RSSList.size(); i++) {
            System.out.println(i + 1 + ". " + rssList.RSSList.get(i));
        }
        rssList.RSSList.remove(scanner.nextInt() - 1);
        rssList.saveCurrentlyList();
    }

    private static void showHistory() throws IOException, ClassNotFoundException {
        rssList.readHistory();
        for (int i = 0; i < rssList.RSSList.size(); i++) {
            System.out.println(rssList.RSSList.get(i));
        }

    }
}


