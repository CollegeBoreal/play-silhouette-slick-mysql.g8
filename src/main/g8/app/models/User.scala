package models

case class User(user: Option[Int],
              providerKey: String,
              number: String,
              active: Boolean,
              created: java.sql.Timestamp)

