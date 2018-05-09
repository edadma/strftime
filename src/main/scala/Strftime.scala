//@
package xyz.hyperreal.strftime

import java.time.{OffsetDateTime, ZonedDateTime}
import java.time.format.TextStyle._
import java.time.format.{DateTimeFormatter, DateTimeFormatterBuilder}
import java.time.temporal.ChronoField._
import java.time.temporal.TemporalAccessor


object Strftime {

	def convert( pattern: String ): DateTimeFormatter = {
		val builder = new DateTimeFormatterBuilder
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
						case 'c' =>
							builder.appendText( DAY_OF_WEEK, SHORT ).appendLiteral( ' ' ).
								appendText( MONTH_OF_YEAR, SHORT ).appendLiteral( ' ' ).
								appendValue( DAY_OF_MONTH, 2 ).appendLiteral( ' ' ).
								appendValue( HOUR_OF_DAY, 2 ).appendLiteral( ':' ).
								appendValue( MINUTE_OF_HOUR, 2 ).appendLiteral( ':' ).
								appendValue( SECOND_OF_MINUTE, 2 ).appendLiteral( ' ' ).
								appendText( YEAR )
						case 'C' => sys.error( "not implemented" )	// todo: don't know how to do this using java.time
						case 'd' => builder.appendValue( DAY_OF_MONTH, 2 )
						case 'D' =>
							builder.appendValue(MONTH_OF_YEAR, 2).appendLiteral('/').
								appendValue( DAY_OF_MONTH, 2 ).appendLiteral('/').
								appendValueReduced( YEAR, 2, 2, 2000 )
						case 'e' => builder.appendValue( DAY_OF_MONTH )
						case 'F' =>
							builder.appendText( YEAR ).appendLiteral( '-' ).
								appendValue( MONTH_OF_YEAR, 2 ).appendLiteral( '-' ).
								appendValue( DAY_OF_MONTH, 2 )
						case 'g' => sys.error( "not implemented" )	// todo
						case 'G' => sys.error( "not implemented" )	// todo
						case 'h' => builder.appendText( MONTH_OF_YEAR, SHORT )
						case 'H' => builder.appendValue( HOUR_OF_DAY, 2 )
						case 'I' => builder.appendValue( HOUR_OF_AMPM, 2 )
						case 'j' => builder.appendText( DAY_OF_YEAR )
						case 'm' => builder.appendValue( MONTH_OF_YEAR, 2 )
						case 'M' => builder.appendValue( MINUTE_OF_HOUR, 2 )
						case 'n' => builder.appendLiteral( '\n' )
						case 'p' => builder.appendText( AMPM_OF_DAY )
						case 'r' =>
							builder.appendText( HOUR_OF_AMPM ).appendLiteral( ':' ).
								appendValue( MINUTE_OF_HOUR, 2 ).appendLiteral( ':' ).
								appendValue( SECOND_OF_MINUTE, 2 ).appendLiteral( ' ' ).
								appendText( AMPM_OF_DAY )
						case 'R' =>
							builder.appendValue( HOUR_OF_DAY, 2 ).appendLiteral( ':' ).
								appendValue( MINUTE_OF_HOUR, 2 )
						case 'S' => builder.appendValue( SECOND_OF_MINUTE, 2 )
						case 't' => builder.appendLiteral( '\t' )
						case 'T' =>
							builder.appendValue( HOUR_OF_DAY, 2 ).appendLiteral( ':' ).
								appendValue( MINUTE_OF_HOUR, 2 ).appendLiteral( ':' ).
								appendValue( SECOND_OF_MINUTE, 2 )
						case 'u' => sys.error( "not implemented" )  // todo
						case 'U' => sys.error( "not implemented" )  // todo
						case 'V' => sys.error( "not implemented" )  // todo
						case 'w' => sys.error( "not implemented" )  // todo
						case 'W' => sys.error( "not implemented" )  // todo
						case 'x' =>	// same as case 'F'
							builder.appendText( YEAR ).appendLiteral( '-' ).
								appendValue( MONTH_OF_YEAR, 2 ).appendLiteral( '-' ).
								appendValue( DAY_OF_MONTH, 2 )
						case 'X' => // same as case 'R'
							builder.appendText( HOUR_OF_DAY ).appendLiteral( ':' ).
								appendText( MINUTE_OF_HOUR )
						case 'y' => builder.appendValueReduced( YEAR, 2, 2, 2000 )
						case 'Y' => builder.appendText( YEAR )
						case 'z' => builder.appendZoneOrOffsetId
						case 'Z' => builder.appendZoneText( SHORT )
					}
				case c => builder.appendLiteral( c )
			}
		}

		builder.toFormatter
	}

	def format( pattern: String, moment: TemporalAccessor ) = convert( pattern ).format( moment )

	def format( pattern: String ): String = format( pattern, OffsetDateTime.now )

}