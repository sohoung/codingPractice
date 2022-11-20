package SortingandSearching;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

// 설명 : 임의의 N개의 숫자가 입력으로 주어집니다. N개의 수를 오름차순으로 정렬한 다음 N개의 수 중 한 개의 수인 M이 주어지면
//       이분검색으로 M이 정렬된 상태에서 몇 번째에 있는지 구하는 프로그램을 작성하세요. 단 중복값은 존재하지 않습니다.
// 입력 예시 : 8 32
//          23 87 65 12 57 32 99 81
// 출력 예시 : 3
public class 이분검색 {
    public int solution(int n, int k, int[] arr) {
        int answer = 0;
        Arrays.sort(arr);  // 문제의 조건에 따라 오름차순 정렬
        int lt= 0;         // 첫 번째 index
        int rt = n-1;      // 마지막 index
        while(lt<=rt) {    // lt와 rt의 값이 서로 작아지고 커지고 하다가 rt의 값이 lt의 값보다 작아지면 false를 반환하므로 while문 종룔
            int mid = (lt + rt) / 2;  // 이분 검색이므로 입력받은 arr의 값 중간부터 검색을 시작한다. arr[mid]의 값과 입력받은 k의 값을 비교하여 크거나 작거나 같은 경우의 수를 나눠서
            if(arr[mid] == k) {       // 값을 구한다.
                answer = mid+1;
                break;                // 구하였으면 더 이상 while 문이 수행하지 않도록 break를 사용
            }
            if(arr[mid] > k){  // arr[mid]의 값이 입력받은 k의 값보다 큰 경우에는 찾고자 하는 k의 값이 mid를 기준으로 오른쪽 값들은 없기 때문에 왼쪽 값을 다시 탐색해준다.
                rt = mid - 1;
            }
            else {             // arr[mid]의 값이 입력받은 k의 값보다 작은 경우에는 찾고자 하는 k의 값이 mid를 기준으로 왼쪽 값들은 없기 때문에 오른쪽 값을 다시 탐색한다.
                lt = mid + 1;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        이분검색  m = new 이분검색();
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
