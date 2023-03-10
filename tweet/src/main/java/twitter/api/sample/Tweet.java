package twitter.api.sample;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

import com.twitter.clientlib.ApiException;
import com.twitter.clientlib.TwitterCredentialsOAuth2;
import com.twitter.clientlib.api.TwitterApi;
import com.twitter.clientlib.model.TweetCreateRequest;
import com.twitter.clientlib.model.TweetCreateResponse;

public class Tweet {
    public static void main(String[] args) throws ApiException, IOException {
        Properties properties = new Properties();
        try (Reader reader = Files.newBufferedReader(Path.of("../twitter.properties"))) {
            properties.load(reader);
        }

        TwitterCredentialsOAuth2 credentials = new TwitterCredentialsOAuth2(
                properties.getProperty("TWITTER_OAUTH2_CLIENT_ID"),
                properties.getProperty("TWITTER_OAUTH2_CLIENT_SECRET"),
                properties.getProperty("TWITTER_OAUTH2_ACCESS_TOKEN"),
                properties.getProperty("TWITTER_OAUTH2_REFRESH_TOKEN"));
        TwitterApi api = new TwitterApi(credentials);

        String text = "Hello world!";

        TweetCreateRequest request = new TweetCreateRequest().text(text);

        TweetCreateResponse result = api.tweets().createTweet(request).execute();

        System.out.println(result);
    }
}
