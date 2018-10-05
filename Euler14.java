package euler;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class Euler14 {

    private static long getCollatz(long n, HashMap<Long, Long> collatzMap) {
        //System.out.println("Get Collatz for :" + n);
        //System.out.println("Map is"+ Arrays.asList(collatzMap));
        //Long result = collatzMap.get(n);
        //if(result != null) { 
            //System.out.println("Found Already");
        //    return result;
        //}
        
        if(n == 1) {
          //  collatzMap.put(n, 0L);
            return 0L;
        }
        
        
        long t1 = 0;
        
        if(n%2 == 0) {
            t1 = n/2;
        } else {
            t1 = 3*n + 1;
        }
        
        
        Long t1Result = getCollatz(t1, collatzMap);
            
        //collatzMap.put(n, t1Result + 1L);
        return t1Result + 1L;
    }
    
    
    public static long getLongestCollatz(long n) {
        HashMap<Long, Long> collatzMap = new HashMap<Long, Long>();
        HashMap<Long, Long> duration = new HashMap<Long, Long>();
        //long start = System.currentTimeMillis();
        for(long i=1; i<=n; i++) {
            //long start = System.nanoTime();
            getCollatz(i, collatzMap);
            //long end = System.nanoTime();
            //duration.put(i, (end-start));
        }
        long max = Long.MIN_VALUE;
        long maxIndex = Long.MIN_VALUE;
        for(Entry<Long, Long> entry: collatzMap.entrySet()) {
            //System.out.println(entry.getKey()+" "+entry.getValue());
            if(max < entry.getValue()) {
                //System.out.println("Replacing max:"+ max+"\t"+entry.getValue()+"\t"+maxIndex+"\t"+entry.getKey());
                max = entry.getValue();
                maxIndex = entry.getKey();
            } else if(max == entry.getValue() && maxIndex < entry.getKey()) {
                maxIndex = entry.getKey();
            }
        }
        long total = 0;
        /*for(Entry<Long, Long> durationEntry: duration.entrySet()) {
            if(durationEntry.getValue()>1000) {
                System.out.println(durationEntry.getKey()+" "+ durationEntry.getValue());
            }
            total += durationEntry.getValue();
        }
        System.out.println("Average:"+ (total/duration.size()));*/
        return maxIndex;
    }
    
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            long n = scanner.nextLong();
            //long start = System.currentTimeMillis();
            long collatz = getLongestCollatz(n);
            //long end = System.currentTimeMillis();
            //System.out.println(n+" "+collatz +" "+(end-start));
            System.out.println(collatz);
        }
        scanner.close();
    }
}
