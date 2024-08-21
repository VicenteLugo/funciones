/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DaoAlumno;

import BeanAlumno.AlumnoBean;
import Utilerias.ConexionMysql;
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
public class DAOEliminar {
    private static String deleteAlumno = "delete from alumno where matricula=?";
    private static String ConsultaGralAlumno = "select * from alumno";
    
    public boolean FuncionEliminaAlumno(int matricula){
       boolean elimina = false;
        try {
            Connection con = ConexionMysql.getConnection();
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(deleteAlumno);         
            ps.setInt(1, matricula);
            elimina = ps.executeUpdate() == 1;
            con.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return elimina;
    }
    
    public List getConsultaAlumnoDelete() {
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
