package String;

// 설명 : 앞에서 읽을 때나 뒤에서 읽을 때나 같은 문자열을 회문 문자열이라고 합니다.
//      문자열이 입력되면 해당 문자열이 회문 문자열이면 "YES", 회문 문자열이 아니면 “NO"를 출력하는 프로그램을 작성하세요.
//      단 회문을 검사할 때 대소문자를 구분하지 않습니다.
// 입력 예시 : gooG
// 출력 예시 : YES

import java.util.Scanner;

public class 회문문자열 {
    public String solution(String str) {
        String answer = "YES";
        str = str.toUpperCase();  // 문제에서 대소문자를 구분하지 않기로 하였으므로 입력받은 str을 모두 대문자나 소문자로 바꿔준다.
        int len = str.length();   // for문에 따른 charAt의 값을 변화해주기 위해서 입력받은 str의 길이를 구해준다.
        for(int i = 0; i < len/2; i++) {  // for문으로 돌려주는데 조건문을 i < len/2로 한 이유는 서로의 문자를 비교하고 가운데에서는 더 이상 비교할 필요가 없으므로
                                          // len/2로 반복횟수를 정해준다.
            if(str.charAt(i) != str.charAt(len - i - 1)) {  // if문으로 str.charAt의 값들을 비교하여 같지않다면 return값으로 NO를 해주고 for문을 종료시킨다.
                return "NO";
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        회문문자열 m = new 회문문자열();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(m.solution(str));
    }
}
