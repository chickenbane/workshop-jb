package iii_properties

import util.TODO

class LazyProperty(val initializer: () -> Int) {
    private var inited: Boolean = false
    private var lazyVal: Int = 0
    val lazy: Int
    get() =
        if (inited) $lazyVal else { $lazyVal = initializer(); $inited = true; $lazyVal }
}

fun todoTask19() = TODO(
    """
        Task 19.
        Add a custom getter to make the 'lazy' val really lazy.
        It should be initialized by 'initializer()' invocation
        at the moment of the first access.
        You can add as many additional properties as you need.
        Do not use Delegates ;).
    """,
    references = { LazyProperty({ 42 }).lazy }
)
