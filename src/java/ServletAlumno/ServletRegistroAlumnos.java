/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ServletAlumno;

import BeanAlumno.AlumnoBean;
import DaoAlumno.DAOAgregarAlumno;
import java.io.IOException;
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
@WebServlet(name = "ServletRegistroAlumnos", urlPatterns = {"/ServletRegistroAlumnos"})
public class ServletRegistroAlumnos extends HttpServlet {

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
            if (res.equals("agregar")) {
                boolean insertoAl;
                int Matricula, Edad;
                String Nombre, ApellidoP, ApellidoM, Localidad;
                
                //Mensaje de prueba en caso de que el jsp no se conecte con el servlet
                String men = "No se inserto correctamente el registro favor de verificarlo...!!";
                
                //parámetros qeu tenemos en el JSP
                Matricula = Integer.parseInt(request.getParameter("matricula"));
                Nombre    = request.getParameter("nombre");
                ApellidoP = request.getParameter("aprllidoP");
                ApellidoM = request.getParameter("apellidoM");
                Edad      = Integer.parseInt(request.getParameter("edad"));
                Localidad = request.getParameter("localidad");
                
                //objeto tipo bean
                AlumnoBean ab = new AlumnoBean();
                ab.setMatricula(Matricula);
                ab.setNombre(Nombre);
                ab.setAprllidoP(ApellidoP);
                ab.setApellidoM(ApellidoM);
                ab.setEdad(Edad);
                ab.setLocalidad(Localidad);
                
                //objeto tipo DAO
                DAOAgregarAlumno da = new DAOAgregarAlumno();
                insertoAl = da.FunctionAgregarAlumno(ab);
                if(insertoAl){
                    men = "El registro se ha realizado con éxito...";
                }
                request.setAttribute("inserto", men);
                RequestDispatcher rd1 = getServletContext().getRequestDispatcher("/jsp/Alumnos/JSPRegistro.jsp");
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
