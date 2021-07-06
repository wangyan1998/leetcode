package medium;
//给你一个数组 orders，表示客户在餐厅中完成的订单，确切地说， orders[i]=[customerNamei,tableNumberi,foodItemi] ，
//        其中 customerNamei 是客户的姓名，tableNumberi 是客户所在餐桌的桌号，而 foodItemi 是客户点的餐品名称。
//        请你返回该餐厅的 点菜展示表 。在这张表中，表中第一行为标题，其第一列为餐桌桌号 “Table” ，
//        后面每一列都是按字母顺序排列的餐品名称。接下来每一行中的项则表示每张餐桌订购的相应餐品数量，第一列应当填对应的桌号，
//        后面依次填写下单的餐品数量。
//        注意：客户姓名不是点菜展示表的一部分。此外，表中的数据行应该按餐桌桌号升序排列。


import java.util.*;

/**
 * @author wy
 * @date 2021/7/6 8:50
 */
public class DisplayTable1418 {
    /**
     * 首先统计每一桌点的菜品，然后将表头和首列添加进去，然后根据统计信息进行填表，时间比较慢，空间占用也略多
     * @param orders
     * @return
     */
    public List<List<String>> displayTable(List<List<String>> orders){
        List<String> tab=new ArrayList<String>();
        List<String> num=new ArrayList<String>();
        Map<String,List<String>> map=new HashMap<String, List<String>>();
        int n=orders.size();
        for(int i=0;i<n;i++){
            List<String> order=orders.get(i);
            String foodname=order.get(2);
            String tablenum=order.get(1);
            if(!tab.contains(foodname)){
            tab.add(foodname);
            }
            if(!num.contains(tablenum)){
            num.add(tablenum);
            }
            List<String> re=map.getOrDefault(tablenum,new ArrayList<String>());
            re.add(foodname);
            map.put(tablenum,re);
        }
        Collections.sort(tab);
        Collections.sort(num, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.parseInt(o1)-Integer.parseInt(o2);
            }
        });
        List<String> c1=new ArrayList<String>();
        List<List<String>> res=new ArrayList<List<String>>();
        c1.add("Table");
        c1.addAll(tab);
        res.add(c1);
        for(int i=0;i<num.size();i++){
            String nu=num.get(i);
            List<String> c=new ArrayList<String>();
            c.add(nu);
            Map<String,Integer> m=new HashMap<String, Integer>();
            List<String> lis=map.get(nu);
            for(String fn:lis){
                m.put(fn,m.getOrDefault(fn,0)+1);
            }
            for(int j=1;j<c1.size();j++){
                String s=m.getOrDefault(c1.get(j),0)+"";
                c.add(s);
            }
            res.add(c);
        }
        return res;
    }

    public List<List<String>> displayTable1(List<List<String>> orders) {
        // 从订单中获取餐品名称和桌号，统计每桌点餐数量
        Set<String> nameSet = new HashSet<String>();
        Map<Integer, Map<String, Integer>> foodsCnt = new HashMap<Integer, Map<String, Integer>>();
        for (List<String> order : orders) {
            nameSet.add(order.get(2));
            int id = Integer.parseInt(order.get(1));
            Map<String, Integer> map = foodsCnt.getOrDefault(id, new HashMap<String, Integer>());
            map.put(order.get(2), map.getOrDefault(order.get(2), 0) + 1);
            foodsCnt.put(id, map);
        }

        // 提取餐品名称，并按字母顺序排列
        int n = nameSet.size();
        List<String> names = new ArrayList<String>();
        for (String name : nameSet) {
            names.add(name);
        }
        Collections.sort(names);

        // 提取桌号，并按餐桌桌号升序排列
        int m = foodsCnt.size();
        List<Integer> ids = new ArrayList<Integer>();
        for (int id : foodsCnt.keySet()) {
            ids.add(id);
        }
        Collections.sort(ids);

        // 填写点菜展示表
        List<List<String>> table = new ArrayList<List<String>>();
        List<String> header = new ArrayList<String>();
        header.add("Table");
        for (String name : names) {
            header.add(name);
        }
        table.add(header);
        for (int i = 0; i < m; ++i) {
            int id = ids.get(i);
            Map<String, Integer> cnt = foodsCnt.get(id);
            List<String> row = new ArrayList<String>();
            row.add(Integer.toString(id));
            for (int j = 0; j < n; ++j) {
                row.add(Integer.toString(cnt.getOrDefault(names.get(j), 0)));
            }
            table.add(row);
        }
        return table;
    }
}
