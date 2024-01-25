import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestingTimeTest {

    @Test
    public void shouldConvertLongMillisToFormattedDate() {
        String dateString = new TestingTime().getDateString(12345678L);
        assertEquals("1970-01-01T04:25:45", dateString);
    }

    @Test
    public void shouldConvertJavaDateToFormattedDate() {
        String dateString = new TestingTime().getDateStringJavaUtilOnly(12345678L);
        assertEquals("1970-01-01T04:25:45", dateString);
    }

    @Test
    public void shouldHaveSameTimeInMillisAsTheInstantToJodaTime() {
        long instant = 12345678L;
        assertEquals(instant, new TestingTime().getConvertedInstant(instant));
    }
}