package twitter.api.sample;

import java.io.IOException;
import java.io.Reader;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

import com.github.scribejava.core.model.OAuth2AccessToken;
import com.github.scribejava.core.pkce.PKCE;
import com.github.scribejava.core.pkce.PKCECodeChallengeMethod;
import com.twitter.clientlib.auth.TwitterOAuth20Service;

public class OAuth {
    public static void main(String[] args)
            throws IOException, ExecutionException, InterruptedException, URISyntaxException {
        Properties properties = new Properties();
        try (Reader reader = Files.newBufferedReader(Path.of("../twitter.properties"))) {
            properties.load(reader);
        }

        TwitterOAuth20Service service = new TwitterOAuth20Service(
                properties.getProperty("TWITTER_OAUTH2_CLIENT_ID"),
                properties.getProperty("TWITTER_OAUTH2_CLIENT_SECRET"),
                properties.getProperty("TWITTER_OAUTH2_CALLBACK"),
                "tweet.read tweet.write users.read offline.access");

        Scanner in = new Scanner(System.in, StandardCharsets.UTF_8);
        System.out.println("Fetching the Authorization URL...");

        String secretState = "state";
        PKCE pkce = new PKCE();
        pkce.setCodeChallenge("challenge");
        pkce.setCodeChallengeMethod(PKCECodeChallengeMethod.PLAIN);
        pkce.setCodeVerifier("challenge");
        String authorizationUrl = service.getAuthorizationUrl(pkce, secretState);

        System.out.println("Go to the Authorization URL and authorize your App:\n" +
                authorizationUrl + "\nAfter that paste the authorization code here\n>>");
        String code = in.nextLine();

        System.out.println("\nTrading the Authorization Code for an Access Token...");
        OAuth2AccessToken accessToken = service.getAccessToken(pkce, code);

        System.out.println("Access token: " + accessToken.getAccessToken());
        System.out.println("Refresh token: " + accessToken.getRefreshToken());
    }
}
