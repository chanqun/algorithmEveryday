// 정렬 알고리즘 참고
// https://d2.naver.com/helloworld/0315536

function solution(n) {
    let answer = 0;
    let tempAnswer = '';
    const tempList = [];

    while (n >= 1) {
        tempList.push(n % 10)
        n = Math.floor(n / 10)
    }

    tempList.sort((a, b) => (b - a)).forEach(x => tempAnswer += x)
    answer = Number(tempAnswer)
    return answer;
}

// split 함수로 글자 단위로 자를 수 있음
function solution2(n) {
    const newN = n + "";
    const newArr = newN
        .split("")
        .sort()
        .reverse()
        .join("");

    return +newArr;
}


