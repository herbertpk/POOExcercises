package Exercise.Exercise2.AmigoSecreto;

import java.net.Inet4Address;
import java.util.HashMap;
import java.util.ArrayList;


public class SistemaAmigoMap {

    private HashMap<Integer,Mensagem> mensagens;
    private HashMap<Integer,Amigo> amigos;


    public SistemaAmigoMap() {
        this.amigos = new HashMap<Integer,Amigo>();
        this.mensagens = new HashMap<Integer,Mensagem>();
    }

    public void cadastraAmigo(String nomeAmigo, String emailAmigo)throws AmigoJaExisteException{
        Amigo novoAmigo = new Amigo(nomeAmigo,emailAmigo,null);
        for (int i = 1; i < amigos.size(); i++){
            if(amigos.get(i).equals(novoAmigo)){
                throw new AmigoJaExisteException("já existe este amigo de nome: "+nomeAmigo+" e de email: "+emailAmigo);
            }
        }
        if(amigos.isEmpty()){
            amigos.put(1,novoAmigo);
            return;
        }else{
            amigos.put(amigos.size()+1,novoAmigo);
        }
    }

    public Amigo pesquisaAmigo (String emailAmigo) throws AmigoInexistenteException{

        for (int i = 1; i < amigos.size(); i++) {
            if(emailAmigo.equals(amigos.get(i).getEmail())){
                return amigos.get(i);
            }
        }
        throw new AmigoInexistenteException("não existe ninguem com este email: "+ emailAmigo);

    }

    public void enviarMensagemParaTodos(String texto, String emailRemetente, boolean ehAnonima){
        MensagemParaTodos mensagemTodos = new MensagemParaTodos(texto,emailRemetente,ehAnonima);
        if(mensagens.isEmpty()){
            mensagens.put(1,mensagemTodos);
            return;
        }else{
            mensagens.put(mensagens.size()+1,mensagemTodos);
        }

    }

    public void enviarMensagemParaAlguem(String texto, String emailRemetente, String emailDestinatario,boolean ehAnonima){
        MensagemParaAlguem mensagemAlguem = new MensagemParaAlguem(texto,emailRemetente,emailDestinatario,ehAnonima);
        if(mensagens.isEmpty()){
            mensagens.put(1,mensagemAlguem);
            return;
        }else{
            mensagens.put(mensagens.size()+1,mensagemAlguem);
        }
    }

    public ArrayList<Mensagem> pesquisaMensagensAnonimas(){
        ArrayList<Mensagem> listAnonimas = new ArrayList<>();
        for (int i = 1; i < mensagens.size(); i++) {
            if(mensagens.get(i).ehAnonima()){
                listAnonimas.add(mensagens.get(i));
            }
        }
        return listAnonimas;
    }

    public ArrayList<Mensagem> pesquisaTodasAsMensagens(){
        ArrayList<Mensagem> todasMensagens = new ArrayList<>();
        for (int i = 1; i < mensagens.size(); i++){
            todasMensagens.add(mensagens.get(i));
        }
        return todasMensagens;
    }

    public void configuraAmigoSecretoDe(String emailDaPessoa, String emailAmigoSorteado) throws AmigoInexistenteException{

        for (int i = 1; i < amigos.size(); i++){
            if(emailDaPessoa == amigos.get(i).getEmail()) {
                amigos.get(i).setEmailAmigoSorteado(emailAmigoSorteado);
                return;
            }
        }
        throw  new AmigoInexistenteException("não existe email com essa pessoa: "+ emailDaPessoa);
    }

    public String pesquisaAmigoSecretoDe(String emailDaPessoa) throws AmigoInexistenteException,AmigoNaoSorteadoException{
        for (int i = 1; i < amigos.size(); i++) {
            if (emailDaPessoa == amigos.get(i).getEmail()) {
                if(amigos.get(i).getEmailAmigoSorteado() == null){
                    throw new AmigoNaoSorteadoException("Esse amigo secreto ainda não foi sorteado");
                }
                return amigos.get(i).getEmailAmigoSorteado();

            }
        }
        throw new AmigoInexistenteException("não existe email com essa pessoa: "+ emailDaPessoa);

    }

    public ArrayList<Amigo> procurarTodosAmigos(){
        ArrayList<Amigo> todosAmigo = new ArrayList<>();
        for (int i = 1; i < amigos.size(); i++){
            todosAmigo.add(amigos.get(i));
        }
        return todosAmigo;
    }


}
