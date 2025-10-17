package socialmedia;

import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

public class TwitterApi {
    public static class TwitterStatus { public String status; }
    public static class TwitterTweet { public long id; public String text; public String user; public Date createdAt; }

    public TwitterTweet tweet(TwitterStatus status) {
        System.out.println("TWITTER API: Publicando tweet '" + status.status + "'...");
        TwitterTweet newTweet = new TwitterTweet();
        newTweet.id = ThreadLocalRandom.current().nextLong(100000, 999999);
        newTweet.text = status.status;
        newTweet.user = "InternalUser";
        newTweet.createdAt = new Date();
        System.out.println("TWITTER API: Tweet publicado com ID " + newTweet.id);
        return newTweet;
    }
}