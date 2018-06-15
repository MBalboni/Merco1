package grupo.merco;

public class bdProduto {
    // fields
    private int produtoID;
    private String produtoNome;
    // constructors
    public bdProduto() {}
    public bdProduto(int id, String nomeDoProduto) {
        this.produtoID = id;
        this.produtoNome = nomeDoProduto;
    }
    // properties
    public void setID(int id) {
        this.produtoID = id;
    }
    public int getID() {
        return this.produtoID;
    }
    public void setProdutoNome(String nomeDoProduto) {
        this.produtoNome = nomeDoProduto;
    }
    public String getProdutoNome() {
        return this.produtoNome;
    }
}