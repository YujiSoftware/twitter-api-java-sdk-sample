# twitter-api-java-sdk-sample
Sample code for twitter-api-java-sdk

## Reference
* [twitter-api-java-sdk/OAuth20GetAccessToken.java](https://github.com/twitterdev/twitter-api-java-sdk/blob/main/examples/src/main/java/com/twitter/clientlib/auth/OAuth20GetAccessToken.java)
* [twitter-api-java-sdk/OAuth20RefreshToken.java](https://github.com/twitterdev/twitter-api-java-sdk/blob/main/examples/src/main/java/com/twitter/clientlib/auth/OAuth20RefreshToken.java)

## How to use

### Get Access token & Refresh token

1. Write `twitter.properties` from [developer dashboard](https://developer.twitter.com/en/portal/dashboard).
```
TWITTER_OAUTH2_CLIENT_ID=xxxx
TWITTER_OAUTH2_CLIENT_SECRET=xxxx
TWITTER_OAUTH2_CALLBACK=https://xxxx
```

2. Run [`OAuth.java`](oauth/src/main/java/twitter/api/sample/OAuth.java)
```
gradlew oauth:run
```

3. When the following message is displayed, access the URL in your browser, and press "Authorize app".
> Go to the Authorization URL and authorize your App:  
> https://twitter.com/i/oauth2/authorize?code_challenge=...  
> After that paste the authorization code here
4. Copy the `code` parameter of the redirected page.  
(the `xxxx` part of `code=xxxx` in the URL)
5. Paste and press Enter.
6. Make a note of the following values that are displayed.
```
Access token: xxxx
Refresh token: yyyy (may be null)
```

### Tweet & Refresh token

1. Write `twitter.properties` from obtained above. 
```
TWITTER_OAUTH2_CLIENT_ID=xxxx
TWITTER_OAUTH2_CLIENT_SECRET=xxxx
TWITTER_OAUTH2_ACCESS_TOKEN=xxxx
TWITTER_OAUTH2_REFRESH_TOKEN=yyyy
TWITTER_OAUTH2_CALLBACK=https://xxxx
```

2. Run [`Tweet.java`](tweet/src/main/java/twitter/api/sample/Tweet.java)
```
gradlew tweet:run
```

3. Run [`Refresh.java`](tweet/src/main/java/twitter/api/sample/Refresh.java)  (`twitter.properties` will be updated)
```
gradlew refresh:run
```
