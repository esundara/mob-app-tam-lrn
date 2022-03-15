package in.elango.tamillearning;

import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class AaathichudiItemsActivity extends Activity {
	Resources res;
	Typeface typeface;
	private String[] aathichoodiItemsArray;

	TableRow tr1;
	TableRow tr2;
	TextView textView1;
	TextView textView2;
	int aathichoodiItemNumber;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.aathichudi_items_layout);
		res = getResources();
		typeface = Typeface.createFromAsset(getBaseContext().getAssets(),
				"fonts/TSCu_Paranar.ttf");

		Intent intentSongToPlay = getIntent();
		aathichoodiItemNumber = intentSongToPlay.getIntExtra("TO_PLAY", 0);

		if (0 == aathichoodiItemNumber) {
			aathichoodiItemsArray = res
					.getStringArray(R.array.tamil_aathichoodi_text_uirmei_varukkam);
		}else if (1 == aathichoodiItemNumber) {
			aathichoodiItemsArray = res
					.getStringArray(R.array.tamil_aathichoodi_text_kakara_varukkam);
		} else if (2 == aathichoodiItemNumber) {
			aathichoodiItemsArray = res
					.getStringArray(R.array.tamil_aathichoodi_text_sagara_varukkam);
		} else if (3 == aathichoodiItemNumber) {
			aathichoodiItemsArray = res
					.getStringArray(R.array.tamil_aathichoodi_text_thagara_varukkam);
		} else if (4 == aathichoodiItemNumber) {
			aathichoodiItemsArray = res
					.getStringArray(R.array.tamil_aathichoodi_text_nagara_varukkam);
		} else if (5 == aathichoodiItemNumber) {
			aathichoodiItemsArray = res
					.getStringArray(R.array.tamil_aathichoodi_text_pagara_varukkam);
		} else if (6 == aathichoodiItemNumber) {
			aathichoodiItemsArray = res
					.getStringArray(R.array.tamil_aathichoodi_text_magara_varukkam);
		} else if (7 == aathichoodiItemNumber) {
			aathichoodiItemsArray = res
					.getStringArray(R.array.tamil_aathichoodi_text_vagara_varukkam);
		}
		

		TableLayout table1 = (TableLayout) findViewById(R.id.aathichudiItemsTableLayoutID);

		// sv.addView(tl);

		LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

		for (int i = 0; i < aathichoodiItemsArray.length; i++) {

			tr1 = (TableRow) new TableRow(this);
			textView1 = new TextView(this);
			textView1.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
			textView1.setTextSize(getResources().getDimension(
					R.dimen.dimens_aathichudi_item));
			textView1.setTypeface(typeface);
			textView1.setText(ReEncodeTamil
					.unicode2tsc(aathichoodiItemsArray[i]));
			textView1.setMaxLines(5);// HARD CODING
			
			if (i % 2 != 0) {
				// Line 2
				textView1.setBackgroundColor(Color.parseColor("#006400"));
			} else {
				// Line 1
				textView1.setBackgroundColor(Color.parseColor("#556b2f"));
			}
			textView1.setMaxLines(5);// HARD CODING
			tr1.addView(textView1);
			table1.setShrinkAllColumns(true);
			table1.addView(tr1, new TableLayout.LayoutParams(layoutParams));

		}

	}

	protected void onActivityResult(int requestCode, int resultCode, Intent data) {

		// Do nothing
	}

}
