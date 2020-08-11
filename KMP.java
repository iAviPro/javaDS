/** KMP Algorithm : KMP(Knuth Morris Pratt) is an algorithm for substring pattern matching.
* The algorithm first preprocesses the pattern to identify 
 size of suffix same as prefix (common pattern within the pattern) and then based on the output array (temporary) pattern
 matches the pattern to the given text.
* Runtime complexity - O(m + n) where m is length of text and n is length of pattern
* Space complexity - O(n). 
*/
/** 
* @author: Aviral Nigam
*/
import java.util.Scanner;
public class KMP
{
	//preprocessing pattern to identify size of same suffix as prefix
	private static int[] preprocessing(char[] pattern) {
		int[] temp = new int[pattern.length];
		int index=0;
		for(int i=1;i<pattern.length;) {
			if(pattern[i] == pattern[index]) { // if pattern matches then increment both index and counter i
                temp[i] = index + 1;
                index++;
                i++;
            }
            else { // if pattern values do not match
                if(index != 0){ 
                    index = temp[index-1];
                }
                else {
                    temp[i] = 0;
                    i++;
                }
            }
        }
        return temp;
    }
    //Doing Substring search using KMP
    public static void substringSearch(char []text, char []pattern){
        
        int[] temp = preprocessing(pattern);
        int i=0;
        int j=0;
        int index=0;//index where the pattern was found
        while(i < text.length && j < pattern.length) { //traversing through the length of patern and text
            if(text[i] == pattern[j]) {
                i++;
                j++;
            }
            else {
                if(j!=0){
                    j = temp[j-1];
                }
                else {
                    i++;
                }
            }
        }
        if(j == pattern.length){ 
        	index = (i - j) + 1;
            System.out.println("Pattern found at index:"+ index);//if pattern length is found in the text
        }
        else
        	System.out.println("\nPattern Does Not exists in the given text");
    }
    //main method
    public static void main(String args[]) {
    	Scanner in = new Scanner(System.in);
    	System.out.println("Enter the Text to be searched in:");
        String str = in.nextLine();     //e.g."abcxabcdabcdabcy";
        System.out.println("Enter the Pattern to be searched in the given text:");
        String subString = in.nextLine();//"abcdabcy";
        substringSearch(str.toCharArray(), subString.toCharArray());//for ease of calculation converting it to char. array    
    }
}

