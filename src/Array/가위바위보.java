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
        for(int i = 0; i < n; i++) {
            if(a[i] == b[i]) {  // a와 b가 비긴경우
                answer += "D";
            }
            else if(a[i] == 1 && b[i] == 3) {  // a가 이긴 경우 1
                answer += "A";
            }
            else if(a[i] == 3 && b[i] == 2) {  // a가 이긴 경우 2
                answer += "A";
            }
            else if(a[i] == 2 && b[i] == 1) {  // a가 이긴 경우 3
                answer += "A";
            }
            else {                             // a와 b가 비기지도 않고 a가 이기지도 않았으면 나머지 모든 경우의 수는 b가 이긴 경우이다.
                answer += "B";
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        가위바위보 m = new 가위바위보();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();  // 게임 횟수
        int[] a = new int[n];  // 게임 횟수에 따른 배열 동적 할당
        int[] b = new int[n];  // 게임 횟수에 따른 배열 동적 할당
        for(int i = 0; i < n; i++) {  // a가 낸 가위바위보
            a[i] = sc.nextInt();
        }
        for(int i = 0; i < n; i++) {  // b가 낸 가위바위보
            b[i] = sc.nextInt();
        }
        for(char c : m.solution(n,a,b).toCharArray()){  // String이므로 출력형식이 줄바꿈이 되어있으므로 향상된 for문으로 배열로 출력형식을 맞춰준다.
            System.out.println(c);
        }
    }
}
