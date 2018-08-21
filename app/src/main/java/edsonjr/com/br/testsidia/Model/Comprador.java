package edsonjr.com.br.testsidia.Model;

public class Comprador {

    private String nome;
    private String endereco;
    private String telefone;


    //Construtores
    public Comprador(){
        //Construtor padrao
    }


    public  Comprador(String nome, String endereco, String telefone){
        this.setEndereco(endereco);
        this.setTelefone(telefone);
        this.setNome(nome);
    }


    //Getters and Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
