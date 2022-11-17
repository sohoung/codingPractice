package SortingandSearching;
import java.util.Scanner;

// 설명 : N개이 숫자가 입력되면 오름차순으로 정렬하여 출력하는 프로그램을 작성하세요.
//       정렬하는 방법은 삽입정렬입니다.
// 입력 예시 : 6
//          11 7 5 6 10 9
// 출력 예시 : 5 6 7 9 10 11
public class 삽입정렬 {
    public int[] solution(int[] arr , int n) {
        for(int i = 1; i < n; i++) {
            int tmp = arr[i];
            int j;  // j for문의 범위 밖에서 j를 사용하기 때문에 j를 밖에서 따로 선언해준다.
            for(j = i-1; j >= 0; j--){
                if(arr[j] > tmp) {  // 앞의 데이터가 뒤의 데이터 값보다 크다면 앞의 데이터 값을 뒤의 index에 넣어준다.
                    arr[j+1] = arr[j];
                }
                else {
                    break;
                }
            }
            arr[j+1] = tmp;  // j for문이 멈춘 지점 앞에서 tmp값을 넣어준다.
        }
        return arr;
    }
    public static void main(String[] args) {
        삽입정렬  m = new 삽입정렬();
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
