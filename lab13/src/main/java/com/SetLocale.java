package com;

import java.text.MessageFormat;
import java.time.LocalDate;
import java.util.Locale;
import java.util.ResourceBundle;

public class SetLocale {
    public static void run(ResourceBundle resourceBundle, String arg) {
        String pattern = resourceBundle.getString("locale.set");
        Object[] arguments = {arg};
        String localeSet = new MessageFormat(pattern).format(arguments);
        System.out.println(localeSet);
    }
}
