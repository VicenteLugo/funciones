/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ServletAlumno;

import BeanAlumno.AlumnoBean;
import DaoAlumno.AlumnoDao;
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
 * @author Alumno CI
 */
@WebServlet(name = "ServletAlumno", urlPatterns = {"/ServletAlumno"})
public class ServletAlumno extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String res = request.getParameter("submit") != null ? request.getParameter("submit") : null;
        if (res != null) {
            if (res.equals("agregar")) {
                boolean insertoRes;
                int matricula, edad;
                String nombre, apellidoP, apellidoM, localidad;
                String men = "No se inserto correctamente el registro....";
                matricula = Integer.parseInt(request.getParameter("matricula"));
                nombre = request.getParameter("nombre");
                apellidoP = request.getParameter("aprllidoP");
                apellidoM = request.getParameter("apellidoM");
                edad = Integer.parseInt(request.getParameter("edad"));
                localidad = request.getParameter("localidad");

                AlumnoBean ab = new AlumnoBean();
                ab.setMatricula(matricula);
                ab.setNombre(nombre);
                ab.setAprllidoP(apellidoP);
                ab.setApellidoM(apellidoM);
                ab.setEdad(edad);
                ab.setLocalidad(localidad);

                AlumnoDao ad = new AlumnoDao();
                insertoRes = ad.AgregarAlumno(ab);
                if (insertoRes) {
                    men = "Registro insertado correctamente...";
                }
                request.setAttribute("inserto", men);
                RequestDispatcher rd1 = getServletContext().getRequestDispatcher("/JSPAlumnos/JSPAlumnos.jsp");
                rd1.forward(request, response);
            }

            if (res.equals("modificar")) {
                boolean modificoRes;
                int matricula, edad;
                String nombre, apellidoP, apellidoM, localidad;
                String men = "No se modifico correctamente el registro....";
                matricula = Integer.parseInt(request.getParameter("matricula3"));
                nombre = request.getParameter("nombre3");
                apellidoP = request.getParameter("apellidoP3");
                apellidoM = request.getParameter("apellidoM3");
                edad = Integer.parseInt(request.getParameter("edad3"));
                localidad = request.getParameter("localidad3");
                AlumnoBean ab = new AlumnoBean();
                ab.setNombre(nombre);
                ab.setAprllidoP(apellidoP);
                ab.setApellidoM(apellidoM);
                ab.setEdad(edad);
                ab.setLocalidad(localidad);
                AlumnoDao ad = new AlumnoDao();
                modificoRes = ad.ModificaAlumno(ab, matricula);
                if (modificoRes) {
                    men = "Registro modificado correctamente...";
                }
                request.setAttribute("modifico", men);

                RequestDispatcher rd1 = getServletContext().getRequestDispatcher("/JSPAlumnos/JSPAlumnos.jsp");
                rd1.forward(request, response);
            }

            if (res.equals("borrar")) {
                boolean borroRes;
                int mat2 = 0;
                String men = "No se borro correctamente el registro....";
                if (request != null) {
                    mat2 = Integer.parseInt(request.getParameter("mat2"));
                }
                AlumnoDao ad = new AlumnoDao();
                borroRes=ad.EliminaAlumno(mat2);
                
                if (borroRes) {
                    men = "registro borrado correctamente ....";
                }

                request.setAttribute("borro", men);

                RequestDispatcher rd1 = getServletContext().getRequestDispatcher("/JSPAlumnos/JSPAlumnos.jsp");
                rd1.forward(request, response);
            }
            
            
            if (res.equals("consultar")) {
               
                int matricula;
                matricula=Integer.parseInt(request.getParameter("matricula3"));
                List datoAlumno=new ArrayList();
                AlumnoDao ADao=new AlumnoDao();
                datoAlumno=ADao.getAlumno(matricula);
              
              

                request.setAttribute("alumnos",datoAlumno);

                RequestDispatcher rd1 = getServletContext().getRequestDispatcher("/JSPAlumnos/JSPAlumnos.jsp");
                rd1.forward(request, response);
            }  
        }
            
            
            
            
            





        }
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * Handles the HTTP <code>POST</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
