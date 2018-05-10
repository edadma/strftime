package xyz.hyperreal.strftime

import java.time.{Instant, LocalDateTime, OffsetDateTime, ZonedDateTime}
import java.time.format.DateTimeFormatterBuilder
import java.time.temporal.ChronoField._
import java.time.format.TextStyle._


object Main extends App {

  println( Strftime.format("%c",
    ZonedDateTime.parse("2018-05-09T13:09:49.721-04:00")
    ) )

}