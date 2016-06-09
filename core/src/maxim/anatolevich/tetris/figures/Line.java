package maxim.anatolevich.tetris.figures;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by maxim_anatolevich on 06.06.2016.
 */
public class Line extends Figure{
    public static int[][][] LINE_SCHEMES = {
        {
            {1, 1, 1, 1}
        },
        {
            {1},
            {1},
            {1},
            {1}
        }
    };

    public Line(int x, int y, int position, Brilliant brilliant){
        super(x, y, position, brilliant);
        STANDART_SCHEMES = LINE_SCHEMES;
        scheme = STANDART_SCHEMES[position];
    }

}
