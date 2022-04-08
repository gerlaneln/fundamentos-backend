package br.ufac.sgcm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ufac.sgcm.model.Especialidade;

public class EspecialidadeDao implements IDao<Especialidade>{

    private Connection conexao;
    private PreparedStatement ps;
    private ResultSet rs;

    public EspecialidadeDao(){
        conexao = ConexaoDB.getConexao();
    }

    @Override
    public int delete(Long id) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public List<Especialidade> getAll() {
        List<Especialidade> listaRegistros = new ArrayList<>();
        String sql = "SELECT * FROM especialidade";

        try {
            ps = conexao.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Especialidade registro = new Especialidade();
                registro.setId(rs.getLong("id"));
                registro.setNome(rs.getString("nome"));
                listaRegistros.add(registro);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaRegistros;
    }

    @Override
    public List<Especialidade> getByAll(String termoBusca) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Especialidade getById(Long id) {
        Especialidade registro = new Especialidade();
        String sql = "SELECT * FROM especialidade WHERE id = ?";
        try{
            ps = conexao.prepareStatement(sql);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            if(rs.next()){
                registro.setId(rs.getLong("id"));
                registro.setNome(rs.getString("nome"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        
        return registro;
    }

    @Override
    public int insert(Especialidade objeto) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int update(Especialidade objeto) {
        // TODO Auto-generated method stub
        return 0;
    }

    
    
}
