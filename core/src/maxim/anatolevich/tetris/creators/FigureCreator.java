package maxim.anatolevich.tetris.creators;

import maxim.anatolevich.tetris.figures.Brilliant;
import maxim.anatolevich.tetris.figures.Figure;

/**
 * Created by maxim_anatolevich on 06.06.2016.
 */
public abstract class FigureCreator {
    public abstract Figure createFigure(int x, int y, Brilliant brilliant);
}
