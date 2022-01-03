package esay;
//给你一个日期，请你设计一个算法来判断它是对应一周中的哪一天。
//        输入为三个整数：day、month 和year，分别表示日、月、年。
//        您返回的结果必须是这几个值中的一个{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"}。


/**
 * @author wy
 * @date 2022/1/3 10:11
 */
public class DayOfTheWeek1185 {
    public String dayOfTheWeek(int day, int month, int year) {
        String[] res={"Thursday","Friday", "Saturday","Sunday", "Monday", "Tuesday", "Wednesday"};
        int days = 0;
        for(int i=1971;i<year;i++){
            days+=isRyear(i);
        }
        days+=getdays(day,month,year);
        return res[days%7];
    }

    public int isRyear(int year) {
        if (year % 4 == 0 && year % 100 != 0) {
            return 366;
        }
        if (year % 400 == 0) {
            return 366;
        }
        return 365;
    }

    public int getdays(int day, int month, int year) {
        int res = 0;
        for (int i = 1; i < month; i++) {
            if (i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10 || i == 12) {
                res += 31;
            } else if (i == 2 && isRyear(year) == 366) {
                res += 29;
            } else if (i == 2 && isRyear(year)==365) {
                res += 28;
            } else {
                res += 30;
            }
        }
        return res+day;
    }
}
