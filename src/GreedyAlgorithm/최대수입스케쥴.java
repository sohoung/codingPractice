package GreedyAlgorithm;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

// 설명 : 현수는 유명한 강연자이다. N개이 기업에서 강연 요청을 해왔다. 각 기업은 D일 안에 와서 강연을 해 주면 M만큼의 강연료를 주기로 했다.
//       각 기업이 요청한 D와 M를 바탕으로 가장 많을 돈을 벌 수 있도록 강연 스케쥴을 짜야 한다.
//       단 강연의 특성상 현수는 하루에 하나의 기업에서만 강연을 할 수 있다.
// 입력 예시 : 6
//           50 2
//           20 1
//           40 2
//           60 3
//           30 3
//           30 1
// 출력 예시 : 150
// PriorityQueue는 Queue에 들어가 있는 값들 중에 설정되어있는 기준에 의해 제일 적절한 값을 return해주는 것을 말한다.
// compareTo 정의 기준 : 매개 변수(o) - this 변수 = 내림차순 정렬
//                    this 변수 - 매개 변수(o) = 오름차순 정렬

class Lexture implements Comparable<Lexture> {
    public int money;
    public int time;
    Lexture(int money, int time) {
        this.money = money;
        this.time = time;
    }

    @Override
    public int compareTo(Lexture o) {
        return o.time - this.time;  // time에 의해 내림차순 정렬
    }
}
public class 최대수입스케쥴 {
    static int n,max = Integer.MIN_VALUE;
    public int solution(ArrayList<Lexture> arr) {
        int answer = 0;
        PriorityQueue<Integer> p = new PriorityQueue<>(Collections.reverseOrder());
        return answer;

    }
    public static void main(String[] args) {
        최대수입스케쥴 M = new 최대수입스케쥴();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Lexture> arr = new ArrayList<>();  // Lecture 객체를 저장하는 ArrayList 객체 생성
        for(int i = 0; i < n; i++) {
            int m = sc.nextInt();
            int d = sc.nextInt();
            arr.add(new Lexture(m,d));
            if(d > max) max = d;  // 날짜 중 제일 큰 값을 max에 넣어준다.
        }
        System.out.println(M.solution(arr));
    }
}
