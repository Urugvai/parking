package parking

import org.testng.AssertJUnit.assertEquals
import org.testng.annotations.Test

@Test
fun `test max cars at the same time in slots test`() {
    assertEquals(3, maxCarsAtTheSameTimeIn(arrayOf(1L to 3L, 1L to 2L, 1L to 5L, 7L to 9L, 8L to 11L)))
}

@Test
fun `test max cars at the same time in another slots`() {
    assertEquals(1, maxCarsAtTheSameTimeIn(arrayOf(1L to 3L, 4L to 5L, 5L to 9L, 11L to 19L)))
}

@Test
fun `test max cars at the same time in crossed slots`() {
    assertEquals(4, maxCarsAtTheSameTimeIn(arrayOf(1L to 3L, 1L to 5L, 1L to 9L, 2L to 19L)))
}

@Test
fun `test max cars at the same time in one more set of slots`() {
    assertEquals(2, maxCarsAtTheSameTimeIn(arrayOf(1L to 3L, 5L to 7L, 6L to 9L, 12L to 19L)))
}

@Test
fun `test max cars at the same time for single car`() {
    assertEquals(1, maxCarsAtTheSameTimeIn(arrayOf(1L to 3L)))
}

@Test
fun `test max cars at the same time for no cars`() {
    assertEquals(0, maxCarsAtTheSameTimeIn(arrayOf()))
}

@Test
fun `test max very fast cars at the same time`() {
    assertEquals(1, maxCarsAtTheSameTimeIn(arrayOf(1L to 1L, 3L to 3L)))
}