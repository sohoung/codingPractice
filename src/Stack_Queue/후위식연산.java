package Stack_Queue;
import java.util.Scanner;
import java.util.Stack;

// 설명 : 후위연산식이 주어지면 연산한 결과를 출력하는 프로그램을 작성하세요.
//       만약 3*(5+2)-9 을 후위연산식으로 표현하면 352+*9- 로 표현되며 그 결과는 12입니다.
// 입력 예시 : 352+*9-
// 출력 예시 : 12
public class 후위식연산 {
    public int solution(String str) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for(char x : str.toCharArray()) {  // 입력받은 str을 향상된 for문으로 수행한다.
            if(Character.isDigit(x)) {
                // 만약 x가 숫자라면 stack에 push해준다. x-48을 하는 이유는 입력받은 str은 String타입의 변수이므로 아스키 넘버를 사용하여 x의 데이터를 stack에 넣어준다.'0'의 아스키 넘버는 48이다.
                stack.push(x-48);
            }
            else {  // x가 연산자라면 먼저 우항 좌항을 먼저 stack에서 꺼내준다.
                int rt = stack.pop();
                int lt = stack.pop();
                if(x == '+') {  // +,-,*,/의 경우에 따라 lt와 rt를 연산하여 stack에 넣어준다.
                    stack.push(lt + rt);
                }
                else if(x == '-') {
                    stack.push(lt - rt);
                }
                else if(x == '*') {
                    stack.push(lt * rt);
                }
                else if(x == '/') {
                    stack.push(lt / rt);
                }
            }
        }
        answer = stack.get(0);  // stack에 남은값은 1개이므로 stack.get(0)으로 값을 가져와서 answer에 넣어준다.
        return answer;
    }
    public static void main(String[] args) {
        후위식연산 m = new 후위식연산();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(m.solution(str));
    }
}
