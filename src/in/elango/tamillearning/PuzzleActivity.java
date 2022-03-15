package in.elango.tamillearning;

import com.google.ads.*;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;

/**
 * This class helps in actually displaying and playing the sounds
 * 
 * @author ESundar
 * 
 */
public class PuzzleActivity extends Activity {

	public static Integer[] displayImages = {  R.drawable.one_puzzle_drg, R.drawable.two_puzzle_drg,
			R.drawable.three_puzzle_drg, R.drawable.four_puzzle_drg, R.drawable.five_puzzle_drg, R.drawable.six_puzzle_drg,
			R.drawable.seven_puzzle_drg, R.drawable.eight_puzzle_drg, R.drawable.nine_puzzle_drg,
			R.drawable.ten_puzzle_drg };
	public static Integer[] audio_files = { R.raw.one_audio, R.raw.two_audio,
			R.raw.three_audio, R.raw.four_audio, R.raw.five_audio,
			R.raw.six_audio, R.raw.seven_audio, R.raw.eight_audio,
			R.raw.nine_audio, R.raw.ten_audio

	};
	
	int location = 0;
	// references to our images
	static int imageNumber = 0;
	ImageView mainImageView = null;
	static MediaPlayer startMediaPlay = null;
	ImageButton homeButton = null;
	OnClickListener homeButtonClick = null;

	public static int screenWidth;
	public static int screenHeight;
	public static boolean initilizedAlready = false;
	Resources res;
	static Context con;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		con = getBaseContext();
		//setContentView(R.layout.puzzle_layout);
		//setVolumeControlStream(AudioManager.STREAM_MUSIC);

		DisplayMetrics metrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(metrics);
		screenWidth = metrics.widthPixels;
		screenHeight = metrics.heightPixels;

		Intent intentSongToPlay = getIntent();
		if (initilizedAlready == false) {
			imageNumber = intentSongToPlay.getIntExtra("TypeToPlay", 0);
			initilizedAlready = true;
		}

		res = getResources();
		setVolumeControlStream(AudioManager.STREAM_MUSIC);
		try {

			releaseMediaPlayers();
			startMediaPlay = MediaPlayer.create(getBaseContext(),
					audio_files[imageNumber]);

			startMediaPlay.start();

		} catch (Exception e) {
			// NA
		}
		setContentView(R.layout.puzzle_view_layout);

		Button nextButton = (Button) findViewById(R.id.puzzle_next_button_id);

		OnClickListener nextSelector = new OnClickListener() {
			public void onClick(View v) {

				imageNumber = imageNumber + 1;

				if (imageNumber == displayImages.length) {
					imageNumber = 0;
				}
				// mainImageView.setImageResource(displayImages[imageNumber]);
				// speak(audio_text[imageNumber]);

				refreshSlateActivity();
			
			}
		};
		nextButton.setOnClickListener(nextSelector);

		Button previousButton = (Button) findViewById(R.id.puzzle_previous_button_id);
		OnClickListener previousButtonSelector = new OnClickListener() {
			public void onClick(View v) {

				imageNumber = imageNumber - 1;

				if (imageNumber <= 0) {
					imageNumber = 0;
				}
				// mainImageView.setImageResource(displayImages[imageNumber]);
				// speak(audio_text[imageNumber]);

				refreshSlateActivity();

			}
		};
		previousButton.setOnClickListener(previousButtonSelector);

		Button refreshButton = (Button) findViewById(R.id.puzzle_refresh_button_id);
		OnClickListener refreshButtonSelector = new OnClickListener() {
			public void onClick(View v) {
				// speak(audio_text[imageNumber]);

				refreshSlateActivity();

			}
		};
		refreshButton.setOnClickListener(refreshButtonSelector);

		
	}

	public void finish() {
		releaseMediaPlayers();
		super.finish();

	}

	public static void releaseMediaPlayers() {
		if (startMediaPlay != null) {
			startMediaPlay.release();
			startMediaPlay = null;
		}

	}

	static public  void playPuzzleTouchedSound() {
		releaseMediaPlayers();
		startMediaPlay = MediaPlayer.create(con, R.raw.trumpet_1);
		startMediaPlay.start();

		startMediaPlay.setOnCompletionListener(new OnCompletionListener() {
			public void onCompletion(MediaPlayer mp) {
				// TODO Auto-generated method stub

			}
		});

	}
	
	static public  void playCompletionTouchedSound() {
		releaseMediaPlayers();
		startMediaPlay = MediaPlayer.create(con, R.raw.happy_1);
		startMediaPlay.start();

		startMediaPlay.setOnCompletionListener(new OnCompletionListener() {
			public void onCompletion(MediaPlayer mp) {
				releaseMediaPlayers();
				startMediaPlay = MediaPlayer.create(con, R.raw.happy_1);
				startMediaPlay.start();
			}
		});

	}
	@Override
	public void onDestroy() {

		super.onDestroy();
	}

	public void refreshSlateActivity() {
		finish();
		startActivity(getIntent());
	}
}
