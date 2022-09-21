package Exercise.Exercise2.AmigoSecreto;


import java.util.ArrayList;

public class SistemaAmigo {

    private ArrayList<Mensagem> mensagens;
    private ArrayList<Amigo> amigos;

    public SistemaAmigo(int maxMsg,int maxAmigo) {
        this.amigos = new ArrayList<Amigo>(maxMsg);
        this.mensagens = new ArrayList<Mensagem>(maxAmigo);
    }
    public SistemaAmigo() {
        this.amigos = new ArrayList<Amigo>();
        this.mensagens = new ArrayList<Mensagem>();
    }
    public void cadastraAmigo(String nomeAmigo, String emailAmigo)throws AmigoJaExisteException {
        Amigo novoAmigo = new Amigo(nomeAmigo,emailAmigo,null);
        for (Amigo amigo:amigos){
            if(amigo.equals(novoAmigo)){
                throw new AmigoJaExisteException("já existe este amigo de nome: "+nomeAmigo+" e de email: "+emailAmigo);
            }
        }
        amigos.add(novoAmigo);
    }

    public Amigo pesquisaAmigo(String emailAmigo) throws AmigoInexistenteException{

        for (Amigo amigo:amigos) {
            if(emailAmigo == amigo.getEmail()){
                return amigo;
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

    public void configuraAmigoSecretoDe(String emailDaPessoa, String emailAmigoSorteado) throws AmigoInexistenteException{
        for (Amigo amigo : amigos) {
            if(emailDaPessoa == amigo.getEmail()) {
                amigo.setEmailAmigoSorteado(emailAmigoSorteado);
                return;
            }
        }
        throw  new AmigoInexistenteException("não existe email com essa pessoa: "+ emailDaPessoa);
    }

    public String pesquisaAmigoSecretoDe(String emailDaPessoa) throws AmigoInexistenteException,AmigoNaoSorteadoException{
        for (Amigo amigo : amigos) {
            if (emailDaPessoa == amigo.getEmail()) {
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
