import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkShortener shortener = new LinkShortener();
        DataHandler.loadData(shortener.getUrlToShort(), shortener.getShortToUrl());
        
        while (true) {
            System.out.println("1. Shorten URL\n2. Expand URL\n3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline
            
            switch (choice) {
                case 1:
                    System.out.print("Enter long URL: ");
                    String longUrl = scanner.nextLine();
                    String shortUrl = shortener.shortenUrl(longUrl);
                    System.out.println("Short URL: " + shortUrl);
                    DataHandler.saveData(shortener.getUrlToShort());
                    break;
                case 2:
                    System.out.print("Enter short URL: ");
                    shortUrl = scanner.nextLine();
                    System.out.println("Original URL: " + shortener.expandUrl(shortUrl));
                    break;
                case 3:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
