package me.afletchling.weathermanager.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Util {
    private final static Scanner scanner = new Scanner(System.in);

    // Read from the terminal using the scanner class.
    public static String readTerminal(String printText) {
        System.out.print(printText);
        return scanner.nextLine();
    }

    // Read from the terminal and only return if the input is a valid double.
    public static double readTerminalNumber(String printText) {
        System.out.print(printText);
        while (true) {
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (Exception exception) {
                System.out.println("Invalid number, please try again!");
            }
        }
    }

    // Parse the input stream into ASCII / UTF8 and construct a string based off of the bytes.
    public static String readFromStream(InputStream stream, String streamType) throws IOException {
        InputStreamReader inputstreamreader = new InputStreamReader(stream, streamType);
        BufferedReader bufferedreader = new BufferedReader(inputstreamreader);
        StringBuilder builder = new StringBuilder();

        while (true) {
            String s = bufferedreader.readLine();
            if (s == null) {
                return builder.toString();
            }

            builder.append(s);
            builder.append("\n");
        }
    }
}
