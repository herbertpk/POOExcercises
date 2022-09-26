package Exercise.Excercise4;

import java.text.CollationElementIterator;
import java.util.*;

public class SistemaComercialMap implements SistemaComercial {
    private Map<String, Cliente> clientes;
    private Map<String, Produto> produtos;

    public SistemaComercialMap() {
        this.clientes = new HashMap<String, Cliente>();
        this.produtos = new HashMap<String, Produto>();
    }

    @Override
    public boolean existeProduto(Produto produto) {
        return this.produtos.containsKey(produto.getCodigo());
    }

    public boolean cadastraCliente(Cliente cliente) {
        if (existeCliente(cliente)) {
            return false;
        } else {
            this.clientes.put(cliente.getId(), cliente);
            return true;
        }
    }

    @Override
    public Produto pesquisaProduto(String codigoProduto)
            throws ProdutoNaoExisteException {
        if (this.produtos.containsKey(codigoProduto)) {
            return this.produtos.get(codigoProduto);
        }
        throw new ProdutoNaoExisteException("Não foi encontrado produto"

                + " com o código " + codigoProduto);

    }

    @Override
    public boolean cadastraProduto(Produto produto) {
        if (existeProduto(produto)) {
            return false;
        } else {
            this.produtos.put(produto.getCodigo(), produto);
            return true;
        }
    }
    @Override
    public boolean existeCliente(Cliente cliente){
        return clientes.get(cliente.getId()) != null;
    }

    @Override
    public Collection<Produto> pesquisaProdutosDaCategoria(CategoriaProduto categoria) {
        Collection<Produto> produtosCat = new ArrayList<>();

        Set<String> keys = produtos.keySet();
      for(String key : keys){
          if(key != null  && produtos.get(key).getCetegoria().equals(categoria)){
            produtosCat.add(produtos.get(key));
          }
      }
      return produtosCat;
    }

    @Override
    public Cliente pesquisaCliente(String id) throws ClienteNaoExisteException {
        if(clientes.get(id) != null){
            return clientes.get(id);
        } else throw new ClienteNaoExisteException("não existe cliente com este CPF/CNPJ"+id);
    }
}