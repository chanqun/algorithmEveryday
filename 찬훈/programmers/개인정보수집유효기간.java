import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = {};
        List<Integer> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();        
        Date todayDate = new Date(today);
        
        for (String term: terms) {
            String[] temp = term.split(" ");
            map.put(temp[0], Integer.parseInt(temp[1]));
        }
        
        for (int i=0; i<privacies.length; i++) {
            String privacy = privacies[i];
            String[] temp = privacy.split(" ");
            String tempDateString = temp[0];
            String term = temp[1];
            
            Date tempDate = new Date(tempDateString);
            
            boolean result = tempDate.isOver(map.get(term), todayDate);
            if (!result) {
                list.add(i + 1);
            }
        }
        
        answer = new int[list.size()];
        for (int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}

class Date {
    int year;
    int month;
    int day;
    
    Date(String day) {
        String[] dayArray = day.split("\\.");
        
        this.year = Integer.parseInt(dayArray[0]);
        this.month = Integer.parseInt(dayArray[1]);
        this.day = Integer.parseInt(dayArray[2]);
    }
    
    public boolean isOver(int availableMonth, Date today) {
        int tempMonth = this.month + availableMonth;
        int tempYear = this.year;
        int tempDay = this.day;
        
        if (tempMonth > 12) {
            tempYear++;
            tempMonth -= 12;
        }
        
        int tempInt = tempYear * 12 * 28 + tempMonth * 28 + tempDay;
        
        return tempInt > today.getDateInt();
    }
    
    public int getDateInt() {
        return this.year * 12 * 28 + this.month * 28 + this.day;
    }
}

