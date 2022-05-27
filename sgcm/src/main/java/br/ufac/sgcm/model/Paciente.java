package br.ufac.sgcm.model;

import java.sql.Date;

public class Paciente {

    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private Date dataNascimento;
    private EGrupoSanguineo grupoSanguineo;
    private ESexo sexo;
    private String cep;
    private String endereco;
    private String cidade;
    private String estado;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public Date getDataNascimento() {
        return dataNascimento;
    }
    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    public void setDataNascimento(String dataNascimento) {
        if (dataNascimento != null) {
            this.dataNascimento = Date.valueOf(dataNascimento);
        }
    }
    public EGrupoSanguineo getGrupoSanguineo() {
        return grupoSanguineo;
    }
    public void setGrupoSanguineo(EGrupoSanguineo grupoSaguineo) {
        this.grupoSanguineo = grupoSaguineo;
    }
    public void setGrupoSanguineo(String grupoSaguineo) {
        if (grupoSaguineo != null) {
            this.grupoSanguineo = EGrupoSanguineo.valueOfLabel(grupoSaguineo);
        }
    }
    public ESexo getSexo() {
        return sexo;
    }
    public void setSexo(ESexo sexo) {
        this.sexo = sexo;
    }
    public void setSexo(String sexo) {
        if (sexo != null) {
            this.sexo = ESexo.valueOf(sexo);
        }
    }
    public String getCep() {
        return cep;
    }
    public void setCep(String cep) {
        this.cep = cep;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }    
    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}
