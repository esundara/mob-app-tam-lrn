package in.elango.tamillearning;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.webkit.WebView;
import android.widget.ListView;
import android.widget.Toast;


public class TamilMonthsActivity extends ListActivity {
	 
	  private  String[] tamilMonths;
	  private  String[] englishMonths;
	  private  String[] tamilSeasons;
	  int screenHeight = 0;
	  int screenWidth = 0;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	
		Resources res = getResources();      
	       
		 tamilMonths = res.getStringArray(R.array.TamilMonthsArray);
		 englishMonths = res.getStringArray(R.array.EnglishMonthsArray);
		 tamilSeasons = res.getStringArray(R.array.TamilSeasonsArray);
		 
		 DisplayMetrics metrics = new DisplayMetrics();
		 getWindowManager().getDefaultDisplay().getMetrics(metrics);
		 this.screenHeight = metrics.heightPixels;
		 this.screenWidth = metrics.widthPixels;
		
		 
		 TamilMonthsListAdapter adapter= new TamilMonthsListAdapter(getApplicationContext(), tamilMonths, englishMonths, tamilSeasons, screenHeight, screenWidth );
		 setListAdapter(adapter);
	}
	
	//So we open the corresponding child's choice
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
    	String item = (String) getListAdapter().getItem(position);
      
    	Toast toast = Toast.makeText(this, "Tamil Months and how they match with English Months ", 500);
    	toast.show();
   

    }

protected void onActivityResult(int requestCode, int resultCode, Intent data) {

	// Do nothing
}

 
}