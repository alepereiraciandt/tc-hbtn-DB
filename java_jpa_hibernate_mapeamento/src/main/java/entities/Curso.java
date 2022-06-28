package entities;

import javax.persistence.*;
import java.util.Set;
@Entity
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String sigla;

    @ManyToMany
    Set<Aluno> alunos;

    @ManyToOne @JoinColumn(name = "id_professor")
    private Professor professor;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "materialCurso")
    private MaterialCurso materialCurso;

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public void setAlunos(Set<Aluno> alunos) {
        this.alunos = alunos;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public void setMaterialCurso(MaterialCurso materialCurso) {
        this.materialCurso = materialCurso;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getSigla() {
        return sigla;
    }

    public Set<Aluno> getAlunos() {
        return alunos;
    }

    public Professor getProfessor() {
        return professor;
    }

    public MaterialCurso getMaterialCurso() {
        return materialCurso;
    }
}
