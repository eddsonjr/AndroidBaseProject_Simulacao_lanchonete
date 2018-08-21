package edsonjr.com.br.testsidia.Model;




public class Prato {


    private String nomePrato;
    private float valor;
    private String descricaoPrato;


    //Construtores
    public Prato() {
        //Construtor padrao
    }

    public Prato(String nomePrato, float valor, String descricaoPrato){
        this.setNomePrato(nomePrato);
        this.setValor(valor);
        this.setDescricaoPrato(descricaoPrato);
    }


    //Gettesr and Setters

    public String getNomePrato() {
        return nomePrato;
    }

    public void setNomePrato(String nomePrato) {
        this.nomePrato = nomePrato;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getDescricaoPrato() {
        return descricaoPrato;
    }

    public void setDescricaoPrato(String descricaoPrato) {
        this.descricaoPrato = descricaoPrato;
    }

}
