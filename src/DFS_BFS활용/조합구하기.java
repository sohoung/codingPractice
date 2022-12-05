package DFS_BFS활용;
import java.util.Scanner;

// 설명 : 1부터 N까지 번호가 적힌 구슬이 있다. 이 중 k개를 뽑는 방법 수를 출력하는 프로그램을 작성하세요.
// 입력 예시 : 4 2
// 출력 에시 : 1 2
//           1 3
//           1 4
//           2 3
//           2 4
//           3 4
public class 조합구하기 {
    static int[] combi;
    static int n,k;
    public void DFS(int L, int s) {
        if(L == k) {
            for(int x : combi) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
        else {
            for (int i = s; i <= n; i++) {  // 조합을 사용하는 공식은 그냥 외울 것!!
                combi[L] = i;
                DFS(L+1, i+1);
            }
        }
    }
    public static void main(String[] args) {
        조합구하기  m = new 조합구하기();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        combi = new int[k];
        m.DFS(0,1);
    }
}
