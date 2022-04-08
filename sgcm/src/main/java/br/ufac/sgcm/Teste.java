// package br.ufac.sgcm;

// import java.util.List;

// import br.ufac.sgcm.dao.EspecialidadeDao;
// import br.ufac.sgcm.dao.ProfissionalDao;
// import br.ufac.sgcm.dao.UnidadeDao;
// import br.ufac.sgcm.model.Especialidade;
// import br.ufac.sgcm.model.Profissional;
// import br.ufac.sgcm.model.Unidade;

// public class Teste {

//     public static void main(String[] args) {
//         // ProfissionalDao dao = new ProfissionalDao();
//         // List<Profissional> profissionais = dao.getAll();
//         // for (Profissional profissional : profissionais) {
//         //     System.out.println(profissional.getNome());
//         //     System.out.println(profissional.getEspecialidade().getNome());
//         //     System.out.println(profissional.getUnidade().getNome());
//         // }

//         // EspecialidadeDao especialidadeDao = new EspecialidadeDao();
//         // Especialidade e = especialidadeDao.getById(1L);

//         // UnidadeDao unidadeDao = new UnidadeDao();
//         // Unidade u = unidadeDao.getById(1L);

//         // Profissional p = new Profissional();
//         // p.setNome("Maria Chiquinha");
//         // p.setRegistroConselho("5896 CRM/AC");
//         // p.setEspecialidade(e);
//         // p.setUnidade(u);
//         // p.setTelefone("(68) 92568-5658");
//         // p.setEmail("email@email.com");
        
//         ProfissionalDao profissionalDao = new ProfissionalDao();
//         Profissional p = profissionalDao.getById(6L);
//         System.out.println(p.getNome()+", "+p.getEspecialidade().getNome());
        
//         // int status = profissionalDao.insert(p);
//         // System.out.println("Registros afetados: "+status);

//     }
    
// }
