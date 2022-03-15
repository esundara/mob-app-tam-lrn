package in.elango.tamillearning;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.graphics.Color;
import android.graphics.Typeface;

public class AathichoodiListAdapter  extends ArrayAdapter<String> {
	
	  private  String[] aathichoodiFaces;
	  private  String[] aathichoodiValues; 

	  

	  Typeface typeface; 
	  
	  private final Context context;

	  public AathichoodiListAdapter(Context context, String[] aathichoodiFaces, String[] aathichoodiValues) {
	    super(context, R.layout.aathichoodilayout, aathichoodiValues);
	    this.context = context;
	    this.aathichoodiFaces = aathichoodiFaces;
	    
	    this.aathichoodiValues = aathichoodiValues;


	    
	    typeface = Typeface.createFromAsset(context.getAssets(),
				"fonts/TSCu_Paranar.ttf");
	  }
	  @Override
	  public View getView(int position, View convertView, ViewGroup parent) {
	    LayoutInflater inflater = (LayoutInflater) context
	        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	  		    View rowView = inflater.inflate(R.layout.aathichoodilayout, parent, false);
	  		    
	    TextView textViewFace = (TextView) rowView.findViewById(R.id.aathichoodilFaceID);
	    TextView textViewValue = (TextView) rowView.findViewById(R.id.aathichoodiValueID);
	    
	    textViewFace.setTypeface(typeface);
	    textViewValue.setTypeface(typeface);
	    
	    textViewFace.setText(ReEncodeTamil.unicode2tsc(aathichoodiFaces[position]));
	    textViewValue.setText(ReEncodeTamil.unicode2tsc(aathichoodiValues[position]));
	    
	    // Change the icon for Windows and iPhone
 
    
	    if(position%2 != 0){
	    	// Line 2
	    	rowView.setBackgroundColor(Color.parseColor("#006400"));
	    } else {
	    	// Line 1
			rowView.setBackgroundColor(Color.parseColor("#556b2f"));
		  }
	    return rowView;
	  }
	} 
