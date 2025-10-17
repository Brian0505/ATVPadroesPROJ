package socialmedia;

public class SocialMediaFactory {
    public static ISocialMediaAdapter criarAdapter(String platform) {
        if (platform == null) {
            throw new IllegalArgumentException("Plataforma não pode ser nula.");
        }
        switch (platform.toUpperCase()) {
            case "TWITTER":
                return new TwitterAdapter();
            case "LINKEDIN":
                return new LinkedInAdapter();
            default:
                throw new IllegalArgumentException("Plataforma desconhecida: " + platform);
        }
    }
}