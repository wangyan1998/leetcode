package esay;

import java.util.ArrayList;
import java.util.List;

public class PrefixesDivByfive1018 {
    /**
     * 对于 0≤i<n，可以依次计算每个 Ni的值。对于每个 Ni的值，判断其是否可以被 5 整除，即可得到答案。
     * 考虑到数组 A可能很长，如果每次都保留 Ni的值，则可能导致溢出。由于只需要知道每个Ni否可以被 5整除，
     * 因此在计算过程中只需要保留余数即可。
     * Mi=Ni%5
     * @param A
     * @return
     */
    public List<Boolean> prefixesDivBy5(int[] A){
          List<Boolean> res=new ArrayList<Boolean>();
          int m=A[0];
          if(m%5==0){
              res.add(true);
          }else {
              res.add(false);
          }

          for(int i=1;i<A.length;i++){
              m=m%5;
              m=m*2+A[i];
              if(m%5==0){
                  res.add(true);
              }else {
                  res.add(false);
              }
          }
          return res;
    }
    public List<Boolean> prefixesDivBy51(int[] A) {
        List<Boolean> list = new ArrayList<Boolean>();
        int prefix = 0;
        int length = A.length;
        for (int i = 0; i < length; i++) {
            prefix = ((prefix << 1) + A[i]) % 5;
            list.add(prefix == 0);
        }
        return list;
    }
}
