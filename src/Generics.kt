// See generics is com.sourabh
class MyList<T> {
    fun get(pos: Int): T {
        TODO("implement")
    }

    fun addItem(item: T) {}
}

fun workWithList() {
    val intList: MyList<Int>
    val fishList: MyList<Fish>
}

data class Fish(val fishName: String)
