//import java.time.{LocalDate, LocalDateTime, OffsetDateTime}
//
//import xyz.hyperreal.strftime.Strftime
//
//
//object Example extends App {
//
//	println( Strftime.format("%Y-%m-%d %H:%M") )
//	println( Strftime.format("%b %d, %y", LocalDate.parse("2016-03-14")) )
//	println( Strftime.format("%a, %b %d, %y at %R", LocalDateTime.parse("2016-03-14T10:47")) )
//  println( Strftime.format("%a, %d %b %Y %T %z", OffsetDateTime.parse("2018-05-09T13:09:49.721-04:00")) )
//  println( LocalDateTime.parse("Wednesday, May 9, 2018 1:09:49 PM", Strftime.convert("%c")) )
//
//}