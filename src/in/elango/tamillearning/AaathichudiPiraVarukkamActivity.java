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

public class AaathichudiPiraVarukkamActivity extends Activity {
	Resources res;
	Typeface typeface;
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.aathichudi_other_varukkam_layout);
		
		res = getResources();
		typeface = Typeface.createFromAsset(getBaseContext().getAssets(),
					"fonts/TSCu_Paranar.ttf");
		
		
		
		 
		TextView textView1 = (TextView) findViewById(R.id.Aathichoodi_TV_ID_1);
		setProperties(textView1);
		textView1.setText(ReEncodeTamil.unicode2tsc(res.getString(R.string.Aathichoodi_heading_1)));

	
        textView1.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				Intent intent = new Intent();
				intent.setClassName("in.elango.tamillearning",
						"in.elango.tamillearning.AaathichudiItemsActivity");
				intent.putExtra("TO_PLAY", 0);
				startActivity(intent);

			}
		});
        
        TextView textView2 = (TextView) findViewById(R.id.Aathichoodi_TV_ID_2);
		setProperties(textView2);
		textView2.setText(ReEncodeTamil.unicode2tsc(res.getString(R.string.Aathichoodi_heading_2)));        
        textView2.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				Intent intent = new Intent();
				intent.setClassName("in.elango.tamillearning",
						"in.elango.tamillearning.AaathichudiItemsActivity");
				intent.putExtra("TO_PLAY", 1);
				startActivity(intent);

			}
		});
        
        TextView textView3 = (TextView) findViewById(R.id.Aathichoodi_TV_ID_3);
		setProperties(textView3);
		textView3.setText(ReEncodeTamil.unicode2tsc(res.getString(R.string.Aathichoodi_heading_3)));        
        textView3.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				Intent intent = new Intent();
				intent.setClassName("in.elango.tamillearning",
						"in.elango.tamillearning.AaathichudiItemsActivity");
				intent.putExtra("TO_PLAY", 2);
				startActivity(intent);

			}
		});
        
        TextView textView4 = (TextView) findViewById(R.id.Aathichoodi_TV_ID_4);
		setProperties(textView4);
		textView4.setText(ReEncodeTamil.unicode2tsc(res.getString(R.string.Aathichoodi_heading_4)));        
        textView4.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				Intent intent = new Intent();
				intent.setClassName("in.elango.tamillearning",
						"in.elango.tamillearning.AaathichudiItemsActivity");
				intent.putExtra("TO_PLAY", 3);
				startActivity(intent);

			}
		});
        TextView textView5 = (TextView) findViewById(R.id.Aathichoodi_TV_ID_5);
		setProperties(textView5);
		textView5.setText(ReEncodeTamil.unicode2tsc(res.getString(R.string.Aathichoodi_heading_5)));        
        textView5.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				Intent intent = new Intent();
				intent.setClassName("in.elango.tamillearning",
						"in.elango.tamillearning.AaathichudiItemsActivity");
				intent.putExtra("TO_PLAY", 4);
				startActivity(intent);

			}
		});
        TextView textView6 = (TextView) findViewById(R.id.Aathichoodi_TV_ID_6);
		setProperties(textView6);
		textView6.setText(ReEncodeTamil.unicode2tsc(res.getString(R.string.Aathichoodi_heading_6)));        
        textView6.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				Intent intent = new Intent();
				intent.setClassName("in.elango.tamillearning",
						"in.elango.tamillearning.AaathichudiItemsActivity");
				intent.putExtra("TO_PLAY", 5);
				startActivity(intent);

			}
		});
        TextView textView7 = (TextView) findViewById(R.id.Aathichoodi_TV_ID_7);
		setProperties(textView7);
		textView7.setText(ReEncodeTamil.unicode2tsc(res.getString(R.string.Aathichoodi_heading_7)));        
        textView7.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				Intent intent = new Intent();
				intent.setClassName("in.elango.tamillearning",
						"in.elango.tamillearning.AaathichudiItemsActivity");
				intent.putExtra("TO_PLAY", 6);
				startActivity(intent);

			}
		});
        
        TextView textView8 = (TextView) findViewById(R.id.Aathichoodi_TV_ID_8);
		setProperties(textView8);
		textView8.setText(ReEncodeTamil.unicode2tsc(res.getString(R.string.Aathichoodi_heading_8)));        
        textView8.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				Intent intent = new Intent();
				intent.setClassName("in.elango.tamillearning",
						"in.elango.tamillearning.AaathichudiItemsActivity");
				intent.putExtra("TO_PLAY", 7);
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
