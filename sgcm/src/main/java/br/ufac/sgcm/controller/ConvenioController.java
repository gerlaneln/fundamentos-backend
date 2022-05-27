package br.ufac.sgcm.controller;

import java.sql.SQLException;
import java.util.List;

import br.ufac.sgcm.dao.ConvenioDao;
import br.ufac.sgcm.model.Convenio;

public class ConvenioController {

    private ConvenioDao dao;

    public ConvenioController() throws ClassNotFoundException, SQLException {
        dao = new ConvenioDao();
    }

    public List<Convenio> getAll() throws SQLException {
        return dao.getAll();
    }

    public Convenio getById(Long id) throws SQLException {
        return dao.getById(id);
    }

    public List<Convenio> getByAll(String termoBusca) throws SQLException {
        return dao.getByAll(termoBusca);
    }

    public int save(Convenio item) throws SQLException {
        int registrosAfetados = 0;
        if (item.getId() == null) {
            registrosAfetados = dao.insert(item);
        } else {
            registrosAfetados = dao.update(item);
        }
        return registrosAfetados;
    }

    public int delete(Long id) throws SQLException {
        return dao.delete(id);
    }

}
