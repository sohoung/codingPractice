package Stack_Queue;
import java.util.Scanner;
import java.util.Stack;

// 설명 : 입력된 문자열에서 소괄호 ( ) 사이에 존재하는 모든 문자를 제거하고 남은 문자만 출력하는 프로그램을 작성하세요.
// 입력 예시 : (A(BC)D)EF(G(H)(IJ)K)LM(N)
// 출력 예시 : EFLM
public class 괄호문자제거 {
    public String solution(String str) {
        String answer = "";
        Stack<Character> stack = new Stack<>();
        for(char x : str.toCharArray()) {
            if(x == ')') {
                while(stack.pop() != '(');  // '('을 만나지 않는 경우 수행
            }
            else {  // 알파벳이나 '('인 경우 수행
                stack.push(x);
            }
        }
        for(int i = 0; i < stack.size(); i++) {
            answer += stack.get(i);  // answer에다가 stack.get()으로 값을 차례대로 저장
        }
        return answer;
    }
    public static void main(String[] args) {
        괄호문자제거 m  = new 괄호문자제거();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(m.solution(str));
    }
}
