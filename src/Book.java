import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Book implements Comparable<Book> {
    private String title;
    private String author;
    private String publisher;
    private double price;
    private LocalDate publishedDate;

    public Book() {
        this.title = "";
        this.author = "";
        this.publisher = "";
        this.price = 0;
        this.publishedDate = null;

    }

    public void setInfo() {
        Book book = new Book();
        Scanner input = new Scanner(System.in);
        System.out.println("Title: ");
        this.title = input.nextLine();
        System.out.println("Author: ");
        this.author = input.nextLine();
        System.out.println("Publisher: ");
        this.publisher = input.nextLine();
        System.out.println("Price: ");
        this.price = Double.parseDouble(input.nextLine());
        System.out.println("Published Date: ");
        this.publishedDate = LocalDate.parse(input.nextLine());

    }
    public void input() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter number of books: ");
        int numberOfBooks = Integer.parseInt(input.nextLine());
        for(int i = 0; i < numberOfBooks; i++) {
            Book b = new Book();
        }
    }
    public void display() {
        System.out.println("Title: " + this.title);
        System.out.println("Author: " + this.author);
        System.out.println("Publisher: " + this.publisher);
        System.out.println("Price: " + this.price + "$");
        System.out.println("Published Date: " + this.publishedDate);

    }

    private String formatData() {
        return this.title + "," + this.author + "," + this.publisher + "," + this.price + "," + this.publishedDate + "\n";
    }

    public void saveFile() {
        try (FileOutputStream fos = new FileOutputStream(FileInit.FILE_PATH, true)) {
            fos.write(formatData().getBytes());
        } catch (IOException e) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, e);
        }
        System.out.println("Book Saved!");
    }

    public void readFile() {
        try (FileInputStream fis = new FileInputStream(FileInit.FILE_PATH)) {
            int read;
            while ((read = fis.read()) != -1) {
                System.out.print((char) read);
            }
        } catch (IOException e) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    public int compareTo(Book other) {
        return this.author.compareTo(other.author);
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(LocalDate publishedDate) {
        this.publishedDate = publishedDate;
    }
}
