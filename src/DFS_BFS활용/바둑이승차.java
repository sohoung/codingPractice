package DFS_BFS활용;
import java.util.Scanner;

// 설명 : 철수는 그의 바둑이들을 데리고 시장에 가려고 한다. 그런데 그의 트럭은 C킬로그램 넘게 태울수가 없다.
//       철수는 C를 넘지 않으면서 그의 바둑이들을 가장 무겁게 태우고 싶다.
//       N마리의 바둑이와 각 바둑이의 무게 W가 주어지면, 철수가 트럭에 태울 수 있는 가장 무거운 무게를 구하는 프로그램을 작성하세요.
// 입력 예시 : 259 5
//           81
//           58
//           42
//           33
//           61
// 출력 예시 : 242
public class 바둑이승차 {
    static int answer = Integer.MIN_VALUE,n,k;
    public void DFS(int L, int sum, int[] arr) {
        if(sum > n) {  // sum이 입력받은 n보다 값이 크다면 바로 return 해준다.
            return;
        }
        if(L == k) {  // L이 k와 같다면 탐색이 다 되어서 answer을 구해주어야한다.
            answer = Math.max(answer,sum);  // answer에 Math.max(answer,sum)으로 answer와 sum 중 큰 값으로 계속 갱신시켜준다.
        }
        else {
            DFS(L+1,sum+arr[L], arr);  // 입력받은 숫자들을 더해줬을 때
            DFS(L+1,sum,arr);               // 입력받은 숫자들을 더해주지 않고 그 다음 레벨로 탐색을 할 때
        }
    }
    public static void main(String[] args) {
        바둑이승차  m = new 바둑이승차();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();  // 최대 무게
        k = sc.nextInt();  // 바둑이 마릿 수
        int[] arr = new int[k];  // 바둑이 마릿 수에 따른 배열 동적 할당
        for(int i = 0; i < k; i++) {  // for문으로 배열 값 입력
            arr[i] = sc.nextInt();
        }
        m.DFS(0,0,arr);  // 처음 시작 레벨은 0, sum도 0, arr을 계속 매개변수로 넘겨주면서 답을 구한다.
        System.out.println(answer);
    }
}
