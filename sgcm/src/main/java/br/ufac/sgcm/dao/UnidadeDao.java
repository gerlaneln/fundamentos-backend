package br.ufac.sgcm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ufac.sgcm.model.Unidade;

public class UnidadeDao implements IDao<Unidade> {

    private Connection conexao;
    private PreparedStatement ps;
    private ResultSet rs;

    public UnidadeDao() {
        conexao = ConexaoDB.getConexao();
    }

    @Override
    public List<Unidade> getAll() throws SQLException {
        List<Unidade> listaRegistros = new ArrayList<>();
        String sql = "SELECT * FROM unidade";
        ps = conexao.prepareStatement(sql);
        rs = ps.executeQuery();
        while (rs.next()) {
            Unidade registro = new Unidade();
            registro.setId(rs.getLong("id"));
            registro.setNome(rs.getString("nome"));
            registro.setEndereco(rs.getString("endereco"));
            listaRegistros.add(registro);
        }
        return listaRegistros;
    }

    @Override
    public Unidade getById(Long id) throws SQLException {
        Unidade registro = new Unidade();
        String sql = "SELECT * FROM unidade WHERE id = ?";
        ps = conexao.prepareStatement(sql);
        ps.setLong(1, id);
        rs = ps.executeQuery();
        if (rs.next()) {
            registro.setId(rs.getLong("id"));
            registro.setNome(rs.getString("nome"));
            registro.setEndereco(rs.getString("endereco"));
        }
        return registro;
    }

    @Override
    public List<Unidade> getByAll(String termoBusca) throws SQLException {
        List<Unidade> registros = new ArrayList<>();
        String sql = "SELECT * FROM unidade WHERE"
            + " nome LIKE ?"
            + " OR endereco LIKE ?";
        ps = conexao.prepareStatement(sql);
        ps.setString(1, "%" + termoBusca + "%");
        ps.setString(2, "%" + termoBusca + "%");
        rs = ps.executeQuery();
        while (rs.next()) {
            Unidade registro = new Unidade();
            registro.setId(rs.getLong("id"));
            registro.setNome(rs.getString("nome"));
            registro.setEndereco(rs.getString("endereco"));
            registros.add(registro);
        }
        return registros;
    }

    @Override
    public int insert(Unidade objeto) throws SQLException {
        int registrosAfetados = 0;
        String sql = "INSERT INTO unidade (nome, endereco)"
            + " VALUES (?, ?)";
        ps = conexao.prepareStatement(sql);
        ps.setString(1, objeto.getNome());
        ps.setString(2, objeto.getEndereco());
        registrosAfetados = ps.executeUpdate();
        return registrosAfetados;
    }

    @Override
    public int update(Unidade objeto) throws SQLException {
        int registrosAfetados = 0;
        String sql = "UPDATE unidade SET"
            + " nome = ?,"
            + " endereco = ?"
            + " WHERE id = ?";
        ps = conexao.prepareStatement(sql);
        ps.setString(1, objeto.getNome());
        ps.setString(2, objeto.getEndereco());
        ps.setLong(3, objeto.getId());
        registrosAfetados = ps.executeUpdate();
        return registrosAfetados;
    }

    @Override
    public int delete(Long id) throws SQLException {
        int registrosAfetados = 0;
        String sql = "DELETE FROM unidade WHERE id = ?";
        ps = conexao.prepareStatement(sql);
        ps.setLong(1, id);
        registrosAfetados = ps.executeUpdate();
        return registrosAfetados;
    }
    
}
