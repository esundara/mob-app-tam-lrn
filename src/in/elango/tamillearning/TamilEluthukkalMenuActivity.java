package in.elango.tamillearning;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;

public class TamilEluthukkalMenuActivity extends Activity {
	
	Resources res;
	 /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.tamil_letters_menu_layout);
        res = getResources();
        				
        Typeface typeface = Typeface.createFromAsset(this.getAssets(),
				"fonts/TSCu_Paranar.ttf");


        
        Button headingButton= (Button) findViewById(R.id.tamilEluthukkalMenuHeadingButtonId);
        headingButton.setTypeface(typeface);
        headingButton.setText(ReEncodeTamil.unicode2tsc(res.getString(R.string.TamilEluthukkal)));
        headingButton.setBackgroundColor(Color.parseColor("#ffa500"));
        
        Button slateButton= (Button) findViewById(R.id.slate_button_id);
        slateButton.setTypeface(typeface);
        slateButton.setText(ReEncodeTamil.unicode2tsc(res.getString(R.string.menu_text_slate_game)));
        slateButton.setBackgroundColor(Color.parseColor("#556b2f"));
        
        Button uirMenuButton= (Button) findViewById(R.id.MenuTamilLettersUirEluthuID);
        uirMenuButton.setTypeface(typeface);
        uirMenuButton.setText(ReEncodeTamil.unicode2tsc(res.getString(R.string.TamilEluthukkal_Uir)));
        uirMenuButton.setBackgroundColor(Color.parseColor("#006400"));

        Button meiMenuButton= (Button) findViewById(R.id.MenuTamilLettersMeiEluthuID);
        meiMenuButton.setTypeface(typeface);
        meiMenuButton.setText(ReEncodeTamil.unicode2tsc(res.getString(R.string.TamilEluthukkal_Mei)));
        meiMenuButton.setBackgroundColor(Color.parseColor("#556b2f"));
                
        Button uirMeiMenuButton= (Button) findViewById(R.id.MenuTamilLettersUirMeiEluthuID);
        uirMeiMenuButton.setTypeface(typeface);
        uirMeiMenuButton.setText(ReEncodeTamil.unicode2tsc(res.getString(R.string.TamilEluthukkal_UirMei)));
        uirMeiMenuButton.setBackgroundColor(Color.parseColor("#006400"));

        
        
        slateButton.setOnClickListener(new View.OnClickListener() {
     			public void onClick(View v) {
     				
     					
     					Intent sl = new Intent();
     					sl.setClassName("in.elango.tamillearning", "in.elango.tamillearning.SlateActivity");
     		        	startActivity(sl);
     		        	
     							}
     		});
        uirMenuButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				
					
					Intent eluthukkal = new Intent();
					eluthukkal.setClassName("in.elango.tamillearning", "in.elango.tamillearning.TamilEluthukkalActivity");
					eluthukkal.putExtra("TO_PLAY", 0);
		        	startActivity(eluthukkal);
		        	
							}
		});
        
        meiMenuButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				
				Intent eluthukkal = new Intent();
				eluthukkal.setClassName("in.elango.tamillearning", "in.elango.tamillearning.TamilEluthukkalActivity");
				eluthukkal.putExtra("TO_PLAY", 12);
	        	startActivity(eluthukkal);
	        	}
		});
        uirMeiMenuButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				
				Intent eluthukkal = new Intent();
				eluthukkal.setClassName("in.elango.tamillearning", "in.elango.tamillearning.TamilEluthukkalActivity");
				eluthukkal.putExtra("TO_PLAY", 30);
	        	startActivity(eluthukkal);							}
		});
    }
        
       
    
    
    
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

    	// Do nothing
    }
}