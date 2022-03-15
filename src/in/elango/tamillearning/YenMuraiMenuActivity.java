package in.elango.tamillearning;

import java.util.Random;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class YenMuraiMenuActivity extends Activity {
	Resources res;
	private String[] yenMuraiMainMenu;
	int yenMuraiMenuFontSize;

	
	
	/** Called when the activity is first created. */

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.yen_murai_menu_layout);

		res = getResources();
		Typeface typeface = Typeface.createFromAsset(this.getAssets(),
				"fonts/TSCu_Paranar.ttf");
		yenMuraiMainMenu = res
				.getStringArray(R.array.yen_murai_menu_list_array_text);

		DisplayMetrics metrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(metrics);
		yenMuraiMenuFontSize = metrics.widthPixels / 24;
		// //////////////////////
		Button yengalHeaderButton;
		yengalHeaderButton = (Button) findViewById(R.id.YenMurai_Headers_Text_Button_ID);
		yengalHeaderButton.setTypeface(typeface);
		yengalHeaderButton.setBackgroundColor(Color.parseColor("#b8860b"));
		yengalHeaderButton.setTextSize(yenMuraiMenuFontSize);
		yengalHeaderButton.setText(ReEncodeTamil.unicode2tsc(res
				.getString(R.string.yenMuraiMainMenuText)));
		// //////////////////////
		// //////////////////////
		Button mudhalEngalButton;
		mudhalEngalButton = (Button) findViewById(R.id.YenMurai_Mudhal_Yengal_Button_ID);
		mudhalEngalButton.setTypeface(typeface);
		mudhalEngalButton.setBackgroundColor(Color.parseColor("#006400"));
		mudhalEngalButton.setTextSize(yenMuraiMenuFontSize);
		mudhalEngalButton.setText(ReEncodeTamil.unicode2tsc(res
				.getString(R.string.yen_murai_mudhal_engal_text)));

		mudhalEngalButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				Intent mudhalEngalIntent = new Intent();
				mudhalEngalIntent.setClassName("in.elango.tamillearning",
						"in.elango.tamillearning.YenMuraiItemActivity");
				mudhalEngalIntent.putExtra("TO_PLAY", 0);
				startActivity(mudhalEngalIntent);
			}
		});
		// //////////////////////
		// //////////////////////
		Button tenMultiplesButton;
		tenMultiplesButton = (Button) findViewById(R.id.YenMurai_ten_multiples_pathinperukkam_Button_ID);
		tenMultiplesButton.setTypeface(typeface);
		tenMultiplesButton.setBackgroundColor(Color.parseColor("#556b2f"));
		tenMultiplesButton.setTextSize(yenMuraiMenuFontSize);
		tenMultiplesButton.setText(ReEncodeTamil.unicode2tsc(res
				.getString(R.string.yen_murai_ten_multiples_text)));

		tenMultiplesButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				Intent mudhalEngalIntent = new Intent();
				mudhalEngalIntent.setClassName("in.elango.tamillearning",
						"in.elango.tamillearning.YenMuraiItemActivity");
				mudhalEngalIntent.putExtra("TO_PLAY", 1);
				startActivity(mudhalEngalIntent);
			}
		});
		// //////////////////////
		Button yenMuraiFractionsButton;
		yenMuraiFractionsButton = (Button) findViewById(R.id.YenMurai_Fractions_Button_ID);
		yenMuraiFractionsButton.setTypeface(typeface);
		yenMuraiFractionsButton.setBackgroundColor(Color.parseColor("#006400"));
		yenMuraiFractionsButton.setTextSize(yenMuraiMenuFontSize);
		yenMuraiFractionsButton.setText(ReEncodeTamil.unicode2tsc(res
				.getString(R.string.yen_murai_fractions_text)));

		yenMuraiFractionsButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				Intent mudhalEngalIntent = new Intent();
				mudhalEngalIntent.setClassName("in.elango.tamillearning",
						"in.elango.tamillearning.YenMuraiItemActivity");
				mudhalEngalIntent.putExtra("TO_PLAY", 2);
				startActivity(mudhalEngalIntent);
			}
		});
		// //////////////////////
		// //////////////////////
		Button yenPadalButton;
		yenPadalButton = (Button) findViewById(R.id.YenMurai_Yen_Padal_Button_ID);
		yenPadalButton.setTypeface(typeface);
		yenPadalButton.setBackgroundColor(Color.parseColor("#556b2f"));
		yenPadalButton.setTextSize(yenMuraiMenuFontSize);
		yenPadalButton.setText(ReEncodeTamil.unicode2tsc(res
				.getString(R.string.yen_murai_yen_padal_text)));

		yenPadalButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				Intent mudhalEngalIntent = new Intent();
				mudhalEngalIntent.setClassName("in.elango.tamillearning",
						"in.elango.tamillearning.YenMuraiItemActivity");
				mudhalEngalIntent.putExtra("TO_PLAY", 3);
				startActivity(mudhalEngalIntent);
			}
		});
		// //////////////////////
	}

	private static String[] colorRBGs = { "#006400", "#2e8b57", "#00ff7f",
			"#7cfc00", "#32cd32", "#228b22", "#adff2f" };

	private static String getRandomColorRBGString() {

		Random rn = new Random();
		int fromLetter = 0;
		int toLetter = colorRBGs.length - 1;
		int range = (toLetter - fromLetter) + 1;
		int randomNum = rn.nextInt(range) + fromLetter;
		// Log.e("Elango", "LETTERREF " + tamilLettersArray[randomNum] );
		return colorRBGs[randomNum];
	}
}
