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
 * @author Hector Miguel
 */
public class DAOConsultarAlumno {
    private static String ConsultaAlumno = "select * from alumno where matricula=?";
    private static String ConsultaGralAlumno = "select * from alumno";
    
    public List getConsultaAlumno(int matricula) {
        List datos = new ArrayList();
        try {
            Connection con = ConexionMysql.getConnection();
            PreparedStatement ps = con.prepareStatement(ConsultaAlumno);
            ps.setInt(1, matricula);
            ResultSet query = ps.executeQuery();
            while (query.next()) {
                AlumnoBean Ab = new AlumnoBean();
                Ab.setMatricula(query.getInt(1));
                Ab.setNombre(query.getString(2));
                Ab.setAprllidoP(query.getString(3));
                Ab.setApellidoM(query.getString(4));
                Ab.setEdad(query.getInt(5));
                Ab.setLocalidad(query.getString(6));
                datos.add(Ab);
            }
            ps.close();
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return datos;
    }
    public List getConsultaGralAlumno() {
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
