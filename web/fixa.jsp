<%-- 
    Document   : fixa
    Created on : 08/06/2016, 23:44:41
    Author     : Flavio
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.io.IOException"%>
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
                IGestao gestao = new DAOFixa();   
                Date d = new Date(); 
                long mili = d.getTime();
                java.sql.Date data = new java.sql.Date(mili);
                //Salvar
//                try
//                {
//                    ModelFixa m = new ModelFixa();
//                    m.setDescricao("Descrição fixa");
//                    m.setData(data);
//                    m.setValor(20);
//                    m.setIdCategoria(2);
//                    gestao.Save(m);
//                    out.print("Inserido com sucesso");
//                }
//                catch(IOException ex)
//                {
//                    out.print(ex.getMessage());
//                }
                
//                //Atualizar
//                try
//                {
//                    ModelFixa m = new ModelFixa();
//                    m.setIdFixa(2);
//                    m.setDescricao("Descrição fixa 3");
//                    m.setData(data);
//                    m.setValor(50);
//                    m.setIdCategoria(2);
//                    gestao.Atualizar(m);
//                    out.print("Atualizado com sucesso");
//                }
//                catch(IOException ex)
//                {
//                    out.print(ex.getMessage());
//                }
//                
                //Deletar
//                try
//                {
//                    ModelFixa m = new ModelFixa();
//                    gestao.Delete(1);
//                    out.print("Deletado com sucesso");
//                }
//                catch(IOException ex)
//                {
//                    out.print(ex.getMessage());
//                }
//                
//                
                out.print("<br/><br/><br/>");
                List<ModelFixa> lista = gestao.ObterLista();
                DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                if(lista != null)
                {
                    int i = 1;
                    for(ModelFixa cat : lista)                
                    {                        
                        out.print("Linha: " + i++);
                        out.print("<br/>" + cat.getIdFixa() + "<br/>" + cat.getDescricao() + "<br/>");
                        out.print(cat.getData().toString() + "<br/>" + cat.getValor() + "<br/><br/>");
                    }
                }
                else
                    out.print("Nenhum arquivo encontrado");
                
                
                out.print("<br/><br/><br/>");             
                ModelFixa model = (ModelFixa)gestao.ObterPorId(2);
                if(model != null)
                {
                    out.print("<br/>" + model.getIdFixa() + "<br/>" + model.getDescricao() + "<br/>");
                    out.print(model.getData().toString() + "<br/>" + model.getValor() + "<br/><br/>");
                }
                else
                    out.print("Não Encontrado<br/>"); 
            
        %>
    </body>
</html>
