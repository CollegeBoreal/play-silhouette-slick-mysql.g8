package models

case class Password(providerKey: String = "",
                    hasher: String,
                    password: String,
                    salt: Option[String] = None)
