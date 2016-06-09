package maxim.anatolevich.tetris.figures;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by maxim_anatolevich on 06.06.2016.
 */
public class Square extends Figure {
    public static int[][][] SQUARE_SCHEMES = {
            {
                    {1, 1}, {1, 1}
            }
    };

    public Square(int x, int y, int position){
        super(x, y, position);
        STANDART_SCHEMES = SQUARE_SCHEMES;
        scheme = STANDART_SCHEMES[position];
    }
}
