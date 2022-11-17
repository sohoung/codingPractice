package SortingandSearching;
import java.util.Scanner;

// 설명 : N개이 숫자가 입력되면 오름차순으로 정렬하여 출력하는 프로그램을 작성하세요.
//       정렬하는 방법은 버블정렬입니다.
// 입력 예시 : 6
//          13 5 11 7 23 15
// 출력 예시 : 5 7 11 13 15 23
public class 버블정렬 {
    public int[] solution(int[] arr, int n) {
        for(int i = 0; i < n-1; i++) {  // 몇 번을 실행할껀지의 for문
            for(int j = 0; j < n-i-1; j++) {  // 비교 for문
                if(arr[j] > arr[j+1]) {  // 만약 현재의 index 값과 뒤의 index 값을 비교해서 뒤의 index값이 작다면 둘의 자리를 바꾼다.
                    int tmp = arr[j];  // 2개의 자리를 바꾸는 코딩
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
        return arr;
    }
    public static void main(String[] args) {
        버블정렬  m = new 버블정렬();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        for(int x : m.solution(arr,n)) {
            System.out.print(x + " ");
        }
    }
}
