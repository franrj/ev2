<%-- 
    Document   : index
    Created on : 30-09-2022, 11:54:58
    Author     : Fran
--%>

<%@page import="java.util.Iterator"%>
<%@page import="root.model.entities.Cliente"%>
<%@page import="java.util.List"%>
<%@page import="root.model.dao.ClienteJpaController"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Ingreso</h1>
        
        <form action="controller" method="GET">
            
            
            <p>Id:</p>
            <input type="text" name="id" value="" /><br>
            <p>Nombre:</p>
            <input type="text" name="nombre" value="" /><br>
            <p>Apellido:</p>
            <input type="text" name="apellido" value="" /><br>
            <p>Edad:</p>
            <input type="text" name="edad" value="" /><br>
            <p>Correo:</p>
            <input type="text" name="correo" value="" /><br><br>
            
            <input type="submit" name="accion" value="enviar" />
            <input type="submit" name="accion" value="editar" />
            <input type="submit" name="accion" value="borrar" />
        </form>
        <br>
        <br>
        
        <table border="1">
            <thead>
                <tr>
                    <td>ID</td>
                    <td>NOMBRE</td>
                    <td>APELLIDO</td>
                    <td>EDAD</td>
                    <td>CORREO</td>

                </tr>
                
            </thead>
            
            <%
                ClienteJpaController dao = new ClienteJpaController();
                List<Cliente>list=dao.findClienteEntities();
                Iterator<Cliente>iter=list.iterator();
                Cliente cl=null;
                while(iter.hasNext()){
                cl=iter.next();
            %>
            
            
            <tbody>
                <tr>
                    <td><%= cl.getId()%></td>
                    <td><%= cl.getNombre()%></td>
                    <td><%= cl.getApellido()%></td>
                    <td><%= cl.getEdad()%></td>
                    <td><%= cl.getCorreo()%></td>
                </tr>
                <%}%>
            </tbody>
            
        </table>
        
        
        
    </body>
</html>
