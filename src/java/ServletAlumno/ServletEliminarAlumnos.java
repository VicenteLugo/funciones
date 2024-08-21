/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ServletAlumno;

import DaoAlumno.AlumnoDao;
import DaoAlumno.DAOEliminar;
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
@WebServlet(name = "ServletEliminarAlumnos", urlPatterns = {"/ServletEliminarAlumnos"})
public class ServletEliminarAlumnos extends HttpServlet {

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
            if (res.equals("borrar")) {
                boolean borroRes;
                int mat2 = 0;
                
                //Mensaje de prueba en caso de que el jsp no se conecte con el servlet
                String men = "No se borro correctamente el registro....";
                
                if (request != null) {
                    mat2 = Integer.parseInt(request.getParameter("mat2"));
                }
                
                //Objeto tipo DAO
                DAOEliminar ad = new DAOEliminar();
                borroRes=ad.FuncionEliminaAlumno(mat2);
                
                if (borroRes) {
                    men = "registro borrado correctamente ....";
                }

                request.setAttribute("borro", men);
                RequestDispatcher rd1 = getServletContext().getRequestDispatcher("/jsp/Alumnos/JSPEliminar.jsp");
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
