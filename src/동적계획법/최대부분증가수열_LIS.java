package 동적계획법;
import java.util.Scanner;

// 설명 : N개의 자연수로 이루어진 수열이 주어졌을 때, 그 중에서 가장 길게 증가하는(작은 수에서 큰 수로) 원소들의 집합을 찾는 프로그램을 작성하라.
//       예를 들어, 원소가 2, 7, 5, 8, 6, 4, 7, 12, 3 이면 가장 길게 증가하도록 원소들을 차례대로 뽑아내면 2, 5, 6, 7, 12를 뽑아내어
//       길이가 5인 최대 부분 증가수열을 만들 수 있다.
// 입력 예시 : 8
//           5 3 7 8 6 2 9 4
// 출력 예시 : 4
// 최대부분증가수열(LIS)
// LIS(Longest Increasing Subsequence) : 원소가 n개인 배열의 일부 원소를 골라내서 만든 부분 수열 중 각 원소가 이전 원소보다 크다는 조건을 만족하고
//                                       그 길이가 최대인 부분 수열을 최대 부분 수열이라고 합니다.
public class 최대부분증가수열_LIS {
    static int[] dy;
    public int solution(int[] arr) {
        int answer = 0;
        dy = new int[arr.length];
        dy[0] = 1;
        for(int i = 1; i < arr.length; i++) {
            int max = 0;
            for(int j = i-1; j >= 0; j--) {
                if(arr[j] < arr[i] && dy[j] > max) {
                    max = dy[j];
                }
            }
            dy[i] = max + 1;
            answer = Math.max(answer, dy[i]);  // 최댓값을 구하여야 하기 때문에 Math함수로 answer와 dy[i]의 값 중에서 더 큰 값으로 answer을 갱신 시켜준다.
        }
        return answer;
    }
    public static void main(String[] args) {
        최대부분증가수열_LIS m = new 최대부분증가수열_LIS();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(m.solution(arr));
    }
}
