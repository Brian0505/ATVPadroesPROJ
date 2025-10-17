package socialmedia;

import java.util.Date;

public class LinkedInAdapter implements ISocialMediaAdapter {
    private final LinkedInApi linkedInApi;

    public LinkedInAdapter() {
        this.linkedInApi = new LinkedInApi();
    }

    @Override
    public ApiResponse<Publicacao> postar(Conteudo conteudo) {
        try {
            LinkedInApi.LinkedInShare share = new LinkedInApi.LinkedInShare();
            share.content = conteudo.getTexto();
            share.authorUrn = "urn:li:person:" + conteudo.getAutor();

            LinkedInApi.LinkedInPost postResult = linkedInApi.submitShare(share);

            Publicacao publicacao = new Publicacao(
                postResult.urn,
                postResult.text,
                postResult.owner,
                new Date(postResult.timestamp)
            );
            return ApiResponse.success(publicacao);
        } catch (Exception e) {
            return ApiResponse.error("Falha ao postar no LinkedIn: " + e.getMessage());
        }
    }
}