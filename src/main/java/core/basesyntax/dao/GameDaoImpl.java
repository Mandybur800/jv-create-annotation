package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Game;
import java.util.List;

public class GameDaoImpl implements GameDao {
    @Override
    public void add(Game game) {
        Storage.games.add(game);
    }

    @Override
    public List<Game> getAll() {
        return Storage.games;
    }
}
