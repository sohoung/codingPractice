package String;

import java.util.Scanner;

// 설명 : 문자와 숫자가 섞여있는 문자열이 주어지면 그 중 숫자만 추출하여 그 순서대로 자연수를 만듭니다.
//      만약 “tge0a1h205er”에서 숫자만 추출하면 0, 1, 2, 0, 5이고 이것을 자연수를 만들면 1205이 됩니다.
//      추출하여 만들어지는 자연수는 100,000,000을 넘지 않습니다.
// 입력 예시 : g0en2T0s8eSoft
// 출력 예시 : 208
// 문자형 숫자 '0' ~ '9'의 아스키넘버는 48 ~ 57이다.
// 대문자 A-Z의 아스키 넘버는 65-90이고 소문자 a-z의 아스키 넘버는 97-122이다.

public class 숫자만추출 {
    public int solution(String str) {
        int answer = 0;
        for(char c : str.toCharArray()) {
            if(c >= 48 && c <= 57) {  // 문자형 숫자의 아스키 넘버를 이용한 if문
                answer = answer * 10 + (c - 48);  // answer에 값을 누적한다. 만약 맨 앞의 발견된 숫자가 0이더라도 answer의 값은 0에서 그 다음 값으로
                                                  // 누적되기 때문에 상관없다.
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        숫자만추출  m = new 숫자만추출();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(m.solution(str));
    }
}
