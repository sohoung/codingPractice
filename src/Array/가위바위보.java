package Array;
import java.util.Scanner;

// 설명 : A, B 두 사람이 가위바위보 게임을 합니다. 총 N번의 게임을 하여 A가 이기면 A를 출력하고, B가 이기면 B를 출력합니다. 비길 경우에는 D를 출력합니다.
//      가위, 바위, 보의 정보는 1:가위, 2:바위, 3:보로 정하겠습니다.
//      두 사람의 각 회의 가위, 바위, 보 정보가 주어지면 각 회를 누가 이겼는지 출력하는 프로그램을 작성하세요.
// 입력 예시 : 5
//          2 3 3 1 3
//          1 1 2 2 3
// 출력 예시 : A
//          B
//          A
//          B
//          D
public class 가위바위보 {
    public String solution(int n, int[] a, int[] b) {
        String answer = "";
        
        return answer;
    }

    public static void main(String[] args) {
        가위바위보 m = new 가위바위보();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for(int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }
        System.out.println(m.solution(n,a,b));
    }
}
