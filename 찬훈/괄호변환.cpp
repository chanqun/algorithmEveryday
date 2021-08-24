#include <iostream>
#include <string>
#include <vector>

using namespace std;

bool check(string s) {
    int a = 0, b = 0;
    for (int i = 0; i < s.size(); i++) {
        if (s[i] == '(') {
            a++;
        }
        else {
            b++;
        }
        if (a < b) {
            return false;
        }
    }
    if (a != b) {
        return false;
    }
    else {
        return true;
    }
}

string recur(string u, string v) {
    if (u == "") {
        return "";
    }
    string u1 = "";
    string v1 = "";
    int a = 0, b = 0, c = 0;
    for (int i = 0; i < u.size(); i++) {
        if (c == 0) {
            if (u[i] == '(') {
                u1 += "(";
                a++;
            }
            else {
                u1 += ")";
                b++;
            }
            if (a == b) {
                c = 1;
            }
        }
        else {
            if (u[i] == '(') {
                v1 += "(";
                a++;
            }
            else {
                v1 += ")";
                b++;
            }
        }
    }
    if (check(u1)) {
        v1=recur(v1, "");
        return u1 + v1;
    }
    else if (!check(u1)) {
        string temp = "";
        for (int i = 1; i < u1.size()-1; i++)
        {
            if (u1[i] == '(') {
                temp += ")";
            }
            else {
                temp += "(";
            }
        }
        return "(" + recur(v1, "") + ")"+temp;
    }
}

string solution(string p) {
    string answer = "";

    answer = recur(p, "");

    return answer;
}