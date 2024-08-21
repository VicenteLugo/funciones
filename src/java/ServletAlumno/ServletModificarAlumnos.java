/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ServletAlumno;

import BeanAlumno.AlumnoBean;
import DaoAlumno.AlumnoDao;
import DaoAlumno.DAOModificarAlumno;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Hector Miguel
 */
@WebServlet(name = "ServletModificarAlumnos", urlPatterns = {"/ServletModificarAlumnos"})
public class ServletModificarAlumnos extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String res = request.getParameter("submit") != null ? request.getParameter("submit") : null;
        if (res != null) {
            if (res.equals("modificar")) {
                boolean modificoRes;
                int matricula, edad;
                String nombre, apellidoP, apellidoM, localidad;
                
                //Mensaje de prueba en caso de que el jsp no se conecte con el servlet
                String men = "No se modifico correctamente el registro....";
                
                //parámetros qeu tenemos en el JSP
                matricula = Integer.parseInt(request.getParameter("matricula3"));
                nombre = request.getParameter("nombre3");
                apellidoP = request.getParameter("aprllidoP3");
                apellidoM = request.getParameter("apellidoM3");
                edad = Integer.parseInt(request.getParameter("edad3"));
                localidad = request.getParameter("localidad3");
                
                //Objeto tipo Bean
                AlumnoBean ab = new AlumnoBean();
                ab.setNombre(nombre);
                ab.setAprllidoP(apellidoP);
                ab.setApellidoM(apellidoM);
                ab.setEdad(edad);
                ab.setLocalidad(localidad);
                
                //Objeto tipo DAO
                DAOModificarAlumno ad = new DAOModificarAlumno();
                modificoRes = ad.FuncionModificaAlumno(ab, matricula);
                if (modificoRes) {
                    men = "Registro modificado correctamente...";
                }
                request.setAttribute("modifico", men);
                RequestDispatcher rd1 = getServletContext().getRequestDispatcher("/jsp/Alumnos/JSPModificar.jsp");
                rd1.forward(request, response);
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
