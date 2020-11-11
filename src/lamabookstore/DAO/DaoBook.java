/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lamabookstore.DAO;

import java.sql.Connection;
//import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Scanner;
import lamabookstore.entities.Book;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
//import java.util.Date;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import jdk.nashorn.internal.objects.NativeError;

public class DaoBook {

    public DateFormat dateFormat;
    java.util.Date date;

    public static void addBook(Book book, Connection conn) {
        //   Connection conn ;

        PreparedStatement stat;

        try {
            stat = conn.prepareStatement("insert into book " + " (title,price, author,releaseDate)" + " values (?, ? ,?,?)");
            stat.setString(1, book.getTitle());
            stat.setDouble(2, book.getPrice());
            stat.setString(3, book.getAuthor());

            //SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            java.util.Date date = sdf.parse(book.getReleaseDate().toString());
            stat.setDate(4, (new java.sql.Date(date.getTime())));
            stat.executeUpdate();
            System.out.print("insertion effectuée! \n");

        } catch (SQLException ex) {
            Logger.getLogger(DaoBook.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(DaoBook.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static List<Book> listBook(Connection conn) {
        try {
            String requete = "SELECT * FROM book";
            Statement stmt = conn.createStatement();
            ResultSet résultats = stmt.executeQuery(requete);

            ResultSetMetaData rsmd = résultats.getMetaData();
            int nbCols = rsmd.getColumnCount();
            boolean encore = résultats.next();
            List<Book> listbooks = new ArrayList();
            while (encore) {
                Book newbook = new Book();
                newbook.setId(résultats.getInt("id"));
                newbook.setTitle(résultats.getString("title"));
                newbook.setPrice(résultats.getDouble("price"));
                newbook.setAuthor(résultats.getString("author"));
                Date date = résultats.getDate("releaseDate");
                newbook.setReleaseDate(date);
                listbooks.add(newbook);
                encore = résultats.next();
            }
            résultats.close();
            return listbooks;
        } catch (SQLException e) {
            System.out.println("vermegalternant.MyProg.Insert()" + e);
            return null;
        }

    }

    public static void delete(Connection conn, int id) {
        try {
            String delete = "DELETE from book WHERE id= ?";
            PreparedStatement prepareddelete = conn.prepareStatement(delete);
            prepareddelete.setInt(1, id);
            prepareddelete.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getStackTrace());
        }
        JOptionPane.showMessageDialog(null, "book deleted!");
    }

    public static void update(Connection conn, int id, Book book) {
        try {

            String uquery = "update book set title = ?  , price=? , author = ? where id = ?";
            PreparedStatement preparedStmt = conn.prepareStatement(uquery);
            preparedStmt.setString(1, book.getTitle());
            preparedStmt.setDouble(2, book.getPrice());
            preparedStmt.setString(3, book.getAuthor());
            preparedStmt.setInt(4, book.getId());
            //  preparedStmt.setDate(4,new java.sql.Date(book.getReleaseDate().getTime()));
            int resultupdate = preparedStmt.executeUpdate();
            System.out.println(resultupdate);
        } catch (SQLException ex) {
            System.out.println(ex.getStackTrace());
        }
        JOptionPane.showMessageDialog(null, "book updated!");

    }
}
