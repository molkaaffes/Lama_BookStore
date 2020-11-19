/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lamabookstore.DAO;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.StyledEditorKit;
import lamabook.conx.Connect;
import lamabookstore.entities.Client;

/**
 *
 * @author Molka
 */
public class DaoClient {

    public static Boolean Authentification(String login, String Pwd) {

        try {
            String requete = "SELECT * FROM clients where nom='" + login + "' and pwd='" + Pwd + "'";
            Statement stmt = Connect.connectMe().createStatement();
            ResultSet résultats = stmt.executeQuery(requete);
            ResultSetMetaData rsmd = résultats.getMetaData();
            Boolean test=résultats.next();
           Client user=new Client();
           user.setId(résultats.getInt("id"));
           user.setNom(résultats.getString("nom"));
           user.setPrenom(résultats.getString("prenom"));
           user.setEmail(résultats.getString("email"));
           user.setTel(résultats.getString("tel"));
           user.setAdresse(résultats.getString("adresse"));
           user.setPwd(résultats.getString("pwd"));
           Connect.setUserConnect(user);
                return test;
          
        } catch (SQLException ex) {
            Logger.getLogger(DaoClient.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
