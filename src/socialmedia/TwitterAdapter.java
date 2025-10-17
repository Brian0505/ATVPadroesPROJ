package socialmedia;

public class TwitterAdapter implements ISocialMediaAdapter {
    private final TwitterApi twitterApi;

    public TwitterAdapter() {
        this.twitterApi = new TwitterApi();
    }

    @Override
    public ApiResponse<Publicacao> postar(Conteudo conteudo) {
        try {
            TwitterApi.TwitterStatus status = new TwitterApi.TwitterStatus();
            status.status = conteudo.getTexto() + " (via " + conteudo.getAutor() + ")";
            
            TwitterApi.TwitterTweet tweetResult = twitterApi.tweet(status);
            
            Publicacao publicacao = new Publicacao(
                String.valueOf(tweetResult.id),
                tweetResult.text,
                tweetResult.user,
                tweetResult.createdAt
            );
            return ApiResponse.success(publicacao);
        } catch (Exception e) {
            return ApiResponse.error("Falha ao postar no Twitter: " + e.getMessage());
        }
    }
}