// See generics is Aquarium
class MyList<T> {
    fun get(pos: Int): T {
        TODO()
    }

    fun addItem(item: T) {}
}

fun workWithList() {
    val intList: MyList<Int>
    val fishList: MyList<Fish>
}

data class Fish(val fishName: String)
