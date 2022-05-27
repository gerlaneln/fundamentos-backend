package br.ufac.sgcm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ufac.sgcm.model.Paciente;

public class PacienteDao implements IDao<Paciente> {

    private Connection conexao;
    private PreparedStatement pstmt;
    private ResultSet rs;

    public PacienteDao() throws ClassNotFoundException, SQLException {
        conexao = ConexaoDB.getConexao();
    }

    @Override
    public List<Paciente> getAll() throws SQLException {
        List<Paciente> registros = new ArrayList<>();
        String sql = "SELECT * FROM paciente";
        pstmt = conexao.prepareStatement(sql);
        rs = pstmt.executeQuery();
        while (rs.next()) {
            Paciente registro = new Paciente();
            registro.setId(rs.getLong("id"));
            registro.setNome(rs.getString("nome"));
            registro.setEmail(rs.getString("email"));
            registro.setTelefone(rs.getString("telefone"));
            registro.setDataNascimento(rs.getDate("data_nascimento"));
            registro.setGrupoSanguineo(rs.getString("grupo_sanguineo"));
            registro.setSexo(rs.getString("sexo"));
            registro.setCep(rs.getString("cep"));
            registro.setEndereco(rs.getString("endereco"));
            registro.setCidade(rs.getString("cidade"));
            registro.setEstado(rs.getString("estado"));
            registros.add(registro);
        }
        return registros;
    }

    @Override
    public Paciente getById(Long id) throws SQLException {
        Paciente registro = new Paciente();
        String sql = "SELECT * FROM paciente WHERE id = ?";
        pstmt = conexao.prepareStatement(sql);
        pstmt.setLong(1, id);
        rs = pstmt.executeQuery();
        if (rs.next()) {
            registro.setId(rs.getLong("id"));
            registro.setNome(rs.getString("nome"));
            registro.setEmail(rs.getString("email"));
            registro.setTelefone(rs.getString("telefone"));
            registro.setDataNascimento(rs.getDate("data_nascimento"));
            registro.setGrupoSanguineo(rs.getString("grupo_sanguineo"));
            registro.setSexo(rs.getString("sexo"));
            registro.setCep(rs.getString("cep"));
            registro.setEndereco(rs.getString("endereco"));
            registro.setCidade(rs.getString("cidade"));
            registro.setEstado(rs.getString("estado"));
        }
        return registro;
    }

    @Override
    public List<Paciente> getByAll(String termoBusca) throws SQLException {
        List<Paciente> registros = new ArrayList<>();
        String sql = "SELECT * FROM paciente WHERE nome LIKE ?" +
            " OR email LIKE ? OR telefone LIKE ? OR cep LIKE ?" +
            " OR grupo_sanguineo LIKE ? OR sexo LIKE ?" +
            " OR endereco LIKE ? OR cidade LIKE ? OR estado LIKE ?";
        pstmt = conexao.prepareStatement(sql);
        pstmt.setString(1, "%" + termoBusca + "%");
        pstmt.setString(2, "%" + termoBusca + "%");
        pstmt.setString(3, "%" + termoBusca + "%");
        pstmt.setString(4, "%" + termoBusca + "%");
        pstmt.setString(5, "%" + termoBusca + "%");
        pstmt.setString(6, "%" + termoBusca + "%");
        pstmt.setString(7, "%" + termoBusca + "%");
        pstmt.setString(8, "%" + termoBusca + "%");
        pstmt.setString(9, "%" + termoBusca + "%");
        rs = pstmt.executeQuery();
        while (rs.next()) {
            Paciente registro = new Paciente();
            registro.setId(rs.getLong("id"));
            registro.setNome(rs.getString("nome"));
            registro.setEmail(rs.getString("email"));
            registro.setTelefone(rs.getString("telefone"));
            registro.setDataNascimento(rs.getDate("data_nascimento"));
            registro.setGrupoSanguineo(rs.getString("grupo_sanguineo"));
            registro.setSexo(rs.getString("sexo"));
            registro.setCep(rs.getString("cep"));
            registro.setEndereco(rs.getString("endereco"));
            registro.setCidade(rs.getString("cidade"));
            registro.setEstado(rs.getString("estado"));
            registros.add(registro);
        }
        return registros;
    }

    @Override
    public int insert(Paciente objeto) throws SQLException {
        int registrosAfetados = 0;
        String sql = "INSERT INTO paciente" +
            " (nome, email, telefone, data_nascimento, grupo_sanguineo, sexo, cep, endereco, cidade, estado)" +
            " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        pstmt = conexao.prepareStatement(sql);
        pstmt.setString(1, objeto.getNome());
        pstmt.setString(2, objeto.getEmail());
        pstmt.setString(3, objeto.getTelefone());
        pstmt.setDate(4, objeto.getDataNascimento());
        pstmt.setString(5, objeto.getGrupoSanguineo().getLabel());
        pstmt.setString(6, objeto.getSexo().name());
        pstmt.setString(7, objeto.getCep());
        pstmt.setString(8, objeto.getEndereco());
        pstmt.setString(9, objeto.getCidade());
        pstmt.setString(10, objeto.getEstado());
        registrosAfetados = pstmt.executeUpdate();
        return registrosAfetados;
    }

    @Override
    public int update(Paciente objeto) throws SQLException {
        int registrosAfetados = 0;
        String sql = "UPDATE paciente SET " +
            "nome = ?, " +
            "email = ?, " +
            "telefone = ?, " +
            "data_nascimento = ?, " +
            "grupo_sanguineo = ?, " +
            "sexo = ?, " +
            "cep = ?, " +
            "endereco = ?, " +
            "cidade = ?, " +
            "estado = ? " +
            "WHERE id = ?";
        pstmt = conexao.prepareStatement(sql);
        pstmt.setString(1, objeto.getNome());
        pstmt.setString(2, objeto.getEmail());
        pstmt.setString(3, objeto.getTelefone());
        pstmt.setDate(4, objeto.getDataNascimento());
        pstmt.setString(5, objeto.getGrupoSanguineo().getLabel());
        pstmt.setString(6, objeto.getSexo().name());
        pstmt.setString(7, objeto.getCep());
        pstmt.setString(8, objeto.getEndereco());
        pstmt.setString(9, objeto.getCidade());
        pstmt.setString(10, objeto.getEstado());
        pstmt.setLong(11, objeto.getId());
        registrosAfetados = pstmt.executeUpdate();
        return registrosAfetados;
    }

    @Override
    public int delete(Long id) throws SQLException {
        int registrosAfetados = 0;
        String sql = "DELETE FROM paciente WHERE id = ?";
        pstmt = conexao.prepareStatement(sql);
        pstmt.setLong(1, id);
        registrosAfetados = pstmt.executeUpdate();
        return registrosAfetados;
    }
    
}
