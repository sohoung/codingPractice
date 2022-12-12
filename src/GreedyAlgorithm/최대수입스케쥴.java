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

class Lecture implements Comparable<Lecture> {
    public int money;
    public int date;
    Lecture(int money, int date) {
        this.money = money;
        this.date = date;
    }

    @Override
    public int compareTo(Lecture o) {
        return o.date - this.date;  // date에 의해 내림차순 정렬
    }
}
public class 최대수입스케쥴 {
    static int n,max = Integer.MIN_VALUE;  // 최댓값을 구해주어야하므로 Integer.MIN_VALUE로 최솟값으로 초기화
    public int solution(ArrayList<Lecture> arr) {
        int answer = 0;
        PriorityQueue<Integer> p = new PriorityQueue<>(Collections.reverseOrder());  // PriorityQueue 객체 생성
        // Collections.reverseOrder가 없다면 PritorityQueue에서 제일 작은 값을 poll하지만 Collections.reverseOrder가 있다면 반대로 정렬하므로 제일 큰 값을 poll해준다.
        Collections.sort(arr);  // 재정의 했던 date에 의한 내림차순 정렬
        int j = 0;
        for(int i = max; i >= 1; i--) {  // max 날짜부터 1까지 for문 수행
            for( ; j < n; j++) {
                if(arr.get(j).date < i) break;  // 만약 max의 날짜보다 arr.get(j)date의 날짜가 크다면 더이상 p에 money를 넣지 않아야 하므로 break
                p.offer(arr.get(j).money);  // max의 날짜보다 arr.get(j).date의 날짜가 작다면 p에 money를 넣어준다.
            }
            if(!p.isEmpty()) answer += p.poll();
            // p가 비어있지 않다면 answer에 p에 들어있는 값들 중에 설정되어있는 우선순위에서 제일 적합한 값을 p에 poll로 return시켜준다.
        }
        return answer;
    }
    public static void main(String[] args) {
        최대수입스케쥴 M = new 최대수입스케쥴();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();  // 전역변수로 이미 선언되어있으므로 int를 붙이지 않는다. int를 붙여서 원하는 출력값이 나오지 않아서 찾는데 힘들었다. 개념 다시 숙지
        ArrayList<Lecture> arr = new ArrayList<>();  // Lecture 객체를 저장하는 ArrayList 객체 생성
        for(int i = 0; i < n; i++) {
            int m = sc.nextInt();
            int d = sc.nextInt();
            arr.add(new Lecture(m,d));
            if(d > max) max = d;  // 날짜 중 제일 큰 값을 max에 넣어준다.
        }
        System.out.println(M.solution(arr));
    }
}
