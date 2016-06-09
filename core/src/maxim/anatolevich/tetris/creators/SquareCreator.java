package maxim.anatolevich.tetris.creators;

import com.badlogic.gdx.math.MathUtils;

import maxim.anatolevich.tetris.figures.Figure;
import maxim.anatolevich.tetris.figures.Square;

/**
 * Created by maxim_anatolevich on 06.06.2016.
 */
public class SquareCreator extends FigureCreator{
    @Override
    public Figure createFigure(int x, int y) {
        return new Square(x, y, MathUtils.random(Square.SQUARE_SCHEMES.length - 1));
    }
}
