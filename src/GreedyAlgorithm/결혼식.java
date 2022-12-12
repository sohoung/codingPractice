package GreedyAlgorithm;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// 설명 : 현수는 다음 달에 결혼을 합니다.
//       현수는 결혼식 피로연을 장소를 빌려 3일간 쉬지 않고 하려고 합니다.
//       피로연에 참석하는 친구들 N명의 참석하는 시간정보를 현수는 친구들에게 미리 요구했습니다.
//       각 친구들은 자신이 몇 시에 도착해서 몇 시에 떠날 것인지 현수에게 알려주었습니다.
//       현수는 이 정보를 바탕으로 피로연 장소에 동시에 존재하는 최대 인원수를 구하여 그 인원을 수용할 수 있는 장소를 빌리려고 합니다. 여러분이 현수를 도와주세요.
//       만약 한 친구가 오는 시간 13, 가는시간 15라면 이 친구는 13시 정각에 피로연 장에 존재하는 것이고 15시 정각에는 존재하지 않는다고 가정합니다.
// 입력 예시 : 5
//           14 18
//           12 15
//           15 20
//           20 30
//           5 14
// 출력 예시 : 2

class Times implements Comparable<Times> {
    public int time;  // 시간에 대한 변수
    public char state;  // 현재 있는지 없는지에 대한 상황 변수
    Times(int time, char state) {
        this.time = time;
        this.state = state;
    }

    @Override
    public int compareTo(Times o) {  // 정렬 기준
        if(this.time == o.time) {
            return this.state - o.state;  // 시간이 같으면 상황에 따른 오름차순
        }
        else {
            return this.time - o.time;  // 시간이 틀리면 시간에 대한 오름차순
        }
    }
}
public class 결혼식 {
    public int solution(ArrayList<Times> arr) {
        int answer = Integer.MIN_VALUE;  // 최댓값을 구해야하므로 Integer.MIN_VALUE로 최솟값을 먼저 초기화시켜준다.
        Collections.sort(arr);  // 위에 먼저 Override로 재정의된 compareTo의 기준으로 입력받은 arr을 정렬시켜준다.
        int cnt = 0;  // 현재 순간에 몇 명이 존재하는가에 대한 변수
        for(Times o : arr) {  // 향상된 for문으로 arr에 저장되어 있는 것들을 하나하나 대입시켜준다.
            if(o.state == 's') {  // 만약에 대입 되어있는 state 변수가 's'라면 즉 현재 있는 사람이라면
                cnt++;           // cnt 1증가
            }
            else {               // 이제 나가는 사람도 있으니 만약 'e'로 나가는 사람이 생긴다면 cnt를 1감소 시켜준다.
                cnt--;
            }
            answer = Math.max(answer,cnt);  // answer와 cnt중 큰 값으로 answer을 갱신시켜준다.
        }
        return answer;
    }
    public static void main(String[] args) {
        결혼식  m = new 결혼식();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Times> arr = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            int st = sc.nextInt();  // 들어온 시간 입력
            int et = sc.nextInt();  // 나가는 시간 입력
            arr.add(new Times(st,'s'));
            arr.add(new Times(et,'e'));
            // 뒤의 's'와'e'는 만약 한 사람의 나가는 시간과 다른 사람의 들어온 시간이 같다면 카운트를 하지 않기 위해서 먼저 나가는 사람을 체크하고 들어온 사람을 체크한다.
            // 즉 카운트를 하지 않아야 하므로 미리 Override로 재정의된 compareTo메서드를 통해 알파벳 순으로 정렬을 하기 위한 char형 변수 state이다.
        }
        System.out.print(m.solution(arr));
    }
}
