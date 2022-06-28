package entities;

import javax.persistence.*;

@Entity
public class Telefone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String DDD;
    private String numero;

    @ManyToOne
    @JoinColumn(name = "id_aluno")
    private Aluno aluno;
}
