/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DaoAlumno;

import BeanAlumno.AlumnoBean;
import Utilerias.ConexionMysql;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hector miguel
 */
public class DAOAgregarAlumno {

    private static String insertaAlumno = "insert into alumno (matricula,nombre,aprllidop,apellidom,edad,localidad) values (?,?,?,?,?,?)";
    private static String ConsultaGralAlumno = "select * from alumno";

    public boolean FunctionAgregarAlumno(AlumnoBean bean) throws IOException {
        boolean insercion = false;
        try {
            Connection con = ConexionMysql.getConnection();
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(insertaAlumno);

            ps.setInt(1, bean.getMatricula());
            ps.setString(2, bean.getNombre());
            ps.setString(3, bean.getAprllidoP());
            ps.setString(4, bean.getApellidoM());
            ps.setInt(5, bean.getEdad());
            ps.setString(6, bean.getLocalidad());

            insercion = ps.executeUpdate() == 1;
            ps.close();
            con.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return insercion;
    }

    public List getConsultaGeneralAlumno() {
        List datos = new ArrayList();
        try {
            Connection con = ConexionMysql.getConnection();
            PreparedStatement ps = con.prepareStatement(ConsultaGralAlumno);
            ResultSet res = ps.executeQuery();
            while (res.next()) {
                AlumnoBean Abean = new AlumnoBean();
                Abean.setMatricula(res.getInt(1));
                Abean.setNombre(res.getString(2));
                Abean.setAprllidoP(res.getString(3));
                Abean.setApellidoM(res.getString(4));
                Abean.setEdad(res.getInt(5));
                Abean.setLocalidad(res.getString(6));
                datos.add(Abean);
            }
            res.close();
            ps.close();
            con.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return datos;
    }
}
