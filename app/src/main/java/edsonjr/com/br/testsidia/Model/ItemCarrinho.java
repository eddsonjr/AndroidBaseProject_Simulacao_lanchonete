package edsonjr.com.br.testsidia.Model;

public class ItemCarrinho {

    private Prato prato;
    private int quantidade = 0;
    private float valorTotalDesteProduto = 0;



    //Construtores
    public  ItemCarrinho() {
        //Construtor padrao
    }


    public ItemCarrinho(Prato prato, int quantidade) {
        this.setPrato(prato);
        this.setQuantidade(quantidade);
    }



    public ItemCarrinho(Prato prato, int quantidade, float valorTotalDesteProduto) {
        this.setPrato(prato);
        this.setQuantidade(quantidade);
        this.setValorTotalDesteProduto(valorTotalDesteProduto);
    }


    //Getters and Setters

    public Prato getPrato() {
        return prato;
    }

    public void setPrato(Prato prato) {
        this.prato = prato;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }


    public float getValorTotalDesteProduto() {
        return valorTotalDesteProduto;
    }

    public void setValorTotalDesteProduto(float valorTotalDesteProduto) {
        this.valorTotalDesteProduto = valorTotalDesteProduto;
    }
}
