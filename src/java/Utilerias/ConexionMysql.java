/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilerias;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Alumno CI
 */
public class ConexionMysql {

    static Connection con;

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("---------------------------------------Cargo Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("No cargo Driver");
        }

        return DriverManager.getConnection("jdbc:mysql://localhost:3306/baseprogramacion", "root", "");
    }

    public static void main(String[] args) {
        try {

            con = getConnection();
            System.out.println("-------------------------------------Conexion efectuada...");

            PreparedStatement s = (PreparedStatement) con.prepareStatement("select * from alumno");
            ResultSet rs = (ResultSet) s.executeQuery();
            rs.next();
            do {

                System.out.println("------------------------------------Se realizo la consulta");

                System.out.println(rs.getInt("matricula"));
                System.out.println(rs.getString("nombre"));
                System.out.println(rs.getString("aprllidop"));
                System.out.println(rs.getString("apellidom"));
                System.out.println(rs.getInt("edad"));
                System.out.println(rs.getString("localidad"));

                rs.next();
            } while (rs.isLast() == false);
            con.close();
        } catch (SQLException e) {
            System.out.println("Error en la Conexión");

        }
    }
}
