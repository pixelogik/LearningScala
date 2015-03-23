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

object CaseClassesAndExtractorsApp extends App {

	// Here we create an instance of Office using the default class constructor. 
	// When using a class constructor we have to use the keyword "new".
	val a = new Office("y&tg", "Berlin", 6, 870.0f)

	// Create an instance using the non-default constructor
	val b = new Office("Super", "Berlin", 6)

	// This time we create an instance of Office using the companion object Office.
	// This line actually calls Office.apply(), which returns an instance of Office.
	val c = Office("Wow", "Berlin", 6, 870.0f)

	// Building is a case class and brings auto-generated companion object with apply() and unapply().
	// This is why we can create an instance without the "new" keyword.
	val d = Building("Rainmaking Loft", "Berlin")

	// Make list with all three, possible because they all have the common super type RealEstateItem
	val items = List(a, b, c, d)

	// Iterate over list and perform pattern matching
	for (item <- items) {
		item match {

			// We use the unapply() method of the Office companion object. This is called an extractor btw. This case only matches if rent is zero. 
			case Office(name, city, peopleCapacity, rentInEuro) if rentInEuro == 0.0f => println("The free office is located in "+city)

			// We use the unapply() method of the Office companion object. This is called an extractor btw. 
			case Office(name, city, peopleCapacity, rentInEuro) => println("The office is located in "+city+" and the rent is "+rentInEuro)

			// We do not want to use the name property so we specify a _ there. Here we can just use the auto-generated extractor because Building is a case class.
			case Building(_, city) => println("Building is located in "+city)

			case _ => println("Unknown item...")
		}
	}

}






