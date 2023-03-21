package modelos.entidades;

public class Titular {

    protected String nome;
    protected Integer idade;

    public Titular(String nome, Integer idade) throws IllegalArgumentException{

        if (idade < 0) {
            throw new IllegalArgumentException("A idade deve ser um valor positivo. ");
        }

        this.nome = nome;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }
}
