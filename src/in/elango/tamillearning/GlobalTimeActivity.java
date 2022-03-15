package in.elango.tamillearning;

import java.text.DateFormatSymbols;
import java.text.DecimalFormat;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;

import android.os.Bundle;
import android.os.Message;
import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.method.ScrollingMovementMethod;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Handler;

public class GlobalTimeActivity extends Activity {

	private int screenHeight;
	private int screenWidth;
	private int heightMultiple;
	private int widthMultiple;
	private int buttonsTextFontSize;
	private int pointsTextFontSize;
	private int colorNameFontSize;
	private int colorDisplayHeight;
	TimeZone tz = null;
	Date now = null;
	TextView tempTV= null;

	
	Resources res = null;

	String[] colorNames = null;
	String[] colorCodes = null;

	String[] timeZoneIDs = null;
	String[] timeZoneDisplayNames = null;
	DateFormatSymbols symbols;
	
	
	final Vector textViewVector = new Vector();
	SimpleDateFormat formatter;
	
	TableRow tr1;
	TableRow tr2;
	TextView textView1;
	TextView textView2;
	
	Handler mHandler;
	Typeface typeface; 
	String[] tamilDays;
	String tamilHour;
	String tamilMinute;
	String tamilSecond;
	String tamilAM;
	String tamilPM;
	String[] tamilAMPM;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.time_converter_layout);

		DisplayMetrics metrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(metrics);
		this.screenHeight = metrics.heightPixels;
		this.screenWidth = metrics.widthPixels;
		colorNameFontSize = screenWidth / 25;
		colorDisplayHeight = screenHeight / 6;
		
		typeface = Typeface.createFromAsset(this.getAssets(),
				"fonts/TSCu_Paranar.ttf");
		TimerTask task;
		Timer timer;
						
		
		widthMultiple = screenWidth;
		buttonsTextFontSize = screenWidth / 20;

		res = getResources();
		//colorNames = res.getStringArray(R.array.global_time_color_names_array);
		colorCodes = res.getStringArray(R.array.global_time_color_name_codes_array);

		timeZoneIDs = res.getStringArray(R.array.global_time_zone_ids);
		timeZoneDisplayNames = res
				.getStringArray(R.array.global_time_zone_names);

		// ScrollView sv = new ScrollView(this);

	

		TableLayout table1 = (TableLayout) findViewById(R.id.globalTimeTableLayoutID);

		// sv.addView(tl);
		
		

		LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		
		tamilHour = res.getString(R.string.global_time_tamil_hour);
		tamilMinute = res.getString(R.string.global_time_tamil_minute);
		tamilSecond = res.getString(R.string.global_time_tamil_second);
		String[] tamilDays = res.getStringArray(R.array.global_time_tamil_days);
		
		for (int i= 0; i < tamilDays.length; i++){
			tamilDays[i] = ReEncodeTamil.unicode2tsc(tamilDays[i]);
		}
		tamilAM =ReEncodeTamil.unicode2tsc(res.getString(R.string.global_time_tamil_AM));
		tamilPM =ReEncodeTamil.unicode2tsc(res.getString(R.string.global_time_tamil_PM));
		tamilAMPM = new String []{tamilAM,tamilPM };
		
		symbols = new DateFormatSymbols();
		symbols.setShortWeekdays(tamilDays);
		symbols.setAmPmStrings(tamilAMPM);
		 
						
		final String timePattern = ReEncodeTamil.unicode2tsc("EEE a, h"+tamilHour+" mm"+tamilMinute+" ss"+tamilSecond);
		
		formatter = new SimpleDateFormat(timePattern,symbols);
		//
		// formatter.setCalendar(calendar);

		
		// String output = formatter.format(now);

		Handler handler = new Handler();
		

		for (int i = 0; i < timeZoneIDs.length; i++) {
						
			tz = TimeZone.getTimeZone(timeZoneIDs[i]);
			
			
			formatter.setTimeZone(tz);
			now = new Date();
			tr1 = (TableRow) new TableRow(this);
			textView1 = new TextView(this);
			textView1.setGravity(Gravity.CENTER_VERTICAL
					| Gravity.CENTER_HORIZONTAL);
			textView1.setTextSize(getResources().getDimension(R.dimen.dimens_global_time_location));
			//textView1.setTextSize(colorNameFontSize / 2);
			// textView1.setText(colorNames[i]);
			textView1.setTypeface(typeface);
			textView1.setText(ReEncodeTamil.unicode2tsc(timeZoneDisplayNames[i]));
			textView1.setBackgroundColor(Color.parseColor(colorCodes[i]));
			textView1.setHeight(colorDisplayHeight);
			textView1.setMaxLines(5);// HARD CODING
			tr1.addView(textView1);
			table1.setShrinkAllColumns(true);
			table1.addView(tr1, new TableLayout.LayoutParams(layoutParams));
			

			tr2 = (TableRow) new TableRow(this);
			textView2 = new TextView(this);
			textView2.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.TOP);
			textView2.setTextSize(getResources().getDimension(R.dimen.dimens_global_time));
			textView2.setTypeface(typeface);

			
			//textView2.setTextSize(colorNameFontSize);
			textView2.setText(ReEncodeTamil.unicode2tsc(formatter.format(now)));
			textView2.setBackgroundColor(Color.parseColor(colorCodes[i]));
			textView1.setHeight(colorDisplayHeight);
			textView2.setMaxLines(5);// HARD CODING
			tr2.addView(textView2);
			textViewVector.add(textView2);
			table1.addView(tr2, new TableLayout.LayoutParams(layoutParams));
			

		}

		tr2 = (TableRow) new TableRow(this);
		textView2 = new TextView(this);
		textView2.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CLIP_VERTICAL);
		textView2.setTextSize(getResources().getDimension(R.dimen.dimens_global_time_caveat));
		//textView2.setTextSize(colorNameFontSize / 3);
		textView2.setText("Time Calculations Based On Time In Your Hardware");
		textView2.setBackgroundColor(Color.MAGENTA);
		textView2.setHeight(colorDisplayHeight);
		textView2.setMovementMethod(new ScrollingMovementMethod());
		tr2.addView(textView2);

		table1.addView(tr2, new TableLayout.LayoutParams(layoutParams));
		
		final String textTochange = "text";
		task = new TimerTask() {
            public void run() {
            	
            	//updateTime();
            	
            	Message msg = new Message();
            	
            	msg.obj = textTochange;
            	mHandler.sendMessage(msg);
            }
                
        };
        timer = new Timer();
        timer.schedule(task, 1000, 1000);
       
        
        mHandler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                String text = (String)msg.obj;
                //call setText here
                
                for (int i = 0; i < textViewVector.size(); i++) {
        			tz = TimeZone.getTimeZone(timeZoneIDs[i]);
        			formatter.setTimeZone(tz);
        			now = new Date();

        			tempTV = (TextView) textViewVector.get(i);					
        			tempTV.setText(formatter.format(now));
        			
        		}
                
    			//Log.e("ELANGO", "CALLED");

            }
    };
		
		

	}
	
	

}
