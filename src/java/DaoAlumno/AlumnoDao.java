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
public class AlumnoDao {

    private static String insertaAlumno = "insert into alumno (matricula,nombre,aprllidop,apellidom,edad,localidad) values (?,?,?,?,?,?)";
    private static String updateAlumno = "Update alumno set nombre=?, aprllidop=?, apellidom=?, edad=?,localidad=? where matricula=?";
    private static String ConsultaAlumno = "select * from alumno where matricula=?";
    private static String ConsultaGralAlumno = "select * from alumno";
    private static String deleteAlumno = "delete from alumno where matricula=?";

    public boolean AgregarAlumno(AlumnoBean bean) throws IOException {
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

    public boolean ModificaAlumno(AlumnoBean bean, int matricula) throws IOException {
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

    public boolean EliminaAlumno(int matricula){
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
 public List getAlumno(int matricula) {
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
  










    public List getConsultaAlumno() {
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
