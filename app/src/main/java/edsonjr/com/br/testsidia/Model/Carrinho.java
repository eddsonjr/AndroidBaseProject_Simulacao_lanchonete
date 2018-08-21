package edsonjr.com.br.testsidia.Model;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {

    private float valorTotalCompras = 0;
    private List<ItemCarrinho> listaCompras = new ArrayList<>();


    //Construtores
    public Carrinho() {
        //Construtor padrao
    }


    public Carrinho(float valorTotalCompras, List<ItemCarrinho> listaCompras){
        this.setValorTotalCompras(valorTotalCompras);
        this.setListaCompras(listaCompras);
    }



    //Getters and Setters

    public float getValorTotalCompras() {
        return valorTotalCompras;
    }

    public void setValorTotalCompras(float valorTotalCompras) {
        this.valorTotalCompras = valorTotalCompras;
    }

    public List<ItemCarrinho> getListaCompras() {
        return listaCompras;
    }

    public void setListaCompras(List<ItemCarrinho> listaCompras) {
        this.listaCompras = listaCompras;
    }
}
