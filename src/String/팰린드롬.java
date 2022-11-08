package String;
import java.util.Scanner;

// 설명 : 앞에서 읽을 때나 뒤에서 읽을 때나 같은 문자열을 팰린드롬이라고 합니다.
//       문자열이 입력되면 해당 문자열이 팰린드롬이면 "YES", 아니면 “NO"를 출력하는 프로그램을 작성하세요.
//       단 회문을 검사할 때 알파벳만 가지고 회문을 검사하며, 대소문자를 구분하지 않습니다.
//       알파벳 이외의 문자들의 무시합니다.
// 입력 예시 : found7, time: study; Yduts; emit, 7Dnuof
// 출력 예시 : YES
public class 팰린드롬 {
    public String solution(String str) {
        String answer = "NO";
        str = str.toUpperCase().replaceAll("[^A-Z]","");
        // 문제에서 대소문자는 구문하지 않으므로 모두 대문자로 바꿔주고 replaceAll은 정규식이 사용가능하고 replace는 정규식을 사용하지 못한다.
        // replaceAll()함수를 사용하여 "[^A-Z],""의 의미는 A-Z까지가 아니라면(^이 부정을 의미) ""로 바꿔라 즉 빈문자로 바꿔버리라는 의미이다.
        String tmp = new StringBuilder(str).reverse().toString();
        if(str.equals(tmp)) {
            answer = "YES";
        }
        return answer;
    }
    public static void main(String[] args) {
        팰린드롬 m = new 팰린드롬();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(m.solution(str));
    }
}
