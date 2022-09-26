package Exercise.Excercise4;

import java.util.Collection;
public interface SistemaComercial {
    boolean existeProduto(Produto produto);

    Produto pesquisaProduto(String codigoProduto)
            throws ProdutoNaoExisteException;
    public boolean cadastraCliente(Cliente cliente);

    boolean cadastraProduto(Produto produto);

    boolean existeCliente(Cliente cliente) throws ClienteNaoExisteException;

    Cliente pesquisaCliente(String id) throws ClienteNaoExisteException;

    Collection<Produto> pesquisaProdutosDaCategoria(CategoriaProduto categoria);
}