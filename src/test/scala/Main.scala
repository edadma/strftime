package xyz.hyperreal.strftime

import java.time.{Instant, LocalDateTime}
import java.time.format.DateTimeFormatterBuilder
import java.time.temporal.ChronoField._
import java.time.format.TextStyle._


object Main extends App {

//	val builder = new DateTimeFormatterBuilder
//
//	builder.appendValue( YEAR, 2 )
//
//	val formatter = builder.toFormatter
//
//	println( formatter.format( LocalDateTime.now ) )

	println( Strftime.format("%z") )

}