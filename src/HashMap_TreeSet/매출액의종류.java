package HashMap_TreeSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

// 설명 : 현수의 아빠는 제과점을 운영합니다. 현수아빠는 현수에게 N일 동안의 매출기록을 주고 연속된 K일 동안의 매출액의 종류를
//       각 구간별로 구하라고 했습니다.
//       만약 N=7이고 7일 간의 매출기록이 아래와 같고, 이때 K=4이면
//       20 12 20 10 23 17 10
//       각 연속 4일간의 구간의 매출종류는
//       첫 번째 구간은 [20, 12, 20, 10]는 매출액의 종류가 20, 12, 10으로 3이다.
//       두 번째 구간은 [12, 20, 10, 23]는 매출액의 종류가 4이다.
//       세 번째 구간은 [20, 10, 23, 17]는 매출액의 종류가 4이다.
//       네 번째 구간은 [10, 23, 17, 10]는 매출액의 종류가 3이다.
//       N일간의 매출기록과 연속구간의 길이 K가 주어지면 첫 번째 구간부터 각 구간별
//       매출액의 종류를 출력하는 프로그램을 작성하세요.
// 입력 예시 : 7 4
//          20 12 20 10 23 17 10
// 출력 예시 : 3 4 4 3
public class 매출액의종류 {
    public ArrayList<Integer> solution(int[] arr, int n, int k) {
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();  // Key형이 Integer이고 Value값이 Integer인 HashMap 객체 생성
        for(int i = 0; i < k-1; i++) {  // 처음에 k-1까지의 값을 먼저 세팅해준다. k가 4라면 index번호 0,1,2까지의 값을 먼저 세팅해준다.
            map.put(arr[i], map.getOrDefault(arr[i],0)+1);
        }
        int lt = 0;  // index의 시작 지점
        for(int rt = k-1; rt < n; rt++) {  // rt로 이제 n-1까지의 index까지 탐색한다.
            map.put(arr[rt],map.getOrDefault(arr[rt],0)+1);  // arr[rt]의 값으로 먼저 세팅된 map에 넣어주고
            answer.add(map.size());   // answer에 map의 종류를 map.size()함수로 첫 번째 값을 넣어준다.
            map.put(arr[lt],map.get(arr[lt])-1);  // 그 다음 arr[lt]를 먼저 빼준다.
            if(map.get(arr[lt])==0) {  // 하지만 arr[lt]를 빼는 과정에서 arr[lt]의 값이 빠지더라도 0으로 value값이 있다고 할 수 있기 때문에 만약 value값이 0인 데이터가
                                       // 있다면 map.remove()로 데이터를 완전히 지워준다.
                map.remove(arr[lt]);
            }
            lt++;   // 그리고 다시 다음 차례의 for문을 수행하기 위해 lt를 1증가시켜준다.
        }
        return answer;
    }
    public static void main(String[] args) {
        매출액의종류  m = new 매출액의종류();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for(int x : m.solution(arr,n,k)) {
            System.out.print(x + " ");
        }
    }
}
