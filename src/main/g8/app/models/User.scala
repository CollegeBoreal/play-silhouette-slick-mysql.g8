package models

import java.time.LocalDateTime

case class User(providerKey: String,
                number: String,
                active: Boolean,
                created: LocalDateTime,
                user: Long = 0L)
