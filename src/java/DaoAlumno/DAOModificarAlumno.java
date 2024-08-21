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
public class DAOModificarAlumno {
    private static String updateAlumno = "Update alumno set nombre=?, aprllidop=?, apellidom=?, edad=?,localidad=? where matricula=?";
    private static String ConsultaGralAlumno = "select * from alumno";
    
    public boolean FuncionModificaAlumno(AlumnoBean bean, int matricula) throws IOException {
        boolean modifica = false;
        try {
            Connection con = ConexionMysql.getConnection();
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(updateAlumno);
            ps.setString(1, bean.getNombre());
            ps.setString(2, bean.getAprllidoP());
            ps.setString(3, bean.getApellidoM());
            ps.setInt(4, bean.getEdad());
            ps.setString(5, bean.getLocalidad());
            ps.setInt(6, matricula);
            modifica = ps.executeUpdate() == 1;
            con.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage() + "Modifica DAO");
        }
        return modifica;
    }
    
    public List getConsultaGenAlumno() {
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