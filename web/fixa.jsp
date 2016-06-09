<%-- 
    Document   : fixa
    Created on : 08/06/2016, 23:44:41
    Author     : Flavio
--%>

<%@page import="Modelo.ModelFixa"%>
<%@page import="java.util.List"%>
<%@page import="DAO.DAOFixa"%>
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
                out.print("1");
                IGestao gestao = new DAOFixa();   
                
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
                List<ModelFixa> listCategoria = gestao.ObterLista();
                for(ModelFixa cat : listCategoria)                
                    out.print(cat.getIdCategoria() + " - " + cat.getNomeCategoria() + "<br/>");                
                
                out.print("<br/><br/><br/>");                
                ModelFixa modelCat = (ModelFixa)gestao.ObterPorId(1);
                if(modelCat != null)
                    out.print(modelCat.getIdCategoria() + " - " + modelCat.getNomeCategoria() + "<br/>"); 
                else
                    out.print("Não Encontrado<br/>"); 
            }
            catch(Exception e)
            {
                out.print("Erro: " + e.getMessage());
            }
        %>
    </body>
</html>
