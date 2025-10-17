package socialmedia;

public interface ISocialMediaAdapter {
    ApiResponse<Publicacao> postar(Conteudo conteudo);
}