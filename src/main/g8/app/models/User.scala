package models

import java.sql.Timestamp

case class User(providerKey: String,
              number: String,
              active: Boolean,
              created: Timestamp,
              user: Long = 0L)
