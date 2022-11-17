package SortingandSearching;
import java.util.ArrayList;
import java.util.Scanner;

// 설명 : N개이 숫자가 입력되면 오름차순으로 정렬하여 출력하는 프로그램을 작성하세요.
//       정렬하는 방법은 선택정렬입니다.
// 입력 예시 : 6
//          13 5 11 7 23 15
// 출력 예시 : 5 7 11 13 15 23
public class 선택정렬 {
    public int[] solution(int[] arr, int n) {
        for(int i = 0; i < n-1; i++) {  // i < n-1은 2중 for문으로 j가 끝 index에 갈 경우에 출력값이 완성이 되므로 n-1까지 수행한다.
            int idx = i;  // 작은 인덱스 번호를 저장하는 변수
            for(int j = i+1; j < n; j++) {
                if(arr[j]<arr[idx]) {
                    idx = j;  // 작은 index를 idx에 저장시킨다.
                }
            }
            int tmp = arr[i];  // 2개의 값을 바꾸는 코딩 꼭 암기 할 것
            arr[i] = arr[idx];
            arr[idx] = tmp;
        }
        return arr;
    }
    public static void main(String[] args) {
        선택정렬  m = new 선택정렬();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for(int x : m.solution(arr,n)) {
            System.out.print(x + " ");
        }
    }
}
