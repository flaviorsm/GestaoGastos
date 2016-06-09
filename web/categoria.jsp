<%-- 
    Document   : categoria
    Created on : 09/06/2016, 00:17:36
    Author     : Flavio
--%>

<%@page import="java.util.List"%>
<%@page import="java.io.IOException"%>
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
                IGestao gestao = new DAOCategoria();   
                
                //Salvar
//                try
//                {
//                    ModelCategoria m = new ModelCategoria();
//                    m.setNomeCategoria("Categoria 1");
//                    gestao.Save(m);
//                    out.print("Inserido com sucesso");
//                }
//                catch(IOException ex)
//                {
//                    out.print(ex.getMessage());
//                }
                
                //Atualizar
//                try
//                {
//                    ModelCategoria m = new ModelCategoria();
//                    m.setIdCategoria(1);
//                    m.setNomeCategoria("Categoria 3");
//                    gestao.Atualizar(m);
//                    out.print("Atualizado comsucesso");
//                }
//                catch(IOException ex)
//                {
//                    out.print(ex.getMessage());
//                }
//                
                //Deletar
//                try
//                {
//                ModelCategoria m = new ModelCategoria();
//                gestao.Delete(1);
//                out.print("Deletado com sucesso");
//                }
//                catch(IOException ex)
//                {
//                    out.print(ex.getMessage());
//                }
//                
//                
                out.print("<br/><br/><br/>");
                List<ModelCategoria> lista = gestao.ObterLista();
                if(!lista.isEmpty())
                    for(ModelCategoria cat : lista)                
                        out.print(cat.getIdCategoria() + " - " + cat.getNomeCategoria() + "<br/>");                
                else
                    out.print("Nenhum arquivo encontrado");
                
                
                out.print("<br/><br/><br/>");             
                ModelCategoria model = (ModelCategoria)gestao.ObterPorId(3);
                if(model != null)
                    out.print(model.getIdCategoria() + " - " + model.getNomeCategoria() + "<br/>"); 
                else
                    out.print("Não Encontrado<br/>"); 
            %>
    </body>
</html>
