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

public class YenNiramVannamMatrumMenuActivity extends Activity {

	Resources res;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.yen_niram_vadivam_matrum_menu_layout);
		
		res = getResources();

		Typeface typeface = Typeface.createFromAsset(this.getAssets(),
				"fonts/TSCu_Paranar.ttf");

		Button numbersButton = (Button) findViewById(R.id.YenNiram_Numbers_Menu_Button_ID);
		numbersButton.setTypeface(typeface);
		numbersButton.setText(ReEncodeTamil.unicode2tsc(res
				.getString(R.string.Numbers)));
		numbersButton.setBackgroundColor(Color.parseColor("#006400"));
		numbersButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				
				startLearningSlides(0);

			}
		});		
		
		Button colorsButton = (Button) findViewById(R.id.YenNiram_Colors_Menu_Button_ID);
		colorsButton.setTypeface(typeface);
		colorsButton.setText(ReEncodeTamil.unicode2tsc(res
				.getString(R.string.Colors)));
		colorsButton.setBackgroundColor(Color.parseColor("#556b2f"));
		colorsButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				startLearningSlides(12);
			}
		});
		

		Button shapesButton = (Button) findViewById(R.id.YenNiram_shapes_Menu_Button_ID);
		shapesButton.setTypeface(typeface);
		shapesButton.setText(ReEncodeTamil.unicode2tsc(res
				.getString(R.string.Shapes)));
		shapesButton.setBackgroundColor(Color.parseColor("#006400"));
		shapesButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				startLearningSlides(17);
			}
		});
		
		
		Button fruitsButton = (Button) findViewById(R.id.YenNiram_Fruits_Menu_Button_ID);
		fruitsButton.setTypeface(typeface);
		fruitsButton.setText(ReEncodeTamil.unicode2tsc(res
				.getString(R.string.Fruits)));
		fruitsButton.setBackgroundColor(Color.parseColor("#556b2f"));
		shapesButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				startLearningSlides(22);
			}
		});
		
		Button animalsButton = (Button) findViewById(R.id.YenNiram_Animals_Menu_Button_ID);
		animalsButton.setTypeface(typeface);
		animalsButton.setText(ReEncodeTamil.unicode2tsc(res
				.getString(R.string.Animals)));
		animalsButton.setBackgroundColor(Color.parseColor("#006400"));
		animalsButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				startLearningSlides(26);
			}
		});
		
		Button vehiclesButton = (Button) findViewById(R.id.YenNiram_Vehicles_Menu_Button_ID);
		vehiclesButton.setTypeface(typeface);
		vehiclesButton.setText(ReEncodeTamil.unicode2tsc(res
				.getString(R.string.Vehicles)));
		vehiclesButton.setBackgroundColor(Color.parseColor("#556b2f"));
		vehiclesButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				startLearningSlides(31);
			}
		});
		

		
		
	}

	private void startLearningSlides(int slideNumber) {

		Intent tamilLearningIntent = new Intent();
		tamilLearningIntent.setClassName("in.elango.tamillearning",
				"in.elango.tamillearning.Song");
		
		Song.initilizedAlready = false;
		tamilLearningIntent.putExtra("TypeToPlay", slideNumber);
		startActivity(tamilLearningIntent);

	}

	protected void onActivityResult(int requestCode, int resultCode, Intent data) {

		// Do nothing
	}
}