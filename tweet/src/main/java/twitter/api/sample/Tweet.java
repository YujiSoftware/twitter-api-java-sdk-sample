package twitter.api.sample;

import com.twitter.clientlib.ApiException;
import com.twitter.clientlib.TwitterCredentialsOAuth2;
import com.twitter.clientlib.api.TwitterApi;
import com.twitter.clientlib.model.TweetCreateRequest;
import com.twitter.clientlib.model.TweetCreateResponse;

public class Tweet {
    public static void main(String[] args) throws ApiException {
        TwitterCredentialsOAuth2 credentials = new TwitterCredentialsOAuth2(
                System.getenv("TWITTER_OAUTH2_CLIENT_ID"),
                System.getenv("TWITTER_OAUTH2_CLIENT_SECRET"),
                System.getenv("TWITTER_OAUTH2_ACCESS_TOKEN"),
                System.getenv("TWITTER_OAUTH2_REFRESH_TOKEN")
        );
        TwitterApi api = new TwitterApi(credentials);

        String text = "Hello world!";

        TweetCreateRequest request = new TweetCreateRequest().text(text);

        TweetCreateResponse result = api.tweets().createTweet(request).execute();

        System.out.println(result);
    }
}
