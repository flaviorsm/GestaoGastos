<%-- 
    Document   : index
    Created on : 07/06/2016, 22:43:47
    Author     : aluno
--%>

<%@page import="java.util.List"%>
<%@page import="Modelo.ModelCategoria"%>
<%@page import="DAO.DAOCategoria"%>
<%@page import="Interface.IGestao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%            
            try
            {
                IGestao categoria = new DAOCategoria();                
//                ModelCategoria m = new ModelCategoria();
//                m.setNomeCategoria("CategoriaTeste3");
//                categoria.Save(m);
//                out.print(m.getMensagem());
                
//                ModelCategoria m = new ModelCategoria();
//                m.setIdCategoria(6);
//                m.setNomeCategoria("Categoria Teste 3");
//                categoria.Atualizar(m);
//                out.print(m.getMensagem());
                
//                ModelCategoria m = new ModelCategoria();
//                categoria.Delete(6);
//                out.print(m.getMensagem());
                
                out.print("<br/><br/><br/>");
                List<ModelCategoria> listCategoria = categoria.ObterLista();
                for(ModelCategoria cat : listCategoria)                
                    out.print(cat.getIdCategoria() + " - " + cat.getNomeCategoria() + "<br/>");                
                
                out.print("<br/><br/><br/>");                
                ModelCategoria modelCat = (ModelCategoria)categoria.ObterPorId(6);
                out.print(modelCat.getIdCategoria() + " - " + modelCat.getNomeCategoria() + "<br/>"); 
            }
            catch(Exception e)
            {
                out.print("Erro: " + e.getMessage());
            }
        %>
    </body>
</html>
