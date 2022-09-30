<%-- 
    Document   : index
    Created on : 30-09-2022, 11:54:58
    Author     : Fran
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Ingreso</h1>
        
        <form action="controller" method="POST">
            
            id:
            <input type="text" name="id" value="" />
            nombre:
            <input type="text" name="nombre" value="" />
            apellido:
            <input type="text" name="apellido" value="" />
            edad:
            <input type="text" name="edad" value="" />
            correo:
            <input type="text" name="correo" value="" />
            
            <input type="submit" value="enviar" />
        </form>
        
        
        
        
        
    </body>
</html>
