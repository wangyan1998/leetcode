package simple;

public class MergeAlternately5685 {
    public String mergeAlternately(String word1,String word2){
        int n1=word1.length();
        int n2=word2.length();
        char[] res=new char[n1+n2];
        char[] w1=word1.toCharArray();
        char[] w2=word2.toCharArray();
        int i=0,j=0,k=0;
        while (i<n1&&j<n2){
            if(k%2==0){
                res[k]=w1[i];
                i++;
            }else {
                res[k]=w2[j];
                j++;
            }
            k++;
        }
        while(i<n1){
            res[k]=w1[i];
            i++;
            k++;
        }
        while(j<n2){
            res[k]=w2[j];
            k++;
            j++;
        }
        return String.valueOf(res);
    }
}
