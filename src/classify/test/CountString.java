package classify.test;

import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import jxl.Workbook; //java读取excel表使用的类
import jxl.Cell;  //java读取表格里的单元格的类
import jxl.Sheet; //java读取的工作铺的类
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/**
 * @author wy
 * @date 2021/4/4 11:40
 */
public class CountString {
    private static String filename="5-27";
    /**
     * 统计文件中字符串的个数
     *
     * @param filename
     * @param target
     * @return
     * @throws IOException
     */
    public static int count(String filename, String target) throws IOException {
        FileReader fr = new FileReader(filename);
        BufferedReader br = new BufferedReader(fr);
        StringBuilder strb = new StringBuilder();
        while (true) {
            String line = br.readLine();
            if (line == null) {
                break;
            }
            strb.append(line);
        }
        String result = strb.toString();
        int count = 0;
        int index = 0;
        while (true) {
            index = result.indexOf(target, index + 1);
            if (index > 0) {
                count++;
            } else {
                break;
            }
        }
        br.close();
        return count;
    }

    /**
     * 统计每个同学的投票数
     *
     * @return
     * @throws IOException
     * @throws BiffException
     */
    public static List<Integer> getCount() throws IOException, BiffException {
        List<String> name = getStudentName();
        List<Integer> num = new ArrayList<Integer>();
        for (int i = 0; i < name.size(); i++) {
            try {
                num.add(count("D:\\Desktop\\graduate_student\\工作临时文件夹\\工作\\助教\\2021年春季学期\\投票统计\\元数据\\"+filename+".txt", name.get(i)));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return num;
    }

    /**
     * 获取每个同学的姓名
     *
     * @return
     * @throws IOException
     * @throws BiffException
     */
    public static List<String> getStudentName() throws IOException, BiffException {
        Workbook workbook = null;
        File Inputfile = new File("D:\\Desktop\\graduate_student\\工作临时文件夹\\工作\\助教\\2021年春季学期\\投票统计\\name.xls");
        List<String> name = new ArrayList<String>();
        FileInputStream fileInputStream = new FileInputStream(Inputfile);
        workbook = Workbook.getWorkbook(fileInputStream);
        Sheet readfirst = workbook.getSheet(0);
        int rows = readfirst.getRows();
        //System.out.println(rows);
        for (int i = 1; i <rows; i++) {
            Cell[] cells = readfirst.getRow(i); //循环得到每一行的单元格对象
            String Name = cells[0].getContents();
            name.add(Name);
        }
        name.add("何斐");
        return name;
    }

    /**
     * 将统计结果写回文件中
     *
     * @param name
     * @param num
     * @throws IOException
     * @throws WriteException
     */
    public static void writeExcel(List<String> name, List<Integer> num) throws IOException, WriteException {
        //开始写入excel,创建模型文件头
        String[] titleA = {"姓名", "投票题数"};
        Calendar c = Calendar.getInstance();//可以对每个时间域单独修改
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH)+1;
        int date = c.get(Calendar.DATE);
        String testdate=year+"-"+month+"-"+date;
        //创建Excel文件，B库CD表文件
        File fileA = new File("D:\\Desktop\\graduate_student\\工作临时文件夹\\工作\\助教\\2021年春季学期\\投票统计\\元数据\\"+filename+".xls");
        fileA.createNewFile();
        if (fileA.exists()) {
            //如果文件存在就删除
            fileA.delete();
        }
        //创建工作簿
        WritableWorkbook workbookA = Workbook.createWorkbook(fileA);
        //创建sheet
        WritableSheet sheetA = workbookA.createSheet("sheet1", 0);
        Label labelA = null;
        //设置列名
        for (int i = 0; i < titleA.length; i++) {
            labelA = new Label(i, 0, titleA[i]);
            sheetA.addCell(labelA);
        }
        //获取数据源
        for (int i = 1; i < name.size(); i++) {
            labelA = new Label(0, i, name.get(i - 1));
            sheetA.addCell(labelA);
            labelA = new Label(1, i, num.get(i - 1) + "");
            sheetA.addCell(labelA);
        }
        workbookA.write();    //写入数据
        workbookA.close();  //关闭连接

    }

    public static void main(String[] args) throws IOException, WriteException, BiffException {
        List<String> name = getStudentName();
        List<Integer> num = getCount();
        writeExcel(name,num);
    }
}
