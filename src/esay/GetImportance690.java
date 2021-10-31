package esay;

import java.util.*;
//给定一个保存员工信息的数据结构，它包含了员工 唯一的 id ，重要度和 直系下属的 id 。
//        比如，员工 1 是员工 2 的领导，员工 2 是员工 3 的领导。他们相应的重要度为 15 , 10 , 5 。
//        那么员工 1 的数据结构是 [1, 15, [2]] ，员工 2的 数据结构是 [2, 10, [3]] ，员工 3 的数据结构是 [3, 5, []] 。
//        注意虽然员工 3 也是员工 1 的一个下属，但是由于 并不是直系 下属，因此没有体现在员工 1 的数据结构中。
//        现在输入一个公司的所有员工信息，以及单个员工 id ，返回这个员工和他所有下属的重要度之和。




// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;

    public Employee(int id, int importance, List<Integer> subordinates) {
        this.id = id;
        this.importance = importance;
        this.subordinates = subordinates;
    }
};
/**
 * @author wy
 * @date 2021/5/1 9:28
 */
public class GetImportance690 {
    /**
     * 采用了队列，类似于树的层次遍历
     * @param employees
     * @param id
     * @return
     */
    public static int getImportance(List<Employee> employees,int id){
        Map<Integer,Integer> map=new HashMap<Integer, Integer>();
        for(int i=0;i<employees.size();i++){
            map.put(employees.get(i).id,i);
        }
        int sum=0;
        Queue<Integer> qe=new PriorityQueue<Integer>();
        qe.add(id);
        while(!qe.isEmpty()){
            int a=qe.poll();
            sum+=employees.get(map.get(a)).importance;
            qe.addAll(employees.get(map.get(a)).subordinates);
        }
        return sum;
    }

    Map<Integer,Employee> map=new HashMap<Integer, Employee>();

    /**
     * 深度优先遍历
     * @param employees
     * @param id
     * @return
     */
    public int getImportance1(List<Employee> employees,int id){
        for(Employee employee:employees){
            map.put(employee.id,employee);
        }
        return dfs(id);
    }
    public int dfs(int id){
        Employee employee=map.get(id);
        int total=employee.importance;
        List<Integer> subordinates=employee.subordinates;
        for(int subId:subordinates){
            total+=dfs(subId);
        }
        return total;
    }

    /**
     * 广度优先遍历，和第一种方法一样
     * @param employees
     * @param id
     * @return
     */
    public int getImportance2(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<Integer, Employee>();
        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }
        int total = 0;
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(id);
        while (!queue.isEmpty()) {
            int curId = queue.poll();
            Employee employee = map.get(curId);
            total += employee.importance;
            List<Integer> subordinates = employee.subordinates;
            for (int subId : subordinates) {
                queue.offer(subId);
            }
        }
        return total;
    }
}
