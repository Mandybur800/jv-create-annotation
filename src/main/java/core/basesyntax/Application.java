package core.basesyntax;

import core.basesyntax.controller.ConsoleHandler;

public class Application {
    public static void main(String[] args) {
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.handle();
    }
}
