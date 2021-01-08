package core.basesyntax.dao;

import core.basesyntax.model.Game;
import java.util.List;

public interface GameDao {
    void add(Game game);

    List<Game> getAll();
}
