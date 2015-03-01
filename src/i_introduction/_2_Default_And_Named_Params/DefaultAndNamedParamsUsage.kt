package i_introduction._2_Default_And_Named_Params

import util.TODO
import i_introduction._1_Functions.task1

fun todoTask2_2() = TODO(
    """
        Task 2(2).
        Implement the same logic as in 'task1' again through the library method 'joinToString()'.
        Change values of some arguments of 'joinToString'.
    """,
    references = { (collection: Collection<Int>) -> task1(collection); collection.joinToString() })

fun task2_2(collection: Collection<Int>): String {
    return collection.joinToString(", ", "{", "}")
}
public fun Copiedtask1(collection: Collection<Int>): String {
    val sb = StringBuilder()
    sb.append("{")
    val iterator = collection.iterator()
    while (iterator.hasNext()) {
        val element = iterator.next()
        sb.append(element)
        if (iterator.hasNext()) {
            sb.append(", ")
        }
    }
    sb.append("}")
    return sb.toString()
}