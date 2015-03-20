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


//////////////////////////////////////////////////////////////////////////////////////////

// Supertype of all classes 
trait RealEstateItem

// Classes (also case classes) have primary constructors defined right after the class name. 
class Office(val name: String, val city: String, val peopleCapacity: Int, val rentInEuro: Float) extends RealEstateItem {

	// Non-default constructor
	def this(name: String, city: String, peopleCapacity: Int) = {
		this(name, city, peopleCapacity, 0.0f)
	}

}

// Companion objects are related to the class with the same name and defined in the same file. 
// They are storing type methods that in Java you would declare static. 
object Office {

	// This apply method allows us to create instances of the Office class by calling 
	// Office(name, city, peopleCapacity, rentInEuro). That is an invocation of 
	// Office.apply() actually. If Office would be a case class, this would come 
	// for free / would have been auto-generated by the compiler.
	def apply(name: String, city: String, peopleCapacity: Int, rentInEuro: Float) : Office = {
		return new Office(name, city, peopleCapacity, rentInEuro)
	}

	// This unapply method allows us to use Office in patter matching. Again, if Office was 
	// a case class, we would get this for free.
	def unapply(item: Office) = Some((item.name, item.city, item.peopleCapacity, item.rentInEuro))
	
}

// This is why cases classes are so handy. They auto-create companion objects with apply and unapply
// for instanciaton without "new" and for pattern matching.
case class Building(val name: String, val city: String) extends RealEstateItem

//////////////////////////////////////////////////////////////////////////////////////////



