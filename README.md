# twitter-api-java-sdk-sample
Sample code for twitter-api-java-sdk

# How to use

## Get Access token & Refresh token

Reference: [twitter-api-java-sdk/OAuth20GetAccessToken.java](https://github.com/twitterdev/twitter-api-java-sdk/blob/main/examples/src/main/java/com/twitter/clientlib/auth/OAuth20GetAccessToken.java)

1. Set environment variables from [developer dashboard](https://developer.twitter.com/en/portal/dashboard).
```
# Linux / macOS / UNIX
export TWITTER_OAUTH2_CLIENT_ID=xxxx
export TWITTER_OAUTH2_CLIENT_SECRET=xxxx
export TWITTER_OAUTH2_CALLBACK=https://xxxx

# Windows
set TWITTER_OAUTH2_CLIENT_ID=xxxx
set TWITTER_OAUTH2_CLIENT_SECRET=xxxx
set TWITTER_OAUTH2_CALLBACK=https://xxxx
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

## Tweet


1. Set environment variables from obtained above.  
(If refresh token is null, no need to set)
```
# Linux / macOS / UNIX
export TWITTER_OAUTH2_ACCESS_TOKEN=xxxx
export TWITTER_OAUTH2_REFRESH_TOKEN=yyyy

# Windows
set TWITTER_OAUTH2_ACCESS_TOKEN=xxxx
set TWITTER_OAUTH2_REFRESH_TOKEN=yyyy
```

2. Run [`Tweet.java`](tweet/src/main/java/twitter/api/sample/Tweet.java)
```
gradlew tweet:run
```
