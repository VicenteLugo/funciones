<%-- 
    Document   : index
    Created on : 19/07/2014, 09:18:09 PM
    Author     : Hector Miguel
--%>
<% String contextPath = request.getContextPath();%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="description" content="'C R U D'">
        <meta name="keywords" content="HTML5, CSS3, JavaScript">
        <meta name="Author" content=" T.S.U Hector Miguel Arroyo Ayala ">

        <%------------ Logotipo (Iconfinder) ------------%>
        <link rel="shortcut icon" href="<%=contextPath%>/images/iconfinder/ico1.ico" >

        <%------------ Título del Sistema ------------%>
        <title>Interfaz de Inicio (M E N &Uacute; del C R U D)</title>

        <%------------ Hojas de Estilo (.css) ------------%>
        <link rel="stylesheet" href="<%=contextPath%>/css/styleIndex.css" media="all">
        <link rel="stylesheet" href="<%=contextPath%>/css/styleBarraMac.css" media="all">

        <%------------ Archivos JavaScript (.js) ------------%>
        <script language="javascript" type="text/javascript" src="<%=contextPath%>/js/mac/jquer_mac.js"></script>
        <script language="javascript" type="text/javascript" src="<%=contextPath%>/js/mac/mac.js"></script>
        <script language="javascript" type="text/javascript" src="<%=contextPath%>/js/mac/macFunction.js"></script>        
    </head>
    <body>
        <section id="main">
            <header id="Header"><div id="tituloText">Aplicaci&oacute;n &nbsp; Web &nbsp; utilizando &nbsp; el &nbsp; C&nbsp;R&nbsp;U&nbsp;D</div></header>
            <section id="baseHeader"></section>
            <section id="Body">
                <section id="bodyMain">
                    <table id="tableContainer">
                        <tr>
                            <td class="td1">
                                <table id="tableSup">
                                    <div style="float:right; margin:2px 2px 0 0;"><img src="<%=contextPath%>/images/index/articulo.png" width="100" height="22" /></div>
                                    <div class="divTableSup"><img alt="Actualidad" src="<%=contextPath%>/images/index/estrella.png" width="17" height="17"/> &nbsp; Acceso a las funciones de los alumnos... </div>
                                    <tr>
                                        <td><img src="<%=contextPath%>/images/index/interrogacion-2.png"></td>
                                        <td>
                                            <p class="pTableSup" style="padding: 0 0 0 50px">&nbsp;A continuaci&oacute;n se muestra un <b>peque&ntilde;o men&uacute;</b> donde podr&aacute;s accesar a &nbsp;<b class="campoObligatorio">la funci&oacute;n deseada!</b>.</p>
                                            <br/>
                                            <article>
                                                <fieldset style="margin:auto; border:1px solid #E8DDC9; border-radius:10px; width:540px;">
                                                    <legend><span style=" font-size:11px"><b>C R U D</b></span></legend>
                                                    <br>
                                                    <form name="formA" method="post" action="#">  
                                                        <table align="center" width="300">
                                                            <tr>
                                                                <td>
                                                                    <br/>
                                                                    <div class="dock" id="dock2">
                                                                        <div class="dock-container2">
                                                                            <a class="dock-item2" href="#"><span></span></a> 
                                                                            <a class="dock-item2" href="#"><span></span></a> 
                                                                            <a class="dock-item2" href="<%=contextPath%>/jsp/Alumnos/JSPRegistro.jsp"><span>Agregar</span><img  src="<%=contextPath%>/images/barraMac/1.png"></a> 
                                                                            <a class="dock-item2" href="<%=contextPath%>/jsp/Alumnos/JSPConsulta.jsp"><span>Consultar</span><img src="<%=contextPath%>/images/barraMac/2.png"></a>
                                                                            <a class="dock-item2" href="<%=contextPath%>/jsp/Alumnos/JSPModificar.jsp"><span>Modificar</span><img src="<%=contextPath%>/images/barraMac/3.png"></a> 
                                                                            <a class="dock-item2" href="<%=contextPath%>/jsp/Alumnos/JSPEliminar.jsp"><span>Eliminar</span><img src="<%=contextPath%>/images/barraMac/4.png"></a> 
                                                                            <a class="dock-item2" href="#"><span></span></a> 
                                                                            <a class="dock-item2" href="#"><span></span></a> 
                                                                        </div>
                                                                    </div>
                                                                </td>
                                                            </tr>
                                                        </table>                                                            
                                                    </form> 
                                                    <br/>
                                                </fieldset>                        
                                            </article>                                      
                                        </td>
                                    </tr>
                                </table>    
                            </td>    
                        </tr>
                    </table>
                </section>
            </section>
            <div id="footer"></div>
        </section>
        <%------------ Última barra inferior------------%>
        <div style="background:rgba(1,0,0,0.5);padding:3px;font:normal 13px Tahoma;text-align:center;position:fixed;bottom:0;width:100%;color:#8A0808">
            &copy; &nbsp;
            <a 
                href='http://www.utez.edu.mx/' title='Universidad Tecnola Emiliano Zapata' style="color:#94B3C5;font-weight:bold;text-decoration:none">
                'Ejercicio implementando el CRUD con una BD'
            </a> 
            &nbsp; | &nbsp;
            <font style="color:#F6D8CE; font-weight:bold; text-decoration:none">Realizado por</font>
            &nbsp; : &nbsp;
            <font style="color:#D8D8D8; font-weight:bold; text-decoration:none"> T.S.U &nbsp; H&eacute;ctor Miguel Arroyo Ayala </font>	
        </div>
    </body>
</html>