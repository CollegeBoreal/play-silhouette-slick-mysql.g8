package models

case class Password(providerId: Option[String],
                     hasher: String,
                     password: String,
                     salt: String)
