package f14.common;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

/**
 * Created by f14shm4n on 21.11.2017.
 */

public final class ExHelper {
    public static String stackTraceToString(Exception e) {
        Writer writer = new StringWriter();
        e.printStackTrace(new PrintWriter(writer));
        return writer.toString();
    }
}
