import java.util.Map;
import java.util.TreeMap;

public class SieveOfEratosthenesPrime {
    public static void main(String[] args) {
        int start = 10;
        int end = 19;
        Map<Integer, Boolean> map = new TreeMap<>();
        for (int i = start; i <= end; i++) {
            map.put(i, true);
        }
        for (int i = 2; i <= end; i = i + 2) {
            if (map.containsKey(i)) {
                map.put(i, false);
            }
        }
        for (int i = 3; i <= end; i++) {
            for (int j = i * i; j <= end; j = j + i) {
                if (map.containsKey(j)) {
                    map.put(j, false);
                }
            }
        }
        for (Map.Entry<Integer, Boolean> mapVal : map.entrySet()) {
            System.out.println("Number : " + mapVal.getKey() + " is prime :  " + mapVal.getValue());
        }

    }
}
