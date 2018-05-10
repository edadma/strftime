package xyz.hyperreal.strftime

import java.time.{Instant, LocalDateTime, OffsetDateTime, ZonedDateTime}
import java.time.format.DateTimeFormatterBuilder
import java.time.temporal.ChronoField._
import java.time.format.TextStyle._


object Main extends App {

  val res = Strftime.parse("%c", "Wednesday, May 9, 2018 1:09:49 PM")

  println( res, res.getClass )

}