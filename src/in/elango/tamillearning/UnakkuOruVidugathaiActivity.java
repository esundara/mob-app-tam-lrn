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
public class UnakkuOruVidugathaiActivity  extends Activity{
	
	private String[] tamilLettersArrayUnakkuOruVidugatahiQuestions = null;
	private String[] tamilLettersArrayUnakkuOruVidugatahiAnswers = null; 
	
	private String vidugathaiQuestion = null;
	private String vidugathaiAnswer = null;
	
	Button unakkuOriVidugathaiButton;
	Button unakkuOruVidugathaiAnswerButton;
	Button unakkuOruVidugathaiNextButton;
	
	int screenHeight = 0;
	int screenWidth = 0;
	int fontSize = 0;
	Resources res;

	MediaPlayer startMediaPlay = null;
	OnClickListener homeButtonClick = null;
	Typeface typeface;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		
		
		setContentView(R.layout.unakku_oru_vidugathai_layout);
		//Remove title bar
		//this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		releaseMediaPlayers();
		startMediaPlay = MediaPlayer.create(this, R.raw.background_score);
		//mediaPlay.setLooping(true);
		startMediaPlay.start();
		
	    typeface = Typeface.createFromAsset(this.getAssets(),
					"fonts/TSCu_Paranar.ttf");
	    
		
		DisplayMetrics metrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(metrics);
		screenHeight = metrics.heightPixels;
		screenWidth = metrics.widthPixels;
		fontSize = screenWidth / 20;
		
		res = getResources();
		tamilLettersArrayUnakkuOruVidugatahiQuestions = res.getStringArray(R.array.unakku_oru_vidugathai_questions_array_strings);
		tamilLettersArrayUnakkuOruVidugatahiAnswers = res.getStringArray(R.array.unakku_oru_vidugathai_answers_array_strings);
		
	

	    unakkuOriVidugathaiButton= (Button) findViewById(R.id.unakkuOruVidugathaiButton);
	 	unakkuOriVidugathaiButton.setTypeface(typeface);
	 	unakkuOriVidugathaiButton.setHeight(screenHeight * 4 / 10 );
	 	
	 	unakkuOruVidugathaiAnswerButton= (Button) findViewById(R.id.unakkuOruVidugathaiAnswerButton);
	 	unakkuOruVidugathaiAnswerButton.setTypeface(typeface);	 
	 	unakkuOruVidugathaiAnswerButton.setBackgroundColor(Color.parseColor("#006400"));
	 	unakkuOruVidugathaiAnswerButton.setTextSize(fontSize);
	 	unakkuOruVidugathaiAnswerButton.setText(ReEncodeTamil.unicode2tsc(res.getString(R.string.UnakkuOruVidugathaiVidaiEnna)));
		    
	    
	    unakkuOruVidugathaiNextButton= (Button) findViewById(R.id.unakkuOruVidugathaiNextButton);
	    unakkuOruVidugathaiNextButton.setTypeface(typeface);	    
	    unakkuOruVidugathaiNextButton.setBackgroundColor(Color.parseColor("#228b22"));
	    unakkuOruVidugathaiNextButton.setTextSize(fontSize);
	    unakkuOruVidugathaiNextButton.setText(ReEncodeTamil.unicode2tsc(res.getString(R.string.UnakkuOruVidugathaiVerondru)));
	    
	    initOrRefreshVidugathai();
	    
	    OnClickListener unakkuOruVidugathaiAnswerSelector = new OnClickListener() {
			public void onClick(View v) {

				unakkuOriVidugathaiButton.setText(ReEncodeTamil.unicode2tsc(vidugathaiQuestion) + "\n\n(" + ReEncodeTamil.unicode2tsc(vidugathaiAnswer)+")");
			}
		};
		unakkuOruVidugathaiAnswerButton.setOnClickListener(unakkuOruVidugathaiAnswerSelector);
		
		
        
    	OnClickListener unakkuOruVidugathaiNextSelector = new OnClickListener() {
			public void onClick(View v) {

				initOrRefreshVidugathai();

			}
		};
		unakkuOruVidugathaiNextButton.setOnClickListener(unakkuOruVidugathaiNextSelector);
		
		
	

	}

	private void initOrRefreshVidugathai(){
		
		    unakkuOriVidugathaiButton.setBackgroundColor(Color.parseColor(getRandomColorRBGString()));
		    unakkuOriVidugathaiButton.setTextSize(fontSize);
		    
		    setOrResetRandomPazhaMozhiString();
		    unakkuOriVidugathaiButton.setText(ReEncodeTamil.unicode2tsc(vidugathaiQuestion));
		    
		   
	        
		
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
		
	
	
	
private  void setOrResetRandomPazhaMozhiString() {
		
		Random rn = new Random();
		int fromLetter = 0;
		int toLetter = tamilLettersArrayUnakkuOruVidugatahiQuestions.length-1;
		int range = (toLetter - fromLetter) + 1;
		int randomNum = rn.nextInt(range) + fromLetter;
		//Log.e("Elango", "LETTERREF " + tamilLettersArray[randomNum] );
		vidugathaiQuestion = tamilLettersArrayUnakkuOruVidugatahiQuestions[randomNum];
		vidugathaiAnswer = tamilLettersArrayUnakkuOruVidugatahiAnswers[randomNum];
		
	}
	
}
