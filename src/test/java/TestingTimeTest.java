import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestingTimeTest {

    @Test
    public void shouldConvertLongMillisToFormattedDate() {
        String dateString = new TestingTime().getDateString(12345678L);
        assertEquals("1970-01-01T04:25:45", dateString);

    }
}