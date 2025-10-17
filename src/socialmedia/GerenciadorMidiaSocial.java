package socialmedia;

public class GerenciadorMidiaSocial {
    public static void main(String[] args) {
        System.out.println("--- INICIANDO GERENCIADOR DE MÍDIA SOCIAL ---");

        Conteudo meuConteudo = new Conteudo("Confira nosso novo post sobre Padrões de Projeto!", "AgenciaDigital");

        System.out.println("\n>> TENTANDO PUBLICAR NO TWITTER...");
        try {
            ISocialMediaAdapter twitterAdapter = SocialMediaFactory.criarAdapter("TWITTER");
            ApiResponse<Publicacao> respostaTwitter = twitterAdapter.postar(meuConteudo);
            
            if (respostaTwitter.isSucesso()) {
                System.out.println("SUCESSO! Publicação no Twitter: " + respostaTwitter.getData());
            } else {
                System.out.println("ERRO: " + respostaTwitter.getMensagemErro());
            }
        } catch (IllegalArgumentException e) {
            System.out.println("ERRO DE CONFIGURAÇÃO: " + e.getMessage());
        }

        System.out.println("\n>> TENTANDO PUBLICAR NO LINKEDIN...");
        try {
            ISocialMediaAdapter linkedInAdapter = SocialMediaFactory.criarAdapter("LINKEDIN");
            ApiResponse<Publicacao> respostaLinkedIn = linkedInAdapter.postar(meuConteudo);

            if (respostaLinkedIn.isSucesso()) {
                System.out.println("SUCESSO! Publicação no LinkedIn: " + respostaLinkedIn.getData());
            } else {
                System.out.println("ERRO: " + respostaLinkedIn.getMensagemErro());
            }
        } catch (IllegalArgumentException e) {
            System.out.println("ERRO DE CONFIGURAÇÃO: " + e.getMessage());
        }
    }
}
