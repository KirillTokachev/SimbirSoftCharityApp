package kotlinpart1

interface Publication {

    val price: Int
    val wordCount: Int

    fun getType(s: String): String

}