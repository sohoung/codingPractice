package Stack_Queue;
import java.sql.SQLOutput;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 설명 : 현수는 1년 과정의 수업계획을 짜야 합니다.
//       수업중에는 필수과목이 있습니다. 이 필수과목은 반드시 이수해야 하며, 그 순서도 정해져 있습니다.
//       만약 총 과목이 A, B, C, D, E, F, G가 있고, 여기서 필수과목이 CBA로 주어지면 필수과목은 C, B, A과목이며 이 순서대로 꼭 수업계획을 짜야 합니다.
//       여기서 순서란 B과목은 C과목을 이수한 후에 들어야 하고, A과목은 C와 B를 이수한 후에 들어야 한다는 것입니다.
//       현수가 C, B, D, A, G, E로 수업계획을 짜면 제대로 된 설계이지만
//       C, G, E, A, D, B 순서로 짰다면 잘 못 설계된 수업계획이 됩니다.
//       수업계획은 그 순서대로 앞에 수업이 이수되면 다음 수업을 시작하다는 것으로 해석합니다.
//       수업계획서상의 각 과목은 무조건 이수된다고 가정합니다.
//       필수과목순서가 주어지면 현수가 짠 N개의 수업설계가 잘된 것이면 “YES", 잘못된 것이면 ”NO“를 출력하는 프로그램을 작성하세요.
// 입력 예시 : CBA
//          CBDAGE
// 출략 예시 : YES
public class 교육과정설계 {
    public String solution(String str1, String str2) {
        String answer = "YES";
        Queue<Character> Q = new LinkedList<>();
        for(char x : str1.toCharArray()) {  // 입력받은 필수과멱 str1을 Q에 데이터를 차례대로 넣어준다.
            Q.offer(x);
        }
        for(char x : str2.toCharArray()) {  // 입력받은 str2에서 x와 Q의 데이터가 다르면 계획을 잘못 작성했으므로 return값을 NO로 반환해준다.
            if(Q.contains(x)) {
                if(x != Q.poll()) {
                    return "NO";
                }
            }
        }
        if(!Q.isEmpty()) {  // 비어있지 않다는 말은 필수과목을 듣지 않았다는 이야기이므로 return값을 NO해준다.
            return "NO";
        }
        return answer;
    }
    public static void main(String[] args) {
        교육과정설계  m = new 교육과정설계();
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();
            System.out.println(m.solution(str1,str2));
    }
}
