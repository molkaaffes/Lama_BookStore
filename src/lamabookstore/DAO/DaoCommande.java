/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lamabookstore.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import lamabookstore.entities.Book;
import lamabookstore.entities.Commande;

/**
 *
 * @author Molka
 */
public class DaoCommande {

    public static void addCommande(List<Book> listBook, int id_client, Connection conn) {
        //   Connection conn ;

        PreparedStatement stat;

        try {
            for (Book book : listBook) {
                stat = conn.prepareStatement("insert into commandes " + " (qte,idproduit,idclient,prixUnit,dateCommande)" + " values (?,?,?,?,?)");
                stat.setInt(1, 1);
                stat.setInt(2, book.getId());
                stat.setInt(3, id_client);
                stat.setDouble(4, book.getPrice());
             //   SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//            java.util.Date date = sdf.parse(book.getReleaseDate().toString());
                java.util.Date date = new Date();
                stat.setDate(5, (new java.sql.Date(date.getTime())));
                stat.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoBook.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static List<Commande> listCommandes(Connection conn, int id_client) {
        try {
            String requete = "SELECT * FROM Commandes where idclient="+id_client+"";
            Statement stmt = conn.createStatement();
            ResultSet résultats = stmt.executeQuery(requete);

            ResultSetMetaData rsmd = résultats.getMetaData();
            int nbCols = rsmd.getColumnCount();
            boolean encore = résultats.next();
            List<Commande> listCommande = new ArrayList();
            while (encore) {
                Commande newCommande = new Commande();
                newCommande.setId(résultats.getInt("id"));
                newCommande.setIdClient(résultats.getInt("idClient"));
                newCommande.setIdProduit(résultats.getInt("idProduit"));
                newCommande.setPrixUnit(résultats.getInt("prixUnit"));
                newCommande.setQte(résultats.getInt("qte"));
                Date date = résultats.getDate("dateCommande");
                newCommande.setDateCommande(date);
                listCommande.add(newCommande);
                encore = résultats.next();
            }
            résultats.close();
            return listCommande;
        } catch (SQLException e) {
            System.out.println("vermegalternant.MyProg.Insert()" + e);
            return null;
        }

    }
    /*
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

    }*/

}
