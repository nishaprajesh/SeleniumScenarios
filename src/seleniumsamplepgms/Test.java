package seleniumsamplepgms;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String Chk= "+44 20 8022 0136 **";
		String Agentphoneexpected= "+44 20 8022 0136";
		
		String replace1=replaced(Chk,"*");
		replace1.replaceAll("\\s+","");
		System.out.println(replace1.replaceAll("\\s+",""));
	
		Boolean b=(replace1.replaceAll("\\s+","")).equals(Agentphoneexpected.replaceAll("\\s+",""));
		System.out.println(b);
	}
	public static String replaced(String s,String Ochar)
	{
		String newstring =s.replace(Ochar, "");
		return newstring;
	}

}

