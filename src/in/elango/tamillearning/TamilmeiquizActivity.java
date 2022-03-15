package in.elango.tamillearning;

import android.app.Activity;


import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;


public class TamilmeiquizActivity extends Activity {

	Resources res;
	int gamePoints = 0;
	String timeText = null;
	String pointsText = null;
	Button pointButton = null;
	Typeface typeface = null;
	String POINTS_TEXT = null;
	String TIME_REMAINING = null;
	
	Context con= null;


	Button questionButton = null;
	Button answerButton_1 = null;
	Button answerButton_2 = null;
	Button answerButton_3 = null;
	Button answerButton_4 = null;


	int screenHeight = 0;
	int screenWidth = 0;
	int heightMultiple = 0;
	int widthMultiple = 0;
	CountDownTimer countDown;
	int pointsTextFontSize = 0;
	int buttonsTextFontSize = 0;
		
	MediaPlayer mediaPlay = null;
	
	int randomNumUirMeiReference;
	final Handler handler = new Handler();
	
	
	public Integer[] audio_files = { 
			R.raw.u1,
			R.raw.u2,
			R.raw.u3,
			R.raw.u4,
			R.raw.u5,
			R.raw.u6,
			R.raw.u7,
			R.raw.u8,
			R.raw.u9,
			R.raw.u10,
			R.raw.u11,
			R.raw.u12,
			R.raw.m1,
			R.raw.m2,
			R.raw.m3,
			R.raw.m4,
			R.raw.m5,
			R.raw.m6,
			R.raw.m7,
			R.raw.m8,
			R.raw.m9,
			R.raw.m10,
			R.raw.m11,
			R.raw.m12,
			R.raw.m13,
			R.raw.m14,
			R.raw.m15,
			R.raw.m16,
			R.raw.m17,
			R.raw.m18,
			R.raw.m1u1,
			R.raw.m2u1,
			R.raw.m3u1,
			R.raw.m4u1,
			R.raw.m5u1,
			R.raw.m6u1,
			R.raw.m7u1,
			R.raw.m8u1,
			R.raw.m9u1,
			R.raw.m10u1,
			R.raw.m11u1,
			R.raw.m12u1,
			R.raw.m13u1,
			R.raw.m14u1,
			R.raw.m15u1,
			R.raw.m16u1,
			R.raw.m17u1,
			R.raw.m18u1,
			R.raw.m1u2,
			R.raw.m2u2,
			R.raw.m3u2,
			R.raw.m4u2,
			R.raw.m5u2,
			R.raw.m6u2,
			R.raw.m7u2,
			R.raw.m8u2,
			R.raw.m9u2,
			R.raw.m10u2,
			R.raw.m11u2,
			R.raw.m12u2,
			R.raw.m13u2,
			R.raw.m14u2,
			R.raw.m15u2,
			R.raw.m16u2,
			R.raw.m17u2,
			R.raw.m18u2,
			R.raw.m1u3,
			R.raw.m2u3,
			R.raw.m3u3,
			R.raw.m4u3,
			R.raw.m5u3,
			R.raw.m6u3,
			R.raw.m7u3,
			R.raw.m8u3,
			R.raw.m9u3,
			R.raw.m10u3,
			R.raw.m11u3,
			R.raw.m12u3,
			R.raw.m13u3,
			R.raw.m14u3,
			R.raw.m15u3,
			R.raw.m16u3,
			R.raw.m17u3,
			R.raw.m18u3,
			R.raw.m1u4,
			R.raw.m2u4,
			R.raw.m3u4,
			R.raw.m4u4,
			R.raw.m5u4,
			R.raw.m6u4,
			R.raw.m7u4,
			R.raw.m8u4,
			R.raw.m9u4,
			R.raw.m10u4,
			R.raw.m11u4,
			R.raw.m12u4,
			R.raw.m13u4,
			R.raw.m14u4,
			R.raw.m15u4,
			R.raw.m16u4,
			R.raw.m17u4,
			R.raw.m18u4,
			R.raw.m1u5,
			R.raw.m2u5,
			R.raw.m3u5,
			R.raw.m4u5,
			R.raw.m5u5,
			R.raw.m6u5,
			R.raw.m7u5,
			R.raw.m8u5,
			R.raw.m9u5,
			R.raw.m10u5,
			R.raw.m11u5,
			R.raw.m12u5,
			R.raw.m13u5,
			R.raw.m14u5,
			R.raw.m15u5,
			R.raw.m16u5,
			R.raw.m17u5,
			R.raw.m18u5,
			R.raw.m1u6,
			R.raw.m2u6,
			R.raw.m3u6,
			R.raw.m4u6,
			R.raw.m5u6,
			R.raw.m6u6,
			R.raw.m7u6,
			R.raw.m8u6,
			R.raw.m9u6,
			R.raw.m10u6,
			R.raw.m11u6,
			R.raw.m12u6,
			R.raw.m13u6,
			R.raw.m14u6,
			R.raw.m15u6,
			R.raw.m16u6,
			R.raw.m17u6,
			R.raw.m18u6,
			R.raw.m1u7,
			R.raw.m2u7,
			R.raw.m3u7,
			R.raw.m4u7,
			R.raw.m5u7,
			R.raw.m6u7,
			R.raw.m7u7,
			R.raw.m8u7,
			R.raw.m9u7,
			R.raw.m10u7,
			R.raw.m11u7,
			R.raw.m12u7,
			R.raw.m13u7,
			R.raw.m14u7,
			R.raw.m15u7,
			R.raw.m16u7,
			R.raw.m17u7,
			R.raw.m18u7,
			R.raw.m1u8,
			R.raw.m2u8,
			R.raw.m3u8,
			R.raw.m4u8,
			R.raw.m5u8,
			R.raw.m6u8,
			R.raw.m7u8,
			R.raw.m8u8,
			R.raw.m9u8,
			R.raw.m10u8,
			R.raw.m11u8,
			R.raw.m12u8,
			R.raw.m13u8,
			R.raw.m14u8,
			R.raw.m15u8,
			R.raw.m16u8,
			R.raw.m17u8,
			R.raw.m18u8,
			R.raw.m1u9,
			R.raw.m2u9,
			R.raw.m3u9,
			R.raw.m4u9,
			R.raw.m5u9,
			R.raw.m6u9,
			R.raw.m7u9,
			R.raw.m8u9,
			R.raw.m9u9,
			R.raw.m10u9,
			R.raw.m11u9,
			R.raw.m12u9,
			R.raw.m13u9,
			R.raw.m14u9,
			R.raw.m15u9,
			R.raw.m16u9,
			R.raw.m17u9,
			R.raw.m18u9,
			R.raw.m1u10,
			R.raw.m2u10,
			R.raw.m3u10,
			R.raw.m4u10,
			R.raw.m5u10,
			R.raw.m6u10,
			R.raw.m7u10,
			R.raw.m8u10,
			R.raw.m9u10,
			R.raw.m10u10,
			R.raw.m11u10,
			R.raw.m12u10,
			R.raw.m13u10,
			R.raw.m14u10,
			R.raw.m15u10,
			R.raw.m16u10,
			R.raw.m17u10,
			R.raw.m18u10,
			R.raw.m1u11,
			R.raw.m2u11,
			R.raw.m3u11,
			R.raw.m4u11,
			R.raw.m5u11,
			R.raw.m6u11,
			R.raw.m7u11,
			R.raw.m8u11,
			R.raw.m9u11,
			R.raw.m10u11,
			R.raw.m11u11,
			R.raw.m12u11,
			R.raw.m13u11,
			R.raw.m14u11,
			R.raw.m15u11,
			R.raw.m16u11,
			R.raw.m17u11,
			R.raw.m18u11,
			R.raw.m1u12,
			R.raw.m2u12,
			R.raw.m3u12,
			R.raw.m4u12,
			R.raw.m5u12,
			R.raw.m6u12,
			R.raw.m7u12,
			R.raw.m8u12,
			R.raw.m9u12,
			R.raw.m10u12,
			R.raw.m11u12,
			R.raw.m12u12,
			R.raw.m13u12,
			R.raw.m14u12,
			R.raw.m15u12,
			R.raw.m16u12,
			R.raw.m17u12,
			R.raw.m18u12


	};
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.tamiluirmeilayout);
		
		setVolumeControlStream(AudioManager.STREAM_MUSIC);
		//Remove title bar
		//this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		initializeSettings();
		initDisplay();
		initTamilQuizLetter();
		initRefreshDisplayText();
		releaseMediaPlayers();
		mediaPlay = MediaPlayer.create(this, R.raw.background_score);
		//mediaPlay.setLooping(true);
		mediaPlay.start();
		
		
		   		// count down for 100 seconds
		// Interval of 2 second
		

	}

	void initDisplay() {

		pointButton = (Button) findViewById(R.id.pointsbutton);

		pointButton.setHeight(heightMultiple);
		pointButton.setTypeface(typeface);
		pointButton.setTextSize(pointsTextFontSize );
		pointsText = getString(R.string.points);

		pointsText = ReEncodeTamil.unicode2tsc(POINTS_TEXT) + " " + gamePoints;

		// pointsText = ReEncodeTamil.convertBaminiTamilString(pointsText);
		// pointsText = ReEncodeTamil.unicode2tsc(pointsText + " " + gamePoints
		// + timeText);
		// pointButton.setText(pointsText);
		pointButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// Do something in response to button click
			}
		});

		// ==============================================
		questionButton = (Button) findViewById(R.id.questionbutton);
		questionButton.setHeight(heightMultiple * 2);
		questionButton.setTypeface(typeface);
		questionButton.setTextSize(pointsTextFontSize );

		questionButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// Do something in response to button click
				
				releaseMediaPlayers();
				mediaPlay = MediaPlayer.create(getBaseContext(),audio_files[randomNumUirMeiReference]);
				mediaPlay.start();
			}
		});

		// ==============================================

		answerButton_1 = (Button) findViewById(R.id.answerbutton_1);
		answerButton_1.setHeight(heightMultiple);
		answerButton_1.setTextSize(buttonsTextFontSize );
		ViewGroup.LayoutParams answerButton_1_params = answerButton_1
				.getLayoutParams();
		answerButton_1_params.width = widthMultiple;
		answerButton_1.setLayoutParams(answerButton_1_params);
		answerButton_1.setTypeface(typeface);

		answerButton_1.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// Do something in response to button click
						
				//Log.e("Elango", "Button 1 clicked");
				if (TamilLetters.getQuizOptions()[0].equals(TamilLetters
						.getUriMeiLetter())) {
					//Log.e("Elango", "Answer 1 Correct");
					playSuccessSound();
					refreshTamilQuizLetter();

				} else {
					answerButton_1.setBackgroundColor(Color
							.parseColor("#ff0000"));
				}
			}
		});

		// ==============================================

		answerButton_2 = (Button) findViewById(R.id.answerbutton_2);
		answerButton_2.setHeight(heightMultiple);
		answerButton_2.setTextSize(buttonsTextFontSize );

		ViewGroup.LayoutParams answerButton_2_params = answerButton_2
				.getLayoutParams();
		answerButton_2_params.width = widthMultiple;
		answerButton_2.setLayoutParams(answerButton_2_params);
		answerButton_2.setTypeface(typeface);
		answerButton_2.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				//Log.e("Elango", "Button 2 clicked");
				if (TamilLetters.getQuizOptions()[1].equals(TamilLetters
						.getUriMeiLetter())) {
					//Log.e("Elango", "Answer 2 Correct");
					playSuccessSound();

					refreshTamilQuizLetter();
					

				} else {
					answerButton_2.setBackgroundColor(Color
							.parseColor("#ff0000"));
				}

			}
		});

		// ==============================================

		answerButton_3 = (Button) findViewById(R.id.answerbutton_3);
		answerButton_3.setHeight(heightMultiple);
		answerButton_3.setTextSize(buttonsTextFontSize );

		ViewGroup.LayoutParams answerButton_3_params = answerButton_3
				.getLayoutParams();
		answerButton_3_params.width = widthMultiple;
		answerButton_3.setLayoutParams(answerButton_3_params);
		answerButton_3.setTypeface(typeface);
		answerButton_3.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				//Log.e("Elango", "Button 3 clicked");
				if (TamilLetters.getQuizOptions()[2].equals(TamilLetters
						.getUriMeiLetter())) {
					//Log.e("Elango", "Answer 3 Correct");
					playSuccessSound();
					refreshTamilQuizLetter();
				} else {
					answerButton_3.setBackgroundColor(Color
							.parseColor("#ff0000"));
				}
			}
		});

		// ==============================================

		answerButton_4 = (Button) findViewById(R.id.answerbutton_4);
		answerButton_4.setHeight(heightMultiple);
		answerButton_4.setTextSize(buttonsTextFontSize );

		ViewGroup.LayoutParams answerButton_4_params = answerButton_4
				.getLayoutParams();
		answerButton_4_params.width = widthMultiple;
		answerButton_4.setLayoutParams(answerButton_4_params);
		answerButton_4.setTypeface(typeface);
		answerButton_4.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				//Log.e("Elango", "Button 4 clicked");
				if (TamilLetters.getQuizOptions()[3].equals(TamilLetters
						.getUriMeiLetter())) {
					//Log.e("Elango", "Answer 4 Correct");
					playSuccessSound();
					refreshTamilQuizLetter();
				} else {
					answerButton_4.setBackgroundColor(Color
							.parseColor("#ff0000"));
				}
			}
		});

		// ==============================================

	}

	void initializeSettings() {

		DisplayMetrics metrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(metrics);
		
		con = this.getBaseContext();
		this.screenHeight = metrics.heightPixels;
		this.screenWidth = metrics.widthPixels;
		heightMultiple = screenHeight / 7;
		widthMultiple = screenWidth / 2;

		//pointsTextFontSize  = screenWidth / 15;
		pointsTextFontSize  = screenWidth / 18;
		
		buttonsTextFontSize = screenWidth /15;
		
		//Log.e("Elango", "pointsTextFontSize   " + pointsTextFontSize  );
		// Lets make Heighyt divisions by Nine
		res = getResources();

		POINTS_TEXT = res.getString(R.string.points);

		/**
		 * TIME_REMAINING = res.getString(R.string.time_remaining);
		 * WANT_TO_CONTINUE = res.getString(R.string.WantToContinue);
		 * CONTINUE_YES = res.getString(R.string.ContinueYES); CONTINUE_NO =
		 * res.getString(R.string.ContinueNO);
		 */

		typeface = Typeface.createFromAsset(this.getAssets(),
				"fonts/TSCu_Paranar.ttf");

		String[] tamilLettersArray = res
				.getStringArray(R.array.tamil_letters_array);
		String[] tamilLetterReferencesArray = res
				.getStringArray(R.array.tamil_letters_name_reference_array);
		TamilLetters.tamilLettersArray = tamilLettersArray;
		TamilLetters.tamilLetterReferencesArray = tamilLetterReferencesArray;
	}

	private void initTamilQuizLetter() {
		TamilLetters tamilLetter = TamilLetters.getTamilLetters();
		tamilLetter.initializeAndRefresh();
		randomNumUirMeiReference = tamilLetter.getActiveUirMeiReference();
	}
	private void refreshTamilQuizLetter() {
		
		handler.postDelayed(new Runnable() {

			public void run() {
				// Do something after 5s = 5000ms
				gamePoints = gamePoints + 1;
				TamilLetters tamilLetter = TamilLetters.getTamilLetters();
				tamilLetter.initializeAndRefresh();
				randomNumUirMeiReference = tamilLetter.getActiveUirMeiReference();
				initRefreshDisplayText();
				
			}
		}, 4000);
		
	}

	void initRefreshDisplayText() {

		pointButton.setBackgroundColor(Color.parseColor("#32cd32"));

		pointButton.setText(ReEncodeTamil.unicode2tsc(POINTS_TEXT) + " "
				+ gamePoints);

		questionButton.setText(ReEncodeTamil.unicode2tsc(TamilLetters
				.getUirPart())
				+ " + "
				+ ReEncodeTamil.unicode2tsc(TamilLetters.getMeiPart())
				+ " = ? ");
		questionButton.setTextColor(Color.BLACK);
		
		answerButton_1.setBackgroundColor(Color.parseColor("#00ffff"));
		

		answerButton_1.setText(ReEncodeTamil.unicode2tsc(TamilLetters
				.getQuizOptions()[0]));
		
		//Log.e("Elango", "0=  " + TamilLetters.getQuizOptions()[0] );

		answerButton_2.setBackgroundColor(Color.parseColor("#dda0dd"));
		answerButton_2.setText(ReEncodeTamil.unicode2tsc(TamilLetters
				.getQuizOptions()[1]));
		
		//Log.e("Elango", "1=  " + TamilLetters.getQuizOptions()[1] );
		
		answerButton_3.setBackgroundColor(Color.parseColor("#a020f0"));
		answerButton_3.setText(ReEncodeTamil.unicode2tsc(TamilLetters
				.getQuizOptions()[2]));
		//Log.e("Elango", "2=  " + TamilLetters.getQuizOptions()[2] );
		answerButton_4.setBackgroundColor(Color.parseColor("#0000cd"));

		answerButton_4.setText(ReEncodeTamil.unicode2tsc(TamilLetters
				.getQuizOptions()[3]));
		
		//Log.e("Elango", "3=  " + TamilLetters.getQuizOptions()[3] );

	}

	
	protected void releaseMediaPlayers() {
		if (mediaPlay != null) {
			mediaPlay.stop();
			mediaPlay.release();
			mediaPlay = null;
		}

	}
	
	protected void onStop(){
		super.onStop();
		releaseMediaPlayers();

		
	}
	
	private void playSuccessSound() {
		releaseMediaPlayers();
		mediaPlay = MediaPlayer.create(this, R.raw.clap_short);
		mediaPlay.start();
		
		
		
		//final String speaksuccess= "That is Correct . The letter is "+ spriteCharacter + " . Now find the next letter ";
		
		mediaPlay.setOnCompletionListener(new OnCompletionListener() {
			public void onCompletion(MediaPlayer mp) {
				releaseMediaPlayers();
				mediaPlay = MediaPlayer.create(con,audio_files[randomNumUirMeiReference]);
				mediaPlay.start();
			}
		});
		
	}
	
}