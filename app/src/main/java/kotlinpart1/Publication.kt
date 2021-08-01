package kotlinpart1

interface Publication {

    var price: Int
    var wordCount: Int

    fun getType(s: String): String

}