import java.util.*;
import java.time.*;

class Solution {
    public String solution(int a, int b) {
        var dayOfWeek = LocalDate.of(2016, a, b).getDayOfWeek(); 
        
        return dayOfWeek.name().substring(0, 3);
    }
}
