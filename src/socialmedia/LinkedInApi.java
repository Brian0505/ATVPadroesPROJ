package socialmedia;

import java.util.Date;
import java.util.UUID;

public class LinkedInApi {
    public static class LinkedInShare { public String content; public String authorUrn; }
    public static class LinkedInPost { public String urn; public String text; public String owner; public long timestamp; }
    
    public LinkedInPost submitShare(LinkedInShare share) {
        System.out.println("LINKEDIN API: Enviando post '" + share.content + "'...");
        LinkedInPost newPost = new LinkedInPost();
        newPost.urn = "urn:li:share:" + UUID.randomUUID().toString();
        newPost.text = share.content;
        newPost.owner = share.authorUrn;
        newPost.timestamp = new Date().getTime();
        System.out.println("LINKEDIN API: Post enviado com URN " + newPost.urn);
        return newPost;
    }
}