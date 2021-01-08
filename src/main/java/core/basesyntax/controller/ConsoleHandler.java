package core.basesyntax.controller;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.dao.GameDao;
import core.basesyntax.dao.GameDaoImpl;
import core.basesyntax.model.Bet;
import core.basesyntax.model.Game;
import java.util.Scanner;

public class ConsoleHandler {
    private static final Scanner scanner = new Scanner(System.in);
    private BetDao betDao = new BetDaoImpl();
    private GameDao gameDao = new GameDaoImpl();

    public void handle() {
        while (true) {
            System.out.println("Please, enter command:\n"
                    + "q - for exit from program;\n"
                    + "1 - for input Bet;\n"
                    + "2 - for input Game;\n");
            String command = scanner.nextLine();
            switch (command) {
                case "q" :
                    return;
                case "1" :
                    handleBet();
                    break;
                case "2" :
                    handleGame();
                    break;
                default:
                    System.out.println("Incorrect operation, please try again.");
            }
        }
    }

    private void handleGame() {
        while (true) {
            System.out.println("Please, enter type of sport or 'q' for exit to previous menu");
            String sport = scanner.nextLine();
            while (!sport.matches("[a-zA-Z_]\\w{2,}")) {
                System.out.println("Please, enter correct sport or 'q' for exit to previous menu");
                sport = scanner.nextLine();
                if (sport.equalsIgnoreCase("q")) {
                    return;
                }
            }
            String team1 = "";
            while (!team1.matches("[a-zA-Z_]\\w{2,}")) {
                System.out.println("Please, enter first team");
                team1 = scanner.nextLine();
            }
            String team2 = "";
            while (!team2.matches("[a-zA-Z_]\\w{2,}")) {
                System.out.println("Please, enter second team");
                team2 = scanner.nextLine();
            }
            Game game = new Game(sport, team1, team2);
            gameDao.add(game);
            System.out.println(game);
        }
    }

    private void handleBet() {
        while (true) {
            System.out.println("Please, enter value and risk for your bet "
                    + "or 'q' for exit to previous menu");
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase("q")) {
                return;
            }
            Bet bet = null;
            try {
                String[] betData = command.split(" ");
                int value = Integer.parseInt(betData[0]);
                double risk = Double.parseDouble(betData[1]);
                if (betData.length > 2 || value <= 0 || risk <= 0) {
                    throw new RuntimeException();
                }
                bet = new Bet(value, risk);

            } catch (NumberFormatException e) {
                System.out.println("Incorrect input, please enter again");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("You need to input two values!");
            } catch (RuntimeException e) {
                System.out.println("Please, enter two positive values");
            }
            betDao.add(bet);
            System.out.println(bet);
        }
    }
}
