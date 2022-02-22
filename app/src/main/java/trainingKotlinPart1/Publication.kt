package trainingKotlinPart1
// комент для комита
interface Publication {

    var price: Int
    var wordCount: Int

    fun getType(s: String): String

}