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

// Everybody can mix in this trait, no constraints
trait SimpleTrait {
  var simpleVariable = ""
  def simplePrint() = println("Wow this is simple ("+simpleVariable+")...")
}

// This class just gets the one variable and method from the SimpleTrait
class SimpleUser(name: String) extends SimpleTrait {
  simpleVariable = "My name is "+name
}

//////////////////////////////////////////////////////////////////////////////////////////

// The parent class contains a variable and three methods. It is abstract because two methods are not implemented
abstract class ParentClass {
  var parentVariable = "Parent"
  def parentJob: String
  def parentLocation: String
  def parentMethod = println("This is parent '"+parentVariable+"' speaking, the job is '"+parentJob+"', the location is '"+parentLocation+"'...")
}

// This trait can only be used by subclasses of ParentClass
trait TraitForParents extends ParentClass {
  def parentLocation: String = "Berlin"
  def traitMethod = println("This is the trait method only useable by parent classes..")
}

// This trait can be used by everybody
trait JustAnotherTraitForEverybody {
  def academicTitle = println("Dr.")
}

// This child class extends ParentClass and uses the specific trait (could also just extend the trait)
class ChildClass extends ParentClass with TraitForParents with JustAnotherTraitForEverybody {
  def parentJob: String = "Software Engineer ("+academicTitle+")"
}

//////////////////////////////////////////////////////////////////////////////////////////



