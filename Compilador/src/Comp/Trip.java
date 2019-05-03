package Comp;
import java.util.List;
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


public class Trip {
	static String triplos="";
	static String fin;
	static int t=1;
	public static String generar(String exp) {
		List<String> newList = new ArrayList<String>();
		newList=separar(exp);
		jerarquia(newList);													
		return triplos+"\n";
	}

	public static List<String> separar(String texto) {
						
		final String regex = "[\\d.]+|[-+*/()]|[a-z]+";
		final Pattern pattern = Pattern.compile(regex);
		final Matcher matcher = pattern.matcher(texto);
		
		final List<String> resultado = new ArrayList<String>();
		
		while (matcher.find()) {		
		    resultado.add(matcher.group());
		}
		
		return resultado;
		
	}
	public static void jerarquia(List<String> exp) {
		List<String> newList = new ArrayList<String>();
		int count=0;		
		boolean finish=true;
		while(exp.contains("(")) {	
			for (String element : exp) {			
				if (element.equals("(")) {
					newList=recortarParentesis(exp,count);					
					count++;
					break;
				}else count++;
				
			}
			count=0;
			exp=newList;			
			
		}		
		
		while(exp.size()>=3&&finish) {			
			for (String element : exp) {			
				if (element.equals("*")||element.equals("/")) {				
					newList=recortar(exp,count-1,count+1,"T"+String.valueOf(t));
					t++;
					count++;
					break;
				}else count++;
				if (count==exp.size()) {
					finish=false;
				}
			}
			count=0;
			exp=newList;			
			
		}	
		
		while(exp.size()!=1) {			
			for (String element : exp) {			
				if (element.equals("+")||element.equals("-")) {										
					newList=recortar(exp,count-1,count+1,"T"+String.valueOf(t));					
					t++;
					count++;
					break;
				}else count++;
				
			}
			count=0;
			exp=newList;				
			
		}
		fin=exp.get(0);				
		
	}
	
	public static List<String> recortar(List<String> exp, int beg,int end,String name) {
		List<String> newList = new ArrayList<String>();
		int count=0;
		for(String element:exp) {
			if (count>end||count<beg) {
				newList.add(element);
			}
			if (count==beg) {
				int y=0;
				newList.add(name);
				y=count;
				triplos +=name+"="+ exp.get(y);			
				y=count+1;
				triplos += exp.get(y);
				y=count+2;
				triplos += exp.get(y)+"\n";
			}
			count++;
		}
		return newList;
		
	}
	
	
	public static List<String> recortarParentesis(List<String> exp, int beg) {			
		List<String> newList = new ArrayList<String>();
		List<String> newList2 = new ArrayList<String>();
		int count=0;
		int end =exp.indexOf(")");
		for(String element:exp) {
			if (count>end||count<beg) {
				newList.add(element);
			}			
			if (count==beg) {
								
				int y=0;				
				for (int i = beg; i < end-1; i++) {
					y=i+1;					
					newList2.add(exp.get(y));					
				}							
				jerarquia(newList2);
				int f=t-1;
				newList.add("T"+Integer.valueOf(f));
			}
			count++;
		}							
		return newList;
		
	}
	
	
	
	
	

}
