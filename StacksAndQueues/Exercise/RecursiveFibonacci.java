package StacksAndQueues.Exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RecursiveFibonacci {
    public static class memorisation {
        private Map<Integer, Long> cache = new HashMap<>();

        public long getFibonacci(int num) {
            if (num == 0 || num == 1) {
                return 1;
            }
            if (this.cache.containsKey(num)) {
                return this.cache.get(num);
            } else {
                long result = getFibonacci(num - 1) + getFibonacci(num - 2);
                this.cache.put(num, result);
                return result;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = Integer.parseInt(scan.nextLine());
        memorisation memorisation = new memorisation();
        System.out.println(memorisation.getFibonacci(number));
    }
}
