package com;

import java.text.MessageFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class DisplayLocales {
    public static void run(ResourceBundle resourceBundle){
        System.out.println(resourceBundle.getString("locales"));
    }
}
