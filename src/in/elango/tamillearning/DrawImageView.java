package in.elango.tamillearning;


import java.util.ArrayList;
import java.util.List;
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

public class DrawImageView extends ImageView {
	
	static int viewWidth;
	static int viewHeight;
	
	List<Point> points = new ArrayList<Point>();
    Paint paint = new Paint();
    Bitmap bmp;
    
	public DrawImageView(Context context) {
		super(context);
		 //bmp = BitmapFactory.decodeResource(getResources(), Song.displayImages[Song.imageNumber]);
	
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		//this.setImageBitmap(R.id.slate_next_button_id);

        super.onDraw(canvas);
        
        Paint paintTopArea = new Paint();
		paintTopArea.setColor(Color.BLACK);
        Bitmap bmp = BitmapFactory.decodeResource(getResources(), Song.displayImages[Song.imageNumber]);
		//canvas.drawBitmap(bmp,null, new Rect(0, 0, Song.screenWidth, (int) (Song.screenHeight * 0.5) ),paintTopArea);
		canvas.drawBitmap(bmp,null, new Rect(0, 0, viewWidth, (int) viewHeight  ),paintTopArea);
        
        paint.setColor(Color.GREEN);
		for (Point point : points) {
            canvas.drawCircle(point.x, point.y, 9, paint);
            // Log.d(TAG, "Painting: "+point);
        };
		
	}

	
	@Override
	protected void onSizeChanged(int newW, int newH, int oldw, int oldh) {
		super.onSizeChanged(newW, newH, oldw, oldh);
		viewWidth = newW;
		viewHeight = newH;

	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		
		super.onTouchEvent(event);
        Point point = new Point();
        point.x = event.getX();
        point.y = event.getY();
        points.add(point);
        invalidate();
        return true;
		
	}
	

	public DrawImageView(Context context, AttributeSet attrs) {
		super(context, attrs);
		//this.context = context;
	}

	public DrawImageView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		//this.context = context;

		
	}
	
	 class Point {
	        float x, y;
	        @Override
	        public String toString() {
	            return x + ", " + y;
	        }
	    }
	 
	 
	 
}