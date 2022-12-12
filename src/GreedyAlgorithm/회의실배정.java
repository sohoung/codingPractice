package GreedyAlgorithm;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// 설명 : 한 개의 회의실이 있는데 이를 사용하고자 하는 n개의 회의들에 대하여 회의실 사용표를 만들려고 한다.
//       각 회의에 대해 시작시간과 끝나는 시간이 주어져 있고, 각 회의가 겹치지 않게 하면서 회의실을 사용할 수 있는 최대수의 회의를 찾아라.
//       단, 회의는 한번 시작하면 중간에 중단될 수 없으며 한 회의가 끝나는 것과 동시에 다음 회의가 시작될 수 있다.
// 입력 예시 1 : 5
//           1 4
//           2 3
//           3 5
//           4 6
//           5 7
// 출력 예시 1 : 3
// 입력 예시 2 : 3
//           3 3
//           1 3
//           2 3
// 출력 예시 2 : 2

class Time implements Comparable<Time> {
    public int s,e;
    Time(int s, int e) {
        this.s = s;  // 시작 시간
        this.e = e;  // 끝나는 시간
    }
    @Override
    public int compareTo(Time o) {
        if(this.e == o.e) {
            return this.s - o.s;
            // 만약 끝나는 시간이 같다면 시작 시간에 의해 오름차순 정렬해준다. 이유는 입력 예시 2번을 보면 끝나는 시간이 3으로 다 같은 상황에서는 문제의 조건상
            // 1개의 회의만을 진행 할 수 있다. 하지만 1 3의 회의를 진행하고 3 3의 회의도 진행을 할 수 있기 때문이다. 입력 조건에 끝나는 시간의 조건은
            // 시작 시 <= 끝나는 시간으로 끝나는 시간과 다음 회의 시작시간이 같다면 회의 진행이 가능하기 때문이다.
        }
        else {
            return this.e - o.e;  // 끝나는 시간이 제각각이면 끝나는 시간을 오름차순 정렬
        }
    }
}
public class 회의실배정 {
    public int solution(ArrayList<Time> arr, int n) {
        int cnt = 0;
        Collections.sort(arr);  // 먼저 입력 받은 회의 시간들을 Override로 재정의 된 CompareTo의 메서드를 기준으로 정렬을 먼저 해준다.
        int et = 0;  // endTime의 약자로 끝나느 시간을 먼저 0으로 초기화해준다.
        for(Time o : arr) {  // 향상된 for문으로 arr에 있는 회의 시간들을 하나하나 대입해준다.
            if(o.s >= et) {  // 만약 끝나는 시간이 현재 arr에 대입되어 있는 시작시간을 기준으로 작거나 같다면 회의 진행이 가능하다는 의미이므로
                cnt++;       // cnt를 1증가 시켜주고
                et = o.e;    // 끝나느 시작을 현재 대입되어있는 회의 시간의 끝나는 시간으로 바꿔준다.
            }
        }
        return cnt;
    }
    public static void main(String[] args) {
        회의실배정  m = new 회의실배정();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Time> arr = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            arr.add(new Time(x,y));
        }
        System.out.println(m.solution(arr,n));
    }
}
