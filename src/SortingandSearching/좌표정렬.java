package SortingandSearching;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// 설명 : N개의 평면상의 좌표(x, y)가 주어지면 모든 좌표를 오름차순으로 정렬하는 프로그램을 작성하세요.
//       정렬기준은 먼저 x값의 의해서 정렬하고, x값이 같을 경우 y값에 의해 정렬합니다.
// 입력 예시 : 5
//          2 7
//          1 3
//          1 2
//          2 5
//          3 6
// 출력 예시 : 1 2
//          1 3
//          2 5
//          2 7
//          3 6

class Point implements Comparable<Point> {  // Point는 Comparable의 interface 안의 구현체로 들어있으므로 implements를 해준다.
    public int x,y;  // 먼저 입력받을 x와 y좌표를 먼저 변수로 선언해준다.
    Point(int x, int y) {   // Point의 객체로 x와 y의 생성자를 만들어준다.
        this.x = x;
        this.y = y;
    }
    @Override
    public int compareTo(Point p){   // 입력받은 x와 y좌표를 어떻게 정렬할 것인가의 재정의를 Override로 해준다.
        if(this.x == p.x) {          // 오름차순으로 정렬을 하고 싶다면 this에서 매개변수로 입력받은 객체의 값을 빼주면 된다.
            return this.y - p.y;     // 만약 내림차순이라면 매개변수로 받은 객체에서 this의 값을 빼주면 된다.
        }                            // ex) 오름차순 정렬 : this.x - p.x
                                     //                 this.y - p.y
                                     //     내림차순 정렬 : p.x - this.x
                                     //                 p.y - this.y 이렇게 정렬을 재정의하여서 원하는 출력값을 내도록 해준다.
        else {
            return this.x - p.x;
        }
    }
}
public class 좌표정렬 {
    public static void main(String[] args) {
        좌표정렬  m = new 좌표정렬();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Point> arr = new ArrayList<>(); // Point를 제네틱 타입으로 받는 ArrayList 객체 생성
        for(int i = 0; i < n; i++) {  // 각각의 x좌표와 y좌표를 입력한다.
            int x = sc.nextInt();
            int y = sc.nextInt();
            arr.add(new Point(x,y));  // add함수로 arr에 x와 y좌표를 넣어준다.
        }
        Collections.sort(arr);       // 받은 arr을 위에서 Override로 재정의한 값으로 sort를 해준다.
        for(Point p : arr) {         // 향상된 for문으로 Point 객체를 전부 돌아서 차례대로 재정의한 값을 기준으로 출력해준다.
            System.out.println(p.x + " " + p.y);
        }
    }
}
