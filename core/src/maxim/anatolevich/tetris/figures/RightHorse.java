package maxim.anatolevich.tetris.figures;

/**
 * Created by maxim_anatolevich on 08.06.2016.
 */
public class RightHorse extends Figure {
    public static int [][][] RIGHT_HORSE_SCHEMES = {
        {
                {0, 1},
                {0, 1},
                {1, 1}
        },
        {
                {1, 0, 0},
                {1, 1, 1}
        },
        {
                {1, 1},
                {1, 0},
                {1, 0}
        },
        {
                {1, 1, 1},
                {0, 0, 1}
        }

    };

    public RightHorse(int x, int y, int position, Brilliant brilliant){
        super(x, y, position, brilliant);
        STANDART_SCHEMES = RIGHT_HORSE_SCHEMES;
        scheme = STANDART_SCHEMES[position];
    }
}
