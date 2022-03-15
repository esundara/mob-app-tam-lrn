package in.elango.tamillearning;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class PuzzleView extends View {

	static int widthSlices = 3;
	static int heightSlices = 3;
	static int[][] bmpPointsCalculated = new int[widthSlices * heightSlices][4];
	static int[][] drawingViewPointsCalculated = new int[widthSlices
			* heightSlices][4];
	static int[] currentOrder = new int[widthSlices * heightSlices];
	boolean initialized = false;

	static int viewWidth;
	static int viewHeight;
	static Bitmap bmp;
	static Bitmap winnerBitmap;
	static Paint paintRectangleBox;
	private Handler handler;

	static Canvas thisCanvas;

	boolean puzzleInOrder = false;

	int touchStart_X = 0;
	int touchStart_Y = 0;
	int touchEnd_X = 0;
	int touchEnd_Y = 0;

	static int startLocationFound = 0;
	static int endLocationFound = 0;

	List<Point> points = new ArrayList<Point>();
	Paint paint = new Paint();

	public PuzzleView(Context context) {

		super(context);

	}

	@Override
	protected void onSizeChanged(int newW, int newH, int oldw, int oldh) {
		super.onSizeChanged(newW, newH, oldw, oldh);

		if (bmp != null) {
			bmp.recycle();
		}
		viewWidth = newW;
		viewHeight = newH;

		bmp = BitmapFactory.decodeResource(getResources(),
				PuzzleActivity.displayImages[PuzzleActivity.imageNumber]);

	}

	@Override
	protected void onDraw(Canvas canvas) {

		super.onDraw(canvas);

		
		if (!initialized) {

			for (int counter = 0; counter < heightSlices * widthSlices; counter++) {
				currentOrder[counter] = counter;

			}

			final Runnable runnable = new Runnable() {
				public void run() {
					try {
						shuffleArray(currentOrder);
						invalidate();
					} catch (Exception e) {

					}

				}
			};
			handler = new Handler();
			handler.postDelayed(runnable, 3000);

			initialized = true;
		}

		// shuffleArray(currentOrder);
		// bmp =
		// BitmapFactory.decodeResource(getResources(),PuzzleActivity.displayImages[PuzzleActivity.imageNumber]);
		// super.onDraw(canvas);
		thisCanvas = canvas;

		paintRectangleBox = new Paint();
		paintRectangleBox.setColor(Color.RED);
		paintRectangleBox.setStrokeWidth(2);

		int xSliceBMP = bmp.getWidth() / widthSlices;
		int ySliceBMP = bmp.getHeight() / heightSlices;

		int xSliceView = viewWidth / widthSlices;
		int ySliceView = viewHeight / heightSlices;

		int item = 0;

		for (int y = 0; y < heightSlices; y++) {

			for (int x = 0; x < widthSlices; x++) {
				bmpPointsCalculated[item][0] = xSliceBMP * x;
				bmpPointsCalculated[item][1] = ySliceBMP * y;
				bmpPointsCalculated[item][2] = xSliceBMP * (x + 1);
				bmpPointsCalculated[item][3] = ySliceBMP * (y + 1);

				drawingViewPointsCalculated[item][0] = xSliceView * x;
				drawingViewPointsCalculated[item][1] = ySliceView * y;
				drawingViewPointsCalculated[item][2] = xSliceView * (x + 1);
				drawingViewPointsCalculated[item][3] = ySliceView * (y + 1);
				//Log.e("Elango", "POPULATE ITEM" + item);
				item++;
			}
		}

		for (int displayItem = 0; displayItem < heightSlices * widthSlices; displayItem++) {
			//Log.e("Elango", "DRAWING ON  LOCATION" + currentOrder[displayItem]);

			// DRAWING BOXES
			if (!puzzleInOrder) {

				thisCanvas.drawRect(new Rect(
						drawingViewPointsCalculated[displayItem][0] - 1,
						drawingViewPointsCalculated[displayItem][1] - 1,
						drawingViewPointsCalculated[displayItem][2] - 1,
						drawingViewPointsCalculated[displayItem][3] - 1),
						paintRectangleBox);
			} else {
				PuzzleActivity.playCompletionTouchedSound();
			}

			thisCanvas.drawBitmap(bmp, new Rect(
					bmpPointsCalculated[currentOrder[displayItem]][0],
					bmpPointsCalculated[currentOrder[displayItem]][1],
					bmpPointsCalculated[currentOrder[displayItem]][2],
					bmpPointsCalculated[currentOrder[displayItem]][3]),
					new Rect(drawingViewPointsCalculated[displayItem][0],
							drawingViewPointsCalculated[displayItem][1],
							drawingViewPointsCalculated[displayItem][2],
							drawingViewPointsCalculated[displayItem][3]),
					paintRectangleBox);
		}

	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {

		super.onTouchEvent(event);

		float x = event.getX();
		float y = event.getY();

		switch (event.getAction()) {

		case MotionEvent.ACTION_DOWN:
			touchStart_X = (int) x;
			touchStart_Y = (int) y;
			break;

		case MotionEvent.ACTION_UP:
			touchEnd_X = (int) x;
			touchEnd_Y = (int) y;
			findTouchLocation();
			invalidate();
			break;

		}

		return true;

	}
	

	private void findTouchLocation() {

		startLocationFound = 0;
		endLocationFound = 0;
		for (int counter = 0; counter < heightSlices * widthSlices; counter++) {
			if (touchStart_X > drawingViewPointsCalculated[counter][0]
					&& touchStart_X < drawingViewPointsCalculated[counter][2]
					&& touchStart_Y > drawingViewPointsCalculated[counter][1]
					&& touchStart_Y < drawingViewPointsCalculated[counter][3]) {

				startLocationFound = counter;
				//Log.e("Elango", "START  LOCATION" + startLocationFound);

			}
			if (touchEnd_X > drawingViewPointsCalculated[counter][0]
					&& touchEnd_X < drawingViewPointsCalculated[counter][2]
					&& touchEnd_Y > drawingViewPointsCalculated[counter][1]
					&& touchEnd_Y < drawingViewPointsCalculated[counter][3]) {

				endLocationFound = counter;
				//Log.e("Elango", "END  LOCATION" + endLocationFound);

			}
		}

		int temp = currentOrder[startLocationFound];
		currentOrder[startLocationFound] = currentOrder[endLocationFound];
		currentOrder[endLocationFound] = temp;
		/**
		 * - // switch start and end orders for (int counter = 0; counter <
		 * heightSlices * widthSlices; counter++) { if (currentOrder[counter] ==
		 * startLocationFound) { currentOrder[counter] = endLocationFound; }
		 * else if (currentOrder[counter] == endLocationFound) {
		 * currentOrder[counter] = startLocationFound;
		 * 
		 * }
		 * 
		 * }
		 */

		int previousItem = 0;
		// check Order
		// miss the 1
		for (int counter = 1; counter < heightSlices * widthSlices; counter++) {
			if (currentOrder[counter] > previousItem) {
				previousItem = currentOrder[counter];
				puzzleInOrder = true;
				
			} else {
				puzzleInOrder = false;
				break;
			}
		}

		if (puzzleInOrder== true ){
			//Game OVER HERE
			//winnerBitmap = BitmapFactory.decodeResource(getResources(),R.drawable.puzzle_winner);
			//thisCanvas.drawBitmap(winnerBitmap,null, new Rect(0, 0, viewWidth, (int) viewHeight  ),paint);
			
		}
		// play a tiuch sound
		PuzzleActivity.playPuzzleTouchedSound();

	}

	private void shuffleArray(int[] array) {
		int index;
		Random random = new Random();
		for (int i = array.length - 1; i > 0; i--) {
			index = random.nextInt(i + 1);
			if (index != i) {
				array[index] ^= array[i];
				array[i] ^= array[index];
				array[index] ^= array[i];
			}
		}
	}

	public PuzzleView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// this.context = context;
	}

	public PuzzleView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// this.context = context;

	}

	class Point {
		float x, y;

		@Override
		public String toString() {
			return x + ", " + y;
		}
	}

}