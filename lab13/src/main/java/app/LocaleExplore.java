package app;

import com.DisplayLocales;
import com.Info;
import com.SetLocale;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.time.Month;
import java.time.format.TextStyle;
import java.time.temporal.WeekFields;
import java.util.*;

public class LocaleExplore {

    public static ResourceBundle resourceBundle;

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String lineCmd;


        resourceBundle = ResourceBundle.getBundle("Messages", Locale.getDefault());

        do {
            System.out.print(resourceBundle.getString("prompt"));
            lineCmd = scanner.nextLine();
            handleRequest(lineCmd);
        } while (!lineCmd.equals("exit"));

    }

    private static void handleRequest(String lineCmd) {
        try {
            var cmd = lineCmd.split(" ");
            if (cmd[0].equals("locales"))
                DisplayLocales.run(resourceBundle);
            else if (cmd[0].equals("locale.set"))
                SetLocale.run(resourceBundle, cmd[1]);
            else if (cmd[0].equals("info"))
                Info.run(resourceBundle, cmd[1]);
            else if (cmd[0].equals("lang") && cmd[1].equals("tag")) {
                var locale = Locale.forLanguageTag(cmd[2]);
                resourceBundle = ResourceBundle.getBundle("Messages", locale);
                printLangDetails(locale);
            }
            else
                System.out.println(resourceBundle.getString("invalid"));
        } catch (Exception e){
            e.printStackTrace();
            System.out.println(resourceBundle.getString("invalid"));

        }
    }

    private static void printLangDetails(Locale locale) {
        System.out.println("Country: " + locale.getCountry() + "(" + locale.getDisplayCountry() + ")");

        System.out.println("Language: " + locale.getLanguage() + "(" + locale.getDisplayLanguage() + ")");

        Currency currency = Currency.getInstance(locale);
        System.out.println("Currency: " + currency.getCurrencyCode() + "(" + currency.getDisplayName() + ")");

        DateFormatSymbols dfs = new DateFormatSymbols(locale);
        String weekdays[] = dfs.getWeekdays();

        System.out.println("Week Days: "
                + weekdays[1] + ", "
                + weekdays[2] + ", "
                + weekdays[3] + ", "
                + weekdays[4] + ", "
                + weekdays[5] + ", "
                + weekdays[6] + ", "
                + weekdays[7]
        );

        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateInstance(
                DateFormat.FULL, locale);

        System.out.print("Months: ");

        for (int i=1; i<= 12 ;i++){
            System.out.print(Month
                    .of(i)
                    .getDisplayName(
                            TextStyle.FULL_STANDALONE ,
                            locale
                    ) + ", ");
        }
        System.out.println();

        System.out.println("Today: "
                + dateFormat.format(date));
    }
}
