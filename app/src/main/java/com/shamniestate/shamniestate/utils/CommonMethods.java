package com.shamniestate.shamniestate.utils;

import android.app.DatePickerDialog;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommonMethods {
    public static int SECONDS_IN_A_DAY = 24 * 60 * 60;

    public static String remainingTime(String timeString) {
        String[] dateTime = timeString.split(" ");

        String dateS = dateTime[0];
        String timeS = dateTime[1];

        timeS = timeS.substring(0, 5);

        String[] dateArray = dateS.split("-");
        String[] timeArray = timeS.split(":");

        int year = Integer.parseInt(dateArray[0]);
        int month = Integer.parseInt(dateArray[1]);
        int day = Integer.parseInt(dateArray[2]);

        int hour = Integer.parseInt(timeArray[0]);
        int min = Integer.parseInt(timeArray[1]);
        int second = Integer.parseInt(timeArray[2]);

        Calendar expiryDate = Calendar.getInstance();

        expiryDate.set(year, month - 1, day);
        expiryDate.set(Calendar.HOUR, hour);
        expiryDate.set(Calendar.MINUTE, min);
        expiryDate.set(Calendar.SECOND, second);

        Calendar today = Calendar.getInstance();
        long diff =  expiryDate.getTimeInMillis() - today.getTimeInMillis();
        long diffSec = diff / 1000;

        long days = diffSec / SECONDS_IN_A_DAY;
        long secondsDay = diffSec % SECONDS_IN_A_DAY;
        long seconds = secondsDay % 60;
        long minutes = (secondsDay / 60) % 60;
        long hours = (secondsDay / 3600); // % 24 not needed

        return String.format(Locale.getDefault(), "%d days, %d:%d:%d", days, hours, minutes, seconds);
    }

    public static boolean isValidEmail(String email) {
        Pattern pattern;
        Matcher matcher;
        final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(email);

        return matcher.matches();
    }



}
