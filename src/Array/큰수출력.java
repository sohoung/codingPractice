package Array;
import java.util.ArrayList;
import java.util.Scanner;

// 설명 : N개의 정수를 입력받아, 자신의 바로 앞 수보다 큰 수만 출력하는 프로그램을 작성하세요.
//       (첫 번째 수는 무조건 출력한다)
// 입력 예시 : 6
//          7 3 9 5 6 12
// 출력 예시 : 7 9 6 12
public class 큰수출력 {
    public ArrayList<Integer> solution(int[] arr, int n) {
        ArrayList<Integer> answer = new ArrayList<>();
        answer.add(arr[0]);  // ArrayList에 값을 넣어주는 함수는 add이다. 문제의 조건중에서 첫 번째 수는 무조건 출력이므로 먼저 index 0번의 값을 넣어준다.
        for(int i = 1; i < n; i++) {  // 첫 번째 index의 값을 answer에 넣어줬으므로 시작지점을 1로 설정해준다.
            if(arr[i] > arr[i-1]) {  // 문제의 조건에 맞게 앞의 수보다 자신의 수가 더 크다면 answer에 값을 넣어준다.
                answer.add(arr[i]);
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        큰수출력 m = new 큰수출력();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];  // 입력받은 n에 따른 배열크기 동적 할당
        for(int i = 0; i < arr.length; i++) {  // 생성된 배열에 값을 for문으로 넣어준다.
            arr[i] = sc.nextInt();
        }
        for(int x : m.solution(arr,n)) {
            System.out.print(x + " ");
        }
    }
}
