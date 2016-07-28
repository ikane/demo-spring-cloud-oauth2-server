Test server:

Our server is using the Spring Boot default security settings, so like the server in Part I it will be protected by HTTP Basic authentication. To initiate an authorization code token grant you visit the authorization endpoint, e.g. at 

http://localhost:9999/uaa/oauth/authorize?response_type=code&client_id=acme&redirect_uri=http://example.com 

once you have authenticated you will get a redirect to example.com with an authorization code attached, e.g. 
http://example.com/?code=jYWioI.


The code can be exchanged for an access token using the “acme” client credentials on the token endpoint:

curl acme:acmesecret@localhost:9999/uaa/oauth/token -d grant_type=authorization_code -d client_id=acme -d redirect_uri=http://example.com -d code=0CUgkq