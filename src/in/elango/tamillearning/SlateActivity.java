package in.elango.tamillearning;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Typeface;

public class SlateActivity extends Activity {

	static MediaPlayer startMediaPlay = null;
	public static Context context;
	static public Integer[] audio_files = { R.raw.u1, R.raw.u2, R.raw.u3,
			R.raw.u4, R.raw.u5, R.raw.u6, R.raw.u7, R.raw.u8, R.raw.u9,
			R.raw.u10, R.raw.u11, R.raw.u12, R.raw.m1, R.raw.m2, R.raw.m3,
			R.raw.m4, R.raw.m5, R.raw.m6, R.raw.m7, R.raw.m8, R.raw.m9,
			R.raw.m10, R.raw.m11, R.raw.m12, R.raw.m13, R.raw.m14, R.raw.m15,
			R.raw.m16, R.raw.m17, R.raw.m18, R.raw.m1u1, R.raw.m2u1,
			R.raw.m3u1, R.raw.m4u1, R.raw.m5u1, R.raw.m6u1, R.raw.m7u1,
			R.raw.m8u1, R.raw.m9u1, R.raw.m10u1, R.raw.m11u1, R.raw.m12u1,
			R.raw.m13u1, R.raw.m14u1, R.raw.m15u1, R.raw.m16u1, R.raw.m17u1,
			R.raw.m18u1, R.raw.m1u2, R.raw.m2u2, R.raw.m3u2, R.raw.m4u2,
			R.raw.m5u2, R.raw.m6u2, R.raw.m7u2, R.raw.m8u2, R.raw.m9u2,
			R.raw.m10u2, R.raw.m11u2, R.raw.m12u2, R.raw.m13u2, R.raw.m14u2,
			R.raw.m15u2, R.raw.m16u2, R.raw.m17u2, R.raw.m18u2, R.raw.m1u3,
			R.raw.m2u3, R.raw.m3u3, R.raw.m4u3, R.raw.m5u3, R.raw.m6u3,
			R.raw.m7u3, R.raw.m8u3, R.raw.m9u3, R.raw.m10u3, R.raw.m11u3,
			R.raw.m12u3, R.raw.m13u3, R.raw.m14u3, R.raw.m15u3, R.raw.m16u3,
			R.raw.m17u3, R.raw.m18u3, R.raw.m1u4, R.raw.m2u4, R.raw.m3u4,
			R.raw.m4u4, R.raw.m5u4, R.raw.m6u4, R.raw.m7u4, R.raw.m8u4,
			R.raw.m9u4, R.raw.m10u4, R.raw.m11u4, R.raw.m12u4, R.raw.m13u4,
			R.raw.m14u4, R.raw.m15u4, R.raw.m16u4, R.raw.m17u4, R.raw.m18u4,
			R.raw.m1u5, R.raw.m2u5, R.raw.m3u5, R.raw.m4u5, R.raw.m5u5,
			R.raw.m6u5, R.raw.m7u5, R.raw.m8u5, R.raw.m9u5, R.raw.m10u5,
			R.raw.m11u5, R.raw.m12u5, R.raw.m13u5, R.raw.m14u5, R.raw.m15u5,
			R.raw.m16u5, R.raw.m17u5, R.raw.m18u5, R.raw.m1u6, R.raw.m2u6,
			R.raw.m3u6, R.raw.m4u6, R.raw.m5u6, R.raw.m6u6, R.raw.m7u6,
			R.raw.m8u6, R.raw.m9u6, R.raw.m10u6, R.raw.m11u6, R.raw.m12u6,
			R.raw.m13u6, R.raw.m14u6, R.raw.m15u6, R.raw.m16u6, R.raw.m17u6,
			R.raw.m18u6, R.raw.m1u7, R.raw.m2u7, R.raw.m3u7, R.raw.m4u7,
			R.raw.m5u7, R.raw.m6u7, R.raw.m7u7, R.raw.m8u7, R.raw.m9u7,
			R.raw.m10u7, R.raw.m11u7, R.raw.m12u7, R.raw.m13u7, R.raw.m14u7,
			R.raw.m15u7, R.raw.m16u7, R.raw.m17u7, R.raw.m18u7, R.raw.m1u8,
			R.raw.m2u8, R.raw.m3u8, R.raw.m4u8, R.raw.m5u8, R.raw.m6u8,
			R.raw.m7u8, R.raw.m8u8, R.raw.m9u8, R.raw.m10u8, R.raw.m11u8,
			R.raw.m12u8, R.raw.m13u8, R.raw.m14u8, R.raw.m15u8, R.raw.m16u8,
			R.raw.m17u8, R.raw.m18u8, R.raw.m1u9, R.raw.m2u9, R.raw.m3u9,
			R.raw.m4u9, R.raw.m5u9, R.raw.m6u9, R.raw.m7u9, R.raw.m8u9,
			R.raw.m9u9, R.raw.m10u9, R.raw.m11u9, R.raw.m12u9, R.raw.m13u9,
			R.raw.m14u9, R.raw.m15u9, R.raw.m16u9, R.raw.m17u9, R.raw.m18u9,
			R.raw.m1u10, R.raw.m2u10, R.raw.m3u10, R.raw.m4u10, R.raw.m5u10,
			R.raw.m6u10, R.raw.m7u10, R.raw.m8u10, R.raw.m9u10, R.raw.m10u10,
			R.raw.m11u10, R.raw.m12u10, R.raw.m13u10, R.raw.m14u10,
			R.raw.m15u10, R.raw.m16u10, R.raw.m17u10, R.raw.m18u10,
			R.raw.m1u11, R.raw.m2u11, R.raw.m3u11, R.raw.m4u11, R.raw.m5u11,
			R.raw.m6u11, R.raw.m7u11, R.raw.m8u11, R.raw.m9u11, R.raw.m10u11,
			R.raw.m11u11, R.raw.m12u11, R.raw.m13u11, R.raw.m14u11,
			R.raw.m15u11, R.raw.m16u11, R.raw.m17u11, R.raw.m18u11,
			R.raw.m1u12, R.raw.m2u12, R.raw.m3u12, R.raw.m4u12, R.raw.m5u12,
			R.raw.m6u12, R.raw.m7u12, R.raw.m8u12, R.raw.m9u12, R.raw.m10u12,
			R.raw.m11u12, R.raw.m12u12, R.raw.m13u12, R.raw.m14u12,
			R.raw.m15u12, R.raw.m16u12, R.raw.m17u12, R.raw.m18u12

	};

	Button previousButton;
	Button refreshButton;
	Button nextButton;

	private Paint mPaint;
	static Typeface typeface;
	Resources res;
	static String[] alphabetsArray = null;
	static String alphabet = null;
	static int alphabetItegerRef = 0;

	static boolean increaseDecreaseAlphabetFlag = false;

	public static float screenWidth;
	public static float screenHeight;

	public static float getScreenWidth() {

		return screenWidth;
	}

	public static float getScreenHeight() {

		return screenHeight;
	}

	public static Typeface getTypeface() {

		return typeface;
	}

	public static String[] getAlphabetArray() {
		return alphabetsArray;
	}

	public static String getAlphabet() {
		return alphabet;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);

		context = getBaseContext();
		res = getResources();

		DisplayMetrics metrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(metrics);
		screenWidth = metrics.widthPixels;
		screenHeight = metrics.heightPixels;

		typeface = Typeface.createFromAsset(this.getAssets(),
				"fonts/TSCu_Paranar.ttf");
		alphabetsArray = res.getStringArray(R.array.tamil_letters_array);
		alphabet = alphabetsArray[alphabetItegerRef];

		setContentView(R.layout.slate_view_layout);
		speakAlphabet();

		/**
		 * SlateView v = new SlateView(this); setContentView(v);
		 * 
		 * 
		 * res = getResources(); tamilLettersArray =
		 * res.getStringArray(R.array.tamil_letters_array);
		 * 
		 * 
		 * 
		 * // slate.setMinimumHeight(metrics.heightPixels/2);
		 */
		// View slate = (View) findViewById(R.id.slate_view);

		previousButton = (Button) findViewById(R.id.slate_previous_button_id);
		previousButton.setBackgroundColor(Color.GREEN);

		OnClickListener previousButtonOnClick = new OnClickListener() {
			public void onClick(View v) {
				decrementAlphabet();
				//increaseDecreaseAlphabetFlag = true;
				refreshSlateActivity();				

			}
		};
				
		previousButton.setOnClickListener(previousButtonOnClick);

		nextButton = (Button) findViewById(R.id.slate_next_button_id);
		nextButton.setBackgroundColor(Color.GREEN);

		OnClickListener nextButtonOnClick = new OnClickListener() {
			public void onClick(View v) {

				incrementAlphabet();
				//increaseDecreaseAlphabetFlag = true;
				refreshSlateActivity();
			}
		};
		nextButton.setOnClickListener(nextButtonOnClick);

		refreshButton = (Button) findViewById(R.id.slate_refresh_button_id);
		refreshButton.setBackgroundColor(Color.GREEN);

		OnClickListener refreshButtonOnClick = new OnClickListener() {
			public void onClick(View v) {

				refreshSlateActivity();
			}
		};
		refreshButton.setOnClickListener(refreshButtonOnClick);

	}

	public static void incrementAlphabet() {
		alphabetItegerRef = alphabetItegerRef + 1;

		if (alphabetItegerRef >= alphabetsArray.length - 1) {
			alphabetItegerRef = 0;
		}
		alphabet = alphabetsArray[alphabetItegerRef];
		//speakAlphabet();
		
	}

	public static void decrementAlphabet() {
		alphabetItegerRef = alphabetItegerRef - 1;

		if (alphabetItegerRef <= 0) {
			alphabetItegerRef = 0;
		}
		alphabet = alphabetsArray[alphabetItegerRef];
		//speakAlphabet();
	}

	private static void speakAlphabet() {
		releaseMediaPlayers();
		startMediaPlay = MediaPlayer.create(context,
				audio_files[alphabetItegerRef]);
		startMediaPlay.start();
	}
	protected static void releaseMediaPlayers() {
		if (startMediaPlay != null) {
			startMediaPlay.release();
			startMediaPlay = null;
		}

	}

	

	public void refreshSlateActivity() {
		finish();
		startActivity(getIntent());
	}
}