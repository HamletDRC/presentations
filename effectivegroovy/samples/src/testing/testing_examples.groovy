package testing

class MyTest extends GroovyTestCase {

    public void testBooleanLogic() {

        def result = 4

        assert result == 5
        // 1
        assertEquals(true, result)
        assertEquals(false, result)

        assertTrue(result)
        assertFalse(result)

        // 2
        assertTrue(result == 5)
        assertEquals(5, result)

        // 3
        assertTrue(result.isSame(source))
        assertSame(result, source)

        // 4
        assert result == 5

        // 5
        try {
            something()
        } catch (Exception e) {
            fail(e.message)
        }

        // 6
        fail() // should never happen
        fail('should never happen')
    }
}
