package maxim.anatolevich.tetris.figures;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by maxim_anatolevich on 08.06.2016.
 */
public class RightZigZag extends Figure {
    public static int [][][] RIGHT_ZIGZAG_SCHEMES = {
            {
                    {0, 1},
                    {1, 1},
                    {1, 0}
            },
            {
                    {1, 1, 0},
                    {0, 1, 1}
            }
    };

    public RightZigZag(int x, int y, int position, Brilliant brilliant){
        super(x, y, position, brilliant);
        STANDART_SCHEMES = RIGHT_ZIGZAG_SCHEMES;
        scheme = STANDART_SCHEMES[position];
    }
}
