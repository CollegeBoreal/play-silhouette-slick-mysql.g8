libraryDependencies ++= {
  val PLAY_SLICK_VERSION = "3.0.1"
  Seq(
    "com.typesafe.play" %% "play-slick" % PLAY_SLICK_VERSION,
    "com.typesafe.play" %% "play-slick-evolutions" % PLAY_SLICK_VERSION
  )
}
