@file:Suppress("FoldInitializerAndIfToElvis", "SENSELESS_COMPARISON", "UnnecessaryVariable")

sealed class ParseResult {

    data class Error(val errorMessage: String) : ParseResult()

    data class ParsedData(val data: String, val mimeType: String) : ParseResult()
}


private fun parse(url: String): ParseResult {
    val result = "Something"
    if (result == null) {
        return ParseResult.Error("error")
    }

    val mimeType = "Some media type"
    val data = result
    return ParseResult.ParsedData(data, mimeType)
}

/**
 * If you returned the result of the when expression,
 * the compiler would then start highlighting any ParseResult subclasses
 * that you haven’t handled;
 * providing further compile time safety against forgetting to handle new
 * types of the sealed class.
 */

fun method() {
    val result = parse("Some url")
    when (result) {
        is ParseResult.ParsedData -> TODO()
        is ParseResult.Error -> TODO()
    }
}