package testing

class MyTest extends GroovyTestCase {

    public void testBooleanLogic() {

        // 1
        assertEquals(true, result)
        assertTrue(result)

        assertEquals(false, result)
        assertFalse(result)

        // 2
        assertTrue(result == 5)
        assertEquals(5, result)

        // 3
        assertTrue(result.isSame(source))
        assertSame(result, source)

        // 4
        try {
            something()
        } catch (Exception e) {
            fail(e.message)
        }

        // 5
        fail() // should never happen
        fail('should never happen')
    }
}
