package xyz.hyperreal.strftime

import java.time.LocalDateTime

import org.scalatest._
import prop.PropertyChecks


class Tests extends FreeSpec with PropertyChecks with Matchers {

	"tests" in {
		Strftime.format( "%a, %b %d, %y at %H:%M", LocalDateTime.parse("2016-03-14T10:47") ) shouldBe "Mon, Mar 14, 16 at 10:47"
	}
	
}