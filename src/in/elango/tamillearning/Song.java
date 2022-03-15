package in.elango.tamillearning;

import com.google.ads.*;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.media.AudioManager;
import android.media.MediaPlayer;
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
public class Song extends Activity {

	public static Integer[] displayImages = { R.drawable.start,
			R.drawable.numbers, R.drawable.one, R.drawable.two,
			R.drawable.three, R.drawable.four, R.drawable.five, R.drawable.six,
			R.drawable.seven, R.drawable.eight, R.drawable.nine,
			R.drawable.ten, R.drawable.colors, R.drawable.blue, R.drawable.red,
			R.drawable.black, R.drawable.green, R.drawable.shapes,
			R.drawable.circle, R.drawable.square, R.drawable.triangle,
			R.drawable.rectangle, R.drawable.fruits, R.drawable.mango,
			R.drawable.pineapple, R.drawable.watermelon, R.drawable.animals,
			R.drawable.owl, R.drawable.cat, R.drawable.lion, R.drawable.parrot,
			R.drawable.vehicles, R.drawable.bus, R.drawable.car,
			R.drawable.train, R.drawable.bicycle, R.drawable.boat };
	public static Integer[] audio_files = { R.raw.learn_audio,
			R.raw.numbers_audio, R.raw.one_audio, R.raw.two_audio,
			R.raw.three_audio, R.raw.four_audio, R.raw.five_audio,
			R.raw.six_audio, R.raw.seven_audio, R.raw.eight_audio,
			R.raw.nine_audio, R.raw.ten_audio, R.raw.colors_audio,
			R.raw.blue_audio, R.raw.red_audio, R.raw.black_audio,
			R.raw.green_audio, R.raw.shapes_audio, R.raw.circle_audio,
			R.raw.square_audio, R.raw.triangle_audio, R.raw.rectange_audio,
			R.raw.fruits_audio, R.raw.mango_audio, R.raw.pineapple_audio,
			R.raw.watermelon_audio, R.raw.animals_audio, R.raw.owl_audio,
			R.raw.cat_audio, R.raw.lion_audio, R.raw.parrot_audio,
			R.raw.vehicles_audio, R.raw.bus_audio, R.raw.car_audio,
			R.raw.train_audio, R.raw.bicycle_audio, R.raw.boat_audio

	};
	int location = 0;
	// references to our images
	static int imageNumber = 0;
	ImageView mainImageView = null;
	MediaPlayer startMediaPlay = null;
	ImageButton homeButton = null;
	OnClickListener homeButtonClick = null;

	public static int screenWidth;
	public static int screenHeight;
	public static boolean initilizedAlready = false;
	Resources res;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.song);
		setVolumeControlStream(AudioManager.STREAM_MUSIC);

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
		setContentView(R.layout.song);
		setVolumeControlStream(AudioManager.STREAM_MUSIC);
		try {

			releaseMediaPlayers();
			startMediaPlay = MediaPlayer.create(getBaseContext(),
					audio_files[imageNumber]);

			startMediaPlay.start();

		} catch (Exception e) {
			// NA
		}

		Button nextButton = (Button) findViewById(R.id.draw_on_image_next_button_id);

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

		Button previousButton = (Button) findViewById(R.id.draw_on_image_previous_button_id);
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

		Button refreshButton = (Button) findViewById(R.id.draw_on_image_refresh_button_id);
		OnClickListener refreshButtonSelector = new OnClickListener() {
			public void onClick(View v) {
				// speak(audio_text[imageNumber]);

				refreshSlateActivity();

			}
		};
		refreshButton.setOnClickListener(refreshButtonSelector);

		/**
		 * mainImageView = (ImageView) findViewById(R.id.imageView);
		 * 
		 * mainImageView.setImageResource(displayImages[imageNumber]);
		 * 
		 * try {
		 * 
		 * releaseMediaPlayers(); startMediaPlay =
		 * MediaPlayer.create(getBaseContext(), audio_files[imageNumber]);
		 * startMediaPlay.start();
		 * 
		 * } catch (Exception e) { // NA }
		 * 
		 * homeButton = (ImageButton) findViewById(R.id.homeButton);
		 * homeButtonClick = new OnClickListener() { public void onClick(View v)
		 * { finish(); } }; homeButton.setOnClickListener(homeButtonClick);
		 * 
		 * 
		 * OnClickListener selector = new OnClickListener() { public void
		 * onClick(View v) {
		 * 
		 * imageNumber = imageNumber + 1;
		 * 
		 * if (imageNumber == displayImages.length) { imageNumber = 0; }
		 * mainImageView.setImageResource(displayImages[imageNumber]);
		 * 
		 * try {
		 * 
		 * releaseMediaPlayers(); startMediaPlay =
		 * MediaPlayer.create(getBaseContext(),audio_files[imageNumber]);
		 * startMediaPlay.start();
		 * 
		 * 
		 * } catch (Exception e) { // NA }
		 * 
		 * } }; mainImageView.setOnClickListener(selector);
		 */
	}

	public void finish() {
		releaseMediaPlayers();
		super.finish();

	}

	protected void releaseMediaPlayers() {
		if (startMediaPlay != null) {
			startMediaPlay.release();
			startMediaPlay = null;
		}

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
