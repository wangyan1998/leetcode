package competition.test_2021_11_21;

/**
 * @author wy
 * @date 2021/11/21 11:26
 */
public class KMirror {
    public long kMirror(int k, int n) {
        int count = 0;
        int i = 1;
        int ans=0;
        while (count < n) {
            if (getKnum(10, i) && getKnum(k, i)){
                count++;
                ans+=i;
            }
            i++;
        }
        return ans;
    }

    public boolean getKnum(int k, int n) {
        StringBuffer s = new StringBuffer();
        while (n != 0) {
            s.append(n % k);
            n = n / k;
        }
        String s1=s.toString();
        String s2=s.reverse().toString();
        if (s1.equals(s2)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        KMirror km=new KMirror();
        km.kMirror(2,5);
    }
}
