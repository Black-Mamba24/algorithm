package leetcode.recursion.dfs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 员工的重要性
 * 给定一个保存员工信息的数据结构，它包含了员工唯一的id，重要度 和 直系下属的id。
 * 比如，员工1是员工2的领导，员工2是员工3的领导。他们相应的重要度为15, 10, 5。那么员工1的数据结构是[1, 15, [2]]，员工2的数据结构是[2, 10, [3]]，员工3的数据结构是[3, 5, []]。注意虽然员工3也是员工1的一个下属，但是由于并不是直系下属，因此没有体现在员工1的数据结构中。
 * 现在输入一个公司的所有员工信息，以及单个员工id，返回这个员工和他所有下属的重要度之和。
 * 输入: [[1, 5, [2, 3]], [2, 3, []], [3, 3, []]], 1
 * 输出: 11
 * 解释:
 * 员工1自身的重要度是5，他有两个直系下属2和3，而且2和3的重要度均为3。因此员工1的总重要度是 5 + 3 + 3 = 11。
 * 思路：典型深度遍历，循环中递归，结合hash表
 */
public class EmployeeImportance690 {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer/*id*/, Employee> map = new HashMap<>();
        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }
        return sum_importance(map.get(id), map);
    }

    public int sum_importance(Employee employee, Map<Integer/*id*/, Employee> map) {
        int res = 0;
        res += employee.importance;
        for (Integer id : employee.subordinates) {
            res += sum_importance(map.get(id), map);
        }
        return res;
    }
}
