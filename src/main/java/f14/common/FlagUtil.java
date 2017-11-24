package f14.common;

/**
 * Created by f14shm4n on 13.11.2017.
 */

/**
 * Contains helper methods for working with bit flags.
 */
public final class FlagUtil {

    /**
     * Determines whether the flags value contains the specific flag.
     * @param flags The flags value.
     * @param flag The specific flag to check.
     * @return True - if {@code flags} contains {@code flag} or false otherwise.
     */
    public static boolean hasFlag(int flags, int flag) {
        return (flags & flag) == flag;
    }
}
