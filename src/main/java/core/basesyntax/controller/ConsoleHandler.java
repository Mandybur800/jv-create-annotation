package core.basesyntax.controller;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.model.Bet;
import java.util.Scanner;

public class ConsoleHandler {
    BetDao betDao = new BetDaoImpl();

    public void handle() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Please, enter value and risk for your bet or 'q' for exit");
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase("q")) {
                return;
            }
            Bet bet = null;
            try {
                String[] betData = command.split(" ");
                if (betData.length > 2) {
                    throw new RuntimeException();
                }
                int value = Integer.parseInt(betData[0]);
                double risk = Double.parseDouble(betData[1]);
                bet = new Bet(value, risk);

            } catch (NumberFormatException e) {
                System.out.println("Incorrect input, please enter again");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("You need to input two values!");
            } catch (RuntimeException e) {
                System.out.println("Please, enter two values");
            }
            betDao.add(bet);
            System.out.println(bet == null ? null : bet.toString());
        }
    }
}
