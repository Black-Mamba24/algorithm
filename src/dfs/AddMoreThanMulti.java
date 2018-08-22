package number;

import java.util.*;

/**
 * Created by zhaiyi on 2018/8/22.
 */
public class AddMoreThanMulti {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int[] list = new int[count];
        for (int i = 0; i < count; i++) {
            list[i] = scanner.nextInt();
        }
        Arrays.sort(list);
        long sum = 0, multi = 1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < count; i++) {
            sum += list[i];
            multi *= list[i];
            if (multi > sum) {
                break;
            }
            if (!map.containsKey(list[i])) {
                map.put(list[i], 1);
            } else {
                map.put(list[i], map.get(list[i]) + 1);
            }
        }
        if (map.size() == 0 || !map.containsKey(1)) {
            System.out.println(0);
        } else if (map.get(1) == 1) {
            System.out.println(map.keySet().size() - 1);
        } else {
            int result = 1;
            int tmp = 0;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getKey() == 1) {
                    result *= (entry.getValue() - 1);
                } else {
                    result *= (entry.getValue() + 1);
                    tmp++;
                }
            }
            System.out.println(result + tmp);
        }
    }
}
