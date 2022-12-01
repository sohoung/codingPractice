package DFS_BFS활용;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

// 설명 : 다음과 같이 여러 단위의 동전들이 주어져 있을때 거스름돈을 가장 적은 수의 동전으로 교환해주려면 어떻게 주면 되는가?
//       각 단위의 동전은 무한정 쓸 수 있다.
// 입력 예시 : 3
//           1 2 5
//           15
// 출력 예시 : 3
public class 동전교환 {
    static int answer = Integer.MAX_VALUE,n,k;
    public void DFS(int L, int sum, Integer[] arr) {  // int L을 동전의 갯수로 생각
        if(sum > k) {  // sum이 k보다 클 경우 밑으로 뻗어가지 않게 하기 위해 return 해준다.
            return;
        }
        if(L>=answer) { // 동전의 갯수가 answer보다 크거나 같다면 답이 아니므로 바로 return 시켜준다.
            return;
        }
        if(sum==k) {  // sum이 k의 값과 같다면 문제의 조건과 일치하므로 답을 구해준다.
            answer = Math.min(answer,L);  // sum이 입력받은 k와 값이 같을 때 answer와 L을 Math.min으로 값을 비교해서 더 작은 값으로 갱신시킨다.
        }
        else {
            for(int i = 0; i < n; i++) {  // n개의 가닥으로 뻗어간다.
                DFS(L + 1, sum + arr[i], arr);
            }
        }
    }
    public static void main(String[] args) {
        동전교환  m = new 동전교환();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        Integer[] arr = new Integer[n];  // Collectios.reverseOrder를 사용하려면 arr이 기본형 int가 아니라 객체형 int인 Integer로 선언해주어야한다.
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr, Collections.reverseOrder());
        // 위의 if(L >= answer)에 대한 효율을 극대화 시키기 위한 내림차순 정렬이다. 즉 입력받은 arr을 제일 큰 숫자부터 더한다면 동전의 갯수는 처음 answer부터 많이 적게 시작할 것이고
        // 시간 복잡도가 많이 내려간다는 뜻이다.
        k = sc.nextInt();
        m.DFS(0,0,arr);
        System.out.println(answer);
    }
}
