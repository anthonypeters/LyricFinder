    /**

     **  Java Program to implement Wagner Fischer Algorithm

     **/

    import java.io.BufferedReader;

    import java.io.InputStreamReader;

    import java.io.IOException;

    /** Class WagnerFischer **/
    public class WagnerFischer{

        /** Function to get levenshtein distance between 2 strings **/

        public int getLevenshteinDistance(String str1, String str2){    

            int len1 = str1.length();

            int len2 = str2.length();

            int[][] arr = new int[len1 + 1][len2 + 1];

            for (int i = 0; i <= len1; i++)

                arr[i][0] = i;

            for (int i = 1; i <= len2; i++)

                arr[0][i] = i;

            for (int i = 1; i <= len1; i++) {

                for (int j = 1; j <= len2; j++) {

                    int m = (str1.charAt(i - 1) == str2.charAt(j - 1)) ? 0:1;                        

                    arr[i][j] = Math.min(Math.min(arr[i - 1][j] + 1, arr[i][j - 1] + 1), arr[i - 1][j - 1] + m);

                }

            }

            return arr[len1][len2];

        }

     

        /** Main Function **/

        public static void main(String[] args) throws IOException {    

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Wagner Fischer Test\n");

     

            /** Accept two strings **/

            System.out.println("\nEnter string 1 :");

            String str1 = br.readLine();

            System.out.println("\nEnter string 2 :");

            String str2 = br.readLine();

     

            /** make object and call function **/

            WagnerFischer wf = new WagnerFischer();

            int lDist = wf.getLevenshteinDistance(str1, str2);    

     

            System.out.println("\nLevenshtein Distance = "+ lDist);    

        }

    }