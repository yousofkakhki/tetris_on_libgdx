package maxim.anatolevich.tetris.figures;

/**
 * Created by maxim_anatolevich on 06.06.2016.
 */
public class LeftZigZag extends Figure {
    public static int [][][] LEFT_ZIGZAG_SCHEMES = {
           {
                   {1, 0},
                   {1, 1},
                   {0, 1}
           },
           {
                   {0, 1, 1},
                   {1, 1, 0}
           }
    };

    public LeftZigZag(int x, int y, int position, Brilliant brilliant){
        super(x, y, position, brilliant);
        STANDART_SCHEMES = LEFT_ZIGZAG_SCHEMES;
        scheme = STANDART_SCHEMES[position];
    }
}
