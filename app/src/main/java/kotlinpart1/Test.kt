package kotlinpart1

import android.util.Log

class Test {
}

    fun main(){

        var n: Int? = null

        val book1 = Book(50,550)
        val book2 = Book(75,1523)

        val book3 = n?.let { Book(it,2341) }
        val book4 = Book(56,3431)


        Log.d("Test", (book1 === book2).toString())

        Log.d("Test",book1.equals(book2).toString())

        book3?.let { buy(it) }

        buy(book4);

        val sum = { x: Int, y: Int -> Log.d("sum",((x+y).toString())) }

        sum(5,6)

    }

fun buy(publication: Publication) {
    println("The purchase is complete. The purchase amount was ${publication.price}")
}