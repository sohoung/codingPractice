package TwoPointer_SlidingWindow;
import java.util.ArrayList;
import java.util.Scanner;

// 설명 : 오름차순으로 정렬이 된 두 배열이 주어지면 두 배열을 오름차순으로 합쳐 출력하는 프로그램을 작성하세요.
// 입력 예시 : 3
//           1 3 5
//           5
//           2 3 6 7 9
// 출력 예시 : 1 2 3 3 5 6 7 9
public class 두배열합치기 {
    public ArrayList<Integer> solution(int[] a, int n, int[] b, int k) {
        ArrayList<Integer> answer = new ArrayList<>();
        int p1 = 0, p2 = 0;   // a배열과 b배열의 시작지점을 해주기 위한 변수
        while(p1<n && p2<k) {  // while문으로 p1이 n보다 작고 p2가 k보다 작을 때 while문을 수행하도록 해준다.
            // a와 b 배열의 길이가 다르므로 어느 한 배열이 answer에 다 들어갔다면 나머지 한 배열은 남아있는 데이터 값을 그대로 answer에 넣어줘야 하기 때문이다.
            if(a[p1] < b[p2]) {
                // 문제의 조건대로 a배열의 값이 b배열의 값보다 작다면 answer에 a배열의 값을 넣어주고 후위증감연산자로 p1의 값을 1증가시켜 다음 index로 넘어가게 해준다.
                answer.add(a[p1++]);
            }
            else {
                // 마찬가지로 b배열의 값이 a배열의 값보다 작다면 answer에 b배열의 값을 넣어주고 만약 두 배열의 값이 같다면 어느 배열의 값이 들어가도 상관없으므로 b배열의 값을 넣어준다.
                // 위와 같이 후위증감연산자로 b배열에 값을 넣어주고 p2의 값을 1증가시켜준다.
                answer.add(b[p2++]);
            }
        }
        while(p1<n) {  // 만약 p2의 값이 위의 while문 조건을 false로 반환해 while문을 빠져나오게 되면 p1의 값이 아직 남았고 a배열의 값은 아직 answer에 들어가지 않았다는 말
            // 이므로 나머지 a배열의 값들도 차례대로 answer에 while문을 통해서 넣어준다.
            answer.add(a[p1++]);
        }
        while(p2<k) {  // 위의 while문과 마찬가지로 p2의 값이 남았다면 answer에 b배열의 값을 차례대로 넣어준다.
            answer.add(b[p2++]);
        }
        return answer;
    }
    public static void main(String[] args) {
        두배열합치기 m = new 두배열합치기();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        int[] b = new int[k];
        for(int i = 0; i < k; i++) {
            b[i] = sc.nextInt();
        }
        for(int x : m.solution(a,n,b,k)) {
            System.out.print(x + " ");
        }
    }
}
