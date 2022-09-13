package Exercise.Exercise3.AmigoSecretoMap;

import javax.swing.*;
import java.util.ArrayList;

public class TestaSistemaAmigo {
    public static void main(String [] args){

        SistemaAmigo sistema = new SistemaAmigo();

        sistema.cadastraAmigo("José","josé@email.com");
        sistema.cadastraAmigo("Maria","Maria@email.com");

        try{
            sistema.configuraAmigoSecretoDe("josé@email.com","Maria@email.com");
            JOptionPane.showMessageDialog(null,"amigo secreto cadastrado com sucesso");
        }catch (AmigoInexistenteException e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        try{
            sistema.configuraAmigoSecretoDe("Maria@email.com","josé@email.com");
            JOptionPane.showMessageDialog(null,"amigo secreto cadastrado com sucesso");
        }catch (AmigoInexistenteException e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }

        sistema.enviarMensagemParaAlguem("está é minha mensagem anonima","Maria@email.com","josé@email.com",true);
        sistema.enviarMensagemParaTodos("está é minha mensagem anonima para todos","Maria@email.com",true);


        ArrayList<Mensagem> mensagensAnonimas = new ArrayList<>();
        

        mensagensAnonimas = sistema.pesquisaMensagensAnonimas();

        String pesquisa = "";

        try{
            pesquisa = sistema.pesquisaAmigoSecretoDe("josé@email.com");
        }
        catch (AmigoInexistenteException e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        catch (AmigoNaoSorteadoException e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }

        for(Mensagem mensagens: mensagensAnonimas){

            System.out.println(mensagens.getTextoCompletoAExibir());

        }


        if(pesquisa == "Maria@email.com"){
            System.out.println("OK");
        }







    }
}
