package in.elango.tamillearning;

public class ReEncodeTamil {


	public static String convertBaminiTamilString(String text){
		
		text = text.replace("ஸ்ரீ", "=");
		text = text.replace(",", ">");
		text = text.replace("ஜௌ", "n[s");
		text = text.replace("ஜோ", "N[h");
		text = text.replace("ஜொ", "n[h");
		text = text.replace("ஜா", "[h");
		text = text.replace("ஜி", "[p");
		text = text.replace("ஜீ", "[P");
		text = text.replace("ஜு", "[{");
		text = text.replace("ஜூ", "[_");
		text = text.replace("ஜெ", "n[");
		text = text.replace("ஜே", "N[");
		text = text.replace("ஜை", "i[");
		text = text.replace("ஜ்", "[;");
		text = text.replace("ஜ", "[");
		text = text.replace("கௌ", "nfs");
		text = text.replace("கோ", "Nfh");
		text = text.replace("கொ", "nfh");
		text = text.replace("கா", "fh");
		text = text.replace("கி", "fp");
		text = text.replace("கீ", "fP");
		text = text.replace("கு", "F");
		text = text.replace("கூ", "$");
		text = text.replace("கெ", "nf");
		text = text.replace("கே", "Nf");
		text = text.replace("கை", "if");
		text = text.replace("க்", "f;");
		text = text.replace("க", "f");
		text = text.replace("ஙௌ", "nqs");
		text = text.replace("ஙோ", "Nqh");
		text = text.replace("ஙொ", "nqh");
		text = text.replace("ஙா", "qh");
		text = text.replace("ஙி", "qp");
		text = text.replace("ஙீ", "qP");
		text = text.replace("ஙு", "*");
		text = text.replace("ஙூ", "*");
		text = text.replace("ஙெ", "nq");
		text = text.replace("ஙே", "Nq");
		text = text.replace("ஙை", "iq");
		text = text.replace("ங்", "q;");
		text = text.replace("ங", "q");
		text = text.replace("சௌ", "nrs");
		text = text.replace("சோ", "Nrh");
		text = text.replace("சொ", "nrh");
		text = text.replace("சா", "rh");
		text = text.replace("சி", "rp");
		text = text.replace("சீ", "rP");
		text = text.replace("சு", "R");
		text = text.replace("சூ", "R+");
		text = text.replace("செ", "nr");
		text = text.replace("சே", "Nr");
		text = text.replace("சை", "ir");
		text = text.replace("ச்", "r;");
		text = text.replace("ச", "r");
		text = text.replace("ஞௌ", "nQs");
		text = text.replace("ஞோ", "NQh");
		text = text.replace("ஞொ", "nQh");
		text = text.replace("ஞா", "Qh");
		text = text.replace("ஞி", "Qp");
		text = text.replace("ஞீ", "QP");
		text = text.replace("ஞு", "*");
		text = text.replace("ஞூ", "*");
		text = text.replace("ஞெ", "nQ");
		text = text.replace("ஞே", "NQ");
		text = text.replace("ஞை", "iQ");
		text = text.replace("ஞ்", "Q;");
		text = text.replace("ஞ", "Q");
		text = text.replace("டௌ", "nls");
		text = text.replace("டோ", "Nlh");
		text = text.replace("டொ", "nlh");
		text = text.replace("டா", "lh");
		text = text.replace("டி", "b");
		text = text.replace("டீ", "B");
		text = text.replace("டு", "L");
		text = text.replace("டூ", "^");
		text = text.replace("டெ", "nl");
		text = text.replace("டே", "Nl");
		text = text.replace("டை", "il");
		text = text.replace("ட்", "l;");
		text = text.replace("ட", "l");
		text = text.replace("ணௌ", "nzs");
		text = text.replace("ணோ", "Nzh");
		text = text.replace("ணொ", "nzh");
		text = text.replace("ணா", "zh");
		text = text.replace("ணி", "zp");
		text = text.replace("ணீ", "zP");
		text = text.replace("ணு", "Z");
		text = text.replace("ணூ", "Z}");
		text = text.replace("ணெ", "nz");
		text = text.replace("ணே", "Nz");
		text = text.replace("ணை", "iz");
		text = text.replace("ண்", "z;");
		text = text.replace("ண", "z");
		text = text.replace("தௌ", "njs");
		text = text.replace("தோ", "Njh");
		text = text.replace("தொ", "njh");
		text = text.replace("தா", "jh");
		text = text.replace("தி", "jp");
		text = text.replace("தீ", "jP");
		text = text.replace("து", "J");
		text = text.replace("தூ", "J}");
		text = text.replace("தெ", "nj");
		text = text.replace("தே", "Nj");
		text = text.replace("தை", "ij");
		text = text.replace("த்", "j;");
		text = text.replace("த", "j");
		text = text.replace("நௌ", "nes");
		text = text.replace("நோ", "Neh");
		text = text.replace("நொ", "neh");
		text = text.replace("நா", "eh");
		text = text.replace("நி", "ep");
		text = text.replace("நீ", "eP");
		text = text.replace("நு", "E");
		text = text.replace("நூ", "E}");
		text = text.replace("நெ", "ne");
		text = text.replace("நே", "Ne");
		text = text.replace("நை", "ie");
		text = text.replace("ந்", "e;");
		text = text.replace("ந", "e");
		text = text.replace("னௌ", "nds");
		text = text.replace("னோ", "Ndh");
		text = text.replace("னொ", "ndh");
		text = text.replace("னா", "dh");
		text = text.replace("னி", "dp");
		text = text.replace("னீ", "dP");
		text = text.replace("னு", "D");
		text = text.replace("னூ", "D}");
		text = text.replace("னெ", "nd");
		text = text.replace("னே", "Nd");
		text = text.replace("னை", "id");
		text = text.replace("ன்", "d;");
		text = text.replace("ன", "d");
		text = text.replace("பௌ", "ns");
		text = text.replace("போ", "Nh");
		text = text.replace("பொ", "nh");
		text = text.replace("பா", "h");
		text = text.replace("பி", "p");
		text = text.replace("பீ", "P");
		text = text.replace("பு", "g");
		text = text.replace("பூ", "g+");
		text = text.replace("பெ", "ng");
		text = text.replace("பே", "Ng");
		text = text.replace("பை", "ig");
		text = text.replace("ப்", "g;");
		text = text.replace("ப", "g");
		text = text.replace("மௌ", "nks");
		text = text.replace("மோ", "Nkh");
		text = text.replace("மொ", "nkh");
		text = text.replace("மா", "kh");
		text = text.replace("மி", "kp");
		text = text.replace("மீ", "kP");
		text = text.replace("மு", "K");
		text = text.replace("மூ", "%");
		text = text.replace("மெ", "nk");
		text = text.replace("மே", "Nk");
		text = text.replace("மை", "ik");
		text = text.replace("ம்", "k;");
		text = text.replace("ம", "k");
		text = text.replace("யௌ", "nas");
		text = text.replace("யோ", "Nah");
		text = text.replace("யொ", "nah");
		text = text.replace("யா", "ah");
		text = text.replace("யி", "ap");
		text = text.replace("யீ", "aP");
		text = text.replace("யு", "A");
		text = text.replace("யூ", "A+");
		text = text.replace("யெ", "na");
		text = text.replace("யே", "Na");
		text = text.replace("யை", "ia");
		text = text.replace("ய்", "a;");
		text = text.replace("ய", "a");
		text = text.replace("ரௌ", "nus");
		text = text.replace("ரோ", "Nuh");
		text = text.replace("ரொ", "nuh");
		text = text.replace("ரா", "uh");
		text = text.replace("ரி", "up");
		text = text.replace("ரீ", "uP");
		text = text.replace("ரு", "U");
		text = text.replace("ரூ", "\\&");
		text = text.replace("ரெ", "nu");
		text = text.replace("ரே", "Nu");
		text = text.replace("ரை", "iu");
		text = text.replace("ர்", "u;");
		text = text.replace("ர", "u");
		text = text.replace("லௌ", "nys");
		text = text.replace("லோ", "Nyh");
		text = text.replace("லொ", "nyh");
		text = text.replace("லா", "yh");
		text = text.replace("லி", "yp");
		text = text.replace("லீ", "yP");
		text = text.replace("லு", "Y");
		text = text.replace("லூ", "Y}");
		text = text.replace("லெ", "ny");
		text = text.replace("லே", "Ny");
		text = text.replace("லை", "iy");
		text = text.replace("ல்", "y;");
		text = text.replace("ல", "y");
		text = text.replace("ளௌ", "nss");
		text = text.replace("ளோ", "Nsh");
		text = text.replace("ளொ", "nsh");
		text = text.replace("ளா", "sh");
		text = text.replace("ளி", "sp");
		text = text.replace("ளீ", "sP");
		text = text.replace("ளு", "S");
		text = text.replace("ளூ", "Sh");
		text = text.replace("ளெ", "ns");
		text = text.replace("ளே", "Ns");
		text = text.replace("ளை", "is");
		text = text.replace("ள்", "s;");
		text = text.replace("ள", "s");
		text = text.replace("வௌ", "nts");
		text = text.replace("வோ", "Nth");
		text = text.replace("வொ", "nth");
		text = text.replace("வா", "th");
		text = text.replace("வி", "tp");
		text = text.replace("வீ", "tP");
		text = text.replace("வு", "T");
		text = text.replace("வூ", "T+");
		text = text.replace("வெ", "nt");
		text = text.replace("வே", "Nt");
		text = text.replace("வை", "it");
		text = text.replace("வ்", "t;");
		text = text.replace("வ", "t");
		text = text.replace("ழௌ", "nos");
		text = text.replace("ழோ", "Noh");
		text = text.replace("ழொ", "noh");
		text = text.replace("ழா", "oh");
		text = text.replace("ழி", "op");
		text = text.replace("ழீ", "oP");
		text = text.replace("ழு", "O");
		text = text.replace("ழூ", "*");
		text = text.replace("ழெ", "no");
		text = text.replace("ழே", "No");
		text = text.replace("ழை", "io");
		text = text.replace("ழ்", "o;");
		text = text.replace("ழ", "o");
		text = text.replace("றௌ", "nws");
		text = text.replace("றோ", "Nwh");
		text = text.replace("றொ", "nwh");
		text = text.replace("றா", "wh");
		text = text.replace("றி", "wp");
		text = text.replace("றீ", "wP");
		text = text.replace("று", "W");
		text = text.replace("றூ", "W}");
		text = text.replace("றெ", "nw");
		text = text.replace("றே", "Nw");
		text = text.replace("றை", "iw");
		text = text.replace("ற்", "w;");
		text = text.replace("ற", "w");
		text = text.replace("ஹௌ", "n`s");
		text = text.replace("ஹோ", "N`h");
		text = text.replace("ஹொ", "n`h");
		text = text.replace("ஹா", "`h");
		text = text.replace("ஹி", "`p");
		text = text.replace("ஹீ", "`P");
		text = text.replace("ஹு", "{`");
		text = text.replace("ஹூ", "`_");
		text = text.replace("ஹெ", "n`");
		text = text.replace("ஹே", "N`");
		text = text.replace("ஹை", "i`");
		text = text.replace("ஹ்", "`;");
		text = text.replace("ஹ", "`");
		text = text.replace("ஷௌ", "n\\s");
		text = text.replace("ஷோ", "N\\h");
		text = text.replace("ஷொ", "n\\h");
		text = text.replace("ஷா", "\\h");
		text = text.replace("ஷி", "\\p");
		text = text.replace("ஷீ", "\\P");
		text = text.replace("ஷு", "\\{");
		text = text.replace("ஷூ", "\\\\_");
		text = text.replace("ஷெ", "n\\");
		text = text.replace("ஷே", "N\\");
		text = text.replace("ஷை", "i\\");
		text = text.replace("ஷ்", "\\;");
		text = text.replace("ஷ", "\\");
		text = text.replace("ஸௌ", "n]s");
		text = text.replace("ஸோ", "N]h");
		text = text.replace("ஸொ", "n]h");
		text = text.replace("ஸா", "]h");
		text = text.replace("ஸி", "]p");
		text = text.replace("ஸீ", "]P");
		text = text.replace("ஸு", "]{");
		text = text.replace("ஸூ", "]_");
		text = text.replace("ஸெ", "n]");
		text = text.replace("ஸே", "N]");
		text = text.replace("ஸை", "i]");
		text = text.replace("ஸ்", "];");
		text = text.replace("ஸ", "]");
		text = text.replace("அ", "m");
		text = text.replace("ஆ", "M");
		text = text.replace("இ", ",");
		text = text.replace("ஈ", "<");
		text = text.replace("உ", "c");
		text = text.replace("ஊ", "C");
		text = text.replace("எ", "v");
		text = text.replace("ஏ", "V");
		text = text.replace("ஐ", "I");
		text = text.replace("ஒ", "x");
		text = text.replace("ஓ", "X");
		text = text.replace("ஔ", "xs");
		text = text.replace("ஃ", "\"");
		
		
		return text;
	}
	
	
	 public static String unicode2tsc(String unicodeni){
		 
         unicodeni = unicodeni.replace("ஜௌ", "¦ƒª");
         unicodeni = unicodeni.replace("ஜோ", "§ƒ¡");
         unicodeni = unicodeni.replace("ஜொ", "¦ƒ¡");
         unicodeni = unicodeni.replace("ஜா", "ƒ¡");
         unicodeni = unicodeni.replace("ஜி", "ƒ¢");
         unicodeni = unicodeni.replace("ஜீ", "ƒ£");
         unicodeni = unicodeni.replace("ஜு", "ƒ¤");
         unicodeni = unicodeni.replace("ஜூ", "ƒ¥");
         unicodeni = unicodeni.replace("ஜெ", "¦ƒ");
         unicodeni = unicodeni.replace("ஜே", "§ƒ");
         unicodeni = unicodeni.replace("ஜை", "¨ƒ");
         unicodeni = unicodeni.replace("ஜ்", "\\ˆ");
         unicodeni = unicodeni.replace("ஜ", "ƒ");




         unicodeni = unicodeni.replace("கௌ", "¦¸ª");
         unicodeni = unicodeni.replace("கோ", "§¸¡");
         unicodeni = unicodeni.replace("கொ", "¦¸¡");
         unicodeni = unicodeni.replace("கா", "¸¡");
         unicodeni = unicodeni.replace("கி", "¸¢");
         unicodeni = unicodeni.replace("கீ", "¸£");
         unicodeni = unicodeni.replace("கு", "Ì");
         unicodeni = unicodeni.replace("கூ", "Ü");
         unicodeni = unicodeni.replace("கெ", "¦¸");
         unicodeni = unicodeni.replace("கே", "§¸");
         unicodeni = unicodeni.replace("கை", "¨¸");
         unicodeni = unicodeni.replace("க்", "ì");
         unicodeni = unicodeni.replace("க", "¸");


         unicodeni = unicodeni.replace("ஙௌ", "¦¹ª");
         unicodeni = unicodeni.replace("ஙோ", "§¹¡");
         unicodeni = unicodeni.replace("ஙொ", "¦¹¡");
         unicodeni = unicodeni.replace("ஙா", "¹¡");
         unicodeni = unicodeni.replace("ஙி", "¹¢");
         unicodeni = unicodeni.replace("ஙீ", "¹£");
         unicodeni = unicodeni.replace("ஙு", "");
         unicodeni = unicodeni.replace("ஙூ", "");
         unicodeni = unicodeni.replace("ஙெ", "¦¹");
         unicodeni = unicodeni.replace("ஙே", "§¹");
         unicodeni = unicodeni.replace("ஙை", "¨¹");
         unicodeni = unicodeni.replace("ங்", "í");
         unicodeni = unicodeni.replace("ங", "¹");



         unicodeni = unicodeni.replace("சௌ", "¦ºª");
         unicodeni = unicodeni.replace("சோ", "§º¡");
         unicodeni = unicodeni.replace("சொ", "¦º¡");
         unicodeni = unicodeni.replace("சா", "º¡");
         unicodeni = unicodeni.replace("சி", "º¢");
         unicodeni = unicodeni.replace("சீ", "º£");
         unicodeni = unicodeni.replace("சு", "Í");
         unicodeni = unicodeni.replace("சூ", "Ý");
         unicodeni = unicodeni.replace("செ", "¦º");
         unicodeni = unicodeni.replace("சே", "§º");
         unicodeni = unicodeni.replace("சை", "¨º");
         unicodeni = unicodeni.replace("ச்", "î");
         unicodeni = unicodeni.replace("ச", "º");


         unicodeni = unicodeni.replace("ஞௌ", "¦»ª");
         unicodeni = unicodeni.replace("ஞோ", "§»¡");
         unicodeni = unicodeni.replace("ஞொ", "¦»¡");
         unicodeni = unicodeni.replace("ஞா", "»¡");
         unicodeni = unicodeni.replace("ஞி", "»¢");
         unicodeni = unicodeni.replace("ஞீ", "»£");
         unicodeni = unicodeni.replace("ஞு", "");
         unicodeni = unicodeni.replace("ஞூ", "");
         unicodeni = unicodeni.replace("ஞெ", "¦»");
         unicodeni = unicodeni.replace("ஞே", "§»");
         unicodeni = unicodeni.replace("ஞை", "¨»");
         unicodeni = unicodeni.replace("ஞ்", "ï");
         unicodeni = unicodeni.replace("ஞ", "»");



         unicodeni = unicodeni.replace("டௌ", "¦¼ª");
         unicodeni = unicodeni.replace("டோ", "§¼¡");
         unicodeni = unicodeni.replace("டொ", "¦¼¡");
         unicodeni = unicodeni.replace("டா", "¼¡");
         unicodeni = unicodeni.replace("டி", "Ê");
         unicodeni = unicodeni.replace("டீ", "Ë");
         unicodeni = unicodeni.replace("டு", "Î");
         unicodeni = unicodeni.replace("டூ", "Þ");
         unicodeni = unicodeni.replace("டெ", "¦¼");
         unicodeni = unicodeni.replace("டே", "§¼");
         unicodeni = unicodeni.replace("டை", "¨¼");
         unicodeni = unicodeni.replace("ட்", "ð");
         unicodeni = unicodeni.replace("ட", "¼");


         unicodeni = unicodeni.replace("ணௌ", "¦½ª");
         unicodeni = unicodeni.replace("ணோ", "§½¡");
         unicodeni = unicodeni.replace("ணொ", "¦½¡");
         unicodeni = unicodeni.replace("ணா", "½¡");
         unicodeni = unicodeni.replace("ணி", "½¢");
         unicodeni = unicodeni.replace("ணீ", "½£");
         unicodeni = unicodeni.replace("ணு", "Ï");
         unicodeni = unicodeni.replace("ணூ", "ß");
         unicodeni = unicodeni.replace("ணெ", "¦½");
         unicodeni = unicodeni.replace("ணே", "§½");
         unicodeni = unicodeni.replace("ணை", "¨½");
         unicodeni = unicodeni.replace("ண்", "ñ");
         unicodeni = unicodeni.replace("ண", "½");

         unicodeni = unicodeni.replace("தௌ", "¦¾ª");
         unicodeni = unicodeni.replace("தோ", "§¾¡");
         unicodeni = unicodeni.replace("தொ", "¦¾¡");
         unicodeni = unicodeni.replace("தா", "¾¡");
         unicodeni = unicodeni.replace("தி", "¾¢");
         unicodeni = unicodeni.replace("தீ", "¾£");
         unicodeni = unicodeni.replace("து", "Ð");
         unicodeni = unicodeni.replace("தூ", "à");
         unicodeni = unicodeni.replace("தெ", "¦¾");
         unicodeni = unicodeni.replace("தே", "§¾");
         unicodeni = unicodeni.replace("தை", "¨¾");
         unicodeni = unicodeni.replace("த்", "ò");
         unicodeni = unicodeni.replace("த", "¾");



         unicodeni = unicodeni.replace("நௌ", "¦¿ª");
         unicodeni = unicodeni.replace("நோ", "§¿¡");
         unicodeni = unicodeni.replace("நொ", "¦¿¡");
         unicodeni = unicodeni.replace("நா", "¿¡");
         unicodeni = unicodeni.replace("நி", "¿¢");
         unicodeni = unicodeni.replace("நீ", "¿£");
         unicodeni = unicodeni.replace("நு", "Ñ");
         unicodeni = unicodeni.replace("நூ", "á");
         unicodeni = unicodeni.replace("நெ", "¦¿");
         unicodeni = unicodeni.replace("நே", "§¿");
         unicodeni = unicodeni.replace("நை", "¨¿");
         unicodeni = unicodeni.replace("ந்", "ó");
         unicodeni = unicodeni.replace("ந", "¿");


         unicodeni = unicodeni.replace("னௌ", "¦Éª");
         unicodeni = unicodeni.replace("னோ", "§É¡");
         unicodeni = unicodeni.replace("னொ", "¦É¡");
         unicodeni = unicodeni.replace("னா", "É¡");
         unicodeni = unicodeni.replace("னி", "É¢");
         unicodeni = unicodeni.replace("னீ", "É£");
         unicodeni = unicodeni.replace("னு", "Û");
         unicodeni = unicodeni.replace("னூ", "ë");
         unicodeni = unicodeni.replace("னெ", "¦É");
         unicodeni = unicodeni.replace("னே", "§É");
         unicodeni = unicodeni.replace("னை", "¨É");
         unicodeni = unicodeni.replace("ன்", "ý");
         unicodeni = unicodeni.replace("ன", "É");


         unicodeni = unicodeni.replace("பௌ", "¦Àª");
         unicodeni = unicodeni.replace("போ", "§À¡");
         unicodeni = unicodeni.replace("பொ", "¦À¡");
         unicodeni = unicodeni.replace("பா", "À¡");
         unicodeni = unicodeni.replace("பி", "À¢");
         unicodeni = unicodeni.replace("பீ", "À£");
         unicodeni = unicodeni.replace("பு", "Ò");
         unicodeni = unicodeni.replace("பூ", "â");
         unicodeni = unicodeni.replace("பெ", "¦À");
         unicodeni = unicodeni.replace("பே", "§À");
         unicodeni = unicodeni.replace("பை", "¨À");
         unicodeni = unicodeni.replace("ப்", "ô");
         unicodeni = unicodeni.replace("ப", "À");


         unicodeni = unicodeni.replace("மௌ", "¦Áª");
         unicodeni = unicodeni.replace("மோ", "§Á¡");
         unicodeni = unicodeni.replace("மொ", "¦Á¡");
         unicodeni = unicodeni.replace("மா", "Á¡");
         unicodeni = unicodeni.replace("மி", "Á¢");
         unicodeni = unicodeni.replace("மீ", "Á£");
         unicodeni = unicodeni.replace("மு", "Ó");
         unicodeni = unicodeni.replace("மூ", "ã");
         unicodeni = unicodeni.replace("மெ", "¦Á");
         unicodeni = unicodeni.replace("மே", "§Á");
         unicodeni = unicodeni.replace("மை", "¨Á");
         unicodeni = unicodeni.replace("ம்", "õ");
         unicodeni = unicodeni.replace("ம", "Á");


         unicodeni = unicodeni.replace("யௌ", "¦Âª");
         unicodeni = unicodeni.replace("யோ", "§Â¡");
         unicodeni = unicodeni.replace("யொ", "¦Â¡");
         unicodeni = unicodeni.replace("யா", "Â¡");
         unicodeni = unicodeni.replace("யி", "Â¢");
         unicodeni = unicodeni.replace("யீ", "Â£");
         unicodeni = unicodeni.replace("யு", "Ô");
         unicodeni = unicodeni.replace("யூ", "ä");
         unicodeni = unicodeni.replace("யெ", "¦Â");
         unicodeni = unicodeni.replace("யே", "§Â");
         unicodeni = unicodeni.replace("யை", "¨Â");
         unicodeni = unicodeni.replace("ய்", "ö");
         unicodeni = unicodeni.replace("ய", "Â");

         unicodeni = unicodeni.replace("ரௌ", "¦Ãª");
         unicodeni = unicodeni.replace("ரோ", "§Ã¡");
         unicodeni = unicodeni.replace("ரொ", "¦Ã¡");
         unicodeni = unicodeni.replace("ரா", "Ã¡");
         unicodeni = unicodeni.replace("ரி", "Ã¢");
         unicodeni = unicodeni.replace("ரீ", "Ã£");
         unicodeni = unicodeni.replace("ரு", "Õ");
         unicodeni = unicodeni.replace("ரூ", "å");
         unicodeni = unicodeni.replace("ரெ", "¦Ã");
         unicodeni = unicodeni.replace("ரே", "§Ã");
         unicodeni = unicodeni.replace("ரை", "¨Ã");
         unicodeni = unicodeni.replace("ர்", "÷");
         unicodeni = unicodeni.replace("ர", "Ã");


         unicodeni = unicodeni.replace("லௌ", "¦Äª");
         unicodeni = unicodeni.replace("லோ", "§Ä¡");
         unicodeni = unicodeni.replace("லொ", "¦Ä¡");
         unicodeni = unicodeni.replace("லா", "Ä¡");
         unicodeni = unicodeni.replace("லி", "Ä¢");
         unicodeni = unicodeni.replace("லீ", "Ä£");
         unicodeni = unicodeni.replace("லு", "Ö");
         unicodeni = unicodeni.replace("லூ", "æ");
         unicodeni = unicodeni.replace("லெ", "¦Ä");
         unicodeni = unicodeni.replace("லே", "§Ä");
         unicodeni = unicodeni.replace("லை", "¨Ä");
         unicodeni = unicodeni.replace("ல்", "ø");
         unicodeni = unicodeni.replace("ல", "Ä");


         unicodeni = unicodeni.replace("ளௌ", "¦Çª");
         unicodeni = unicodeni.replace("ளோ", "§Ç¡");
         unicodeni = unicodeni.replace("ளொ", "¦Ç¡");
         unicodeni = unicodeni.replace("ளா", "Ç¡");
         unicodeni = unicodeni.replace("ளி", "Ç¢");
         unicodeni = unicodeni.replace("ளீ", "Ç£");
         unicodeni = unicodeni.replace("ளு", "Ù");
         unicodeni = unicodeni.replace("ளூ", "é");
         unicodeni = unicodeni.replace("ளெ", "¦Ç");
         unicodeni = unicodeni.replace("ளே", "§Ç");
         unicodeni = unicodeni.replace("ளை", "¨Ç");
         unicodeni = unicodeni.replace("ள்", "û");
         unicodeni = unicodeni.replace("ள", "Ç");

         unicodeni = unicodeni.replace("வௌ", "¦Åª");
         unicodeni = unicodeni.replace("வோ", "§Å¡");
         unicodeni = unicodeni.replace("வொ", "¦Å¡");
         unicodeni = unicodeni.replace("வா", "Å¡");
         unicodeni = unicodeni.replace("வி", "Å¢");
         unicodeni = unicodeni.replace("வீ", "Å£");
         unicodeni = unicodeni.replace("வு", "×");
         unicodeni = unicodeni.replace("வூ", "ç");
         unicodeni = unicodeni.replace("வெ", "¦Å");
         unicodeni = unicodeni.replace("வே", "§Å");
         unicodeni = unicodeni.replace("வை", "¨Å");
         unicodeni = unicodeni.replace("வ்", "ù");
         unicodeni = unicodeni.replace("வ", "Å");


         unicodeni = unicodeni.replace("ழௌ", "¦Æª");
         unicodeni = unicodeni.replace("ழோ", "§Æ¡");
         unicodeni = unicodeni.replace("ழொ", "¦Æ¡");
         unicodeni = unicodeni.replace("ழா", "Æ¡");
         unicodeni = unicodeni.replace("ழி", "Æ¢");
         unicodeni = unicodeni.replace("ழீ", "Æ£");
         unicodeni = unicodeni.replace("ழு", "Ø");
         unicodeni = unicodeni.replace("ழூ", "è");
         unicodeni = unicodeni.replace("ழெ", "¦Æ");
         unicodeni = unicodeni.replace("ழே", "§Æ");
         unicodeni = unicodeni.replace("ழை", "¨Æ");
         unicodeni = unicodeni.replace("ழ்", "ú");
         unicodeni = unicodeni.replace("ழ", "Æ");

         unicodeni = unicodeni.replace("றௌ", "¦Èª");
         unicodeni = unicodeni.replace("றோ", "§È¡");
         unicodeni = unicodeni.replace("றொ", "¦È¡");
         unicodeni = unicodeni.replace("றா", "È¡");
         unicodeni = unicodeni.replace("றி", "È¢");
         unicodeni = unicodeni.replace("றீ", "È£");
         unicodeni = unicodeni.replace("று", "Ú");
         unicodeni = unicodeni.replace("றூ", "ê");
         unicodeni = unicodeni.replace("றெ", "¦È");
         unicodeni = unicodeni.replace("றே", "§È");
         unicodeni = unicodeni.replace("றை", "¨È");
         unicodeni = unicodeni.replace("ற்", "ü");
         unicodeni = unicodeni.replace("ற", "È");





         unicodeni = unicodeni.replace("ஹௌ", "¦ª");
         unicodeni = unicodeni.replace("ஹோ", "§¡");
         unicodeni = unicodeni.replace("ஹொ", "¦¡");
         unicodeni = unicodeni.replace("ஹா", "†¡");
         unicodeni = unicodeni.replace("ஹி", "¢");
         unicodeni = unicodeni.replace("ஹீ", "£");
         unicodeni = unicodeni.replace("ஹு", "¤");
         unicodeni = unicodeni.replace("ஹூ", "¥");
         unicodeni = unicodeni.replace("ஹெ", "¦");
         unicodeni = unicodeni.replace("ஹே", "§");
         unicodeni = unicodeni.replace("ஹை", "¨");
         unicodeni = unicodeni.replace("ஹ்", "‹ ");
         unicodeni = unicodeni.replace("ஹ", "†");



         unicodeni = unicodeni.replace("ஷௌ", "¦„ª");
         unicodeni = unicodeni.replace("ஷோ", "§„¡");
         unicodeni = unicodeni.replace("ஷொ", "¦„¡");
         unicodeni = unicodeni.replace("ஷா", "„¡");
         unicodeni = unicodeni.replace("ஷி", "„¢");
         unicodeni = unicodeni.replace("ஷீ", "„£");
         unicodeni = unicodeni.replace("ஷு", "„¤");
         unicodeni = unicodeni.replace("ஷூ", "„¥");
         unicodeni = unicodeni.replace("ஷெ", "¦„");
         unicodeni = unicodeni.replace("ஷே", "§„");
         unicodeni = unicodeni.replace("ஷை", "¨„");
         unicodeni = unicodeni.replace("ஷ்", "‰");
         unicodeni = unicodeni.replace("ஷ", "„");


         unicodeni = unicodeni.replace("ஸௌ", "¦…ª");
         unicodeni = unicodeni.replace("ஸோ", "§…¡");
         unicodeni = unicodeni.replace("ஸொ", "¦…¡");
         unicodeni = unicodeni.replace("ஸா", "…¡");
         unicodeni = unicodeni.replace("ஸி", "…¢");
         unicodeni = unicodeni.replace("ஸீ", "…£");
         unicodeni = unicodeni.replace("ஸு", "…¤");
         unicodeni = unicodeni.replace("ஸூ", "…¥");
         unicodeni = unicodeni.replace("ஸெ", "¦…");
         unicodeni = unicodeni.replace("ஸே", "§…");
         unicodeni = unicodeni.replace("ஸை", "¨…");
         unicodeni = unicodeni.replace("ஸ்", "Š");
         unicodeni = unicodeni.replace("ஸ", "…");


         unicodeni = unicodeni.replace("அ", "«");
         unicodeni = unicodeni.replace("ஆ", "¬");
         unicodeni = unicodeni.replace("இ", "þ");
         unicodeni = unicodeni.replace("ஈ", "®");
         unicodeni = unicodeni.replace("உ", "¯");
         unicodeni = unicodeni.replace("ஊ", "°");
         unicodeni = unicodeni.replace("எ", "±");
         unicodeni = unicodeni.replace("ஏ", "²");
         unicodeni = unicodeni.replace("ஐ", "³");
         unicodeni = unicodeni.replace("ஒ", "´");
         unicodeni = unicodeni.replace("ஓ", "µ");
         unicodeni = unicodeni.replace("ஔ", "¶");
         unicodeni = unicodeni.replace("ஃ", "·");
         unicodeni = unicodeni.replace("ஸ்ரீ", "");
         unicodeni = unicodeni.replace("‘", "‘");

         unicodeni = unicodeni.replace("௧", "");
         unicodeni = unicodeni.replace("௨", "");
         unicodeni = unicodeni.replace("௩", "");
         unicodeni = unicodeni.replace("௪", "");
         unicodeni = unicodeni.replace("௫", "");
         unicodeni = unicodeni.replace("௰", "");
         unicodeni = unicodeni.replace("௱", "");
         unicodeni = unicodeni.replace("௲", "Ÿ");
         unicodeni = unicodeni.replace("௭", "–");
         unicodeni = unicodeni.replace("௮", "—");
         unicodeni = unicodeni.replace("௯", "˜");
         unicodeni = unicodeni.replace("௲", "Ÿ");
         unicodeni = unicodeni.replace("௭", "–");
        
         return unicodeni;
 }
	

}
