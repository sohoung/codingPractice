package HashMap_TreeSet;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;

// 설명 : 현수는 1부터 100사이의 자연수가 적힌 N장의 카드를 가지고 있습니다. 같은 숫자의 카드가 여러장 있을 수 있습니다.
//       현수는 이 중 3장을 뽑아 각 카드에 적힌 수를 합한 값을 기록하려고 합니다. 3장을 뽑을 수 있는 모든 경우를 기록합니다.
//       기록한 값 중 K번째로 큰 수를 출력하는 프로그램을 작성하세요.
//       만약 큰 수부터 만들어진 수가 25 25 23 23 22 20 19......이고 K값이 3이라면 K번째 큰 값은 22입니다.
// 입력 예시 : 10 3
//           13 15 34 23 45 65 33 11 26 42
// 출력 예시 : 143
// 함수 -> set() : 중복제거 함수
public class k번째큰수 {
    public int solution(int n, int k, int[] arr) {
        int answer = -1;  // answer값을 -1로 해주는 이유는 문제에서 원하는 순서의 값이 없다면 -1로 출력하라고 하였으므로 아래의 코드가 다 거짓으로되었을때는 원하는 k번째의 수가
                          // 나오지 않았으므로 -1을 출력하기위해 초깃값으로 선언해준다.
        TreeSet<Integer> tset = new TreeSet<>(Collections.reverseOrder());
        // TreeSet은 이진트리로 Collections.reverseOrder()가 없다면 오름차순으로 정렬이된다. 하지만 Collections.reverseOrder()가 있다면 오름차순을 내림차순으로 정렬해준다.
        for(int i = 0; i < n; i++) {
            for(int j = i+1; j < n; j++) {
                for(int s = j+1; s < n; s++) {
                    tset.add(arr[i]+arr[j]+arr[s]);  // 모든 3개의 값을 더한 경우의 수를 구해서 tset에 넣어준다.
                }
            }
        }
        int cnt = 0;  // k번째 수인지 확인하는 int형 변수
        for(int x : tset) {
            cnt++;  // cnt를 증가시켜주면서 입력받은 k인지 확인하여 k이면 k번째의 수를 return값으로 출력해준다.
            if(cnt == k) {
                return x;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        k번째큰수  m = new k번째큰수();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(m.solution(n,k,arr));
    }
}
