package Exercise.Excercise4;
import org.junit.jupiter.api.Test;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class SistemaComercialMapTest {
    @Test
    public void testaCadastroProdutos() {
        SistemaComercialMap sistema = new SistemaComercialMap();
        Collection<Produto> alimentos =
                sistema.pesquisaProdutosDaCategoria(CategoriaProduto.ALIMENTO);
        assertTrue(alimentos.size()==0);

    }

    @Test
    public void testaCadastroProdutos3() {
        SistemaComercialMap sistema = new SistemaComercialMap();
        Cliente test = new ClientePF("herbert","rio tinto","herbertpk@Live.com","123.123.123-22");

        assertFalse(sistema.existeCliente(test));

    }

    @Test
    public void testaCadastroProdutos4() {
        SistemaComercialMap sistema = new SistemaComercialMap();
        Cliente test = new ClientePF("herbert","rio tinto","herbertpk@Live.com","123.123.123-22");
        Cliente test2 = new ClientePF("herbert","rio tinto","herbertpk@Live.com","1123.123.123-22");
        assertTrue(sistema.cadastraCliente(test));

        assertTrue(sistema.existeCliente(test));
        assertFalse(sistema.existeCliente(test2));

    }


    @Test
    public void testaCadastroProdutos2() {
        SistemaComercialMap sistema = new SistemaComercialMap();
        Produto test = new Produto("3100","",0.0,1,CategoriaProduto.ALIMENTO);
        sistema.cadastraProduto(test);

        assertTrue(sistema.existeProduto(test));

        Collection<Produto> alimentos = sistema.pesquisaProdutosDaCategoria(CategoriaProduto.ALIMENTO);
        assertTrue(alimentos.size()==1);

    }
}