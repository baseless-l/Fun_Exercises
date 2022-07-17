import java.util.ArrayList;

public class Split_Method {

	public static void main(String[] args) {
		
		String[] strings =split("he@ll@o","@");
		if(strings!=null)
		for(int i=0;i<strings.length;i++) {
			if(strings[i]!=null)System.out.println(strings[i]);
		}
	}
	
	public static String[] split(String s,String regex) {
		//First goal. Get delimeters.
		if(s!=null&&regex!=null) {
			char[] delArr;
			if(regex.startsWith("[", 0)&&regex.endsWith("]")) {
				String del=regex.substring(regex.indexOf('[')+1,regex.indexOf(']'));
				delArr=new char[del.length()];
				for(int i=0;i<del.length();i++) {
					delArr[i]=del.charAt(i);
				}
			}else {
				delArr=regex.toCharArray();
				System.out.println();
			}
			
			ArrayList<String> strings=new ArrayList<>();
			int lastIndex=0;
			for(int i=0;i<s.length();i++) {
				for(int j=0;j<delArr.length;j++) {
					if(s.charAt(i)==delArr[j]) {
						strings.add(s.substring(lastIndex,i));
						strings.add(String.valueOf(delArr[j]));
						lastIndex=i+1;
					}
				}
			}
			String[] ret=new String[strings.size()];
			for(int i=0;i<strings.size();i++) {
				ret[i]=strings.get(i);
			}
			return ret;
		}
		return null;
	}
}