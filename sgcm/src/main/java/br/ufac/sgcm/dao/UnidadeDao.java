package br.ufac.sgcm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ufac.sgcm.model.Unidade;

public class UnidadeDao implements IDao<Unidade>{

    private Connection conexao;
    private PreparedStatement ps;
    private ResultSet rs;

    public UnidadeDao(){
        conexao = ConexaoDB.getConexao();
    }

    @Override
    public List<Unidade> getAll() {
        List<Unidade> listaRegistros = new ArrayList<>();
        String sql = "SELECT * FROM unidade";

        try {
            ps = conexao.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Unidade registro = new Unidade();
                registro.setId(rs.getLong("id"));
                registro.setNome(rs.getString("nome"));
                registro.setEndereco(rs.getString("endereco"));
                listaRegistros.add(registro);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaRegistros;
    }

    @Override
    public Unidade getById(Long id) {
        Unidade registro = new Unidade();
        String sql = "SELECT * FROM unidade WHERE id = ?";

        try {
            ps = conexao.prepareStatement(sql);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            if(rs.next()){
                registro.setId(rs.getLong("id"));
                registro.setNome(rs.getString("nome"));
                registro.setEndereco(rs.getString("endereco"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return registro;
    }

    @Override
    public List<Unidade> getByAll(String termoBusca) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int insert(Unidade objeto) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int update(Unidade objeto) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int delete(Long id) {
        // TODO Auto-generated method stub
        return 0;
    }
    
}
