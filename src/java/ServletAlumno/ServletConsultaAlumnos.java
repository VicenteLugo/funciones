/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ServletAlumno;

import BeanAlumno.AlumnoBean;
import DaoAlumno.AlumnoDao;
import DaoAlumno.DAOConsultarAlumno;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author yo
 */
@WebServlet(name = "ServletConsultaAlumnos", urlPatterns = {"/ServletConsultaAlumnos"})
public class ServletConsultaAlumnos extends HttpServlet {

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
            
            if (res.equals("consultar")) {
                int matricula;
                matricula = Integer.parseInt(request.getParameter("matricula3"));
                List datoAlumno = new ArrayList();
                
                //Objeto tipo DAO
                DAOConsultarAlumno ADao = new DAOConsultarAlumno();
                datoAlumno = ADao.getConsultaAlumno(matricula);

                request.setAttribute("alumnosAgregadosConsulta", datoAlumno);
                RequestDispatcher rd1 = getServletContext().getRequestDispatcher("/jsp/Alumnos/JSPConsulta.jsp");
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
