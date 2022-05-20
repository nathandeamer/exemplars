Run:  
`./gradlew clean bootRun`

Curl the hello world endpoint multiple times:  
`curl http://localhost:8080`

curl to get the metrics:  
`curl -H "Accept: application/openmetrics-text" http://localhost:8080/actuator/prometheus`

### Expected result:  
Should be able to see metrics with span/trace ids