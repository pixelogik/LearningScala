// The MIT License (MIT)

// Copyright (c) 2015 Ole Krause-Sparmann

// Permission is hereby granted, free of charge, to any person obtaining a copy
// of this software and associated documentation files (the "Software"), to deal
// in the Software without restriction, including without limitation the rights
// to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
// copies of the Software, and to permit persons to whom the Software is
// furnished to do so, subject to the following conditions:

// The above copyright notice and this permission notice shall be included in all
// copies or substantial portions of the Software.

// THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
// IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
// FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
// AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
// LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
// OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
// SOFTWARE.

object CaseClassesAndPatternMatchingApp extends App {

	val events = List( 
			Event("The Concert", "The Concert Hall", 12.50f),
			Event("The Other Concert", "The Concert Hall", 21.00f),
			Event("The Big Concert", "The Arena", 45.00f),
			XMAS,
			Event("The Indie Concert", "The Small Club", 8.50f)	
		)

	for (event <- events) {

		println("--------")

		event match {
			case Event(name, locationName, ticketPrice) => {
				println("Event name = "+name)
				println("Location name = "+locationName)
				println("Ticket price = "+ticketPrice)
			}
			case XMAS => println("It is XMAS!!")
		}
	}

	// Case classes auto-implement equal()
 	val a = Event("The Indie Concert", "The Small Club", 8.50f)	
	val b = Event("The Indie Concert", "The Small Club", 8.50f)	
	println("a==b says "+(a == b))

	// Because equal() is auto-implemented eventSet will only contain one item, because of a==b
	val eventSet = Set(a, b)
	println(eventSet)

	// Case classes bring a copy() method. Let's make a copy with changed ticket price
	val c = a.copy(ticketPrice = 20.0f)
	println(c)
	
}






