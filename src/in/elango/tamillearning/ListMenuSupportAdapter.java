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

public class ListMenuSupportAdapter extends ArrayAdapter<String> {
	
	  	  private final String[] values;
		  int imageID[] ={R.drawable.ic_menu_numbers,R.drawable.ic_menu_puzzle,R.drawable.ic_menu_puzzle_kural_vehicle,R.drawable.ic_menu_uirmei_vilaiyadu, R.drawable.ic_menu_aathichoodi, R.drawable.ic_menu_tamileluthukkal,R.drawable.ic_menu_tamilmonths,R.drawable.ic_menu_indru_oru_pazha_mozhi,R.drawable.ic_menu_unakku_oru_vidugathai,R.drawable.ic_menu_yen_murai_main_menu,R.drawable.ic_menu_indru_nyabaga_game,R.drawable.ic_menu_idam,R.drawable.ic_menu_pazhakam,R.drawable.ic_menu_time};
		  Typeface typeface; 		  
		  private final Context context;

		  public ListMenuSupportAdapter(Context context, String[] values) {
		    super(context, R.layout.main, values);
		    this.context = context;
		    this.values = values;		    
		    typeface = Typeface.createFromAsset(context.getAssets(),
					"fonts/TSCu_Paranar.ttf");
		  }
		  @Override
		  public View getView(int position, View convertView, ViewGroup parent) {
		    LayoutInflater inflater = (LayoutInflater) context
		        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		  		    View rowView = inflater.inflate(R.layout.main, parent, false);
		  		    
		    TextView textView = (TextView) rowView.findViewById(R.id.labelID);
		    
		    
		    textView.setTypeface(typeface);
		    ImageView imageView = (ImageView) rowView.findViewById(R.id.imageID);
		    textView.setText(values[position]);
		    // Change the icon for Windows and iPhone
	   
		    imageView.setImageResource(imageID[position]);
		    
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

