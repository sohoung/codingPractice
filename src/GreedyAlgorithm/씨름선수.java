package GreedyAlgorithm;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// 설명 : 현수는 씨름 감독입니다. 현수는 씨름 선수를 선발공고를 냈고, N명의 지원자가 지원을 했습니다.
//       현수는 각 지원자의 키와 몸무게 정보를 알고 있습니다.
//       현수는 씨름 선수 선발 원칙을 다음과 같이 정했습니다.
//       “A라는 지원자를 다른 모든 지원자와 일대일 비교해서 키와 몸무게 모두 A지원자 보다 높은(크고, 무겁다) 지원자가
//       존재하면 A지원자는 탈락하고, 그렇지 않으면 선발된다.”
//       N명의 지원자가 주어지면 위의 선발원칙으로 최대 몇 명의 선수를 선발할 수 있는지 알아내는 프로그램을 작성하세요.
// 입력 예시 : 5
//           172 67
//           183 65
//           180 70
//           170 72
//           181 60
// 출력 예시 : 3
// Greedy Algorithm : 현재 시점에서 최선의 선택을 하는 알고리즘

class Body implements Comparable<Body> {
    public int h,w;
    Body(int h, int w) {
        this.h = h;  // 키
        this.w = w;  // 몸무게
    }
        @Override
        public int compareTo (Body o){
            return o.h - this.h;  // 입력받은 키에 대한 내림차순 정렬
    }
}

public class 씨름선수 {
    public int solution(ArrayList<Body> arr, int n) {
        int cnt = 0;
        Collections.sort(arr);  // 위의 override 기준에 의해 내림차순으로 정렬한다.
        int max = Integer.MIN_VALUE; // 최댓값을 찾기 위해 최솟값으로 초기화
        for(Body ob : arr) {
            if(ob.w > max) {
                max = ob.w;
                cnt++;
            }
        }

        return cnt;
    }
    public static void main(String[] args) {
        씨름선수  m = new 씨름선수();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Body> arr = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            int h = sc.nextInt();
            int w = sc.nextInt();
            arr.add(new Body(h,w));
        }
        System.out.println(m.solution(arr,n));
    }
}
