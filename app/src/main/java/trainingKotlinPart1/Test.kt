package trainingKotlinPart1

import android.util.Log
// комент для комита
class Test {
}

fun main(){

    var n: Int? = null

    val book1 = Book(50,550)
    val book2 = Book(75,1523)
    val magazine = Magazine(1500,15000)
    val book3 = n?.let { Book(it,2341) }

    Log.d("Test", book1.getType("Harry Potter") + ", strings: " + "${book1.wordCount}, " + "price: " + "${book1.price}" + " euro")
    Log.d("Test", book2.getType("Piece and War") + ", strings: " + "${book2.wordCount}, " + "price: " + "${book2.price}" + " euro")
    Log.d("Test", magazine.getType("Black Howl") + ", strings: " + "${magazine.wordCount}, " + "price: " + "${magazine.price}" + " euro")
    Log.d("Test", (book1 === book2).toString())
    Log.d("Test",book1.equals(book2).toString())


    val sum = { x: Int, y: Int -> Log.d("sum",((x+y).toString())) }

    sum(5,6)

    val bookNotNull: Book? = Book(7346,912389)
    val bookNull: Book? = null

    buy(bookNotNull!!)


    buy(bookNull!!)


}

fun buy(publication: Publication) {
    println("The purchase is complete. The purchase amount was ${publication.price}")
}