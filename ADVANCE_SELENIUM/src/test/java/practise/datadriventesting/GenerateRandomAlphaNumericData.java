package practise.datadriventesting;

public class GenerateRandomAlphaNumericData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=20;
		String alphaNumeicString="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz";
		StringBuilder sb = new StringBuilder(n);
		System.out.println(alphaNumeicString.length());
		System.out.println(sb);
		
		for(int i=0;i<20;i++)
		{
			int index= (int)(alphaNumeicString.length()*Math.random());
			System.out.println("*******************");
			System.out.println(index);
			sb.append(alphaNumeicString.charAt(index));
			System.out.println(sb);
			System.out.println("*******************");
		}
		System.out.println(" random generated alpha numeric value is "+"\t"+sb);
		

	}

}
