package DFS_BFS활용;
import java.util.Scanner;

// 설명 : N개의 원소로 구성된 자연수 집합이 주어지면, 이 집합을 두 개의 부분집합으로 나누었을 때
//       두 부분집합의 원소의 합이 서로 같은 경우가 존재하면 “YES"를 출력하고, 그렇지 않으면 ”NO"를 출력하는 프로그램을 작성하세요.
//       둘로 나뉘는 두 부분집합은 서로소 집합이며, 두 부분집합을 합하면 입력으로 주어진 원래의 집합이 되어 합니다.
//       예를 들어 {1, 3, 5, 6, 7, 10}이 입력되면 {1, 3, 5, 7} = {6, 10} 으로 두 부분집합의 합이 16으로 같은 경우가 존재하는 것을 알 수 있다.
// 입력 예시 : 6
//          1 3 5 6 7 10
// 출력 예시 : YES

public class 합이같은부분집합 {
    static String answer = "NO";
    static int total, n;
    boolean flag = false;  // 답이 구해지면 바로 return하기 위한 boolean 변수
    public void DFS(int L, int sum, int[] arr) {
        if(flag) {  // if문이 true이면 실행 대기 중이던 재귀함수를 바로 return 해서 종료
            return;
        }
        if(sum > total/2) {   // total은 sum의 2배의 값이다. 즉 2배보다 넘는다면 이미 틀린 방향이므로 바로 return으로 종료시킨다.
            return;
        }
        if(L==n) {  // L이 n과 값이 같아진다는 말은 탐색을 다 했다는 의미이므로 answer을 구해준다.
            if ((total - sum) == sum) {  // totla은 sum의 2배의 값이므로 total에서 sum을 뺀 값이 sum이면 문제의 조건에 맞는 부분집합이므로 answer을 YES로 바꿔준다.
                answer = "YES";
                flag = true;  // if(flag) return으로 실행 대기중이던 재귀 함수를 수행하지 않고 바로 return 시킨다.
            }
        }
            else {
                DFS(L+1, sum+arr[L], arr);  // 원소를 부분집합에 넣어주면 값을 더해줘야하므로 sum+arr[L]로 sum에 arr[L]의 값을 더해준다.
                DFS(L+1,sum,arr);                // 원소를 부분집합에 안 넣어준다면 sum을 그대로 다음 Level로 가져간다.
            }
    }
    public static void main(String[] args) {
        합이같은부분집합  m = new 합이같은부분집합();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            total += arr[i];
        }
        m.DFS(0,0,arr);
        System.out.println(answer);
    }
}
