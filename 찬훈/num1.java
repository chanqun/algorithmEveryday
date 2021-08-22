import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Solution {
    Map<String, String> user = new HashMap();
    Boolean isLogin = false;
    String loginId = "";
    int orderCount = 0;

    public boolean[] solution(String[] infos, String[] actions) {
        boolean[] answer = {};
        answer = new boolean[actions.length];


        ArrayList<Boolean> booleans = new ArrayList();

        for (String temp : infos) {
            String[] s = temp.split(" ");
            String id = s[0];
            String password = s[1];

            user.put(id, password);
        }

        for (String temp : actions) {
            String[] s = temp.split(" ");
            boolean result = false;

            if (s[0].equals("LOGIN")) {
                result = login(s[1], s[2]);

            } else if (s[0].equals("ADD")) {
                result = isLogin;
                if(isLogin){
                    orderCount++;
                }
            } else if (s[0].equals("ORDER")) {
                if (orderCount != 0) {
                    orderCount = 0;
                    result = true;
                } else {
                    result = false;
                }
            }

            booleans.add(result);
        }

        for (int i = 0; i < booleans.size(); i++) {
            answer[i] = booleans.get(i);
        }

        return answer;
    }

    private boolean login(String id, String pwd) {
        if (isLogin) {
            return false;
        }

        if (user.containsKey(id)) {
            String password = user.get(id);

            if (password.equals(pwd)) {
                loginId = id;
                isLogin = true;

                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
