package medium;
//罗马数字包含以下七种字符：I，V，X，L，C，D和M。
//        字符          数值
//        I             1
//        V             5
//        X             10
//        L             50
//        C             100
//        D             500
//        M             1000
//        例如， 罗马数字 2 写做II，即为两个并列的 1。12 写做XII，即为X+II。 27 写做XXVII, 即为XX+V+II。
//        通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做IIII，而是IV。数字 1 在数字 5 的左边，
//        所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为IX。这个特殊的规则只适用于以下六种情况：
//        I可以放在V(5) 和X(10) 的左边，来表示 4 和 9。
//        X可以放在L(50) 和C(100) 的左边，来表示 40 和90。
//        C可以放在D(500) 和M(1000) 的左边，来表示400 和900。
//        给定一个整数，将其转为罗马数字。输入确保在 1到 3999 的范围内。


/**
 * @author wy
 * @date 2021/5/14 8:57
 */
public class IntToRoman12 {
    /**
     * 先求出每一位的数，然后按照提前约定好的数字对应枚举
     * @param num
     * @return
     */
    public String intToRoman(int num){
      int[] p=new int[4];
      int a=1000;
      for(int i=0;i<4;i++){
          p[i]=num/a;
          num=num%a;
          a/=10;
      }
      String[][] b={{"","M","MM","MMM"},
                    {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"},
                    {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"},
                    {"","I","II","III","IV","V","VI","VII","VIII","IX"}};
      String res="";
      for(int i=0;i<4;i++){
          res=res+b[i][p[i]];
      }
      return res;
    }


    int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public String intToRoman1(int num) {
        StringBuffer roman = new StringBuffer();
        for (int i = 0; i < values.length; ++i) {
            int value = values[i];
            String symbol = symbols[i];
            while (num >= value) {
                num -= value;
                roman.append(symbol);
            }
            if (num == 0) {
                break;
            }
        }
        return roman.toString();
    }
}
