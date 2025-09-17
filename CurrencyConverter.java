package com.internship;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CurrencyConverter {

    // Map of currency pairs to exchange rates (relative to USD)
    private static final Map<String, Double> exchangeRates = new HashMap<>();

    static {
        // Base is USD
        exchangeRates.put("USD", 1.0);
        exchangeRates.put("INR", 83.25);
        exchangeRates.put("EUR", 0.94);
        exchangeRates.put("GBP", 0.81);
        exchangeRates.put("JPY", 147.58);
        exchangeRates.put("AUD", 1.56);
        exchangeRates.put("CAD", 1.35);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Available currencies: USD, INR, EUR, GBP, JPY, AUD, CAD");

        System.out.print("Enter base currency (FROM): ");
        String baseCurrency = scanner.nextLine().toUpperCase();

        System.out.print("Enter target currency (TO): ");
        String targetCurrency = scanner.nextLine().toUpperCase();

        if (!exchangeRates.containsKey(baseCurrency) || !exchangeRates.containsKey(targetCurrency)) {
            System.out.println("Invalid currency entered.");
            return;
        }

        System.out.print("Enter amount to convert: ");
        double amount;
        try {
            amount = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid amount.");
            return;
        }

        double usdAmount = amount / exchangeRates.get(baseCurrency);
        double convertedAmount = usdAmount * exchangeRates.get(targetCurrency);

        System.out.printf("Converted amount: %.2f %s\n", convertedAmount, targetCurrency);
    }
}
