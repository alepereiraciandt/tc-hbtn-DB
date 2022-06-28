package entities;

import javax.persistence.*;

@Entity
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String largadouro;
    private String endereco;
    private String numero;
    private String bairro;
    private String cidade;
    private String estado;
    private Integer cep;

    @ManyToOne @JoinColumn(name = "id_aluno")
    private Aluno aluno;

}
