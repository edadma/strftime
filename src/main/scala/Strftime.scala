//@
package xyz.hyperreal.strftime

import java.time.LocalDateTime
import java.time.format.TextStyle._
import java.time.format.{DateTimeFormatter, DateTimeFormatterBuilder}
import java.time.temporal.ChronoField._


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
								appendText( HOUR_OF_DAY ).appendLiteral( ':' ).
								appendText( MINUTE_OF_HOUR ).appendLiteral( ':' ).
								appendText( SECOND_OF_MINUTE ).appendLiteral( ' ' ).
								appendText( YEAR )
						case 'd' => builder.appendValue( DAY_OF_MONTH, 2 )
						case 'H' => builder.appendText( HOUR_OF_DAY )
						case 'I' => builder.appendText( HOUR_OF_AMPM )
						case 'm' => builder.appendValue( MONTH_OF_YEAR, 2 )
						case 'M' => builder.appendText( MINUTE_OF_HOUR )
						case 'S' => builder.appendText( SECOND_OF_MINUTE )
						case 'y' => builder.appendValueReduced( YEAR, 2, 2, 2000 )
						case 'Y' => builder.appendText( YEAR )
					}
				case c => builder.appendLiteral( c )
			}
		}

		builder.toFormatter
	}

	def format( pattern: String, moment: LocalDateTime ) = convert( pattern ).format( moment )

	def format( pattern: String ): String = format( pattern, LocalDateTime.now )

}