package in.elango.tamillearning;

import java.util.Arrays;
import java.util.Random;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.Toast;

public class NyabagaGameActivity extends Activity {

	Resources res;
	int gamePoints = 0;
	int screenHeight = 0;
	int screenWidth = 0;
	int heightMultiple = 0;
	int widthMultiple = 0;
	int pointsTextFontSize = 0;
	int buttonsTextFontSize = 0;

	String pointsText = null;

	Typeface typeface = null;

	Button pointsButton = null;
	Button headerButton = null;
	Button footerButton = null;
	Button questionButton = null;
	Button answerButton_1 = null;
	Button answerButton_2 = null;
	Button answerButton_3 = null;
	Button answerButton_4 = null;
	Button answerButton_5 = null;
	Button answerButton_6 = null;
	Button answerButton_7 = null;
	Button answerButton_8 = null;
	Button answerButton_9 = null;
	Button answerButton_10 = null;
	Button answerButton_11 = null;
	Button answerButton_12 = null;

	int randomLetter;
	int randomLetterNumberReferenceInArray;

	String[] tamilLettersArray = null;
	int[] quizLettersArray = new int[12];

	MediaPlayer mediaPlay = null;

	public Integer[] audio_files = { R.raw.u1, R.raw.u2, R.raw.u3, R.raw.u4,
			R.raw.u5, R.raw.u6, R.raw.u7, R.raw.u8, R.raw.u9, R.raw.u10,
			R.raw.u11, R.raw.u12, R.raw.m1, R.raw.m2, R.raw.m3, R.raw.m4,
			R.raw.m5, R.raw.m6, R.raw.m7, R.raw.m8, R.raw.m9, R.raw.m10,
			R.raw.m11, R.raw.m12, R.raw.m13, R.raw.m14, R.raw.m15, R.raw.m16,
			R.raw.m17, R.raw.m18, R.raw.m1u1, R.raw.m2u1, R.raw.m3u1,
			R.raw.m4u1, R.raw.m5u1, R.raw.m6u1, R.raw.m7u1, R.raw.m8u1,
			R.raw.m9u1, R.raw.m10u1, R.raw.m11u1, R.raw.m12u1, R.raw.m13u1,
			R.raw.m14u1, R.raw.m15u1, R.raw.m16u1, R.raw.m17u1, R.raw.m18u1,
			R.raw.m1u2, R.raw.m2u2, R.raw.m3u2, R.raw.m4u2, R.raw.m5u2,
			R.raw.m6u2, R.raw.m7u2, R.raw.m8u2, R.raw.m9u2, R.raw.m10u2,
			R.raw.m11u2, R.raw.m12u2, R.raw.m13u2, R.raw.m14u2, R.raw.m15u2,
			R.raw.m16u2, R.raw.m17u2, R.raw.m18u2, R.raw.m1u3, R.raw.m2u3,
			R.raw.m3u3, R.raw.m4u3, R.raw.m5u3, R.raw.m6u3, R.raw.m7u3,
			R.raw.m8u3, R.raw.m9u3, R.raw.m10u3, R.raw.m11u3, R.raw.m12u3,
			R.raw.m13u3, R.raw.m14u3, R.raw.m15u3, R.raw.m16u3, R.raw.m17u3,
			R.raw.m18u3, R.raw.m1u4, R.raw.m2u4, R.raw.m3u4, R.raw.m4u4,
			R.raw.m5u4, R.raw.m6u4, R.raw.m7u4, R.raw.m8u4, R.raw.m9u4,
			R.raw.m10u4, R.raw.m11u4, R.raw.m12u4, R.raw.m13u4, R.raw.m14u4,
			R.raw.m15u4, R.raw.m16u4, R.raw.m17u4, R.raw.m18u4, R.raw.m1u5,
			R.raw.m2u5, R.raw.m3u5, R.raw.m4u5, R.raw.m5u5, R.raw.m6u5,
			R.raw.m7u5, R.raw.m8u5, R.raw.m9u5, R.raw.m10u5, R.raw.m11u5,
			R.raw.m12u5, R.raw.m13u5, R.raw.m14u5, R.raw.m15u5, R.raw.m16u5,
			R.raw.m17u5, R.raw.m18u5, R.raw.m1u6, R.raw.m2u6, R.raw.m3u6,
			R.raw.m4u6, R.raw.m5u6, R.raw.m6u6, R.raw.m7u6, R.raw.m8u6,
			R.raw.m9u6, R.raw.m10u6, R.raw.m11u6, R.raw.m12u6, R.raw.m13u6,
			R.raw.m14u6, R.raw.m15u6, R.raw.m16u6, R.raw.m17u6, R.raw.m18u6,
			R.raw.m1u7, R.raw.m2u7, R.raw.m3u7, R.raw.m4u7, R.raw.m5u7,
			R.raw.m6u7, R.raw.m7u7, R.raw.m8u7, R.raw.m9u7, R.raw.m10u7,
			R.raw.m11u7, R.raw.m12u7, R.raw.m13u7, R.raw.m14u7, R.raw.m15u7,
			R.raw.m16u7, R.raw.m17u7, R.raw.m18u7, R.raw.m1u8, R.raw.m2u8,
			R.raw.m3u8, R.raw.m4u8, R.raw.m5u8, R.raw.m6u8, R.raw.m7u8,
			R.raw.m8u8, R.raw.m9u8, R.raw.m10u8, R.raw.m11u8, R.raw.m12u8,
			R.raw.m13u8, R.raw.m14u8, R.raw.m15u8, R.raw.m16u8, R.raw.m17u8,
			R.raw.m18u8, R.raw.m1u9, R.raw.m2u9, R.raw.m3u9, R.raw.m4u9,
			R.raw.m5u9, R.raw.m6u9, R.raw.m7u9, R.raw.m8u9, R.raw.m9u9,
			R.raw.m10u9, R.raw.m11u9, R.raw.m12u9, R.raw.m13u9, R.raw.m14u9,
			R.raw.m15u9, R.raw.m16u9, R.raw.m17u9, R.raw.m18u9, R.raw.m1u10,
			R.raw.m2u10, R.raw.m3u10, R.raw.m4u10, R.raw.m5u10, R.raw.m6u10,
			R.raw.m7u10, R.raw.m8u10, R.raw.m9u10, R.raw.m10u10, R.raw.m11u10,
			R.raw.m12u10, R.raw.m13u10, R.raw.m14u10, R.raw.m15u10,
			R.raw.m16u10, R.raw.m17u10, R.raw.m18u10, R.raw.m1u11, R.raw.m2u11,
			R.raw.m3u11, R.raw.m4u11, R.raw.m5u11, R.raw.m6u11, R.raw.m7u11,
			R.raw.m8u11, R.raw.m9u11, R.raw.m10u11, R.raw.m11u11, R.raw.m12u11,
			R.raw.m13u11, R.raw.m14u11, R.raw.m15u11, R.raw.m16u11,
			R.raw.m17u11, R.raw.m18u11, R.raw.m1u12, R.raw.m2u12, R.raw.m3u12,
			R.raw.m4u12, R.raw.m5u12, R.raw.m6u12, R.raw.m7u12, R.raw.m8u12,
			R.raw.m9u12, R.raw.m10u12, R.raw.m11u12, R.raw.m12u12,
			R.raw.m13u12, R.raw.m14u12, R.raw.m15u12, R.raw.m16u12,
			R.raw.m17u12, R.raw.m18u12

	};

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.nyabaga_game_layout);
		setVolumeControlStream(AudioManager.STREAM_MUSIC);
		playStartSound();
		typeface = Typeface.createFromAsset(this.getAssets(),
				"fonts/TSCu_Paranar.ttf");

		DisplayMetrics metrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(metrics);
		this.screenHeight = metrics.heightPixels;
		this.screenWidth = metrics.widthPixels;

		heightMultiple = screenHeight / 10;
		widthMultiple = screenWidth / 3;
		buttonsTextFontSize = screenWidth / 20;
		pointsTextFontSize = screenWidth / 28;

		res = getResources();
		tamilLettersArray = res.getStringArray(R.array.tamil_letters_array);

		buildOrRefreshRandomLetterReferenceNumberArray();

		// ==================================
		pointsButton = (Button) findViewById(R.id.NyabagaGamePointsTextButton);
		pointsButton.setHeight(heightMultiple);
		pointsButton.setTypeface(typeface);
		pointsButton.setTextSize(pointsTextFontSize);

		pointsText = ReEncodeTamil.unicode2tsc(res
				.getString(R.string.NyabagaGamePointsText)) + " " + gamePoints;

		pointsButton.setText(pointsText);
		pointsButton
				.setBackgroundResource(R.drawable.ic_menu_lightgreen_circle_button);
		pointsButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// Do something in response to button click
			}
		});

		// ==============================================
		// ==================================

		answerButton_1 = (Button) findViewById(R.id.answerbutton_1);
		answerButton_1.setHeight(heightMultiple);
		answerButton_1.setTextSize(buttonsTextFontSize);

		ViewGroup.LayoutParams answerButton_1_params = answerButton_1
				.getLayoutParams();
		answerButton_1_params.width = widthMultiple;
		answerButton_1.setLayoutParams(answerButton_1_params);
		answerButton_1.setTypeface(typeface);

		answerButton_1.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// Do something in response to button click
				// playLetterSound(0);

				buttonTouchedQuizAction(answerButton_1, quizLettersArray[0]);

			}
		});
		// ==============================================

		// ==============================================

		answerButton_2 = (Button) findViewById(R.id.answerbutton_2);
		answerButton_2.setHeight(heightMultiple);
		answerButton_2.setTextSize(buttonsTextFontSize);

		ViewGroup.LayoutParams answerButton_2_params = answerButton_2
				.getLayoutParams();
		answerButton_2_params.width = widthMultiple;
		answerButton_2.setLayoutParams(answerButton_2_params);
		answerButton_2.setTypeface(typeface);

		answerButton_2.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// Do something in response to button click

				buttonTouchedQuizAction(answerButton_2, quizLettersArray[1]);

			}
		});

		// ==============================================

		// ==============================================

		answerButton_3 = (Button) findViewById(R.id.answerbutton_3);
		answerButton_3.setHeight(heightMultiple);
		answerButton_3.setTextSize(buttonsTextFontSize);

		ViewGroup.LayoutParams answerButton_3_params = answerButton_3
				.getLayoutParams();
		answerButton_3_params.width = widthMultiple;
		answerButton_3.setLayoutParams(answerButton_3_params);
		answerButton_3.setTypeface(typeface);

		answerButton_3.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// Do something in response to button click

				buttonTouchedQuizAction(answerButton_3, quizLettersArray[2]);

			}
		});

		// ==============================================

		// ==============================================

		answerButton_4 = (Button) findViewById(R.id.answerbutton_4);
		answerButton_4.setHeight(heightMultiple);
		answerButton_4.setTextSize(buttonsTextFontSize);

		ViewGroup.LayoutParams answerButton_4_params = answerButton_4
				.getLayoutParams();
		answerButton_4_params.width = widthMultiple;
		answerButton_4.setLayoutParams(answerButton_4_params);
		answerButton_4.setTypeface(typeface);

		answerButton_4.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// Do something in response to button click
				buttonTouchedQuizAction(answerButton_4, quizLettersArray[3]);

			}
		});

		// ==============================================
		// ==============================================

		answerButton_5 = (Button) findViewById(R.id.answerbutton_5);
		answerButton_5.setHeight(heightMultiple);
		answerButton_5.setTextSize(buttonsTextFontSize);

		ViewGroup.LayoutParams answerButton_5_params = answerButton_5
				.getLayoutParams();
		answerButton_5_params.width = widthMultiple;
		answerButton_5.setLayoutParams(answerButton_5_params);
		answerButton_5.setTypeface(typeface);

		answerButton_5.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// Do something in response to button click

				buttonTouchedQuizAction(answerButton_5, quizLettersArray[4]);

			}
		});

		// ==============================================
		// ==============================================

		answerButton_6 = (Button) findViewById(R.id.answerbutton_6);
		answerButton_6.setHeight(heightMultiple);
		answerButton_6.setTextSize(buttonsTextFontSize);

		ViewGroup.LayoutParams answerButton_6_params = answerButton_6
				.getLayoutParams();
		answerButton_6_params.width = widthMultiple;
		answerButton_6.setLayoutParams(answerButton_6_params);
		answerButton_6.setTypeface(typeface);

		answerButton_6.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// Do something in response to button click

				buttonTouchedQuizAction(answerButton_6, quizLettersArray[5]);

			}
		});

		// ==============================================
		// ==============================================

		answerButton_7 = (Button) findViewById(R.id.answerbutton_7);
		answerButton_7.setHeight(heightMultiple);
		answerButton_7.setTextSize(buttonsTextFontSize);

		ViewGroup.LayoutParams answerButton_7_params = answerButton_7
				.getLayoutParams();
		answerButton_7_params.width = widthMultiple;
		answerButton_7.setLayoutParams(answerButton_7_params);
		answerButton_7.setTypeface(typeface);

		answerButton_7.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				buttonTouchedQuizAction(answerButton_7, quizLettersArray[6]);

			}
		});

		// ==============================================
		// ==============================================

		answerButton_8 = (Button) findViewById(R.id.answerbutton_8);
		answerButton_8.setHeight(heightMultiple);
		answerButton_8.setTextSize(buttonsTextFontSize);

		ViewGroup.LayoutParams answerButton_8_params = answerButton_8
				.getLayoutParams();
		answerButton_8_params.width = widthMultiple;
		answerButton_8.setLayoutParams(answerButton_8_params);
		answerButton_8.setTypeface(typeface);

		answerButton_8.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				buttonTouchedQuizAction(answerButton_8, quizLettersArray[7]);

			}
		});

		// ==============================================
		// ==============================================

		answerButton_9 = (Button) findViewById(R.id.answerbutton_9);
		answerButton_9.setHeight(heightMultiple);
		answerButton_9.setTextSize(buttonsTextFontSize);

		ViewGroup.LayoutParams answerButton_9_params = answerButton_9
				.getLayoutParams();
		answerButton_9_params.width = widthMultiple;
		answerButton_9.setLayoutParams(answerButton_9_params);
		answerButton_9.setTypeface(typeface);

		answerButton_9.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// Do something in response to button click

				buttonTouchedQuizAction(answerButton_9, quizLettersArray[8]);

			}
		});

		// ==============================================
		// ==============================================

		answerButton_10 = (Button) findViewById(R.id.answerbutton_10);
		answerButton_10.setHeight(heightMultiple);
		answerButton_10.setTextSize(buttonsTextFontSize);

		ViewGroup.LayoutParams answerButton_10_params = answerButton_10
				.getLayoutParams();
		answerButton_10_params.width = widthMultiple;
		answerButton_10.setLayoutParams(answerButton_10_params);
		answerButton_10.setTypeface(typeface);

		answerButton_10.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// Do something in response to button click

				buttonTouchedQuizAction(answerButton_10, quizLettersArray[9]);

			}
		});

		// ==============================================
		// ==============================================

		answerButton_11 = (Button) findViewById(R.id.answerbutton_11);
		answerButton_11.setHeight(heightMultiple);
		answerButton_11.setTextSize(buttonsTextFontSize);

		ViewGroup.LayoutParams answerButton_11_params = answerButton_11
				.getLayoutParams();
		answerButton_11_params.width = widthMultiple;
		answerButton_11.setLayoutParams(answerButton_11_params);
		answerButton_11.setTypeface(typeface);

		answerButton_11.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// Do something in response to button click

				buttonTouchedQuizAction(answerButton_11, quizLettersArray[10]);

			}
		});

		// ==============================================
		// ==============================================

		answerButton_12 = (Button) findViewById(R.id.answerbutton_12);
		answerButton_12.setHeight(heightMultiple);
		answerButton_12.setTextSize(buttonsTextFontSize);

		ViewGroup.LayoutParams answerButton_12_params = answerButton_12
				.getLayoutParams();
		answerButton_12_params.width = widthMultiple;
		answerButton_12.setLayoutParams(answerButton_12_params);
		answerButton_12.setTypeface(typeface);

		answerButton_12.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// Do something in response to button click
				buttonTouchedQuizAction(answerButton_12, quizLettersArray[11]);

			}
		});

		// ==================================
		footerButton = (Button) findViewById(R.id.NyabagaGameFooterTextButton);
		footerButton.setHeight(heightMultiple);
		footerButton.setTypeface(typeface);
		footerButton.setTextSize(pointsTextFontSize);

		footerButton.setText(ReEncodeTamil.unicode2tsc(res
				.getString(R.string.NyabagaGameFooterText)));
		footerButton
				.setBackgroundResource(R.drawable.ic_menu_lightgreen_circle_button);
		footerButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// Do something in response to button click
			}
		});

		// ==============================================

		initOrChangeQuizLettersDisplay();

		// ==============================================

		// ==============================================
	}

	protected void releaseMediaPlayers() {
		if (mediaPlay != null) {
			mediaPlay.stop();
			mediaPlay.release();
			mediaPlay = null;
		}

	}

	private void buildOrRefreshRandomLetterReferenceNumberArray() {

		int fromLetter = 0;
		int toLetter = 0;
		int range = 0;
		Random random = null;
		int randomNum;
		random = new Random();
		// -------------------

		// Get 6 Letters

		fromLetter = 0;
		toLetter = 245;
		int templetter = 0;

		for (int i = 0; i <= 5; i++) {

			range = (toLetter - fromLetter) + 1;
			templetter = random.nextInt(range) + fromLetter;

			quizLettersArray[i] = templetter;
			quizLettersArray[i + 6] = templetter;

		}

		// -------------------
		// SWAP the First Letter that is Uir

		int helper = 0;
		for (int i = 0; i <= 5; i++) {
			fromLetter = 0;
			toLetter = 11;
			range = (toLetter - fromLetter) + 1;
			randomNum = random.nextInt(range) + fromLetter;

			helper = quizLettersArray[i];
			quizLettersArray[i] = quizLettersArray[randomNum];
			quizLettersArray[randomNum] = helper;
		}
		Log.e("ELANGO", Arrays.toString(quizLettersArray));

	}

	private void initOrChangeQuizLettersDisplay() {
		buildOrRefreshRandomLetterReferenceNumberArray();

		answerButton_1
				.setBackgroundResource(R.drawable.ic_menu_green_circle_button);
		answerButton_2
				.setBackgroundResource(R.drawable.ic_menu_green_circle_button);
		answerButton_3
				.setBackgroundResource(R.drawable.ic_menu_green_circle_button);
		answerButton_4
				.setBackgroundResource(R.drawable.ic_menu_green_circle_button);
		answerButton_5
				.setBackgroundResource(R.drawable.ic_menu_green_circle_button);
		answerButton_6
				.setBackgroundResource(R.drawable.ic_menu_green_circle_button);
		answerButton_7
				.setBackgroundResource(R.drawable.ic_menu_green_circle_button);
		answerButton_8
				.setBackgroundResource(R.drawable.ic_menu_green_circle_button);
		answerButton_9
				.setBackgroundResource(R.drawable.ic_menu_green_circle_button);
		answerButton_10
				.setBackgroundResource(R.drawable.ic_menu_green_circle_button);
		answerButton_11
				.setBackgroundResource(R.drawable.ic_menu_green_circle_button);
		answerButton_12
				.setBackgroundResource(R.drawable.ic_menu_green_circle_button);

		answerButton_1.setText(ReEncodeTamil
				.unicode2tsc(tamilLettersArray[quizLettersArray[0]]));

		answerButton_2.setText(ReEncodeTamil
				.unicode2tsc(tamilLettersArray[quizLettersArray[1]]));

		answerButton_3.setText(ReEncodeTamil
				.unicode2tsc(tamilLettersArray[quizLettersArray[2]]));

		answerButton_4.setText(ReEncodeTamil
				.unicode2tsc(tamilLettersArray[quizLettersArray[3]]));
		answerButton_5.setText(ReEncodeTamil
				.unicode2tsc(tamilLettersArray[quizLettersArray[4]]));
		answerButton_6.setText(ReEncodeTamil
				.unicode2tsc(tamilLettersArray[quizLettersArray[5]]));
		answerButton_7.setText(ReEncodeTamil
				.unicode2tsc(tamilLettersArray[quizLettersArray[6]]));
		answerButton_8.setText(ReEncodeTamil
				.unicode2tsc(tamilLettersArray[quizLettersArray[7]]));
		answerButton_9.setText(ReEncodeTamil
				.unicode2tsc(tamilLettersArray[quizLettersArray[8]]));
		answerButton_10.setText(ReEncodeTamil
				.unicode2tsc(tamilLettersArray[quizLettersArray[9]]));
		answerButton_11.setText(ReEncodeTamil
				.unicode2tsc(tamilLettersArray[quizLettersArray[10]]));
		answerButton_12.setText(ReEncodeTamil
				.unicode2tsc(tamilLettersArray[quizLettersArray[11]]));

		setDefaultBackgroundText(answerButton_1);
		setDefaultBackgroundText(answerButton_2);
		setDefaultBackgroundText(answerButton_3);
		setDefaultBackgroundText(answerButton_4);
		setDefaultBackgroundText(answerButton_5);
		setDefaultBackgroundText(answerButton_6);
		setDefaultBackgroundText(answerButton_7);
		setDefaultBackgroundText(answerButton_8);
		setDefaultBackgroundText(answerButton_9);
		setDefaultBackgroundText(answerButton_10);
		setDefaultBackgroundText(answerButton_11);
		setDefaultBackgroundText(answerButton_12);

	}

	private void playSuccessSound(int letterReferenceNumber) {
		gamePoints = gamePoints + 1;
		pointsButton.setText(ReEncodeTamil.unicode2tsc(res
				.getString(R.string.points)) + " " + gamePoints);

		mediaPlay = MediaPlayer.create(getBaseContext(),
				audio_files[quizLettersArray[letterReferenceNumber]]);
		mediaPlay.start();

		mediaPlay.setOnCompletionListener(new OnCompletionListener() {
			public void onCompletion(MediaPlayer mp) {
				releaseMediaPlayers();
				mediaPlay = MediaPlayer.create(getBaseContext(), R.raw.clap);
				mediaPlay.start();

			}
		});

	}

	private void playFailureSound(int letterReferenceNumber) {

		mediaPlay = MediaPlayer.create(getBaseContext(),
				audio_files[quizLettersArray[letterReferenceNumber]]);
		mediaPlay.start();

		mediaPlay.setOnCompletionListener(new OnCompletionListener() {
			public void onCompletion(MediaPlayer mp) {
				// releaseMediaPlayers();
				// mediaPlay = MediaPlayer.create(getBaseContext(), R.raw.beep);
				// mediaPlay.start();

			}
		});

	}

	private void playStartSound() {
		releaseMediaPlayers();
		mediaPlay = MediaPlayer.create(this, R.raw.background_score);
		mediaPlay.start();

		mediaPlay.setOnCompletionListener(new OnCompletionListener() {
			public void onCompletion(MediaPlayer mp) {
				// TODO Auto-generated method stub

			}
		});

	}

	private void playButtonTouchedSound() {
		releaseMediaPlayers();
		mediaPlay = MediaPlayer.create(this, R.raw.trumpet_1);
		mediaPlay.start();

		mediaPlay.setOnCompletionListener(new OnCompletionListener() {
			public void onCompletion(MediaPlayer mp) {
				// TODO Auto-generated method stub

			}
		});

	}

	private void playTwoSucessSound() {
		releaseMediaPlayers();
		mediaPlay = MediaPlayer.create(this, R.raw.happy_1);
		mediaPlay.start();

		mediaPlay.setOnCompletionListener(new OnCompletionListener() {
			public void onCompletion(MediaPlayer mp) {
				// TODO Auto-generated method stub

			}
		});

	}

	private void RoundOver() {
		releaseMediaPlayers();
		mediaPlay = MediaPlayer.create(this, R.raw.trumpet_1);
		mediaPlay.start();

		mediaPlay.setOnCompletionListener(new OnCompletionListener() {
			public void onCompletion(MediaPlayer mp) {
				// TODO Auto-generated method stub

			}
		});

	}

	private void setDefaultBackgroundText(Button changeButton) {

		changeButton.setText("X");
	}

	int previousLetter = -1;
	int currentLetter = -1;
	boolean previouslyTouched = false;
	Button previousButton = null;
	final Button thisButton = null;
	final Handler handler = new Handler();
	int successHits = 0;
	boolean locked = false;

	void buttonTouchedQuizAction(final Button thisButton, int thisLetter) {

		if (thisButton.equals(previousButton)) {
			return;
		}
		
		if(locked){
			return;			
		}

		locked = true;
		if (previouslyTouched == false) {
			// this means this is the first time a button is clicked
			thisButton
					.setBackgroundResource(R.drawable.ic_menu_blue_circle_button);
			thisButton.setText(ReEncodeTamil
					.unicode2tsc(tamilLettersArray[thisLetter]));
			previousButton = thisButton;
			previousLetter = thisLetter;
			previouslyTouched = true;
			playButtonTouchedSound();			
			locked = false;

		} else if(previouslyTouched == true){ // this means this is the 2nd button clicked
			// This means your previous and current button is same
			if (previousLetter == thisLetter) {
				// thisButton.setBackgroundResource(R.drawable.ic_menu_blue_circle_button);
				// previousButton.setBackgroundResource(R.drawable.ic_menu_blue_circle_button);
				
				playTwoSucessSound();


				thisButton.setBackgroundColor(Color.parseColor("#3cb371"));
				previousButton.setBackgroundColor(Color.parseColor("#3cb371"));

				thisButton.setText(ReEncodeTamil
						.unicode2tsc(tamilLettersArray[thisLetter]));
				previousButton.setText(ReEncodeTamil
						.unicode2tsc(tamilLettersArray[thisLetter]));
				// playSuccessSound(thisLetter);
				previousButton = null;
				previousLetter = -1;
				previouslyTouched = false;
				successHits = successHits + 1;

				// This Game is Over if its in multiple of 6
				if ((successHits % 6) == 0) {
					Toast toast = Toast.makeText(this, "! VETRI !", 500);
					toast.show();
					gamePoints = gamePoints + 1;
					initOrChangeQuizLettersDisplay();
					buildOrRefreshRandomLetterReferenceNumberArray();

					pointsText = ReEncodeTamil.unicode2tsc(res
							.getString(R.string.NyabagaGamePointsText))
							+ " "
							+ gamePoints;

					pointsButton.setText(pointsText);
					playStartSound();
				}
				
				locked = false;
				
			} else { // this means the previous button and current button are different
				
				thisButton.setText(ReEncodeTamil
						.unicode2tsc(tamilLettersArray[thisLetter]));
				thisButton.setBackgroundResource(R.drawable.ic_menu_blue_circle_button);
				
			
				handler.postDelayed(new Runnable() {

					public void run() {
						// Do something after 5s = 5000ms
						setDefaultBackgroundText(thisButton);
						setDefaultBackgroundText(previousButton);
						
						previousButton.setBackgroundResource(R.drawable.ic_menu_green_circle_button);
						thisButton.setBackgroundResource(R.drawable.ic_menu_green_circle_button);
						previousButton = null;
						locked = false;
						
					}
				}, 1000);

				previousLetter = -1;
				previouslyTouched = false;
			} // close
		}

	}

}
