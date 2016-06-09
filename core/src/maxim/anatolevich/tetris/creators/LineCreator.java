package maxim.anatolevich.tetris.creators;

import com.badlogic.gdx.math.MathUtils;

import maxim.anatolevich.tetris.figures.Figure;
import maxim.anatolevich.tetris.figures.Line;

/**
 * Created by maxim_anatolevich on 06.06.2016.
 */
public class LineCreator extends FigureCreator{
    @Override
    public Figure createFigure(int x, int y) {
        return new Line(x, y, MathUtils.random(Line.LINE_SCHEMES.length - 1));
    }
}
