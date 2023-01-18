package twitter.api.sample;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

import com.twitter.clientlib.ApiException;
import com.twitter.clientlib.TwitterCredentialsOAuth2;
import com.twitter.clientlib.api.TwitterApi;

public class Refresh {
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
        api.addCallback(token -> {
            properties.setProperty("TWITTER_OAUTH2_ACCESS_TOKEN", token.getAccessToken());
            properties.setProperty("TWITTER_OAUTH2_REFRESH_TOKEN", token.getRefreshToken());
        });

        api.refreshToken();

        try (Writer writer = Files.newBufferedWriter(Path.of("../twitter.properties"))) {
            properties.store(writer, "");
        }
    }
}
