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

public class IndruOruPazhaMozhiActivity  extends Activity{
	
	private String[] tamilLettersArrayIndruOruPazhaMozhi = null; 
	Button indruOruPazhaMozhiButton;
	Button indruOruPazhaMozhiNextButton;
	Typeface typeface;
	
	int screenHeight = 0;
	int screenWidth = 0;
	int fontSize = 0;
	Resources res;

	MediaPlayer mediaPlay = null;
	OnClickListener homeButtonClick = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.indru_oru_pazhamozhi_layout);
		//Remove title bar
		//this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		releaseMediaPlayers();
		mediaPlay = MediaPlayer.create(this, R.raw.background_score);
		//mediaPlay.setLooping(true);
		mediaPlay.start();
		
		res = getResources();
		DisplayMetrics metrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(metrics);
		screenHeight = metrics.heightPixels;
		screenWidth = metrics.widthPixels;
		fontSize = screenWidth / 20;
		
		
		tamilLettersArrayIndruOruPazhaMozhi = res.getStringArray(R.array.indru_oru_pazhamozhi_array_strings);
		
	    typeface = Typeface.createFromAsset(this.getAssets(),
					"fonts/TSCu_Paranar.ttf");
	    
	    indruOruPazhaMozhiButton= (Button) findViewById(R.id.indruOruPazhaMozhiButton);
	    indruOruPazhaMozhiButton.setTypeface(typeface);
	    indruOruPazhaMozhiButton.setHeight(screenHeight * 4 /10 );
	 	
	    
	    indruOruPazhaMozhiNextButton= (Button) findViewById(R.id.indruOruPazhaMozhiNextButton);
	    indruOruPazhaMozhiNextButton.setTypeface(typeface);	    
	    
	   
	    initOrRefreshPazhaMozhi();
        
    	OnClickListener indruOruPazhaMozhiNextSelector = new OnClickListener() {
			public void onClick(View v) {

				initOrRefreshPazhaMozhi();

			}
		};
		indruOruPazhaMozhiNextButton.setOnClickListener(indruOruPazhaMozhiNextSelector);
		
	

	}

	private void initOrRefreshPazhaMozhi(){
		
		    indruOruPazhaMozhiButton.setBackgroundColor(Color.parseColor(getRandomColorRBGString()));
		    indruOruPazhaMozhiButton.setTextSize(fontSize);
		    indruOruPazhaMozhiButton.setText(ReEncodeTamil.unicode2tsc(getRandomPazhaMozhiString(tamilLettersArrayIndruOruPazhaMozhi)));
		    
		    indruOruPazhaMozhiNextButton.setBackgroundColor(Color.parseColor("#006400"));
		    indruOruPazhaMozhiNextButton.setTextSize(fontSize);
		    indruOruPazhaMozhiNextButton.setText(ReEncodeTamil.unicode2tsc(res.getString(R.string.IndruOruPazhaMozhiMatrondru)));
		  
	        
		
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

	
	private static String[] colorRBGs = {"#006400", "#2e8b57", "#228b22", "#6b8e23","#556b2f"};

	private  static String getRandomColorRBGString() {
		
		Random rn = new Random();
		int fromLetter = 0;
		int toLetter = colorRBGs.length-1;
		int range = (toLetter - fromLetter) + 1;
		int randomNum = rn.nextInt(range) + fromLetter;
		//Log.e("Elango", "LETTERREF " + tamilLettersArray[randomNum] );
		return colorRBGs[randomNum];
	}
		
	
	
	
private  static String getRandomPazhaMozhiString(String[] tamilLettersArrayIndruOruPazhaMozhi) {
		
		Random rn = new Random();
		int fromLetter = 0;
		int toLetter = tamilLettersArrayIndruOruPazhaMozhi.length-1;
		int range = (toLetter - fromLetter) + 1;
		int randomNum = rn.nextInt(range) + fromLetter;
		//Log.e("Elango", "LETTERREF " + tamilLettersArray[randomNum] );
		return tamilLettersArrayIndruOruPazhaMozhi[randomNum];
	}
	
}
