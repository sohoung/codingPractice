package Stack_Queue;
import java.util.Scanner;

// 설명 : 괄호가 입력되면 올바른 괄호이면 “YES", 올바르지 않으면 ”NO"를 출력합니다.
//       (())() 이것은 괄호의 쌍이 올바르게 위치하는 거지만, (()()))은 올바른 괄호가 아니다.
// 입력 예시 : (()(()))(()
// 출력 예시 : NO
public class 올바른괄호 {
    public String solution(String str) {
        String answer = "YES";
        return answer;
    }
    public static void main(String[] args) {
        올바른괄호  m = new 올바른괄호();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        
    }
}
