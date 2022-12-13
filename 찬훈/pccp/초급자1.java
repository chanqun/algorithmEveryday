class Solution {
    public String solution(String p) {
        String answer = "";

        answer = recur(p);

        return answer;
    }

    private String recur(String p) {
        if (p.equals("")) {
            return "";
        }

        String u = getBalanceString(p);
        String v = p.substring(u.length());

        if (isRight(u)) {
            v = recur(v);
        } else {
            return "(" + recur(v) + ")" + makeRightString(u);
        }

        return u + v;
    }

    private String makeRightString(String str) {
        String rightString = "";

        for (int i=1; i<str.length() - 1; i++) {
            char temp = str.charAt(i);

            if (temp == '(') {
                rightString += ")";
            } else {
                rightString += "(";
            }
        }

        return rightString;
    }

    private String getBalanceString(String str) {
        int left = 0;
        int right = 0;
        String balanceString = "";

        for (int i=0; i<str.length(); i++) {
            char temp = str.charAt(i);

            if (temp == '(') {
                balanceString += "(";
                left++;
            } else {
                balanceString += ")";
                right++;
            }

            if (left == right) {
                return balanceString;
            }
        }

        return balanceString;
    }

    private boolean isRight(String str) {
        int left = 0;
        int right = 0;

        for (int i=0; i<str.length(); i++) {
            char temp = str.charAt(i);

            if (temp == '(') {
                left++;
            } else {
                right++;
            }

            if (left < right) {
                return false;
            }
        }

        return left == right;
    }
}
