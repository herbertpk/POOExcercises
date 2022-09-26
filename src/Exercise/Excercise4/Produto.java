package Exercise.Excercise4;

public class Produto {

    private String codigo;
    private String descricao;
    private double precoVenda;
    private int quantidadeEmEstoque;
    private CategoriaProduto categoria;

    public Produto(String codigo, String descricao, double precoVenda, int quantidadeEmEstoque, CategoriaProduto categoria) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.precoVenda = precoVenda;
        this.quantidadeEmEstoque = quantidadeEmEstoque;
        this.categoria = categoria;
    }

    public String toString(){
        return "o produto tem codigo: "+this.codigo+"\n descrição: "+this.descricao+"\n preço de venda:"+this.precoVenda+"\n quantidade em estoque: "+this.quantidadeEmEstoque+"\n e a sua categoria é: "+categoria;
    }


    public Produto(){this("","",0.0,0,null);}

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(double precoVenda) {
        this.precoVenda = precoVenda;
    }

    public int getQuantidadeEmEstoque() {
        return quantidadeEmEstoque;
    }

    public void setQuantidadeEmEstoque(int quantidadeEmEstoque) {
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    public CategoriaProduto getCetegoria() {
        return categoria;
    }

    public void setCetegoria(CategoriaProduto cetegoria) {
        this.categoria = cetegoria;
    }




}

