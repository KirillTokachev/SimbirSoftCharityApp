package kotlinpart1

class Book(override var price: Int, override var wordCount: Int) : Publication{

    override fun getType(s: String): String {
        var result: String = ""

        when (wordCount) {
            in 1..1000 -> result = "Flash Fiction”, 7,500 –“Short Story"
            in 1001..15000 -> result = "Novel"
        }
        return result
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        return super.equals(other)
    }
}