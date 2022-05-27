package br.ufac.sgcm.controller;

import java.sql.SQLException;
import java.util.List;

import br.ufac.sgcm.dao.PacienteDao;
import br.ufac.sgcm.model.Paciente;

public class PacienteController implements IController<Paciente> {

    private PacienteDao dao;

    public PacienteController() throws ClassNotFoundException, SQLException {
        dao = new PacienteDao();
    }

    public List<Paciente> getAll() throws SQLException {
        return dao.getAll();
    }

    public Paciente getById(Long id) throws SQLException {
        return dao.getById(id);
    }

    public List<Paciente> getByAll(String termoBusca) throws SQLException {
        return dao.getByAll(termoBusca);
    }

    public int save(Paciente item) throws SQLException {
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
