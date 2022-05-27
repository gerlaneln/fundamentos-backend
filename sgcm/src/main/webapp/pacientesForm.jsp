<%@ page pageEncoding="UTF-8" %>

<jsp:useBean id="controller" class="br.ufac.sgcm.controller.PacienteController" scope="page" />
<jsp:useBean id="item" class="br.ufac.sgcm.model.Paciente" scope="page" />

<%
    String alertaMensagem = null;
    String alertaTipo = null; 

    String paramId = request.getParameter("id");
    if (paramId != null && !paramId.isEmpty()) {
        Long id = Long.parseLong(paramId);
        item = controller.getById(id);
    }

    String submit = request.getParameter("submit");
    if (submit != null) {
        if (!request.getParameter("id").isEmpty()) {
            item.setId(Long.parseLong(request.getParameter("id")));
        }
        item.setNome(request.getParameter("nome"));
        item.setEmail(request.getParameter("email"));
        item.setTelefone(request.getParameter("telefone"));
        item.setDataNascimento(request.getParameter("dataNascimento"));
        item.setGrupoSanguineo(request.getParameter("grupoSanguineo"));
        item.setSexo(request.getParameter("sexo"));
        item.setCep(request.getParameter("cep"));
        item.setEndereco(request.getParameter("endereco"));
        item.setCidade(request.getParameter("cidade"));
        item.setEstado(request.getParameter("estado"));
        int status = controller.save(item);
        try {
            if (status > 0) {
                alertaMensagem = "Paciente salvo com sucesso!";
                alertaTipo = "sucesso";
                String url = "pacientes.jsp?" +
                    "alertaMensagem=" + alertaMensagem +
                    "&alertaTipo=" + alertaTipo;
                pageContext.forward(url);
            } else {
                alertaMensagem = "Erro ao salvar o paciente!";
                alertaTipo = "erro";
            }
        } catch (Exception e) {
            alertaMensagem = "Erro ao salvar o paciente!";
            alertaTipo = "erro";
        }
    }
%>

<!DOCTYPE html>
<html>
    <%@ include file="include/head.jsp" %>
    <body>
        <%@ include file="include/header.jsp" %>
        <%@ include file="include/nav.jsp" %>
        <main>
            <% if (alertaMensagem != null) { %>
            <jsp:include page="include/alerta.jsp">
                <jsp:param name="alertaMensagem" value="<%=alertaMensagem%>"/>
                <jsp:param name="alertaTipo" value="<%=alertaTipo%>"/>
            </jsp:include>
            <% } %>
            <form method="post">
                <div class="grid">
                    <input type="hidden" name="id"
                           value="<%= item.getId() != null ? item.getId() : "" %>">
                    <label for="nome">Nome</label>
                    <input type="text" name="nome" id="nome"
                        value="<%= item.getNome() != null ? item.getNome() : "" %>">
                    <label for="email">Email</label>
                    <input type="text" name="email" id="email"
                        value="<%= item.getEmail() != null ? item.getEmail() : "" %>">
                    <label for="telefone">Telefone</label>
                    <input type="text" name="telefone" id="telefone"
                        value="<%= item.getTelefone() != null ? item.getTelefone() : "" %>">
                    <label for="dataNascimento">Data de nascimento</label>
                    <input type="date" name="dataNascimento" id="dataNascimento"
                        value="<%= item.getDataNascimento() != null ? item.getDataNascimento() : "" %>">
                    <label for="grupoSanguineo">Grupo sanguíneo</label>
                    <select name="grupoSanguineo" id="grupoSanguineo">
                        <option value="">Selecione</option>
                        <option value="A+" <%= item.getGrupoSanguineo() != null && item.getGrupoSanguineo().getLabel().equals("A+") ? "selected" : "" %>>A+</option>
                        <option value="A-" <%= item.getGrupoSanguineo() != null && item.getGrupoSanguineo().getLabel().equals("A-") ? "selected" : "" %>>A-</option>
                        <option value="B+" <%= item.getGrupoSanguineo() != null && item.getGrupoSanguineo().getLabel().equals("B+") ? "selected" : "" %>>B+</option>
                        <option value="B-" <%= item.getGrupoSanguineo() != null && item.getGrupoSanguineo().getLabel().equals("B-") ? "selected" : "" %>>B-</option>
                        <option value="AB+" <%= item.getGrupoSanguineo() != null && item.getGrupoSanguineo().getLabel().equals("AB+") ? "selected" : "" %>>AB+</option>
                        <option value="AB-" <%= item.getGrupoSanguineo() != null && item.getGrupoSanguineo().getLabel().equals("AB-") ? "selected" : "" %>>AB-</option>
                        <option value="O+" <%= item.getGrupoSanguineo() != null && item.getGrupoSanguineo().getLabel().equals("O+") ? "selected" : "" %>>O+</option>
                        <option value="O-" <%= item.getGrupoSanguineo() != null && item.getGrupoSanguineo().getLabel().equals("O-") ? "selected" : "" %>>O-</option>
                    </select>
                    <label for="sexo">Sexo</label>
                    <select name="sexo" id="sexo">
                        <option value="">Selecione</option>
                        <option value="M" <%= item.getSexo() != null && item.getSexo().name().equals("M") ? "selected" : "" %>>Masculino</option>
                        <option value="F" <%= item.getSexo() != null && item.getSexo().name().equals("F") ? "selected" : "" %>>Feminino</option>
                    </select>
                    <label for="cep">CEP</label>
                    <input type="text" name="cep" id="cep"
                        value="<%= item.getCep() != null ? item.getCep() : "" %>">
                    <label for="endereco">Endereço</label>
                    <input type="text" name="endereco" id="endereco"
                        value="<%= item.getEndereco() != null ? item.getEndereco() : "" %>">
                    <label for="estado">Estado</label>
                    <select name="estado" id="estado">
                        <option value="">Selecione</option>
                        <option value="AC" <%= item.getEstado() != null && item.getEstado().equals("AC") ? "selected" : "" %>>Acre</option>
                        <option value="AL" <%= item.getEstado() != null && item.getEstado().equals("AL") ? "selected" : "" %>>Alagoas</option>
                        <option value="AP" <%= item.getEstado() != null && item.getEstado().equals("AP") ? "selected" : "" %>>Amapá</option>
                        <option value="AM" <%= item.getEstado() != null && item.getEstado().equals("AM") ? "selected" : "" %>>Amazonas</option>
                        <option value="BA" <%= item.getEstado() != null && item.getEstado().equals("BA") ? "selected" : "" %>>Bahia</option>
                        <option value="CE" <%= item.getEstado() != null && item.getEstado().equals("CE") ? "selected" : "" %>>Ceará</option>
                        <option value="DF" <%= item.getEstado() != null && item.getEstado().equals("DF") ? "selected" : "" %>>Distrito Federal</option>
                        <option value="ES" <%= item.getEstado() != null && item.getEstado().equals("ES") ? "selected" : "" %>>Espirito Santo</option>
                        <option value="GO" <%= item.getEstado() != null && item.getEstado().equals("GO") ? "selected" : "" %>>Goiás</option>
                        <option value="MA" <%= item.getEstado() != null && item.getEstado().equals("MA") ? "selected" : "" %>>Maranhão</option>
                        <option value="MS" <%= item.getEstado() != null && item.getEstado().equals("MS") ? "selected" : "" %>>Mato Grosso do Sul</option>
                        <option value="MT" <%= item.getEstado() != null && item.getEstado().equals("MT") ? "selected" : "" %>>Mato Grosso</option>
                        <option value="MG" <%= item.getEstado() != null && item.getEstado().equals("MG") ? "selected" : "" %>>Minas Gerais</option>
                        <option value="PA" <%= item.getEstado() != null && item.getEstado().equals("PA") ? "selected" : "" %>>Pará</option>
                        <option value="PB" <%= item.getEstado() != null && item.getEstado().equals("PB") ? "selected" : "" %>>Paraíba</option>
                        <option value="PR" <%= item.getEstado() != null && item.getEstado().equals("PR") ? "selected" : "" %>>Paraná</option>
                        <option value="PE" <%= item.getEstado() != null && item.getEstado().equals("PE") ? "selected" : "" %>>Pernambuco</option>
                        <option value="PI" <%= item.getEstado() != null && item.getEstado().equals("PI") ? "selected" : "" %>>Piauí</option>
                        <option value="RJ" <%= item.getEstado() != null && item.getEstado().equals("RJ") ? "selected" : "" %>>Rio de Janeiro</option>
                        <option value="RN" <%= item.getEstado() != null && item.getEstado().equals("RN") ? "selected" : "" %>>Rio Grande do Norte</option>
                        <option value="RS" <%= item.getEstado() != null && item.getEstado().equals("RS") ? "selected" : "" %>>Rio Grande do Sul</option>
                        <option value="RO" <%= item.getEstado() != null && item.getEstado().equals("RO") ? "selected" : "" %>>Rondônia</option>
                        <option value="RR" <%= item.getEstado() != null && item.getEstado().equals("RR") ? "selected" : "" %>>Roraima</option>
                        <option value="SC" <%= item.getEstado() != null && item.getEstado().equals("SC") ? "selected" : "" %>>Santa Catarina</option>
                        <option value="SP" <%= item.getEstado() != null && item.getEstado().equals("SP") ? "selected" : "" %>>São Paulo</option>
                        <option value="SE" <%= item.getEstado() != null && item.getEstado().equals("SE") ? "selected" : "" %>>Sergipe</option>
                        <option value="TO" <%= item.getEstado() != null && item.getEstado().equals("TO") ? "selected" : "" %>>Tocantins</option>
                    </select>
                    <label for="cidade">Cidade</label>
                    <input type="text" name="cidade" id="cidade"
                        value="<%= item.getCidade() != null ? item.getCidade() : "" %>">
                </div>
                <input type="button" value="Cancelar" data-redirect="pacientes.jsp">
                <input type="submit" value="Salvar" name="submit">
            </form>
        </main>
        <%@ include file="include/footer.jsp" %>
    </body>
</html>
