package com.example.android.nuggets;

import java.text.NumberFormat;

public class ConvertUserInput {

    public String convertUserInput(double userInput, String currentUnit, double unitOutput) {
        double convertPoundsToGrams = (453.59237);
        double convertKilosToGrams = (1000);
        double convertOuncesToGrams = (28.3495);
        double preFormatResult;

        /**
         * Get user selected weight unit and format result for correct units
         */
        switch (currentUnit) {
            case "kg":
                preFormatResult = userInput * (convertKilosToGrams / unitOutput);
                break;
            case "oz":
                preFormatResult = userInput * (convertOuncesToGrams / unitOutput);
                break;
            default:
                preFormatResult = userInput * (convertPoundsToGrams / unitOutput);
                break;
        }

        /**
         * convert double to integer
         */
        NumberFormat nf = NumberFormat.getInstance();
        nf.setMaximumFractionDigits(0);

        /**
         * return formatted result
         */
        return nf.format((preFormatResult));
    }
}
