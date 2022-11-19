package SortingandSearching;
import java.util.Scanner;

// 설명 : 캐시메모리는 CPU와 주기억장치(DRAM) 사이의 고속의 임시 메모리로서 CPU가 처리할 작업을 저장해 놓았다가
//       필요할 바로 사용해서 처리속도를 높이는 장치이다. 워낙 비싸고 용량이 작아 효율적으로 사용해야 한다.
//       철수의 컴퓨터는 캐시메모리 사용 규칙이 LRU 알고리즘을 따른다.
//       LRU 알고리즘은 Least Recently Used 의 약자로 직역하자면 가장 최근에 사용되지 않은 것 정도의 의미를 가지고 있습니다.
//       캐시에서 작업을 제거할 때 가장 오랫동안 사용하지 않은 것을 제거하겠다는 알고리즘입니다.
//       캐시의 크기가 주어지고, 캐시가 비어있는 상태에서 N개의 작업을 CPU가 차례로 처리한다면 N개의 작업을 처리한 후
//       캐시메모리의 상태를 가장 최근 사용된 작업부터 차례대로 출력하는 프로그램을 작성하세요.
// 입력 예시 : 5 9
//           1 2 3 2 6 2 3 5 7
// 출력 예시 : 7 5 3 2 6
public class LRU_카카오변형 {
    public int[] solution(int size, int k, int[] arr) {
        int[] cache = new int[size];
        for(int x : arr) {
            int pos = -1;  // index 번호
            for(int i = 0; i < size; i++) {
                if(x == cache[i]) {  // 히트인경우 히트된 index를 pos에 저장
                    pos = i;  // 히트가 난 지점의 index를 pos에 저장
                }
            }
            if(pos == -1) {  // 미스난 경우 앞으로 값을 땡겨준다.
                for(int i = size-1; i >= 1; i--) {
                    cache[i] = cache[i-1];
                }
                cache[0] = x;
            }
            else {  // 히트가 난 경우
                for(int i = pos; i >= 1; i--) {  // 히트가 난 지점에서 부터 앞으로 땡겨주기 때문에 초깃값을 int i = pos로 해준다.
                    cache[i] = cache[i-1];
                }
                cache[0] = x;
            }
        }
        return cache;
    }
    public static void main(String[] args) {
        LRU_카카오변형 m = new LRU_카카오변형();
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt(); // cache size
        int k = sc.nextInt(); // 작업의 갯수
        int[] arr = new int[k];
        for(int i = 0; i < k; i++) {
            arr[i] = sc.nextInt();
        }
        for(int x : m.solution(s,k,arr)) {
            System.out.print(x + " ");
        }
    }
}
