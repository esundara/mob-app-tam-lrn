package in.elango.tamillearning;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class TamilMonthsListAdapter extends ArrayAdapter<String> {

	private String[] tamilMonths;
	private String[] englishMonths;
	private String[] tamilSeasons;

	int screenHeight = 0;
	int screenWidth = 0;
	int sectionWidth=0;
	int fontSize = 0;

	Typeface typeface;

	private final Context context;

	public TamilMonthsListAdapter(Context context, String[] tamilMonths,
			String[] englishMonths, String[] tamilSeasons, int screenHeight,
			int screenWidth) {
		super(context, R.layout.tamilmonthsxmlweblayout, tamilMonths);
		this.context = context;
		this.tamilMonths = tamilMonths;
		this.englishMonths = englishMonths;
		this.tamilSeasons = tamilSeasons;
		this.screenHeight = screenHeight;
		this.screenWidth = screenWidth;
		sectionWidth = screenHeight / 3;
		fontSize = sectionWidth/ 10;
		typeface = Typeface.createFromAsset(context.getAssets(),
				"fonts/TSCu_Paranar.ttf");
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View rowView = inflater.inflate(R.layout.tamilmonthsxmlweblayout,
				parent, false);

		TextView tamilMonthsTextView = (TextView) rowView
				.findViewById(R.id.tamilMonthsTextViewID);
		TextView englishMonthsTextView = (TextView) rowView
				.findViewById(R.id.englishTextViewMonthsID);
		TextView tamilSeasonsTextView = (TextView) rowView
				.findViewById(R.id.tamilTextViewSeasonsID);

		tamilMonthsTextView.setTypeface(typeface);
		englishMonthsTextView.setTypeface(typeface);
		tamilSeasonsTextView.setTypeface(typeface);

		tamilMonthsTextView.setWidth(sectionWidth);
		englishMonthsTextView.setWidth(sectionWidth);
		tamilSeasonsTextView.setWidth(sectionWidth);
		
		tamilMonthsTextView.setTextSize(fontSize);
		englishMonthsTextView.setTextSize(fontSize);
		tamilSeasonsTextView.setTextSize(fontSize);
		
		tamilMonthsTextView.setText(ReEncodeTamil
				.unicode2tsc(tamilMonths[position]));
		englishMonthsTextView.setText(ReEncodeTamil
				.unicode2tsc(englishMonths[position]));
		tamilSeasonsTextView.setText(ReEncodeTamil
				.unicode2tsc(tamilSeasons[position]));

		// Log.e("Elango", "SEASON"+ tamilSeasons[position] );

		// Change the icon for Windows and iPhone

		if (position % 2 != 0) {
			// Line 2
			rowView.setBackgroundColor(Color.parseColor("#006400"));
		} else {
			// Line 1
			rowView.setBackgroundColor(Color.parseColor("#556b2f"));
		}
		return rowView;
	}

}
