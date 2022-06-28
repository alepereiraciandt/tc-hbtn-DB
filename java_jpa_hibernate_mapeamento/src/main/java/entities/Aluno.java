package entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome_completo")
    private String nomeCompleto;
    private String matricula;
    private Date nascimento;
    private String email;

    @OneToMany(mappedBy = "aluno", targetEntity = Endereco.class, cascade = CascadeType.ALL)
    private List<Endereco> enderecos;

    @OneToMany(mappedBy = "aluno", targetEntity = Telefone.class, cascade = CascadeType.ALL)
    private List<Telefone> telefones;

    @ManyToMany
    Set<Curso> cursos;

    public void setId(Long id) {
        this.id = id;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }

    public void setCursos(Set<Curso> cursos) {
        this.cursos = cursos;
    }

    public Long getId() {
        return id;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public String getMatricula() {
        return matricula;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public String getEmail() {
        return email;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public Set<Curso> getCursos() {
        return cursos;
    }
}
