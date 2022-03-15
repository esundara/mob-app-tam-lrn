package in.elango.tamillearning;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ListView;

public class Tamil extends ListActivity {

	Resources res;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// setContentView(R.layout.main);
		res = getResources();
		String menuTextID[] = {

				ReEncodeTamil
						.unicode2tsc(res
								.getString(R.string.Numbers_Colors_Shapes_etc_Menu_Text)),
				ReEncodeTamil.unicode2tsc(res
						.getString(R.string.Puzzle_Menu_Text)),
				ReEncodeTamil.unicode2tsc(res
								.getString(R.string.Vehicle_Kural_Menu_Text)),						
				ReEncodeTamil.unicode2tsc(res.getString(R.string.UirMei)),
				ReEncodeTamil.unicode2tsc(res
						.getString(R.string.Aathichoodi_main_menu)),
				ReEncodeTamil.unicode2tsc(res
						.getString(R.string.TamilEluthukkal_Menu)),
				ReEncodeTamil.unicode2tsc(res.getString(R.string.TamilMonths)),
				ReEncodeTamil.unicode2tsc(res
						.getString(R.string.IndruOruPazhaMozhiMenuText)),
				ReEncodeTamil.unicode2tsc(res
						.getString(R.string.UnakkuOruVidugathaiMenuText)),
				ReEncodeTamil.unicode2tsc(res
						.getString(R.string.yenMuraiMainMenuText)),
				ReEncodeTamil.unicode2tsc(res
						.getString(R.string.NyabagaGameMainMenuText)),
				ReEncodeTamil.unicode2tsc(res
						.getString(R.string.IndangalinSirappuMenuText)),
				ReEncodeTamil
						.unicode2tsc(res
								.getString(R.string.main_menu_culture_and_habits_of_india_text)),
				ReEncodeTamil.unicode2tsc(res
						.getString(R.string.global_time_text)) };

		// ListView listOptions = (ListView) findViewById(R.layout.main);
		ListMenuSupportAdapter adapter = new ListMenuSupportAdapter(this,
				menuTextID);
		setListAdapter(adapter);
	}

	// So we open the corresponding child's choice
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		String item = (String) getListAdapter().getItem(position);

		// Intent tamilLearningIntent = new Intent();
		// tamilLearningIntent.setClassName("in.elango.tamillearning",
		// "in.elango.tamillearning.Song");

		/**
		 * if(position==0){ //numbers startLearningSlides(0); // key/value pair,
		 * where key needs current package prefix. }else if(position==1){
		 * //colors startLearningSlides(12 ); }else if(position==2){ //shapes
		 * startLearningSlides (17 ); }else if(position==3){ //fruits
		 * startLearningSlides (22 ); }else if(position==4){ //animals
		 * startLearningSlides (26 ); }else if(position==5){ //vehicles
		 * startLearningSlides(31 ); } 
		 */
		if (position == 0) {
			startYenNiramVannamMatrumActivity();
		} else if (position == 1) {
			puzzleActivity();
		} else if (position == 2) {
			startVehiclesKuralPuzzle();
		}else if (position == 3) {
			// vehicles
			startUirMeiGame();
		} else if (position == 4) {
			// vehicles
			startAathichudi();
		} else if (position == 5) {
			// vehicles
			startTamilEluthukkalMenu();

		} else if (position == 6) {
			// Eluthikkal
			startTamilMonths();

		} else if (position == 7) {
			// PazhaMozhi
			startIndruOruPazhaMozhi();

		} else if (position == 8) {
			// PazhaMozhi
			startUnakkuOruVidugathai();

		}

		else if (position == 9) {
			// yenMurai
			startYenMuraiMenuList();

		} else if (position == 10) {
			// yenMurai
			startNyabagaGame();

		} else if (position == 11) {
			// yenMurai
			startIdangalinSirappu();

		} else if (position == 12) {
			// yenMurai
			cultureAndHabitsOfIndiaActivity();

		} else if (position == 13) {
			// yenMurai
			time();

		}

	}

	private void startYenNiramVannamMatrumActivity() {

		Intent yenNiramVannamMatrumIntent = new Intent();
		yenNiramVannamMatrumIntent.setClassName("in.elango.tamillearning",
				"in.elango.tamillearning.YenNiramVannamMatrumMenuActivity");
		startActivity(yenNiramVannamMatrumIntent);

	}

	/**
	 * private void startLearningSlides(int slideNumber){
	 * 
	 * Intent tamilLearningIntent = new Intent();
	 * tamilLearningIntent.setClassName("in.elango.tamillearning",
	 * "in.elango.tamillearning.Song");
	 * tamilLearningIntent.putExtra("TypeToPlay", slideNumber);
	 * startActivity(tamilLearningIntent);
	 * 
	 * }
	 */
	private void startUirMeiGame() {

		Intent uirMeiGame = new Intent();
		uirMeiGame.setClassName("in.elango.tamillearning",
				"in.elango.tamillearning.TamilmeiquizActivity");
		startActivity(uirMeiGame);

	}

	private void startAathichudi() {

		Intent aathichudi = new Intent();
		aathichudi.setClassName("in.elango.tamillearning",
				"in.elango.tamillearning.AaathichudiMainMenuActivity");
		startActivity(aathichudi);

	}

	private void startTamilMonths() {

		Intent tamilMonths = new Intent();
		tamilMonths.setClassName("in.elango.tamillearning",
				"in.elango.tamillearning.TamilMonthsActivity");
		startActivity(tamilMonths);

	}

	private void startTamilEluthukkalMenu() {

		Intent TamilEluthukkalMenuIntent = new Intent();
		TamilEluthukkalMenuIntent.setClassName("in.elango.tamillearning",
				"in.elango.tamillearning.TamilEluthukkalMenuActivity");
		startActivity(TamilEluthukkalMenuIntent);

	}

	private void startIndruOruPazhaMozhi() {

		Intent pazhaMozhi = new Intent();
		pazhaMozhi.setClassName("in.elango.tamillearning",
				"in.elango.tamillearning.IndruOruPazhaMozhiActivity");
		startActivity(pazhaMozhi);

	}

	private void startUnakkuOruVidugathai() {

		Intent UnakkuOruVidugathai = new Intent();
		UnakkuOruVidugathai.setClassName("in.elango.tamillearning",
				"in.elango.tamillearning.UnakkuOruVidugathaiActivity");
		startActivity(UnakkuOruVidugathai);

	}

	private void startYenMuraiMenuList() {

		Intent yenMurai = new Intent();
		yenMurai.setClassName("in.elango.tamillearning",
				"in.elango.tamillearning.YenMuraiMenuActivity");
		startActivity(yenMurai);

	}

	private void startNyabagaGame() {

		Intent nyabagaGame = new Intent();
		nyabagaGame.setClassName("in.elango.tamillearning",
				"in.elango.tamillearning.NyabagaGameActivity");
		startActivity(nyabagaGame);

	}

	private void startIdangalinSirappu() {

		Intent idangalinSirappu = new Intent();
		idangalinSirappu.setClassName("in.elango.tamillearning",
				"in.elango.tamillearning.IndangalinSirappuActivity");
		startActivity(idangalinSirappu);

	}

	private void cultureAndHabitsOfIndiaActivity() {

		Intent intent = new Intent();
		intent.setClassName("in.elango.tamillearning",
				"in.elango.tamillearning.CultureAndHabitsOfIndiaActivity");
		startActivity(intent);

	}

	private void time() {

		Intent intent = new Intent();
		intent.setClassName("in.elango.tamillearning",
				"in.elango.tamillearning.GlobalTimeActivity");
		startActivity(intent);

	}

	private void puzzleActivity() {

		Intent intent = new Intent();
		intent.setClassName("in.elango.tamillearning",
				"in.elango.tamillearning.PuzzleActivity");
		startActivity(intent);

	}
	private void startVehiclesKuralPuzzle() {

		Intent intent = new Intent();
		intent.setClassName("in.elango.tamillearning",
				"in.elango.tamillearning.VehiclesKuralPuzzleActivity");
		startActivity(intent);

	}
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {

		// Do nothing
	}
}