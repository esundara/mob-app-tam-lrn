package in.elango.tamillearning;

import android.app.ListActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

public class YenMuraiItemActivity extends ListActivity {
	Resources res;
	int yenMuraiMenuFontSize;
	int itemToShow = 0;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		res = getResources();
		DisplayMetrics metrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(metrics);
		yenMuraiMenuFontSize = metrics.widthPixels / 30;

		Intent intentItemToPlay = getIntent();
		itemToShow = intentItemToPlay.getIntExtra("TO_PLAY", 0);

		if (itemToShow == 0) {

			YenMuraiItemListAdapter adapter = new YenMuraiItemListAdapter(
					this,
					res.getStringArray(R.array.yen_murai_item_mudal_engal_left),
					res.getStringArray(R.array.yen_murai_item_mudal_engal_right),
					yenMuraiMenuFontSize, metrics.widthPixels);
			setListAdapter(adapter);

		}
		
		if (itemToShow == 1) {

			YenMuraiItemListAdapter adapter = new YenMuraiItemListAdapter(
					this,
					res.getStringArray(R.array.yen_murai_item_ten_multiples_left),
					res.getStringArray(R.array.yen_murai_item_ten_multiples_right),
					yenMuraiMenuFontSize, metrics.widthPixels);
			setListAdapter(adapter);

		}
		if (itemToShow == 2) {

			YenMuraiItemListAdapter adapter = new YenMuraiItemListAdapter(
					this,
					res.getStringArray(R.array.yen_murai_item_fractions_left),
					res.getStringArray(R.array.yen_murai_item_fractions_right),
					yenMuraiMenuFontSize, metrics.widthPixels);
			setListAdapter(adapter);

		}
		if (itemToShow == 3) {

			YenMuraiItemListAdapter adapter = new YenMuraiItemListAdapter(
					this,
					res.getStringArray(R.array.yen_murai_item_yen_padal_left),
					res.getStringArray(R.array.yen_murai_item_yen_padal_right),
					yenMuraiMenuFontSize, metrics.widthPixels);
			setListAdapter(adapter);
		}
	}
	// So we open the corresponding child's choice
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// String item = (String) getListAdapter().getItem(position);

		Toast toast = Toast.makeText(this, "Tamil", 500);
		toast.show();
	}
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {

		// Do nothing
	}		
}
