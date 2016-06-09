package maxim.anatolevich.tetris.creators;

import com.badlogic.gdx.math.MathUtils;

import maxim.anatolevich.tetris.figures.Figure;
import maxim.anatolevich.tetris.figures.RightZigZag;

/**
 * Created by maxim_anatolevich on 08.06.2016.
 */
public class RightZigZagCreator extends FigureCreator {
    @Override
    public Figure createFigure(int x, int y) {
        return new RightZigZag(x, y, MathUtils.random(RightZigZag.RIGHT_ZIGZAG_SCHEMES.length - 1));
    }
}
