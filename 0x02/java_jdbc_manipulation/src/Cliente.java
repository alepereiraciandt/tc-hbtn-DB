public class Cliente {
    private int id;
    private String nome;
    private int idade;
    private String Cpf;
    private String Rg;

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
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

    public void setCpf(String cpf) {
        Cpf = cpf;
    }

    public void setRg(String rg) {
        Rg = rg;
    }

    public String getCpf() {
        return Cpf;
    }

    public String getRg() {
        return Rg;
    }
}
