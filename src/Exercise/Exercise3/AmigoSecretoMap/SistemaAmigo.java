package Exercise.Exercise3.AmigoSecretoMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class SistemaAmigo {




    private HashMap<Integer,Amigo> amigos2;
    private HashMap<Integer,Mensagem> mensagens2;
    private ArrayList<Mensagem> mensagens;
    private ArrayList<Amigo> amigos;

    public SistemaAmigo(int maxMsg,int maxAmigo) {
        this.amigos2 = new HashMap<Integer,Amigo>(maxAmigo);
        this.mensagens2 =  new HashMap<Integer,Mensagem>(maxMsg);
    }

    public SistemaAmigo() {
        this.amigos2 = new HashMap<Integer,Amigo>();
        this.mensagens2 =  new HashMap<Integer,Mensagem>();
    }
    public void cadastraAmigo(String nomeAmigo, String emailAmigo){
        Amigo novoAmigo = new Amigo(nomeAmigo,emailAmigo,null);
        if(amigos2.isEmpty()){
            amigos2.put(1,novoAmigo);
            return;
        }else{
           amigos2.put(amigos2.size()+1,novoAmigo);
        }
    }

    public Amigo pesquisaAmigo (String emailAmigo) throws AmigoInexistenteException{

        for (int i = 1; i < amigos2.size(); i++) {
            if(emailAmigo.equals(amigos2.get(i).getEmail())){
                return amigos2.get(i);
            }
        }
        throw new AmigoInexistenteException("não existe ninguem com este email: "+ emailAmigo);

    }

    public void enviarMensagemParaTodos(String texto, String emailRemetente, boolean ehAnonima){
        MensagemParaTodos mensagemTodos = new MensagemParaTodos(texto,emailRemetente,ehAnonima);
        mensagens.add(mensagemTodos);

    }

    public void enviarMensagemParaAlguem(String texto, String emailRemetente, String emailDestinatario,boolean ehAnonima){
        MensagemParaAlguem mensagemAlguem = new MensagemParaAlguem(texto,emailRemetente,emailDestinatario,ehAnonima);
        mensagens.add(mensagemAlguem);
    }

    public ArrayList<Mensagem> pesquisaMensagensAnonimas(){
        ArrayList<Mensagem> listAnonimas = new ArrayList<>();
        for (Mensagem mensagem:mensagens) {
            if(mensagem.ehAnonima()){
                listAnonimas.add(mensagem);
            }
        }
        return listAnonimas;
    }

    public ArrayList<Mensagem> pesquisaTodasAsMensagens(){
        return mensagens;
    }

    public void configuraAmigoSecretoDe(String emailDaPessoa, String emailAmigoSorteado) throws AmigoInexistenteException {
        for (Amigo amigo : amigos) {
            if(emailDaPessoa.equals(amigo.getEmail())) {
                amigo.setEmailAmigoSorteado(emailAmigoSorteado);
                return;
            }
        }
        throw  new AmigoInexistenteException("não existe email com essa pessoa: "+ emailDaPessoa);
    }

    public String pesquisaAmigoSecretoDe(String emailDaPessoa) throws AmigoInexistenteException,AmigoNaoSorteadoException{
        for (Amigo amigo : amigos) {
            if (emailDaPessoa.equals(amigo.getEmail())) {
                if(amigo.getEmailAmigoSorteado() == null){
                    throw new AmigoNaoSorteadoException("Esse amigo secreto ainda não foi sorteado");
                }
                return amigo.getEmailAmigoSorteado();

            }
        }
        throw new AmigoInexistenteException("não existe email com essa pessoa: "+ emailDaPessoa);

    }

    public ArrayList<Amigo> procurarTodosAmigos(){
        return amigos;
    }


}
