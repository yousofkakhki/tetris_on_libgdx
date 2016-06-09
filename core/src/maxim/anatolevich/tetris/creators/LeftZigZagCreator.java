package maxim.anatolevich.tetris.creators;

import com.badlogic.gdx.math.MathUtils;

import maxim.anatolevich.tetris.figures.Figure;
import maxim.anatolevich.tetris.figures.LeftZigZag;

/**
 * Created by maxim_anatolevich on 08.06.2016.
 */
public class LeftZigZagCreator extends FigureCreator {
    @Override
    public Figure createFigure(int x, int y) {
        return new LeftZigZag(x, y, MathUtils.random(LeftZigZag.LEFT_ZIGZAG_SCHEMES.length - 1));
    }
}
