package SortingandSearching;
import java.util.Scanner;

// 설명 : N개이 숫자가 입력되면 오름차순으로 정렬하여 출력하는 프로그램을 작성하세요.
//       정렬하는 방법은 버블정렬입니다.
// 입력 예시 : 6
//          13 5 11 7 23 15
// 출력 예시 : 5 7 11 13 15 23
public class 버블정렬 {
    public int[] solution(int[] arr, int n) {
        
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
