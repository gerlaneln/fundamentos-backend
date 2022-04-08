<%@ page pageEncoding="UTF-8"%>

<%@ page import="java.util.List"%>
<%@ page import="br.ufac.sgcm.model.Profissional"%>

<jsp:useBean id="controller" class="br.ufac.sgcm.controller.ProfissionalController" scope="page"/>

<%
    String alertaMensagem = null;
    String alertaTipo = null;

    String paramExcluir = request.getParameter("excluir");
    if(paramExcluir != null && !paramExcluir.isEmpty()){

        Long id = Long.parseLong(paramExcluir);
        try{
            int status = controller.delete(id);
            if(status > 0){
                alertaMensagem = "Profissional excluído com sucesso!";
                alertaTipo = "sucesso";
            }else{
                alertaMensagem = "Erro ao excluir profissional!";
                alertaTipo = "erro";
            }
        }catch(Exception e){
            alertaMensagem = e.getMessage();
            alertaTipo = "erro";
        }
        
    }

    List<Profissional> registros = controller.getAll();
%>

<!DOCTYPE html>
<html>
    <%@ include file="include/head.jsp"%>
    <body>
        <%@ include file="include/header.jsp"%>
        <%@ include file="include/nav.jsp"%>
        <main>

            <% if(alertaMensagem != null){%>

            <jsp:include page="include/alerta.jsp">
                <jsp:param name="alertaMensagem" value="<%=alertaMensagem%>"/>
                <jsp:param name="alertaTipo" value="<%=alertaTipo%>"/>
            </jsp:include>
            
            <% } %>

            <jsp:include page="include/comandos.jsp">
                <jsp:param name="link" value="profissionaisForm.jsp"/>
            </jsp:include>

            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nome</th>
                        <th>Registro</th>
                        <th>Especialidade</th>
                        <th>Unidade</th>
                        <th>Telefone</th>
                        <th>E-mail</th>
                        <th>Ações</th>
                    </tr>
                </thead>
                <tbody>
                <% for (Profissional item : registros) {%>
                    <tr>
                        <td class="fit"><%=item.getId()%></td>
                        <td><%=item.getNome()%></td>
                        <td><%=item.getRegistroConselho()%></td>
                        <td><%=item.getEspecialidade().getNome()%></td>
                        <td><%=item.getUnidade().getNome()%></td>
                        <td><%=item.getTelefone()%></td>
                        <td><%=item.getEmail()%></td>
                        <td>
                            <a href="profissionaisForm.jsp?id=<%=item.getId()%>" class="botao">Editar</a>
                            <a href="profissionais.jsp?excluir=<%=item.getId()%>" class="botao excluir">Excluir</a>
                        </td>
                    </tr>
                <%}%>
                </tbody>
                <tfoot>
                    <tr>
                        <td colspan="8">Total de registros: <%=registros.size()%></td>
                    </tr>
                </tfoot>
            </table>
        </main>
        <%@ include file="include/footer.jsp"%>
    </body>
</html>