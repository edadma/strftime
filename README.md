strftime
========

[![Build Status](https://www.travis-ci.org/edadma/strftime.svg?branch=master)](https://www.travis-ci.org/edadma/strftime)
[![Coverage Status](https://coveralls.io/repos/github/edadma/strftime/badge.svg?branch=master)](https://coveralls.io/github/edadma/strftime?branch=master)
[![License](https://img.shields.io/badge/license-ISC-blue.svg)](https://opensource.org/licenses/ISC)
[![Version](https://img.shields.io/badge/latest_release-v0.2.2-orange.svg)](https://github.com/edadma/strftime/releases/tag/v0.2.2)

*strftime* is an implementation of the [strftime](http://pubs.opengroup.org/onlinepubs/009695399/functions/strftime.html) standard C function for the [Scala](http://scala-lang.org) programming language.


Example
-------

The following example program shows how to use the convenience functions to write the current time (when this readme was written), a `java.time.LocalDate` object and a `java.time.LocalDateTime`.

```scala
import java.time.{LocalDate, LocalDateTime, OffsetDateTime}

import xyz.hyperreal.strftime.Strftime


object Main extends App {

  println( Strftime.format("%Y-%m-%d %H:%M") )
  println( Strftime.format("%b %d, %y", LocalDate.parse("2016-03-14")) )
  println( Strftime.format("%a, %b %d, %y at %R", LocalDateTime.parse("2016-03-14T10:47")) )
  println( Strftime.format("%a, %d %b %Y %T %z", OffsetDateTime.parse("2018-05-09T13:09:49.721-04:00")) )

}
```

This program printed

    2018-04-20 12:12
    Mar 14, 16
    Mon, Mar 14, 16 at 10:47
    Wed, 09 May 2018 13:09:49 -0400

Usage
-----

Use the following definition to use *strftime* in your Maven project:

```xml
<repository>
  <id>hyperreal</id>
  <url>https://dl.bintray.com/edadma/maven</url>
</repository>

<dependency>
  <groupId>xyz.hyperreal</groupId>
  <artifactId>strftime</artifactId>
  <version>0.2.2</version>
</dependency>
```

Add the following to your `build.sbt` file to use *strftime* in your SBT project:

```sbt
resolvers += "Hyperreal Repository" at "https://dl.bintray.com/edadma/maven"

libraryDependencies += "xyz.hyperreal" %% "strftime" % "0.2.2"
```


Building
--------

### Requirements

- Java 8
- SBT 1.1.4+
- Scala 2.12.5+

### Clone and Run the Tests

```bash
git clone git://github.com/edadma/strftime.git
cd strftime
sbt test
```

License
-------

ISC © 2018 Edward Maxedon