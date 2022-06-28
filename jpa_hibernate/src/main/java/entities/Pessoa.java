package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String email;
    private Integer idade;
    private Integer cpf;
    private Integer dataDeNascimento;

    public Pessoa() {
    }

    public Pessoa(Integer id, String nome, String email, Integer idade, Integer cpf, Integer dataDeNascimento) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.idade = idade;
        this.cpf = cpf;
        this.dataDeNascimento = dataDeNascimento;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public void setCpf(Integer cpf) {
        this.cpf = cpf;
    }

    public void setDataDeNascimento(Integer dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public Integer getIdade() {
        return idade;
    }

    public Integer getCpf() {
        return cpf;
    }

    public Integer getDataDeNascimento() {
        return dataDeNascimento;
    }
}
