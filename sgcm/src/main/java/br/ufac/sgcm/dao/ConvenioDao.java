package br.ufac.sgcm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ufac.sgcm.model.Convenio;

public class ConvenioDao implements IDao<Convenio> {

    private Connection conexao;
    private PreparedStatement pstmt;
    private ResultSet rs;

    public ConvenioDao() throws ClassNotFoundException, SQLException {
        conexao = ConexaoDB.getConexao();
        System.out.println(conexao);
    }

    @Override
    public List<Convenio> getAll() throws SQLException {
        List<Convenio> registros = new ArrayList<>();
        String sql = "SELECT * FROM convenio";
            pstmt = conexao.prepareStatement(sql);
            rs = pstmt.executeQuery();
        while (rs.next()) {
            Convenio registro = new Convenio();
            registro.setId(rs.getLong("id"));
            registro.setNome(rs.getString("nome"));
            registro.setRazaoSocial(rs.getString("razao_social"));
            registro.setCnpj(rs.getString("cnpj"));
            registro.setRepresentante(rs.getString("representante"));
            registro.setEmail(rs.getString("email"));
            registro.setTelefone(rs.getString("telefone"));
            registro.setAtivo(rs.getBoolean("ativo"));
            registros.add(registro);
        }
        return registros;
    }

    @Override
    public Convenio getById(Long id) throws SQLException {
        Convenio registro = new Convenio();
        String sql = "SELECT * FROM convenio WHERE id = ?";
        pstmt = conexao.prepareStatement(sql);
        pstmt.setLong(1, id);
        rs = pstmt.executeQuery();
        if (rs.next()) {
            registro.setId(rs.getLong("id"));
            registro.setNome(rs.getString("nome"));
            registro.setRazaoSocial(rs.getString("razao_social"));
            registro.setCnpj(rs.getString("cnpj"));
            registro.setRepresentante(rs.getString("representante"));
            registro.setEmail(rs.getString("email"));
            registro.setTelefone(rs.getString("telefone"));
            registro.setAtivo(rs.getBoolean("ativo"));
        }
        return registro;
    }

    @Override
    public List<Convenio> getByAll(String termoBusca) throws SQLException {
        List<Convenio> registros = new ArrayList<>();
        String sql = "SELECT * FROM convenio WHERE nome LIKE ?"
            + " OR razao_social LIKE ?"
            + " OR cnpj LIKE ?"
            + " OR representante LIKE ?"
            + " OR email LIKE ?"
            + " OR telefone LIKE ?";
        pstmt = conexao.prepareStatement(sql);
        pstmt.setString(1, "%" + termoBusca + "%");
        pstmt.setString(2, "%" + termoBusca + "%");
        pstmt.setString(3, "%" + termoBusca + "%");
        pstmt.setString(4, "%" + termoBusca + "%");
        pstmt.setString(5, "%" + termoBusca + "%");
        pstmt.setString(6, "%" + termoBusca + "%");
        rs = pstmt.executeQuery();
        while (rs.next()) {
            Convenio registro = new Convenio();
            registro.setId(rs.getLong("id"));
            registro.setNome(rs.getString("nome"));
            registro.setRazaoSocial(rs.getString("razao_social"));
            registro.setCnpj(rs.getString("cnpj"));
            registro.setRepresentante(rs.getString("representante"));
            registro.setEmail(rs.getString("email"));
            registro.setTelefone(rs.getString("telefone"));
            registro.setAtivo(rs.getBoolean("ativo"));
            registros.add(registro);
        }
        return registros;
    }

    @Override
    public int insert(Convenio objeto) throws SQLException {
        int registrosAfetados = 0;
        String sql = "INSERT INTO convenio"
            + " (nome, razao_social, cnpj, representante, email, telefone, ativo)"
            + " VALUES (?, ?, ?, ?, ?, ?, ?)";
        pstmt = conexao.prepareStatement(sql);
        pstmt.setString(1, objeto.getNome());
        pstmt.setString(2, objeto.getRazaoSocial());
        pstmt.setString(3, objeto.getCnpj());
        pstmt.setString(4, objeto.getRepresentante());
        pstmt.setString(5, objeto.getEmail());
        pstmt.setString(6, objeto.getTelefone());
        pstmt.setBoolean(7, objeto.isAtivo());
        registrosAfetados = pstmt.executeUpdate();
        return registrosAfetados;
    }

    @Override
    public int update(Convenio objeto) throws SQLException {
        int registrosAfetados = 0;
        String sql = "UPDATE convenio SET"
            + " nome = ?,"
            + " razao_social = ?,"
            + " cnpj = ?,"
            + " representante = ?,"
            + " email = ?,"
            + " telefone = ?,"
            + " ativo = ?"
            + " WHERE id = ?";
        pstmt = conexao.prepareStatement(sql);
        pstmt.setString(1, objeto.getNome());
        pstmt.setString(2, objeto.getRazaoSocial());
        pstmt.setString(3, objeto.getCnpj());
        pstmt.setString(4, objeto.getRepresentante());
        pstmt.setString(5, objeto.getEmail());
        pstmt.setString(6, objeto.getTelefone());
        pstmt.setBoolean(7, objeto.isAtivo());
        pstmt.setLong(8, objeto.getId());
        registrosAfetados = pstmt.executeUpdate();
        return registrosAfetados;
    }

    @Override
    public int delete(Long id) throws SQLException {
        int registrosAfetados = 0;
        String sql = "DELETE FROM convenio WHERE id = ?";
        pstmt = conexao.prepareStatement(sql);
        pstmt.setLong(1, id);
        registrosAfetados = pstmt.executeUpdate();
        return registrosAfetados;
    }
    
}
