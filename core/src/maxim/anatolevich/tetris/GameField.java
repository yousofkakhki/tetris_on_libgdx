package maxim.anatolevich.tetris;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import maxim.anatolevich.tetris.figures.Brilliant;
import maxim.anatolevich.tetris.figures.Figure;

/**
 * Created by maxim_anatolevich on 09.06.2016.
 */
public class GameField{
    public Brilliant[][] field;
    Tetris tetris;

    public GameField(Tetris tetris){
        this.tetris = tetris;
        field = new Brilliant[28][15];
    }

    public void printFigureOnGameField(Figure figure){
        for(int i = 0; i < figure.scheme.length; i++){
            for(int j = 0; j < figure.scheme[0].length; j++){
                if(figure.scheme[i][j] == 1){
                    field[figure.y + i][figure.x + j] = figure.brilliant;
                }
            }
        }
    }

    public boolean isFullLine(int line){
        for(int i = 0; i < field[0].length; i++)
            if(field[line][i] == null)
                return false;
        return true;
    }

    public void deleteLine(int line){
        for(int i = line - 1; i >= 0; i--){
            for(int j = 0; j < field[0].length; j++){
                field[i + 1][j] = field[i][j];
            }
        }
        for(int i = 0; i < field[0].length; i++)
            field[0][i] = null;
    }

    public void deleteFullLines(){
        for(int i = field.length - 1; i >= 0; i--){
            if(isFullLine(i)) {
                deleteLine(i);
                tetris.changeScore(100);
                tetris.changeMoveInterval();
            }
        }
    }

    public void drawGameField(SpriteBatch batch){
        for(int i = 0; i < field.length; i++){
            for(int j = 0; j < field[0].length; j++){
                if(field[i][j] != null) {
                    batch.draw(field[i][j].texture, Tetris.xOffset + j * Figure.BLOCK_SIZE, Tetris.yOffset + (field.length - 1 - i) * Figure.BLOCK_SIZE);
                }
            }
        }
    }
}
