package maxim.anatolevich.tetris.creators;

import com.badlogic.gdx.math.MathUtils;

import maxim.anatolevich.tetris.figures.Figure;
import maxim.anatolevich.tetris.figures.LeftHorse;

/**
 * Created by maxim_anatolevich on 08.06.2016.
 */
public class LeftHorseCreator extends  FigureCreator {
    @Override
    public Figure createFigure(int x, int y) {
        return new LeftHorse(x, y, MathUtils.random(LeftHorse.LEFT_HORSE_SCHEMES.length - 1));
    }
}
