package in.elango.tamillearning;

import java.util.Timer;
import java.util.TimerTask;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class SlateView extends View {

	
	public int width;
	public int height;
	private Bitmap mBitmap;
	private Canvas mCanvas;
	private Path mPath;
	private Paint mBitmapPaint;
	private Paint mPaint;
	Context context;
	private Paint circlePaint;
	private Path circlePath;

	private Paint textPaint;
	private Paint refreshPaint;

	float textFontSize;
	//Handler handler;
	//TimerTask task;
	//Timer timer;

	float screenWidth;
	float screenHeight;

	public SlateView(Context context) {
		super(context);
		context = context;
		init();

	}

	void init() {

		mPath = new Path();

		mPaint = new Paint();
		mPaint.setAntiAlias(true);
		mPaint.setDither(true);
		mPaint.setColor(Color.WHITE);
		mPaint.setStyle(Paint.Style.STROKE);
		mPaint.setStrokeJoin(Paint.Join.ROUND);
		mPaint.setStrokeCap(Paint.Cap.ROUND);
		mPaint.setStrokeWidth(12);

		textPaint = new Paint();
		textPaint.setAntiAlias(true);
		textPaint.setDither(true);
		textPaint.setColor(Color.GREEN);
		textPaint.setStyle(Paint.Style.STROKE);
		textPaint.setStrokeJoin(Paint.Join.ROUND);
		textPaint.setStrokeCap(Paint.Cap.ROUND);
		textPaint.setStrokeWidth(5);
		textFontSize = SlateActivity.getScreenWidth() / 2;
		textPaint.setTextSize(textFontSize);
		textPaint.setTypeface(SlateActivity.getTypeface());

		mBitmapPaint = new Paint(Paint.DITHER_FLAG);

		circlePaint = new Paint();
		circlePath = new Path();
		circlePaint.setAntiAlias(true);
		circlePaint.setColor(Color.BLUE);
		circlePaint.setStyle(Paint.Style.STROKE);
		circlePaint.setStrokeJoin(Paint.Join.MITER);
		circlePaint.setStrokeWidth(4f);

		/**
		 * task = new TimerTask() { public void run() {
		 * 
		 * //updateTime();
		 * 
		 * Message msg = new Message();
		 * 
		 * msg.obj = "Refresh"; handler.sendMessage(msg); }
		 * 
		 * }; timer = new Timer(); timer.schedule(task, 1000, 1000);
		 * 
		 * 
		 * handler = new Handler() {
		 * 
		 * @Override public void handleMessage(Message msg) { //String text =
		 *           (String)msg.obj; //call setText here
		 *           if(SlateActivity.increaseDecreaseAlphabetFlag){
		 *           localCanvas.drawColor(Color.BLACK);
		 * 
		 *           localCanvas.drawText(ReEncodeTamil.unicode2tsc(
		 *           SlateActivity.getAlphabet()),
		 *           SlateActivity.getScreenWidth()/2 - textFontSize /2,
		 *           SlateActivity.getScreenHeight()/2, textPaint);
		 *           SlateActivity.increaseDecreaseAlphabetFlag = !
		 *           SlateActivity.increaseDecreaseAlphabetFlag; mBitmap = null;
		 *           mBitmap =
		 *           Bitmap.createBitmap((int)SlateActivity.getScreenWidth(),
		 *           (int) SlateActivity.getScreenHeight(),
		 *           Bitmap.Config.ARGB_8888); mCanvas = null; mBitmapPaint =
		 *           null; mBitmapPaint = new Paint(Paint.DITHER_FLAG); mCanvas
		 *           = new Canvas(mBitmap); mCanvas.drawBitmap(mBitmap, 0, 0,
		 *           mBitmapPaint); invalidate();
		 * 
		 * 
		 *           }
		 * 
		 *           //Log.e("ELANGO", "CALLED");
		 * 
		 *           } };
		 */
	}

	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		super.onSizeChanged(w, h, oldw, oldh);
		if(mBitmap!=null){
			mBitmap.recycle();
		}
		mBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
		mCanvas = new Canvas(mBitmap);

	}
	
	Canvas localCanvas;

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		localCanvas = canvas;
		canvas.drawBitmap(mBitmap, 0, 0, mBitmapPaint);
		canvas.drawPath(mPath, mPaint);
		canvas.drawPath(circlePath, circlePaint);

		
		canvas.drawText(ReEncodeTamil.unicode2tsc(SlateActivity.getAlphabet()),
				SlateActivity.getScreenWidth() / 2 - textFontSize / 2,
				SlateActivity.getScreenHeight() / 4, textPaint);
		// ReEncodeTamil.unicode2tsc(SlateActivity.getTamilLetter())
	}

	private float mX, mY;
	private static final float TOUCH_TOLERANCE = 4;

	private void touch_start(float x, float y) {
		mPath.reset();
		mPath.moveTo(x, y);
		mX = x;
		mY = y;
	}

	private void touch_move(float x, float y) {
		float dx = Math.abs(x - mX);
		float dy = Math.abs(y - mY);
		if (dx >= TOUCH_TOLERANCE || dy >= TOUCH_TOLERANCE) {
			mPath.quadTo(mX, mY, (x + mX) / 2, (y + mY) / 2);
			mX = x;
			mY = y;

			circlePath.reset();
			circlePath.addCircle(mX, mY, 30, Path.Direction.CW);
		}
	}

	private void touch_up() {
		mPath.lineTo(mX, mY);
		circlePath.reset();
		// commit the path to our offscreen
		mCanvas.drawPath(mPath, mPaint);
		// kill this so we don't double draw
		mPath.reset();
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		float x = event.getX();
		float y = event.getY();

		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
			touch_start(x, y);
			invalidate();
			break;
		case MotionEvent.ACTION_MOVE:
			touch_move(x, y);
			invalidate();
			break;
		case MotionEvent.ACTION_UP:
			touch_up();
			invalidate();
			break;
		}
		return true;
	}

	public SlateView(Context context, AttributeSet attrs) {
		super(context, attrs);
		this.context = context;
		init();
	}

	public SlateView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		this.context = context;
		init();

	}
}