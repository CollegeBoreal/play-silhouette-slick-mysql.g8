
at com.mohiva.play.silhouette.impl.authenticators.JWTAuthenticatorService$$anonfun$init$4.applyOrElse(JWTAuthenticator.scala:297)
Caused by: com.atlassian.jwt.exception.JwtMalformedSharedSecretException: Failed to create MAC signer with the provided secret key
	at com.atlassian.jwt.core.writer.NimbusJwtWriterFactory.createMACSigner(NimbusJwtWriterFactory.java:74)
Caused by: com.nimbusds.jose.KeyLengthException: The secret length must be at least 256 bits
	at com.nimbusds.jose.crypto.MACProvider.<init>(MACProvider.java:118)
