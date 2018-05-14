//@
package xyz.hyperreal.strftime

import java.time.{OffsetDateTime}
import java.time.format.TextStyle._
import java.time.format.{DateTimeFormatter, DateTimeFormatterBuilder, FormatStyle}
import java.time.temporal.ChronoField._
import java.time.temporal.TemporalAccessor


object Strftime {

  def convert( pattern: String ): DateTimeFormatter = {
    val builder = new DateTimeFormatterBuilder

    def convert( pattern: String ) {
      val it = pattern.iterator

      while (it.hasNext) {
        it next match {
          case '%' =>
            it next match {
              case '%' => builder.appendLiteral( '%' )
              case 'a' => builder.appendText( DAY_OF_WEEK, SHORT )
              case 'A' => builder.appendText( DAY_OF_WEEK )
              case 'b' => builder.appendText( MONTH_OF_YEAR, SHORT )
              case 'B' => builder.appendText( MONTH_OF_YEAR )
              case 'c' => builder.appendLocalized( FormatStyle.FULL, FormatStyle.MEDIUM )
              case 'C' => sys.error( "not implemented: don't know how using java.time" )
              case 'd' => builder.appendValue( DAY_OF_MONTH, 2 )
              case 'D' => convert( "%m/%d/%y" )
              case 'e' => builder.appendValue( DAY_OF_MONTH )
              case 'F' => convert( "%Y-%m-%d" )
              case 'g' => sys.error( "not implemented: don't know how using java.time" )
              case 'G' => sys.error( "not implemented: don't know how using java.time" )
              case 'h' => builder.appendText( MONTH_OF_YEAR, SHORT )
              case 'H' => builder.appendValue( HOUR_OF_DAY, 2 )
              case 'I' => builder.appendValue( HOUR_OF_AMPM, 2 )
              case 'j' => builder.appendText( DAY_OF_YEAR )
              case 'm' => builder.appendValue( MONTH_OF_YEAR, 2 )
              case 'M' => builder.appendValue( MINUTE_OF_HOUR, 2 )
              case 'n' => builder.appendLiteral( '\n' )
              case 'p' => builder.appendText( AMPM_OF_DAY )
              case 'r' => convert( "%I:%M:%S %p" )
              case 'R' => convert( "%H:%M" )
              case 's' => builder.appendValue( INSTANT_SECONDS )
              case 'S' => builder.appendValue( SECOND_OF_MINUTE, 2 )
              case 't' => builder.appendLiteral( '\t' )
              case 'T' => convert( "%H:%M:%S" )
              case 'u' => builder.appendValue( DAY_OF_WEEK )
              case 'U' => sys.error( "not implemented: don't know how using java.time" )
              case 'V' => builder.appendValue( ALIGNED_WEEK_OF_YEAR, 2 )
              case 'w' => sys.error( "not implemented: don't know how using java.time" )
              case 'W' => sys.error( "not implemented: don't know how using java.time" )
              case 'x' => builder.appendLocalized( FormatStyle.FULL, null )
              case 'X' => builder.appendLocalized( null, FormatStyle.MEDIUM )
              case 'y' => builder.appendValueReduced( YEAR, 2, 2, 2000 )
              case 'Y' => builder.appendText( YEAR )
              case 'z' => builder.appendOffset( "+HHMM", "+0000" )
              case ':' =>
                if (it.hasNext)
                  it.next match {
                    case 'z' => builder.appendOffset( "+HH:MM", "Z" )
                    case c => sys.error( s"expected 'z', found '$c'" )
                  }
                else
                  sys.error( "unexpected end of format string" )
              case 'Z' => builder.appendZoneText( SHORT )
              case c => sys.error( s"unknown conversion: '$c'" )
            }

          case c => builder.appendLiteral( c )
        }
      }
    }

    convert( pattern )
    builder.toFormatter
  }

  def format( pattern: String, moment: TemporalAccessor ) = convert( pattern ).format( moment )

  def format( pattern: String ): String = format( pattern, OffsetDateTime.now )

  def parse( pattern: String, date: String ) = convert( pattern ).parse( date )

}