package maxim.anatolevich.tetris.figures;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;

import maxim.anatolevich.tetris.Tetris;

/**
 * Created by maxim_anatolevich on 06.06.2016.
 */
public abstract class Figure{
    int position;
    public int x, y;
    public int[][] scheme;

    public int[][][] STANDART_SCHEMES;

    public static int VERTICAL = 0;
    public static int HORIZONTAL = 1;
    public static int DOWN = 2;
    public static int UP = 4;
    public static int LEFT = 8;
    public static int RIGHT = 16;
    public static int BLOCK_SIZE = 20;

    public long lastMoveTime;

    public Figure(int x, int y, int position){
        this.x = x;
        this.y = y;
        this.position = position;
        lastMoveTime = TimeUtils.nanoTime();
    }

    public void turn() {
        if(scheme != null) {
            position = (position + 1) % STANDART_SCHEMES.length;
            scheme = STANDART_SCHEMES[position];
        }
    }

    public void draw(SpriteBatch batch, Texture texture){
        for(int j = 0; j < scheme.length; j++){
            for(int i = 0; i < scheme[0].length; i++){
                if(scheme[j][i] == 1)
                    batch.draw(texture, Tetris.xOffset + (x + i) * BLOCK_SIZE, Tetris.yOffset + (27 - (y + j)) * BLOCK_SIZE);
            }
        }
    }

    public void left(){
        //correct moving to block from side
        if(--x <= 0)
            x = 0;
    }

    public void right(){
        //correct moving to block from side
        if((++x + scheme[0].length) >= 15)
            x = 15 - scheme[0].length;
    }

    public void down(){
        if ((++y + scheme.length) >= 27)
            y = 27 - scheme.length;
    }

    public boolean stop(int[][] gameField){
        if(y + scheme.length >= 27) {
            y--;
            return true;
        }
        for(int i = 0; i < scheme.length; i++)
            for(int j = 0; j < scheme[0].length; j++)
                if(scheme[i][j] == 1) {
                    if (gameField[y + i][x + j] == 1) {
                        y--;
                        return true;
                    }
                }
        return false;
    }
}
