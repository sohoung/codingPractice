package SortingandSearching;
import java.util.Arrays;
import java.util.Scanner;

// 설명 : N개의 마구간이 수직선상에 있습니다. 각 마구간은 x1, x2, x3, ......, xN의 좌표를 가지며, 마구간간에 좌표가 중복되는 일은 없습니다.
//       현수는 C마리의 말을 가지고 있는데, 이 말들은 서로 가까이 있는 것을 좋아하지 않습니다. 각 마구간에는 한 마리의 말만 넣을 수 있고,
//       가장 가까운 두 말의 거리가 최대가 되게 말을 마구간에 배치하고 싶습니다.
//       C마리의 말을 N개의 마구간에 배치했을 때 가장 가까운 두 말의 거리가 최대가 되는 그 최대값을 출력하는 프로그램을 작성하세요.
// 입력 예시 : 5 3
//          1 2 8 4 9
// 출력 예시 : 3
public class 마구간정하기 {
    public int count(int[] arr , int dist) {
        int cnt = 1;  // 말의 마리 수
        int ep = arr[0];  // 바로 전의 말을 배치한 좌표
        for(int i = 1; i < arr.length; i++) {
            if(arr[i]-ep>=dist) {  // 가장 가까운 두 말의 거리를 dist(mid를 받는다.)로 크거나 같아야 말을 배치할 수 있다.
                cnt++;
                ep=arr[i];  // 말을 배치했으므로 ep를 arr[i]의 값으로 바꿔준다.
            }
        }
        return cnt;
    }
    public int solution(int n, int c, int[] arr) {
        int answer = 0;
        Arrays.sort(arr);  // 마구관의 좌표가 오름차순으로 정렬이 되어 들어오는 것이 아니므로 먼저 입력된 마구간의 좌표를 오름차순으로 정렬시킨다.
        int lt = 1;
        // 좌표를 구하는 것이 아니라 말으 거리를 구하는 것으로 lt 값은 1로 선언한다. arr[0]으로 lt 값을 선언하면 거리를 구하지 못하고 이상한 답이 나오기 때문이다.
        // 쉽게 생각해서 두 말 사이의 최솟값은 1이기때문에 lt 값을 1로 선언해준다.
        int rt = arr[n-1];
        while(lt<=rt) {  // 이분검색은 lt와 rt *암기
            int mid = (lt+rt)/2;  // 가장 가까운 두 말의 거리를 저장하는 변수로 mid의 값 만큼 입력받은 c의 말을 배치 할 수 있는지 검사하는 것이다.
            if(count(arr,mid)>=c) {  // 유효 함수 : return한 c의 값이 유효한지
                answer=mid;
                lt=mid+1;     // 최대값을 구하기 위해서 범위를 더 좁힌다.
            }
            else {
                rt=mid-1;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        마구간정하기  m = new 마구간정하기();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();  // 마구간 좌표
        int c = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(m.solution(n,c,arr));
    }
}
