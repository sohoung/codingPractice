package SortingandSearching;
import java.util.Arrays;
import java.util.Scanner;

// 설명 : 지니레코드에서는 불세출의 가수 조영필의 라이브 동영상을 DVD로 만들어 판매하려 한다.
//       DVD에는 총 N개의 곡이 들어가는데, DVD에 녹화할 때에는 라이브에서의 순서가 그대로 유지되어야 한다.
//       순서가 바뀌는 것을 우리의 가수 조영필씨가 매우 싫어한다. 즉, 1번 노래와 5번 노래를 같은 DVD에 녹화하기 위해서는
//       1번과 5번 사이의 모든 노래도 같은 DVD에 녹화해야 한다. 또한 한 노래를 쪼개서 두 개의 DVD에 녹화하면 안된다.
//       지니레코드 입장에서는 이 DVD가 팔릴 것인지 확신할 수 없기 때문에 이 사업에 낭비되는 DVD를 가급적 줄이려고 한다.
//       고민 끝에 지니레코드는 M개의 DVD에 모든 동영상을 녹화하기로 하였다. 이 때 DVD의 크기(녹화 가능한 길이)를 최소로 하려고 한다.
//       그리고 M개의 DVD는 모두 같은 크기여야 제조원가가 적게 들기 때문에 꼭 같은 크기로 해야 한다.
// 입력 예시 : 9 3
//          1 2 3 4 5 6 7 8 9
// 출력 예시 : 17
public class 뮤직비디오_결정알고리즘 {
    public int count(int[] arr, int capacity) {
        int cnt = 1;  // 필요한 dvd갯수
        int sum = 0;  // dvd에 들어간 노래 길이의 합
        for(int x : arr) {
            if(sum+x > capacity) {  // sum에 배열 arr의 값을 x에 대입시켜서 capacity 즉 mid의 값이 넘어갈 때 까지 계속 더해준다.
                cnt++;              // sum이 capacity의 값보다 커지면 dvd를 1장 더 추가시켜서 다시 새롭게 sum을 x로 초기화 시켜주고 다시 더해준다.
                sum = x;
            }
            else {
                sum += x;
            }
        }
        return cnt;   // 몇 장의 dvd가 필요한지 구해서 return 값으로 보내준다.
    }
    public int solution(int n, int k, int[] arr) {
        int answer = 0;
        int lt = Arrays.stream(arr).max().getAsInt();  // max의 기본 return형이 Optional int이기 때문에 getAsint()로 int형 변환을 해준다.
        int rt = Arrays.stream(arr).sum();  // sum의 기본 return형이 int이다.
        while(lt <= rt) {
            int mid = (lt+rt) / 2;
            if(count(arr,mid) <= k) {  // count의 return값의 cnt가 입력받은 k의 값보다 작거나 같다면 일단 최소 용량으로 된다는 말이므로 answer에 mid의 값을 저장시켜주고
                answer = mid;          // 더 작은 용량이 있는지 찾기 위해서 rt를 mid-1의 값으로 바꿔주고 다시 탐색한다.
                rt = mid - 1;
            }
            else {                     // count의 값이 k보다 크다면 mid를 기준으로 자신보다 작은 값들은 필요 없으므로 왼쪽의 값들은 날려주고 mid 기준으로 오른쪽의 값들을 다시 탐색해준다.
                lt = mid + 1;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        뮤직비디오_결정알고리즘 m = new 뮤직비디오_결정알고리즘();
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
