package dynamic;
/**Finding Minimum Edit distance - the minimum edits required to change from one given string to another
 * Edits= Deletion, Insertion and Replacement.
 * e.g. String 1 = "INTENTION" & String 2 = "EXECUTION", then the minimum edits requed = 5
 * To compute Minimum Edit distance we use Dynamic Programming and maintain a 2-D array to save the results of previous
  computations and break the problem into recurring sub-problems.
  We take the minimum of a[i-1][j],a[i][j-1],a[i-1][j-1] at each level to compute final value which is at the
  upper-right most corner of teh computed 2-D array**/

/**
 * @author: Aviral Nigam
*/


import java.util.Scanner;
import java.lang.Math;
class MinEditDist
{
	public static int min(int x, int y, int z) { //finding minimum
		return Math.min(Math.min(x,y),z);
	}
	public static void findMinEdit(String x, String y) {
		int M = x.length();
		int N = y.length();
		int[][] a=new int[M+1][N+1];
		for(int i=0;i<=M;i++) {
			for(int j=0;j<=N;j++) {
				if(j==0)
					a[i][j]=i;
				else if (i==0)
					a[i][j]=j;
				else if (x.charAt(i-1)==y.charAt(j-1))
					a[i][j]=a[i-1][j-1]; //equal character on both the string means simply copy the previous diagnol value
				else
					a[i][j]=1 + min(a[i-1][j],a[i][j-1],a[i-1][j-1]); //represents edits
			}
		}
		for(int k=0;k<=M;k++) {
			for(int l=0;l<=N;l++) {
				System.out.print(a[k][l]+"  "); //print the computed 2-D array
	}
	System.out.print("\n");
}
System.out.println("No. of Edits required to change from " + x+" to "+y+" is "+a[M][N]); //final output at position a(M,N)

}
public static void main(String... args) {
	String s1,s2;
	Scanner in = new Scanner(System.in);
	System.out.println("Enter the two Strings:");
	System.out.println("Str1:");
	s1=in.nextLine();
	System.out.println("Str2:");
	s2=in.nextLine();
	findMinEdit(s1,s2);
}
}
