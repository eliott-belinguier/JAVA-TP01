package fr.belinguier.ecole;

public class Converter {

    public static int convertToSecond(final int hours, final int minutes, final int seconds) {
        return hours * 3600 + minutes * 60 + seconds;
    }

    public static String convertSecondToTime(final int seconds) {
        final int[] time = new int[3];
        final StringBuilder strBuilder = new StringBuilder();
        int current;

        time[0] = seconds / 3600;
        time[1] = (seconds % 3600) / 60;
        time[2] = seconds % 60;
        for (int i = 0; i < 3; i++) {
            if (i != 0)
                strBuilder.append(':');
            current = time[i];
            if (current < 10)
                strBuilder.append('0');
            strBuilder.append(current);
        }
        return strBuilder.toString();
    }

}
