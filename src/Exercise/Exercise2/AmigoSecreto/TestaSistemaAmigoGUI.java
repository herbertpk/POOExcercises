package Exercise.Exercise2.AmigoSecreto;

import javax.swing.*;

public class TestaSistemaAmigoGUI {
    public static void main(String[] args){

        int quantMaxMsg =  Integer.parseInt((JOptionPane.showInputDialog("qual a quantidade de mensagens maxima que o sistema vai suportar?: ")));
        int quantMaxAmg =  Integer.parseInt((JOptionPane.showInputDialog("qual a quantidade de amigos maxima que o sistema vai suportar?: ")));
        boolean sair = false;

        SistemaAmigo sistema = new SistemaAmigo(quantMaxMsg,quantMaxAmg);


        while(!sair){
            sistema.cadastraAmigo(JOptionPane.showInputDialog("qual o nome do  amigo?: "),JOptionPane.showInputDialog("qual o email dele?: "));
            int sairInt = JOptionPane.showConfirmDialog(null,"deseja continuar?","Atenção",JOptionPane.YES_NO_OPTION);
            if (sairInt == 1){
                sair = true;
            }
        }

        sair = false;

        while(!sair) {
            int i = 0;
            String[] nomeOptions = new String[quantMaxAmg];
            for (Amigo amigo : sistema.procurarTodosAmigos()) {
                nomeOptions[i] = amigo.getEmail();
                i = i + 1;
            }
            Object selecao = JOptionPane.showInputDialog(null, null, "escolha qual um amigo",
                    JOptionPane.QUESTION_MESSAGE, null, nomeOptions, nomeOptions[0]);

            String[] sorteadoOptions = {};
            i = 0;
            for (Amigo amigo : sistema.procurarTodosAmigos()) {
                nomeOptions[i] = amigo.getEmail();
                i = i + 1;
            }

            Object selecao2 = JOptionPane.showInputDialog(null, null, "escolha quem " + selecao + " vai tirar no amigo secreto.",
                    JOptionPane.QUESTION_MESSAGE, null, nomeOptions, nomeOptions[0]);

            try {
                sistema.configuraAmigoSecretoDe(String.valueOf(selecao), String.valueOf(selecao2));
                JOptionPane.showMessageDialog(null, "amigo secreto cadastrado com sucesso");
            } catch (AmigoInexistenteException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }

            int sairInt = JOptionPane.showConfirmDialog(null, "deseja sortear mais alguem?", "Atenção", JOptionPane.YES_NO_OPTION);
            if (sairInt == 1) {
                sair = true;
            }
        }

        int anonimaInt =JOptionPane.showConfirmDialog(null,"sua mensagem é anonima?","anonima?",JOptionPane.YES_NO_OPTION);

        boolean anonima = true;

        if(anonimaInt == 1)
            anonima = false;
        else if(anonimaInt == 0)
            anonima = true;

        if(anonima){
            sistema.enviarMensagemParaTodos( JOptionPane.showInputDialog("qual a mensagem?: ") ,"Anonimo",true);
        }else{
            sistema.enviarMensagemParaTodos(JOptionPane.showInputDialog("qual a mensagem?: "),JOptionPane.showInputDialog("qual o nome do remetente?: "),false);
        }

    }
}

