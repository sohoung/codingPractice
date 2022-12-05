package DFS_BFS활용;
import java.util.Scanner;

// 설명 : 10이하의 N개의 자연수가 주어지면 이 중 K개를 뽑아 일렬로 나열하는 방법을 모두 출력하세요.
// 입력 예시 : 3 2
//           3 6 9
// 출력 예시 : 3 6
//           3 9
//           6 3
//           6 9
//           9 3
//           9 6
public class 순열구하기 {
    static int[] pm, ch, arr;
    static int n, k;
    public void DFS(int L) {
        if(L==k) {
            for(int x : pm) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
        else {
            for(int i = 0; i < n; i++) {
                if(ch[i] == 0) {  // 뻗는 곳에 체크가 없다면
                    ch[i] = 1;    // 사용을 하기 때문에 먼저 체크를 해주고
                    pm[L] = arr[i];  // 사용하는 값을 pm[L] 위치에 값을 넣어준다.
                    DFS(L+1);  // 다음 레벨로 가기 위한 레벨 상승
                    ch[i] = 0;    // 백트래킹으로 다른 가지로 가기 위한 체크 해제
                }
            }
        }
    }
    public static void main(String[] args) {
        순열구하기  m = new 순열구하기();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();  // 숫자의 갯수
        k = sc.nextInt();  // 뽑는 갯수
        arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        ch = new int[n];  // 체크 배열
        pm = new int[k];
        m.DFS(0);
    }
}
