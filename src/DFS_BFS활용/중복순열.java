package DFS_BFS활용;
import java.util.Scanner;

// 설명 : 1부터 N까지 번호가 적힌 구슬이 있습니다. 이 중 중복을 허락하여 K번을 뽑아 일렬로 나열하는 방법을 모두 출력하세요.
// 입력 예시 : 3 1
// 출력 예시 : 1 1
//           1 2
//           1 3
//           2 1
//           2 2
//           2 3
//           3 1
//           3 2
//           3 3
public class 중복순열 {
    static int[] pm;
    static int n,k;
    public void DFS(int L) {
        if(L==k) {
            for(int x : pm) {
                System.out.print(x + " ");
            }
                System.out.println();
        }
        else {
            for(int i = 1; i <= n; i++) {
                pm[L] = i;  // n갈래로 뻗어가기 때문에 for문을 n번 수행으로 pm[L]의 값에 n개의 값을 순서대로 넣는다.
                DFS(L+1);
            }
        }
    }
    public static void main(String[] args) {
        중복순열  m = new 중복순열();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        pm = new int[k];
        m.DFS(0);
    }
}
