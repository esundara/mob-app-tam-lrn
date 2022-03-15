package in.elango.tamillearning;

import android.app.ListActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

public class AaathichudiUIRActivity extends ListActivity {
	Resources res;
	private String[] aathichoodiMeaning;
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		res = getResources();

		aathichoodiMeaning = res
				.getStringArray(R.array.tamil_aathichoodi_meaning);

		// ListView listOptions = (ListView) findViewById(R.layout.main);
		AathichoodiListAdapter adapter = new AathichoodiListAdapter(this,
				res.getStringArray(R.array.tamil_aathichoodi_face_letters),
				res.getStringArray(R.array.tamil_aathichoodi_text));
		setListAdapter(adapter);
	}

	// So we open the corresponding child's choice
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// String item = (String) getListAdapter().getItem(position);

		Toast toast = Toast.makeText(this, aathichoodiMeaning[position], 500);
		toast.show();

	}

	protected void onActivityResult(int requestCode, int resultCode, Intent data) {

		// Do nothing
	}

}
