package in.elango.tamillearning;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class AaathichudiMainMenuActivity extends Activity {
	Resources res;
	Typeface typeface;
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.aathichudi_main_menu_layout);
		
		res = getResources();
		typeface = Typeface.createFromAsset(getBaseContext().getAssets(),
					"fonts/TSCu_Paranar.ttf");
		
		
		
		 
		TextView textView1 = (TextView) findViewById(R.id.Aathichoodi_uir_id);
		setProperties(textView1);
		textView1.setText(ReEncodeTamil.unicode2tsc(res.getString(R.string.Aathichoodi_Uir)));

	
        textView1.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				Intent intent = new Intent();
				intent.setClassName("in.elango.tamillearning",
						"in.elango.tamillearning.AaathichudiUIRActivity");
				//intent.putExtra("TO_PLAY", 0);
				startActivity(intent);

			}
		});
        
        TextView textView2 = (TextView) findViewById(R.id.Aathichoodi_pira_varukkam_id);
		setProperties(textView2);
		textView2.setText(ReEncodeTamil.unicode2tsc(res.getString(R.string.Aathichoodi_pira_varukam)));        
        textView2.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				Intent intent = new Intent();
				intent.setClassName("in.elango.tamillearning",
						"in.elango.tamillearning.AaathichudiPiraVarukkamActivity");
				intent.putExtra("TO_PLAY", 1);
				startActivity(intent);

			}
		});
        
               		
	}

	private void setProperties(TextView textView){

		textView.setTypeface(typeface);
		textView.setGravity(Gravity.CENTER_VERTICAL	| Gravity.LEFT);
		textView.setTextSize(getResources().getDimension(R.dimen.dimens_aathichudi_menu_heading_item));
		textView.setMaxLines(5);// HARD CODING
		
		//textView.sets
		textView.setMovementMethod(new ScrollingMovementMethod());
	}
	
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {

		// Do nothing
	}

}
