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
public class IndangalinSirappuActivity  extends Activity{
	
	
	private String[] idangalinSirappuArrayQuestions = null;
	private String[] idangalinSirappuArrayAnswers = null; 
	
	private String idangalinSirappuQuestion = null;
	private String idangalinSirappuAnswer = null;
	
	Button idangalinSirappuQuestionButton;
	Button idangalinSirappuAnswerButton;
	Button idangalinSirappuNextButton;
	
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

		
		
		setContentView(R.layout.idangalin_sirappu_layout);
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
		idangalinSirappuArrayQuestions = res.getStringArray(R.array.idangalin_sirappu_array_question);
		idangalinSirappuArrayAnswers = res.getStringArray(R.array.idangalin_sirappu_array_answer);
		
	

	    idangalinSirappuQuestionButton= (Button) findViewById(R.id.idangalinSirappuQuestionButton);
	 	idangalinSirappuQuestionButton.setTypeface(typeface);
	 	idangalinSirappuQuestionButton.setHeight(screenHeight * 4 /10);
	 	
	 	idangalinSirappuAnswerButton= (Button) findViewById(R.id.idangalinSirappuAnswerButton);
	 	idangalinSirappuAnswerButton.setTypeface(typeface);	 
	 	idangalinSirappuAnswerButton.setBackgroundColor(Color.parseColor("#006400"));
	 	idangalinSirappuAnswerButton.setTextSize(fontSize);
	 	idangalinSirappuAnswerButton.setText(ReEncodeTamil.unicode2tsc(res.getString(R.string.IndangalinSirappu_question)));
		    
	    
	    idangalinSirappuNextButton= (Button) findViewById(R.id.idangalinSirappuNextButton);
	    idangalinSirappuNextButton.setTypeface(typeface);	    
	    idangalinSirappuNextButton.setBackgroundColor(Color.parseColor("#228b22"));
	    idangalinSirappuNextButton.setTextSize(fontSize);
	    idangalinSirappuNextButton.setText(ReEncodeTamil.unicode2tsc(res.getString(R.string.IndangalinSirappu_next)));
	    
	    initOrRefreshIdangalinSirappu();
	    
	    OnClickListener idangalinSirappuAnswerSelector = new OnClickListener() {
			public void onClick(View v) {

				idangalinSirappuQuestionButton.setText(ReEncodeTamil.unicode2tsc(idangalinSirappuQuestion) + "\n\n(" + ReEncodeTamil.unicode2tsc(idangalinSirappuAnswer)+")");
			}
		};
		idangalinSirappuAnswerButton.setOnClickListener(idangalinSirappuAnswerSelector);
		
		
        
    	OnClickListener idangalinSirappuNextSelector = new OnClickListener() {
			public void onClick(View v) {

				initOrRefreshIdangalinSirappu();

			}
		};
		idangalinSirappuNextButton.setOnClickListener(idangalinSirappuNextSelector);
		
		
	

	}

	private void initOrRefreshIdangalinSirappu(){
		
		    idangalinSirappuQuestionButton.setBackgroundColor(Color.parseColor(getRandomColorRBGString()));
		    idangalinSirappuQuestionButton.setTextSize(fontSize);
		    
		    setOrResetRandomPazhaMozhiString();
		    idangalinSirappuQuestionButton.setText(ReEncodeTamil.unicode2tsc(idangalinSirappuQuestion));
		    
		   
	        
		
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
		int toLetter = idangalinSirappuArrayQuestions.length-1;
		int range = (toLetter - fromLetter) + 1;
		int randomNum = rn.nextInt(range) + fromLetter;
		//Log.e("Elango", "LETTERREF " + tamilLettersArray[randomNum] );
		idangalinSirappuQuestion = idangalinSirappuArrayQuestions[randomNum];
		idangalinSirappuAnswer = idangalinSirappuArrayAnswers[randomNum];
		
	}
	
}
