/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lamabook.conx;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import lamabookstore.entities.Client;

/**
 *
 * @author Molka
 */
public class Connect {
public static Client userConnect ;
    public static Connection connectMe() throws SQLException {
        
            // Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/bookstore?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "1234");
          //  Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/bookstore", "root", "admin");
              Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore", "root", "");
            return conn;
        
    }

    public static Client getUserConnect() {
        return userConnect;
    }

    public static void setUserConnect(Client userConnect) {
        Connect.userConnect = userConnect;
    }
    

}
