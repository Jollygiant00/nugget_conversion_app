package com.example.android.nuggets;

import java.text.NumberFormat;

class ConvertUserInput {

    /**
     *
     * @param userInput EditText from CalculateWeightToNuggets activity
     * @param currentUnit unit value from spinner
     * @param unitOutput user selected output object
     * @return postFormatResult string from converted values and inputs
     *
     * This method converts user inputs from the CalculateWeightToNuggets activity
     * and returns a formatted string to pass to the TextView in the activity.
     *
     */
      String convertUserInput(double userInput, String currentUnit, double unitOutput) {
        final double convertPoundsToGrams = (453.59237);
        final double convertKilosToGrams = (1000);
        final double convertOuncesToGrams = (28.3495);
        double preFormatResult;
        double convertingUnit;
        String postFormatResult;

        switch (currentUnit) {
            case "kg":
                convertingUnit = convertKilosToGrams;
                break;
            case "oz":
                convertingUnit = convertOuncesToGrams;
                break;
            default:
                convertingUnit = convertPoundsToGrams;
                break;
        }

        preFormatResult = userInput * (convertingUnit / unitOutput);

        NumberFormat nf = NumberFormat.getInstance();
        nf.setMaximumFractionDigits(0);
        postFormatResult = nf.format((preFormatResult));

        return postFormatResult;
    }
}
