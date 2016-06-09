package maxim.anatolevich.tetris.creators;

import com.badlogic.gdx.math.MathUtils;

import maxim.anatolevich.tetris.figures.Brilliant;
import maxim.anatolevich.tetris.figures.Figure;
import maxim.anatolevich.tetris.figures.RightHorse;

/**
 * Created by maxim_anatolevich on 08.06.2016.
 */
public class RightHorseCreator extends FigureCreator {
    @Override
    public Figure createFigure(int x, int y, Brilliant brilliant) {
        return new RightHorse(x, y, MathUtils.random(RightHorse.RIGHT_HORSE_SCHEMES.length - 1), brilliant);
    }
}
