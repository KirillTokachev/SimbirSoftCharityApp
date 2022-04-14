package trainingKotlinPart1
// комент для комита
class Book(override var price: Int, override var wordCount: Int) : Publication{

    override fun getType(s: String): String {
        var result: String = ""

        result = if (wordCount <= 1000) "Flash Fiction”, 7,500 –“Short Story" else "Novel"

        return result
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        return super.equals(other)
    }
}