package in.elango.tamillearning;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.Random;

import android.content.res.Resources;
import android.util.Log;

public class TamilLetters {

	 static String[] tamilLettersArray = null;
	 static String[] tamilLetterReferencesArray = null;

	private static String[] optionLettersArray_N = null;
	private static String quizQuestion_uir_part = null;
	private static String quizQuestion_Mei_part = null; 
	private static String quizAnswer_Uir_Mei_Letter = null;
	int randomNumUirMeiReference;
	/**
	 * This will create the quiz inputs when initiated
	 */
		
	/**
	 * Singleton
	 */
	
	private void TamilLetters(){		
	}
	private static TamilLetters tL = null;
	public static TamilLetters getTamilLetters(){
		if (null == tL) {
			tL = new TamilLetters();
		}
		return tL;
	}
	public  void initializeAndRefresh(){
		
		
		//tamilLettersArray = Resources.getSystem().getStringArray(R.array.tamil_letters_array);
		//tamilLetterReferencesArray = Resources.getSystem().getStringArray(R.array.tamil_letters_name_reference_array);
			
			randomNumUirMeiReference =  getRandomUirMeiLetterReference();	
			
			
			quizAnswer_Uir_Mei_Letter = tamilLettersArray[randomNumUirMeiReference];
			
			//Log.e("Elango", "UIRMEI" +quizAnswer_Uir_Mei_Letter );
			
			String quizAnswer_Uir_Mei_Reference = tamilLetterReferencesArray[randomNumUirMeiReference];
			
			String quizAnswer_Uir_Reference_part= quizAnswer_Uir_Mei_Reference.substring(0,quizAnswer_Uir_Mei_Reference.lastIndexOf("u"));
			//Log.e("Elango", "quizAnswer_Uir_Reference_part" +quizAnswer_Uir_Reference_part );
			
			String quizAnswer_Mei_Reference_part= quizAnswer_Uir_Mei_Reference.substring(quizAnswer_Uir_Mei_Reference.lastIndexOf("u"),quizAnswer_Uir_Mei_Reference.length());
			//Log.e("Elango", "quizAnswer_Mei_Reference_part" +quizAnswer_Mei_Reference_part );
			
			//Log.e("Elango", "NAME  ARRAY=" +Arrays.toString(tamilLettersArray));
			//Log.e("Elango", "NAME REF ARRAY=" +Arrays.toString(tamilLetterReferencesArray));
			
			
			int uirRefPartIndex = findIndex(tamilLetterReferencesArray, quizAnswer_Uir_Reference_part);
			//Log.e("Elango", "uirRefPartIndex" +uirRefPartIndex );
			quizQuestion_uir_part = tamilLettersArray[uirRefPartIndex] ;
			//Log.e("Elango", "quizQuestion_uir_part" + quizQuestion_uir_part );
			int meiRefPartIndex =findIndex( tamilLetterReferencesArray, quizAnswer_Mei_Reference_part);
			//Log.e("Elango", "meiRefPartIndexs" +meiRefPartIndex );
			quizQuestion_Mei_part = tamilLettersArray[meiRefPartIndex] ; 
			//Log.e("Elango", "quizQuestion_Mei_part" + quizQuestion_Mei_part );
			String answerOption_1= quizAnswer_Uir_Mei_Letter;
			String answerOption_2= getRandomUirMeiLetter();
			String answerOption_3= getRandomUirMeiLetter();
			String answerOption_4= getRandomUirMeiLetter();
			
			String[]  optionLettersArray =  {answerOption_1,answerOption_2,answerOption_3,answerOption_4 };
			optionLettersArray_N = swapOptionsArray(optionLettersArray);
			
			
			
		}
	public static String[]  getQuizOptions(){
		return optionLettersArray_N;
	}
	
	public static String getUirPart(){
		
		return quizQuestion_uir_part;
	}
	public static String getMeiPart() {
		return quizQuestion_Mei_part;
	}
	public static String getUriMeiLetter() {
		return quizAnswer_Uir_Mei_Letter;
	}
	private static String getRandomUirMeiLetter() {

		// Get a Random MeiEluthu
		// This will be a number after the Uir and Mei and end with last set
		// hence 31 to 246
		Random rn = new Random();
		int fromLetter = 30;
		int toLetter = 245;
		int range = (toLetter - fromLetter) + 1;
		int randomNum = rn.nextInt(range) + fromLetter;
		//Log.e("Elango", "randomNum " + randomNum );
		
		//Log.e("Elango", "LETTER " + tamilLettersArray[randomNum] );
		return tamilLettersArray[randomNum];
		
	}
	
	private static int getRandomUirMeiLetterReference() {

		// Get a Random MeiEluthu
		// This will be a number after the Uir and Mei and end with last set
		// hence 31 to 246
		
		
		
		Random rn = new Random();
		int fromLetter = 30;
		int toLetter = 245;
		int range = (toLetter - fromLetter) + 1;
		int randomNum = rn.nextInt(range) + fromLetter;
		//Log.e("Elango", "LETTERREF " + tamilLettersArray[randomNum] );
		return randomNum;
		
		
	}
	
	/**
	 * Helper to find index of a String in an Array of Strings
	 * @param arrayOfStrings
	 * @param findThis
	 * @return
	 */
	private static int findIndex(String[] arrayOfStrings, String findThis) {
		int index = -1;

		for (int i = 0; (i < arrayOfStrings.length) && (index == -1); i++) {
			if (arrayOfStrings[i].equals(findThis)) {
				index = i;
			}
		}
		return index;
	}

	/**
	 * Helper Method to shuffle the options
	 * We know the first option is always the right one. Hence switch it to some other loaction 
	 * @param arrayOfStrings
	 * @param findThis
	 * @return
	 */
	private static String[] swapOptionsArray(String[] answerOptions) {
		
				// Generate Random number between zero and 3
				Random rn = new Random();
				int fromLetter = 0;
				int toLetter = 3;
				int range = toLetter - fromLetter + 1;
				int randomNum = rn.nextInt(range) + fromLetter;
				//Log.e("Elango", "Random SWAP " + randomNum );
				
				String helper = answerOptions[0];
				answerOptions[0] = answerOptions[randomNum];
				answerOptions[randomNum] = helper;
				return answerOptions;
	}

	public int getActiveUirMeiReference(){
		return randomNumUirMeiReference;
	}
}
