/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lamabookstore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;
import lamabookstore.DAO.DaoBook;
import lamabookstore.entities.Book;

public class LamaBookstore {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/bookstore?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "1234");
            System.out.println(conn);

             Scanner scanner = new Scanner(System.in);
//            System.out.print("Veuillez saisir la quantité : \n");
//            int qt = scanner.nextInt();
//            System.out.print("Veuillez saisir le prix de l'article (DT) : ");
//            double p = scanner.nextInt();
//
//            System.out.print("le prix totale est  " + Utility.CalculateTotalPrice(qt, p) + "  (DT)\n");

            try {

                int choix = 0;
                while (choix != 3) {
                    System.out.println("1- Inserer un bouquin ");
                    System.out.println("2- lister les bouquins ");
                    System.out.println("3- sortir ");
                    System.out.println("enterez votre choix");
                    Scanner scannerchoix = new Scanner(System.in);
                    choix = scannerchoix.nextInt();
                    switch (choix) {
                        case 1:
                            Book myBook = new Book();
                            System.out.println("*****************************************");
                            System.out.println(" Veuillez saisir le titre : ");
                            myBook.setTitle(scanner.nextLine());
                            System.out.println(" Veuillez saisir le prix du bouquin : ");
                            myBook.setPrice(Double.parseDouble(scanner.nextLine()));
                            System.out.print(" Veuillez saisir son auteur : ");
                            myBook.setAuthor(scanner.nextLine());
                            System.out.println(" Veuillez saisir sa date de sortie  : ");
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                            java.util.Date date = sdf.parse(scanner.nextLine());

                            myBook.setReleaseDate(new java.sql.Date(date.getTime()));
                            DaoBook.addBook(myBook, conn);
                            break;
                        case 2:
                            List<Book> myList = DaoBook.listBook(conn);
                            for (Book book : myList) {
                                System.out.println(book.toString());
                            }
                            break;

                        default:
                            System.out.print("votre choix est incorrecte");
                            break;
                    }
                }
                 conn.close();
            } catch (Exception e) {
                System.out.println(e.getStackTrace()); conn.close();
            }
        } catch (SQLException Se) {
            System.out.println(Se);
        }
        /**
         * *************************
         */

    }

}
