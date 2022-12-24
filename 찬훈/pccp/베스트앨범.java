import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        
        Map<String, PriorityQueue<Data>> record = new HashMap<>();
        Map<String, Integer> rank = new HashMap<>();
        
        for (int i=0; i<genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];
            
            if (!record.containsKey(genre)) {
                record.put(genre, new PriorityQueue<>());
                rank.put(genre, 0);
            }
            
            var pq = record.get(genre);
            
            rank.put(genre, rank.get(genre) + play);
            pq.add(new Data(play, i));
        }
        
        PriorityQueue<Data2> convertRank = new PriorityQueue<>();

        for (String str: rank.keySet()) {
            convertRank.add(new Data2(str, rank.get(str)));
        }
        
        List<Data> list = new ArrayList<>();
        
        while(!convertRank.isEmpty()) {
            Data2 data2 = convertRank.poll();
            var pq = record.get(data2.name);
            int count = 0;
            
            while (count < 2 && !pq.isEmpty()) {
                list.add(pq.poll());
                
                count++;
            }
        }
        
        answer = new int[list.size()];
        
        for (int i=0; i<list.size(); i++) {
            answer[i] = list.get(i).index;
        }
        
        return answer;
    }
}

class Data implements Comparable<Data> {
    int play;
    int index;
    
    public Data(int play, int index) {
        this.play = play;
        this.index = index;
    }
    
    @Override
    public int compareTo(Data target) {
        return target.play - this.play;
    }
}

class Data2 implements Comparable<Data2> {
    String name;
    int play;
    
    public Data2(String name, int play) {
        this.name = name;
        this.play = play;
    }
    
    @Override
    public int compareTo(Data2 target) {
        return target.play - this.play;
    }
}

