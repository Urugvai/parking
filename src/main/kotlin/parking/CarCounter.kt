package parking

fun maxCarsAtTheSameTimeIn(timeSlots: Array<Pair<Long, Long>>): Int {
    if (timeSlots.isEmpty())
        return 0
    if (timeSlots.size == 1)
        return 1

    timeSlots.sortWith(compareBy({ it.first }, { it.second }))

    var totalMaxCarsAtTheSameTime = 1
    var currentWindowSize = 1
    for (i in 1..timeSlots.lastIndex) {
        if (allIsCrossed(timeSlots.sliceArray(i - currentWindowSize..i))) {
            currentWindowSize++
            if (currentWindowSize > totalMaxCarsAtTheSameTime)
                totalMaxCarsAtTheSameTime = currentWindowSize
        } else
            while (!allIsCrossed(timeSlots.sliceArray(i - currentWindowSize until i)))
                currentWindowSize--
    }

    return totalMaxCarsAtTheSameTime
}

private fun allIsCrossed(slots: Array<Pair<Long, Long>>): Boolean {
    for (i in 0 until slots.lastIndex) {
        for (j in i + 1..slots.lastIndex) {
            if (!isCrossed(slots[i], slots[j]))
                return false
        }
    }
    return true
}

private fun isCrossed(firstSlot: Pair<Long, Long>, secondSlot: Pair<Long, Long>): Boolean {
    return firstSlot.first < secondSlot.first && firstSlot.second < secondSlot.second && secondSlot.first < firstSlot.second
            || firstSlot.first > secondSlot.first && firstSlot.second > secondSlot.second && secondSlot.second > firstSlot.first
            || firstSlot.first >= secondSlot.first && firstSlot.second <= secondSlot.second
            || firstSlot.first <= secondSlot.first && firstSlot.second >= secondSlot.second
}
