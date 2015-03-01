package ii_conventions

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {
    override fun compareTo(other: MyDate): Int {
        if (year < other.year) {
            return -1
        } else if (year > other.year) {
            return 1
        } else if (month < other.month) {
            return -1
        } else if (month > other.month) {
            return 1
        } else if (dayOfMonth < other.dayOfMonth) {
            return -1
        } else if (dayOfMonth > other.dayOfMonth) {
            return 1
        } else {
            return 0
        }
    }

}

enum class TimeInterval {
    DAY
    WEEK
    YEAR
}

class DateRange(public val start: MyDate, public val end: MyDate)
