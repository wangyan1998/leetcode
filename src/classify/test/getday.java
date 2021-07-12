package classify.test;

import java.util.Scanner;

/**
 * @author wy
 * @date 2021/7/11 15:59
 */
public class getday {
    public static void main(String[] args) {
        Scanner sca = new Scanner(System.in);
        System.out.println("请输入年份：");
        int year = sca.nextInt();
        System.out.println("请输入月份：");
        int month = sca.nextInt();
        System.out.println("请输入天数：");
        int day = sca.nextInt();
        int days = day;

        //month是多少就会加上之前的每个月满天数
        //如8月就会直接从8月向下加直到break
        switch (month) {
            case 12:
                days += 30;//days += 11月的天数
            case 11:
                days += 31;
            case 10:
                days += 30;
            case 9:
                days += 31;
            case 8:
                days += 31;
            case 7:
                days += 30;
            case 6:
                days += 31;
            case 5:
                days += 30;
            case 4:
                days += 31;
            case 3:
                days += 28;
			/*
			判断闰年
			四年一闰，百年不闰；四百年再闰
			即在不是整百年下每四年一闰或者每四百年一闰
			如2020年是四的倍数但不是100的倍数所以是闰年
			2100是四的倍数也是100的倍数而且也不是400的倍数所以不是闰年
			2000是四的倍数也是100的倍数但是它是400的倍数所以是闰年
			*/
                if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
                    days++;
                }
            case 2:
                days += 31;
                break;

        }
        System.out.println(year + "年" + month + "月" + day + "日是这一年的第" + days + "天");
    }
}
