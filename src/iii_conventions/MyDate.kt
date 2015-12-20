package iii_conventions

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {
    override fun compareTo(other: MyDate): Int {
        val y = year - other.year
        if (y != 0) return y
        val m = month - other.month
        if (m != 0) return m
        return dayOfMonth - other.dayOfMonth
    }
}

operator fun MyDate.rangeTo(other: MyDate): DateRange = DateRange(this, other)

operator fun MyDate.plus(interval: TimeInterval): MyDate = addTimeIntervals(interval, 1)

operator fun MyDate.plus(mti: MultiTimeInterval): MyDate = addTimeIntervals(mti.interval, mti.num)

enum class TimeInterval {
    DAY,
    WEEK,
    YEAR
}
operator fun TimeInterval.times(num: Int): MultiTimeInterval = MultiTimeInterval(this, num)


class DateRange(val start: MyDate, val endInclusive: MyDate) : Iterable<MyDate> {
    override fun iterator(): Iterator<MyDate> {
        return object : Iterator<MyDate> {
            private var pos = start
            override fun hasNext(): Boolean = pos <= endInclusive
            override fun next(): MyDate {
                val r = pos
                pos = pos.nextDay()
                return r
            }

        }
    }

    fun contains(d: MyDate): Boolean {
        return start <= d && d <= endInclusive
    }
}

class MultiTimeInterval(val interval: TimeInterval, val num: Int = 1)
