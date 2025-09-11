package com.functionalProgramming.java8.examples.dateAndTimeApi;


import java.time.Month;
import java.time.chrono.IsoEra;

public class Main {
    public static void main(String[] args) {
        java.time.LocalDate date = java.time.LocalDate.now();
        IsoEra era = date.getEra();
        Month month = date.getMonth();
        int year = date.getYear();
        int dayOfMonth = date.getDayOfMonth();
        System.out.println(era + " " + dayOfMonth + " " + month + " " + year);
        System.out.println(date);
        java.time.LocalDate customDate = java.time.LocalDate.of(2002,03,28);
        System.out.println(customDate);
        java.time.LocalDate yesterDay = date.minusDays(1);
        System.out.println(yesterDay);
        java.time.LocalDate pastDate = date.minusMonths(100);
        System.out.println(pastDate);

    }
}
