package vi_generics

import util.TODO
import java.util.*

fun task41(): Nothing = TODO(
    """
        Task41.
        Add a 'partitionTo' function that splits a collection into two collections according to a predicate.
        Uncomment the commented invocations of 'partitionTo' below and make them compile.

        There is a 'partition()' function in the standard library that always returns two newly created lists.
        You should write a function that splits the collection into two collections given as arguments.
        The signature of the 'toCollection()' function from the standard library may help you.
    """,
        references = { l: List<Int> ->
            l.partition { it > 0 }
            l.toCollection(HashSet<Int>())
        }
)

fun List<String>.partitionWordsAndLines(): Pair<List<String>, List<String>> {
    return partitionTo(ArrayList<String>(), ArrayList()) { s -> !s.contains(" ") }
}

fun <T, C : MutableCollection<T>> Iterable<T>.partitionTo(first: C, second: C, pred: (T)->Boolean): Pair<C, C> {
    for (e in this) {
        if (pred(e)) first.add(e)
        else second.add(e)
    }
    return Pair(first, second)
}

//public fun <T, C : MutableCollection<in T>> Iterable<T>.toCollection(destination: C): C {

//fun <T, C : Collection<T>> Iterable<T>.partitionTo(first: Collection<T>, second: Collection<T>, pred: (T) -> Boolean): Pair<C, C> {
//    return Pair(first, second)
//}

fun Set<Char>.partitionLettersAndOtherSymbols(): Pair<Set<Char>, Set<Char>> {
    return partitionTo(HashSet<Char>(), HashSet()) { c -> c in 'a'..'z' || c in 'A'..'Z'}
}