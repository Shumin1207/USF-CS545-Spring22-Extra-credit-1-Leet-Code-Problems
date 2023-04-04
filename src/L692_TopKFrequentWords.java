import java.util.*;

class L692_TopKFrequentWords {

    public static void main(String[] args) {

        String[] words = new String[]{"i","love","leetcode","i","love","coding"};

        topKFrequent(words, 2);
    }
    public static List<String> topKFrequent(String[] words, int k) {
        if (words.length == 0 || k <= 0){
            return null;
        }

        Map<String, Integer> freqMap = new HashMap<>();
        for (String s: words){
            Integer temp = freqMap.getOrDefault(s, 0);
            freqMap.put(s, temp+1);
        }

        PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(k, (o1, o2)-> o1.getValue().equals(o2.getValue()) ? o2.getKey().compareTo(o1.getKey()) : o1.getValue().compareTo(o2.getValue()));

        for (Map.Entry<String, Integer> entry: freqMap.entrySet()){
            if (minHeap.size() < k){
                minHeap.offer(entry);
            }else if (entry.getValue() > minHeap.peek().getValue()){
                minHeap.poll();
                minHeap.offer(entry);
            }
        }

        System.out.println(minHeap);

        String[] res = new String[k];

        for (int i = minHeap.size()-1; i >=0; i--){
            res[i] = minHeap.poll().getKey();
        }

        List<String> result = new ArrayList<>();
        for (String s: res){
            result.add(s);
        }

        return result;
    }
}