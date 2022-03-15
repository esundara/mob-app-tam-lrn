package in.elango.tamillearning;

import java.util.Locale;
import java.util.Random;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * This class helps in actually displaying and playing the sounds
 * 
 * @author ESundar
 * 
 */
public class CultureAndHabitsOfIndiaActivity extends Activity {
	
	

	private String[] cultureAndHabitsOfIndiaArray = null;
	private String[] cultureAndHabitsOfIndiaHeadingArray = null;
	Button cultureAndhabitsOfIndiaHeaderButton;
	TextView cultureAndHabitsText;
	Button cultureAndHabitsNextButton;

	int screenHeight = 0;
	int screenWidth = 0;
	int fontSize = 0;
	Resources res;
	Typeface typeface; 


	MediaPlayer mediaPlay = null;
	OnClickListener homeButtonClick = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.culture_and_habits_of_india_layout );
		setVolumeControlStream(AudioManager.STREAM_MUSIC);
		// Remove title bar
		// this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		


		playStartSound();

		res = getResources();
		typeface = Typeface.createFromAsset(this.getAssets(),
					"fonts/TSCu_Paranar.ttf");
		 
		DisplayMetrics metrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(metrics);
		screenHeight = metrics.heightPixels;
		screenWidth = metrics.widthPixels;

		
		
		cultureAndHabitsOfIndiaArray = res
				.getStringArray(R.array.culture_and_habits_of_india_array);
		
		cultureAndHabitsOfIndiaHeadingArray = res.getStringArray(R.array.culture_and_habits_of_india_header_array);
		cultureAndhabitsOfIndiaHeaderButton = (Button) findViewById(R.id.culture_and_habits_of_india_header_id);
		
		
		
		cultureAndhabitsOfIndiaHeaderButton
				.setBackgroundResource(R.drawable.button_style_dark_green_plain);
		cultureAndHabitsText = (TextView) findViewById(R.id.culture_and_habits_of_india_textview_id);
		cultureAndHabitsText.setHeight(screenHeight * 3 / 10);
		
		
		
		cultureAndHabitsNextButton = (Button) findViewById(R.id.culture_and_habits_of_india_next_button_id);
		cultureAndHabitsNextButton.setTypeface(typeface);
		cultureAndHabitsNextButton.setText(ReEncodeTamil.unicode2tsc(res.getString(R.string.culture_and_habits_of_india_next_text)));
		
		cultureAndHabitsNextButton
				.setBackgroundResource(R.drawable.button_style_slate_blue);
		
		cultureAndhabitsOfIndiaHeaderButton.setTypeface(typeface);	
		cultureAndHabitsText.setTypeface(typeface);	    
		
		

		
		initOrRefreshAmazingFact();

		OnClickListener amazingFactNextSelector = new OnClickListener() {
			public void onClick(View v) {

				initOrRefreshAmazingFact();
				playButtonTouchedSound();
				

			}
		};
		cultureAndHabitsNextButton.setOnClickListener(amazingFactNextSelector);

	}
	
	int itemNumberToDisplay =0;

	private void initOrRefreshAmazingFact() {

		cultureAndHabitsText.setBackgroundColor(Color
				.parseColor(getRandomColorRBGString()));
		

		itemNumberToDisplay = getCultureHabitItemToDisplay(cultureAndHabitsOfIndiaArray);

		cultureAndhabitsOfIndiaHeaderButton.setText(ReEncodeTamil.unicode2tsc(cultureAndHabitsOfIndiaHeadingArray[itemNumberToDisplay]));
		cultureAndHabitsText.setText(ReEncodeTamil.unicode2tsc(cultureAndHabitsOfIndiaArray[itemNumberToDisplay]));
		
		
		//speak (cultureAndHabitsOfIndiaArray[random]);

	}

	public void finish() {
		releaseMediaPlayers();
		super.finish();

	}

	protected void releaseMediaPlayers() {
		if (mediaPlay != null) {
			mediaPlay.release();
			mediaPlay = null;
		}

	}

	@Override
	public void onDestroy() {

		super.onDestroy();
	}

	private static String[] colorRBGs = { "#006400", "#2e8b57", "#228b22", "#6b8e23","#556b2f" };

	private static String getRandomColorRBGString() {

		Random rn = new Random();
		int fromLetter = 0;
		int toLetter = colorRBGs.length - 1;
		int range = (toLetter - fromLetter) + 1;
		int randomNum = rn.nextInt(range) + fromLetter;
		return colorRBGs[randomNum];
	}

	static int itemOfArray = 0;
	private static int getCultureHabitItemToDisplay(String[] array) {
		itemOfArray = itemOfArray +1;
		if( itemOfArray >= array.length -1 ) {
			itemOfArray =0;
		}		
		
		return itemOfArray;
		
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
	
	private void playStartSound(){
		
		releaseMediaPlayers();
		mediaPlay = MediaPlayer.create(this, R.raw.background_score);
		// mediaPlay.setLooping(true);
		mediaPlay.start();
		
		
	}
	
	
}
