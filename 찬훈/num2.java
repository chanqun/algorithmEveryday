import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class num2 {
    String[][] grade = {
            {"A+", "43"}, {"A0", "40"}, {"A-", "37"},
            {"B+", "33"}, {"B0", "30"}, {"B-", "27"},
            {"C+", "23"}, {"C0", "20"}, {"C-", "17"},
            {"D+", "13"}, {"D0", "10"}, {"D-", "7"},
            {"F", "0"}
    };
    Map<String, Result> map = new HashMap<>();

    public String[] solution(String[] grades) {
        String[] answer = {};

        for (int index = 0; index < grades.length; index++) {
            String[] s = grades[index].split(" ");
            String classNumber = s[0];
            String classGrade = s[1];
            Integer numberGrade = 0;

            for (int i = 0; i < grade.length; i++) {
                if (classGrade.equals(grade[i][0])) {
                    numberGrade = Integer.parseInt(grade[i][1]);
                }
            }

            if (map.containsKey(classNumber)) {
                if (map.get(classNumber).grade < numberGrade) {
                    map.replace(classNumber, new Result(numberGrade, classNumber, index));
                }
            } else {
                map.put(classNumber, new Result(numberGrade, classNumber, index));
            }
        }

        ArrayList<Result> arrayList = new ArrayList<>();
        answer = new String[map.size()];

        for (String key : map.keySet()) {
            Result tempGrade = map.get(key);

            arrayList.add(tempGrade);
        }

        Collections.sort(arrayList);

        for (int i = 0; i < arrayList.size(); i++) {
            String c = arrayList.get(i).cla;
            Integer g = arrayList.get(i).grade;
            String sg = "";

            for (int j = 0; j < grade.length; j++) {
                if (g == Integer.parseInt(grade[j][1])) {
                    sg = grade[j][0];
                }
            }

            answer[i] = c + " " + sg;
        }

        return answer;
    }

    static class Result implements Comparable<Result> {
        Integer grade;
        String cla;
        Integer index;

        Result(Integer grade, String cla) {
            this.grade = grade;
            this.cla = cla;
        }

        Result(Integer grade, String cla, Integer index) {
            this.grade = grade;
            this.cla = cla;
            this.index = index;
        }

        @Override
        public int compareTo(Result result) {
            if (result.grade > grade) {
                return 1;
            } else if (result.grade < grade) {
                return -1;
            }else {
                if(result.index < index){
                    return 1;
                }else if(result.index > index){
                    return -1;
                }

                return 0;
            }

        }
    }
}