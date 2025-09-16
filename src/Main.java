import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static void showMenu() {
        System.out.println("1:Set information: ");
        System.out.println("2:Show all information: ");
        System.out.println("3:Save file");
        System.out.println("4:Read file");
        System.out.println("5:Sorting by author name (A-Z)");
        System.out.println("6:Exit");
    }

    public static void main(String[] args) {
        FileInit.createFile();
        List<Book> bookList = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter number of books: ");
        int numberOfBooks = Integer.parseInt(input.nextLine());
        while (true) {
            showMenu();
            System.out.println("Enter choice: ");
            int choice = Integer.parseInt(input.nextLine());
            switch (choice) {
                case 1:
                    for (int i = 0; i < numberOfBooks; i++) {
                        Book book = new Book();
                        book.setInfo();
                        bookList.add(book);
                    }
                    break;
                case 2:
                    for (Book book : bookList) {
                        book.display();
                    }
                    break;
                case 3:
                    for (Book book : bookList) {
                        book.saveFile();
                    }
                    break;
                case 4:
                    for (Book book : bookList) {
                        book.readFile();
                    }
                case 5:
                    Collections.sort(bookList);
                    System.out.println("Book list sorted!");
                    break;
                case 6:
                    System.exit(0);
                    break;
            }
        }

    }
}
