package fr.belinguier.ecole;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Checker {

    public static final Pattern ADDRESSE_PATTERN = Pattern.compile("(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})");

    public static class MalformedAddressException extends Exception {

        public MalformedAddressException(final String message) {
            super(message);
        }

        public MalformedAddressException(final String message, final Throwable cause) {
            super(message, cause);
        }

        public MalformedAddressException(final Throwable cause) {
            super(cause);
        }

    }

    private static boolean isCorrectMatch(final Matcher matcher) throws MalformedAddressException {
        int number;

        for (int i = 1; i < matcher.groupCount(); i++) {
            try {
                number = Integer.parseInt(matcher.group(i));
                if (number > 255)
                    throw new MalformedAddressException("All address bytes must be between 0 and 255.");
            } catch (final NumberFormatException exception) {
                throw new MalformedAddressException("Please write address with correct syntax.", exception);
            }
        }
        return true;
    }

    public static boolean isCorrectAddress(final String address) throws MalformedAddressException {
        final Matcher matcher;
        if (address == null)
            throw new MalformedAddressException(new NullPointerException("Address must be not null."));
        matcher = ADDRESSE_PATTERN.matcher(address);
        if (matcher.matches())
            return isCorrectMatch(matcher);
        else
            throw new MalformedAddressException("Please write address with correct syntax.");
    }

}
