#include <string>
#include <vector>
#include <deque>
#include <algorithm>

using namespace std;

deque <pair<int, int>> dq;

vector<int> solution(vector<int> fruitWeights, int k) {
    vector<int> answer;

    for (int i = 0; i < fruitWeights.size(); i++)
    {
        int chk = fruitWeights[i];

        if (!dq.empty() && dq.front().second <= i - k) {
            dq.pop_front();
        }

        while (!dq.empty() && dq.back().first < chk) {
            dq.pop_back();
        }

        dq.push_back({ chk,i });

        if(i >= k - 1) {
            answer.push_back(dq.front().first);
        }
    }

    sort(answer.begin(), answer.end());
    reverse(answer.begin(), answer.end());
    answer.erase(unique(answer.begin(), answer.end()), answer.end());

    return answer;
}
