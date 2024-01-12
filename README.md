# Snapgram
Snapgram clone

## Run local frontend
- npm install
- npm start

## Run local backend
- ./mvnw clean build
- run using IDE

## Setup HTTPS
### Generate SSL certificate
`keytool -genkey -alias tomcat -storetype PKCS12 -keyalg RSA -keysize 2048 -keystore keystore.p12  -validity 3650`

