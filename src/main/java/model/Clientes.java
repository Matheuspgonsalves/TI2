package model;

public class Clientes {
    private int id;
    private String nome;
    private String cpf;
    private char sexo;

    public Clientes() {
        this.id = -1;
        this.nome = "";
        this.cpf = "";
        this.sexo = '*';
    }

    public Clientes(int id, String nome, String cpf, char sexo) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.sexo = sexo;
    }

    public int getCodigo() {
        return id;
    }

    public void setCodigo(int id) {
        this.id = id;
    }

    public String getLogin() {
        return nome;
    }

    public void setLogin(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return cpf;
    }

    public void setSenha(String senha) {
        this.cpf = senha;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return "Clientes [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", sexo=" + sexo + "]";
    }
}
