package entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome_completo")
    private String nomeCompleto;
    private String matricula;
    private String email;

    public void setId(Long id) {
        this.id = id;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

    @OneToMany(mappedBy = "professor", targetEntity = Curso.class, cascade = CascadeType.ALL)
    private List<Curso> cursos;

    public Long getId() {
        return id;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getEmail() {
        return email;
    }

    public List<Curso> getCursos() {
        return cursos;
    }
}
