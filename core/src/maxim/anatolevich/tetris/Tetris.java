package maxim.anatolevich.tetris;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;

import maxim.anatolevich.tetris.creators.FigureCreator;
import maxim.anatolevich.tetris.creators.LeftHorseCreator;
import maxim.anatolevich.tetris.creators.LeftZigZagCreator;
import maxim.anatolevich.tetris.creators.LineCreator;
import maxim.anatolevich.tetris.creators.RightHorseCreator;
import maxim.anatolevich.tetris.creators.RightZigZagCreator;
import maxim.anatolevich.tetris.creators.SquareCreator;
import maxim.anatolevich.tetris.figures.Brilliant;
import maxim.anatolevich.tetris.figures.Figure;
import maxim.anatolevich.tetris.figures.Line;

public class Tetris extends ApplicationAdapter {
	public static int xOffset = 25;
	public static int yOffset = 40;

	long moveInterval = 350000000;
	Array<FigureCreator> figureCreatorList;
	SpriteBatch batch;
	Array<Texture> textureList;
	Texture bg;
	Figure activeFigure;
	Figure nextFigure;
	GameField gameField;
	int score;
	Label scoreLabel;
	@Override
	public void create () {
		batch = new SpriteBatch();
		bg = new Texture("bg.jpg");

		textureList = new Array<Texture>();
		textureList.add(new Texture("yellow_brilliant.png"));
		textureList.add(new Texture("purple_brilliant.png"));
		textureList.add(new Texture("blue_brilliant.png"));
		textureList.add(new Texture("green_brilliant.png"));

		formFigureCreatorList();
		nextFigure = createFigure();
		activeFigure = createFigure();
		activeFigure.x = 6;
		activeFigure.y = 0;
		gameField = new GameField(this);

		score = 0;
		scoreLabel = new Label("Score:\n" + score, new Label.LabelStyle(new BitmapFont(true), Color.BLUE));
		scoreLabel.setX(400);
		scoreLabel.setY(270);
	}

	public void changeMoveInterval(){
		moveInterval -= score;
	}

	public void changeScore(int dScore){
		score += dScore;
	}

	private void formFigureCreatorList(){
		figureCreatorList = new Array<FigureCreator>();
		figureCreatorList.add(new LineCreator());
		figureCreatorList.add(new SquareCreator());
		figureCreatorList.add(new LeftZigZagCreator());
		figureCreatorList.add(new RightZigZagCreator());
		figureCreatorList.add(new LeftHorseCreator());
		figureCreatorList.add(new RightHorseCreator());
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 1, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		if(activeFigure.stop(gameField)){
			nextFigure.x = 6;
			nextFigure.y = 0;
			gameField.printFigureOnGameField(activeFigure);
			activeFigure = nextFigure;
			nextFigure = createFigure();
		}
		else {
			if (TimeUtils.nanoTime() - activeFigure.lastMoveTime >= moveInterval) {
				activeFigure.down();
				activeFigure.lastMoveTime = TimeUtils.nanoTime();
			}
		}

		scoreLabel.setText("Score:\n" + score);

		batch.begin();
			batch.draw(bg, 0, 0);
			gameField.drawGameField(batch);
			activeFigure.draw(batch);
			nextFigure.draw(batch);
			scoreLabel.draw(batch, 1);
		batch.end();

		if(Gdx.input.isKeyJustPressed(Input.Keys.UP))
			activeFigure.turn();

		if(Gdx.input.isKeyJustPressed(Input.Keys.LEFT))
			activeFigure.left();

		if(Gdx.input.isKeyJustPressed(Input.Keys.RIGHT))
			activeFigure.right();

		if(Gdx.input.isKeyJustPressed(Input.Keys.DOWN))
			activeFigure.down();

		if(endGame())
			System.exit(0);

		gameField.deleteFullLines();
	}

	public boolean endGame(){
		for(int i = 0; i < gameField.field[0].length; i++)
			if(gameField.field[0][i] != null)
				return true;
		return false;
	}

	public Figure createFigure(){
		int startX = 20;
		int startY = 2;
		Brilliant brilliant = new Brilliant(textureList.get(MathUtils.random(textureList.size - 1)));
		return figureCreatorList.get(MathUtils.random(figureCreatorList.size - 1)).createFigure(startX, startY, brilliant);
	}
}
