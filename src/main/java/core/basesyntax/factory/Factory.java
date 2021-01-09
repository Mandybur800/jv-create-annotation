package core.basesyntax.factory;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.dao.GameDao;
import core.basesyntax.dao.GameDaoImpl;

public class Factory {
    private static BetDao betDao;
    private static GameDao gameDao;

    public static BetDao getBetDao() {
        if (betDao == null) {
            betDao = new BetDaoImpl();
        }
        return betDao;
    }

    public static GameDao getGameDao() {
        if (gameDao == null) {
            gameDao = new GameDaoImpl();
        }
        return gameDao;
    }

    public static Object getDao(Class clazz) {
        if (clazz == BetDao.class) {
            return getBetDao();
        }
        if (clazz == GameDao.class) {
            return getGameDao();
        }
        throw new RuntimeException("Dao for object " + clazz.getName() + " is not exist!");
    }
}
