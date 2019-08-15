package xyz.hyperreal.strftime

import java.time.{LocalDateTime, OffsetDateTime}

import org.scalatest._
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks


class Tests extends FreeSpec with ScalaCheckPropertyChecks with Matchers {

	"formatting" in {
		Strftime.format( "%c", OffsetDateTime.parse("2018-05-09T13:09:49.721-04:00") ) shouldBe "Wednesday, May 9, 2018, 1:09:49 p.m."
    Strftime.format( "%a, %d %b %Y %T %z", OffsetDateTime.parse("2018-05-09T13:09:49.721-04:00") ) shouldBe "Wed., 09 May 2018 13:09:49 -0400"
	}

  "parsing" in {
    LocalDateTime.parse( "Wednesday, May 9, 2018, 1:09:49 p.m.", Strftime.convert("%c") ) shouldBe LocalDateTime.parse( "2018-05-09T13:09:49" )
  }
	
}