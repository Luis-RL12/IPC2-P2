/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author RODRIGUEZ
 */
public class DBConnection {
    private static Connection connection = null;
     public static Connection connection(){
          String user = "root";
          String password = "123456789";
          String stringConnection = "jdbc:mysql://localhost:3306/magazinesa?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
                try {
              try {
                  Class.forName("com.mysql.cj.jdbc.Driver");
              } catch (ClassNotFoundException ex) {
                  System.out.println("Error: "+ex);
              }
			connection = DriverManager.getConnection(stringConnection, user, password);
			//Mostramos el nombre del esquema
			System.out.println("Conectado:" + connection.getCatalog());
		} catch (SQLException e) {
			System.out.println("Fallo la conexion a la base de datos. Error: "+e);
		}
                return connection;
     }
     
     public Connection getConnection(){
         return connection;
     }
     
}
