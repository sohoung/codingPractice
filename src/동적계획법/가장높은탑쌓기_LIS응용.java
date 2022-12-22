package 동적계획법;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// 설명 : 밑면이 정사각형인 직육면체 벽돌들을 사용하여 탑을 쌓고자 한다. 탑은 벽돌을 한 개씩 아래에서 위로 쌓으면서 만들어 간다.
//       아래의 조건을 만족하면서 가장 높은 탑을 쌓을 수 있는 프로그램을 작성하시오.
//       (조건1) 벽돌은 회전시킬 수 없다. 즉, 옆면을 밑면으로 사용할 수 없다.
//       (조건2) 밑면의 넓이가 같은 벽돌은 없으며, 또한 무게가 같은 벽돌도 없다.
//       (조건3) 벽돌들의 높이는 같을 수도 있다.
//       (조건4) 탑을 쌓을 때 밑면이 좁은 벽돌 위에 밑면이 넓은 벽돌은 놓을 수 없다.
//       (조건5) 무게가 무거운 벽돌을 무게가 가벼운 벽돌 위에 놓을 수 없다.
// 입력 예시 : 5
//           25 3 4
//           4 4 6
//           9 2 3
//           16 2 5
//           1 5 2
// 출력 예시 : 10


class Brick implements Comparable<Brick> {
    public int s;
    public int h;
    public int w;

    Brick(int s, int h, int w) {
        this.s = s;
        this.h = h;
        this.w = w;
    }

    @Override
    public int compareTo(Brick o) {
        return o.s - this.s;  // s를 기준으로 내림차순으로 재정의하여 정렬한다.
    }
}

public class 가장높은탑쌓기_LIS응용 {
    static int[] dy;

    public int solution(ArrayList<Brick> arr) {
        int answer = 0;
        Collections.sort(arr);  // Override로 s를 기준으로 내림차순 정렬
        for (int i = 0; i < arr.size(); i++) {
            int max_h = 0;  // h의 최댓값
            for (int j = i - 1; j >= 0; j--) {
                if (arr.get(j).w > arr.get(i).w && dy[j] > max_h) {
                    // j인 앞의 index의 w 값이 앞의 index인 i의 w 값보다 커야 탑을 쌓을 수 있다.
                    max_h = dy[j];
                }
            }
            dy[i] = max_h + arr.get(i).h;  // 최대 높이를 구하기 때문에 arr을 get으로 접근하여 h를 dy 배열에 max_h와 합하여 넣어준다.
            answer = Math.max(answer, dy[i]);  // 최댓값을 구하기 위해서 Math함수의 max를 사용하여 answer와 dy[i]를 비교하여 더 큰 값으로 answer에 갱신시켜준다.
        }
        return answer;
    }

    public static void main(String[] args) {
        가장높은탑쌓기_LIS응용 m = new 가장높은탑쌓기_LIS응용();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Brick> arr = new ArrayList<>();
        dy = new int[n];
        for(int i = 0; i < n; i++) {
            int a = sc.nextInt();  // ArrayList에 값을 넣기 위한 변수
            int b = sc.nextInt();  // ArrayList에 값을 넣기 위한 변수
            int c = sc.nextInt();  // ArrayList에 값을 넣기 위한 변수
            arr.add(new Brick(a,b,c));   // ArrayList이기 때문에 add로 값을 접근하여 넣는다.
        }
        System.out.println(m.solution(arr));
    }
}
