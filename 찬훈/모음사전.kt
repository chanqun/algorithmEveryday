class Solution {
    fun solution(word: String): Int {
        var answer = 0
        var number = HashMap<Char,Int>()
        number.put('A',0)
        number.put('E',1)
        number.put('I',2)
        number.put('O',3)
        number.put('U',4)

        var array = arrayOf(781,156,31,6,1)

        for(i in word.indices){
            answer = answer+ number[word[i]]!! * array[i]+1
        }

        return answer
    }
}