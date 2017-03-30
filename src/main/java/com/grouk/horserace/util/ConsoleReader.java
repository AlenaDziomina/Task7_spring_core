package com.grouk.horserace.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

/**
 * Console Reader
 * Created by Alena on 30.03.2017.
 */
@Component
public class ConsoleReader {

    private static Scanner scanner = new Scanner(System.in);

    @Autowired
    private ConsoleWriter writer;

    public Integer makeBet(List<Integer> numbers) {
        Integer bet;
        writer.printMessage("user.bet", null);
        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                bet = scanner.nextInt();
                if (numbers.contains(bet)) {
                    return bet;
                } else {
                    writer.printMessage("horse.not.found", new Object[]{bet});
                }
            } else {
                writer.printMessage("number.need", new Object[]{scanner.next()});
                System.out.println(scanner.next() + " - is not a number");
            }
        }
        return null;
    }
}
