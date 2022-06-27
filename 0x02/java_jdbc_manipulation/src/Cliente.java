public class Cliente {
    private int id;
    private String nome;
    private int idade;
    private String cpf;
    private String RG;

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setCPF(String cpf) {
        this.cpf = cpf;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getCpf() {
        return cpf;
    }

    public String getRG() {
        return RG;
    }
}
