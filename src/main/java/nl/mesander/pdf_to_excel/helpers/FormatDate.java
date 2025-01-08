package nl.mesander.pdf_to_excel.helpers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class FormatDate {
    public static String formatDate(String inputDate) {
        String formattedDate;

        if (inputDate.matches(".*[a-zA-Z]*.")) {
            DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("d MMMM yyyy", Locale.forLanguageTag("nl"));
            LocalDate date = LocalDate.parse(inputDate, inputFormat);
            DateTimeFormatter outputFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            formattedDate = date.format(outputFormat);
        } else {
            DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate date = LocalDate.parse(inputDate, inputFormat);
            DateTimeFormatter outputFormat = DateTimeFormatter.ofPattern("d MMMM yyyy", Locale.forLanguageTag("nl"));
            formattedDate = date.format(outputFormat);
        }

        return formattedDate;
    }
}
