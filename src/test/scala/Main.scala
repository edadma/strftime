package xyz.hyperreal.strftime

import java.time.{Instant, LocalDateTime, OffsetDateTime, ZonedDateTime}
import java.time.format.DateTimeFormatterBuilder
import java.time.temporal.ChronoField._
import java.time.format.TextStyle._


object Main extends App {

  val res = Strftime.format("%FT%T%:z" )

  println( res )

}