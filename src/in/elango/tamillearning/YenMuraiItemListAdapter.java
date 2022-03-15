package in.elango.tamillearning;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.graphics.Color;
import android.graphics.Typeface;



public class YenMuraiItemListAdapter extends ArrayAdapter<String> {

	private String[] yenMuraiValuesLeft;
	private String[] yenMuraiValuesRight;
	int yenMuraiItemFontSize;
	int screenwidth = 0;
	
	Typeface typeface;
	private final Context context;
	
	public YenMuraiItemListAdapter(Context context, String[] yenMuraiValuesLeft, String[] yenMuraiValuesRight,int yenMuraiMenuFontSize , int screenwidth) {
		
		super(context, R.layout.yen_murai_item_layout,yenMuraiValuesRight);
		this.context = context;
		this.yenMuraiValuesLeft = yenMuraiValuesLeft;
		this.yenMuraiValuesRight = yenMuraiValuesRight;		
		this.yenMuraiItemFontSize = yenMuraiMenuFontSize;
		this.screenwidth = screenwidth;
		typeface = Typeface.createFromAsset(context.getAssets(),
				"fonts/TSCu_Paranar.ttf");
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View rowView = inflater.inflate(R.layout.yen_murai_item_layout, parent,
				false);
		
		Button textViewValueLeft = (Button) rowView
				.findViewById(R.id.yenMuraiItemTextViewLeftID);
		Button textViewValueRight = (Button) rowView
				.findViewById(R.id.yenMuraiItemTextViewRightID);

		textViewValueLeft.setTypeface(typeface);
		textViewValueRight.setTypeface(typeface);

		
		textViewValueLeft.setTextSize(yenMuraiItemFontSize);
		textViewValueRight.setTextSize(yenMuraiItemFontSize);


		textViewValueLeft.setText(ReEncodeTamil
				.unicode2tsc(yenMuraiValuesLeft[position]));
		textViewValueRight.setText(ReEncodeTamil
				.unicode2tsc(yenMuraiValuesRight[position]));
				
		textViewValueLeft.setWidth(screenwidth /2);
		textViewValueRight.setWidth(screenwidth /2);
		

		if (position % 2 != 0) {
			// Line 2
			rowView.setBackgroundColor(Color.parseColor("#006400"));
			textViewValueLeft.setBackgroundColor(Color.parseColor("#006400"));
			textViewValueRight.setBackgroundColor(Color.parseColor("#006400"));
		} else {
			// Line 1
			rowView.setBackgroundColor(Color.parseColor("#556b2f"));
			textViewValueLeft.setBackgroundColor(Color.parseColor("#556b2f"));
			textViewValueRight.setBackgroundColor(Color.parseColor("#556b2f"));
		}	
		return rowView;
	}
}
