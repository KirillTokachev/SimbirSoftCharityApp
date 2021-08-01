package kotlinpart1

class Magazine(override var price: Int, override var wordCount: Int) : Publication {

    override fun getType(s: String): String {
        return "Magazine"
    }

}