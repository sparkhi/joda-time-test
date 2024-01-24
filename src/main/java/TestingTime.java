import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang.time.FastDateFormat;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestingTime {
    public static void main(String args[]) {
        long instant = 0L;
        if (args.length != 1) {
            System.out.println("Usage: java -jar joda-time-test-1.0-SNAPSHOT-jar-with-dependencies.jar [instant]");
            System.out.println("e.g. java -jar joda-time-test-1.0-SNAPSHOT-jar-with-dependencies.jar 12345678");
            System.out.println("for this trial run, using 12345678");
            instant = 12345678L;
        }  else {
            instant = Long.parseLong(args[0]);
        }
        String dateString = new TestingTime().getDateString(instant);
        System.out.println(dateString);
    }

    public String getDateString(long instant) {
        DateTime testDateTime = new DateTime(instant);
        DateTimeFormatter dtf = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss");
        //System.out.println("Joda time direct conversion: " + dtf.print(testDateTime));

        Date nodeDate  = new Date(testDateTime.getMillis());
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        //System.out.println("Java formatted date: " + df.format(nodeDate));

        FastDateFormat dateFormat = DateFormatUtils.ISO_DATETIME_FORMAT;
        String writtenDate = dateFormat.format(nodeDate);
        //System.out.println("Commons Lang Converted Date: " + writtenDate);
        return writtenDate;
    }
}
