This application demonstrates the use of `X-Forwarded` headers using the `ForwardedHeaderFilter` Spring request filter. 

For a full walkthrough see the article over at [tomgregory.com](https://tomgregory.com/spring-boot-behind-a-load-balancer-using-the-x-forwarded-headers).

## Running

`./gradlew bootRun`

## Using

### Hitting an endpoint without any filters applied

Make a request without any headers:

`curl -sb -X GET http://localhost:8080/absoluteURL`

Make a request with `X-Forwarded` headers:

`curl -sb -X GET --header "x-forwarded-proto: https" --header "x-forwarded-port: 1234" --header "x-forwarded-host: tomgregory.com" http://localhost:8080/absoluteURL`

(you should get the same response for both requests)

### Hitting an endpoint with the `ForwardedHeaderFilter` filter applied

Make a request without any headers:

`curl -sb -X GET http://localhost:8080/absoluteURLWithFilter`

Make a request with `X-Forwarded` headers:

`curl -sb -X GET --header "x-forwarded-proto: https" --header "x-forwarded-port: 1234" --header "x-forwarded-host: tomgregory.com" http://localhost:8080/absoluteURLWithFilter`

(you should get a different response for both requests)