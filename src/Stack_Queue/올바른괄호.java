package Stack_Queue;
import java.util.Scanner;
import java.util.Stack;

// 설명 : 괄호가 입력되면 올바른 괄호이면 “YES", 올바르지 않으면 ”NO"를 출력합니다.
//       (())() 이것은 괄호의 쌍이 올바르게 위치하는 거지만, (()()))은 올바른 괄호가 아니다.
// 입력 예시 : (()(()))(()
// 출력 예시 : NO
// Stack 자료구조 : Last In Frist Out 형태의 자료구조
public class 올바른괄호 {
    public String solution(String str) {
        String answer = "YES";
        Stack<Character> stack = new Stack<>();
        for(char x : str.toCharArray()) {
            if(x == '(') {  // ( 괄호인 경우 stack에 값을 넣어준다.
                stack.push(x);
            }
            else {
                if(stack.isEmpty()) {  // ) 괄호인경우 stack이 비어있다면 잘못된 괄호이므로 return값을 NO로 해준다.
                    return "NO";
                }
                stack.pop();  // ( 괄호가 있는 경우 (를 stack에서 빼준다.
            }
        }
        if(!stack.isEmpty()) {  // ( 괄호가 많은 경우
            return "NO";
        }
        return answer;
    }
    public static void main(String[] args) {
        올바른괄호  m = new 올바른괄호();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

    }
}
