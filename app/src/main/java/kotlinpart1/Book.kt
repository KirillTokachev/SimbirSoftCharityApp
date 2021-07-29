package kotlinpart1

class Book(override val price: Int, override val wordCount: Int) : Publication{

    override fun getType(s: String): String {

        var result: String = ""

        if (s.length < 1000){
            result = "Flash Fiction”, 7,500 –“Short Story"
        } else if (s.length > 1000) {
            result = "Novel"
        }
        return result
    }

    override fun equals(other: Any?): Boolean {
        return super.equals(other)
    }
}