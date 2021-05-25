package com;

import java.text.MessageFormat;
import java.util.ResourceBundle;

public class Info {
    public static void run(ResourceBundle resourceBundle, String arg){
        String pattern = resourceBundle.getString("info");
        Object[] arguments = {arg};
        String info = new MessageFormat(pattern).format(arguments);
        System.out.println(info);
    }
}
