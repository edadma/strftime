import java.time.{LocalDate, LocalDateTime}

import xyz.hyperreal.strftime.Strftime


object Main extends App {

	println( Strftime.format("%Y-%m-%d %H:%M") )
	println( Strftime.format("%b %d, %y", LocalDate.parse("2016-03-14")) )
	println( Strftime.format("%a, %b %d, %y at %H:%M", LocalDateTime.parse("2016-03-14T10:47")) )

}