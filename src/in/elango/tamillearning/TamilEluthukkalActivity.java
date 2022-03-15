package in.elango.tamillearning;
import java.util.Random;

import com.google.ads.*;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
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
 * @author ESundar
 *
 */
public class TamilEluthukkalActivity  extends Activity{
	private AdView adView;
	private static String publisher_id = "a15160590fb56aa";
	String[] tamilLettersArray = null; 
	Button eluthukkalButton;
	int screenHeight = 0;
	int screenWidth = 0;
	int fontSize = 0;
	Resources res;
	int maximumUirLetterReference = 12;
	int maximumMeiLetterReference = 30;
	int maximumUirMeiLetterReference = 246;

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
	int location = 0;
	// references to our images
	int letterReferenceNumber = 0;
	TextView textView = null;
	MediaPlayer startMediaPlay = null;
	OnClickListener homeButtonClick = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		
		
		setContentView(R.layout.tamil_eluthukkal);
		setVolumeControlStream(AudioManager.STREAM_MUSIC);
		//Remove title bar
		//this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		DisplayMetrics metrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(metrics);
		screenHeight = metrics.heightPixels;
		screenWidth = metrics.widthPixels;
		fontSize = screenWidth / 5;
		res = getResources();
		tamilLettersArray = res.getStringArray(R.array.tamil_letters_array);
	    Typeface typeface = Typeface.createFromAsset(this.getAssets(),
					"fonts/TSCu_Paranar.ttf");
	    eluthukkalButton= (Button) findViewById(R.id.tamilEluthukkalButton);
        eluthukkalButton.setTypeface(typeface);
        eluthukkalButton.setBackgroundColor(Color.parseColor(getRandomColorRBGString()));
        eluthukkalButton.setTextSize(fontSize);
        
        Intent intentToPlay = getIntent();
		int LETTER_TO_PLAY  = intentToPlay.getIntExtra("TO_PLAY",1);
		Log.e("Elango", "LETTER = "+ LETTER_TO_PLAY);
		if(LETTER_TO_PLAY == 0) letterReferenceNumber =0;
		if(LETTER_TO_PLAY == 12) letterReferenceNumber =12;
		if(LETTER_TO_PLAY == 30) letterReferenceNumber = 30;        
        eluthukkalButton.setText(ReEncodeTamil.unicode2tsc(tamilLettersArray[letterReferenceNumber]));
        
        try {

			releaseMediaPlayers();
			startMediaPlay = MediaPlayer.create(getBaseContext(),audio_files[letterReferenceNumber]);
			startMediaPlay.start();


		} catch (Exception e) {
			// NA
		}

        
    	OnClickListener selector = new OnClickListener() {
			public void onClick(View v) {

				letterReferenceNumber = letterReferenceNumber + 1;
				
				// This would be Uir Rotation
				if (letterReferenceNumber == maximumUirLetterReference) {
					//start of Uir
					letterReferenceNumber = 0;
				}
				// This would be Mei Rotation
				if (letterReferenceNumber ==  maximumMeiLetterReference) {
					//start of Mei
					letterReferenceNumber = 12;
				}
				
				// This would be UirMei Rotation
				if (letterReferenceNumber == maximumUirMeiLetterReference) {
					//Start of UirMei
					letterReferenceNumber = 30;
				}				
				
				 eluthukkalButton.setText(ReEncodeTamil.unicode2tsc(tamilLettersArray[letterReferenceNumber]));
		        eluthukkalButton.setBackgroundColor(Color.parseColor(getRandomColorRBGString()));

				try {

					releaseMediaPlayers();
					startMediaPlay = MediaPlayer.create(getBaseContext(),audio_files[letterReferenceNumber]);
					startMediaPlay.start();


				} catch (Exception e) {
					// NA
				}

			}
		};
		eluthukkalButton.setOnClickListener(selector);
		
		
		
        
		try {

			releaseMediaPlayers();
			startMediaPlay = MediaPlayer.create(getBaseContext(), audio_files[letterReferenceNumber]);
			startMediaPlay.start();

		} catch (Exception e) {
			// NA
		}

		
		//////////////////////////////
		//////////////////////////////
		
		/**
		adView = new AdView(this, AdSize.BANNER, publisher_id);
		AdRequest adRequest = new AdRequest();
		//adRequest.addTestDevice(AdRequest.TEST_EMULATOR);
		//adRequest.setTesting(true);
		adRequest.addTestDevice("OD2S-PLRM-VYK2-F"); // KAK Phone - 
		adRequest.addTestDevice("R62B629778B"); // Tab
		
		FrameLayout layout = (FrameLayout)findViewById(R.id.frameLayout1);
		adView.setGravity(Gravity.TOP);
		layout.addView(adView);
		
		//adView.loadAd(new AdRequest());
		adView.loadAd(adRequest);
		
		*/
		//////////////////////////////
		//////////////////////////////
		
		
		/**
		homeButton = (ImageButton) findViewById(R.id.homeButton);
		homeButtonClick = new OnClickListener() {
			public void onClick(View v) {
			 	finish();
			}
		};
		homeButton.setOnClickListener(homeButtonClick);
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
	    if (adView != null) {
	      adView.destroy();
	    }
	    super.onDestroy();
	  }

	
	private static String[] colorRBGs = {"#006400","#2e8b57","#00ff7f","#7cfc00","#32cd32","#228b22","#adff2f"};

	private  static String getRandomColorRBGString() {

	
		
		Random rn = new Random();
		int fromLetter = 0;
		int toLetter = colorRBGs.length-1;
		int range = (toLetter - fromLetter) + 1;
		int randomNum = rn.nextInt(range) + fromLetter;
		//Log.e("Elango", "LETTERREF " + tamilLettersArray[randomNum] );
		return colorRBGs[randomNum];
	}
		
		
	
}
