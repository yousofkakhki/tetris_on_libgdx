package maxim.anatolevich.tetris.figures;

/**
 * Created by maxim_anatolevich on 08.06.2016.
 */
public class LeftHorse extends Figure{
    public static int [][][] LEFT_HORSE_SCHEMES = {
            {
                    {1, 0},
                    {1, 0},
                    {1, 1}
            },
            {
                    {1, 1, 1},
                    {1, 0, 0}
            },
            {
                    {1, 1},
                    {0, 1},
                    {0, 1}
            },
            {
                    {0, 0, 1},
                    {1, 1, 1}
            }
    };

    public LeftHorse(int x, int y, int position){
        super(x, y, position);
        STANDART_SCHEMES = LEFT_HORSE_SCHEMES;
        scheme = STANDART_SCHEMES[position];
    }
}
