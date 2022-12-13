package GreedyAlgorithm;
import java.util.Scanner;

// 설명 : 오늘은 새 학기 새로운 반에서 처음 시작하는 날이다. 현수네 반 학생은 N명이다. 현수는 각 학생들의 친구관계를 알고 싶다.
//       모든 학생은 1부터 N까지 번호가 부여되어 있고, 현수에게는 각각 두 명의 학생은 친구 관계가 번호로 표현된 숫자쌍이 주어진다.
//       만약 (1, 2), (2, 3), (3, 4)의 숫자쌍이 주어지면 1번 학생과 2번 학생이 친구이고, 2번 학생과 3번 학생이 친구, 3번 학생과 4번 학생이 친구이다.
//       그리고 1번 학생과 4번 학생은 2번과 3번을 통해서 친구관계가 된다.
//       학생의 친구관계를 나타내는 숫자쌍이 주어지면 특정 두 명이 친구인지를 판별하는 프로그램을 작성하세요.
//       두 학생이 친구이면 “YES"이고, 아니면 ”NO"를 출력한다.
// 입력 예시 : 9 7
//           1 2
//           2 3
//           3 4
//           1 5
//           6 7
//           7 8
//           8 9
//           3 8  3번 학생과 8번 학생은 친구인지 묻는 입력
// 출력 예시 : NO
// Disjoint-Set = 서로소 집합

public class 친구인가 {
    static int[] unf;  // index 번호는 학생 번호로 생각하고 배열의 데이터 값은 집합의 번호를 의미한다.
    public static int Find(int v) {
        if (v == unf[v]) {
            return v;
        }
        else {
            return unf[v] = Find(unf[v]);
            // 시간 복잡도를 줄이기 위한 경로 압축 코드이다. 
        }
    }
        public static void Union(int a, int b){
            int fa = Find(a);
            int fb = Find(b);
            if (fa != fb) {
                unf[fa] = fb;
            }
    }
        public static void main (String[]args){
            친구인가 m = new 친구인가();
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();  // 학생 수
            int k = sc.nextInt();  // 순서 쌍의 갯수
            unf = new int[n+1];    // index 번호를 학생의 번호로 생각하기 때문에 n+1 배열크기
            for (int i = 1; i <= n; i++) {
                unf[i] = i;  // 배열안에 index 번호를 그대로 배열의 데이터에 넣는다.
            }
            for (int i = 1; i <= k; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                Union(a, b);  // 친구 관계의 for문
            }
            int a = sc.nextInt();
            int b = sc.nextInt();
            int fa = Find(a);
            int fb = Find(b);
            if(fa == fb) {
                System.out.println("YES");
            }
            else {
                System.out.println("NO");
            }
            System.out.println(Find(1));  // 위의 코드로 집합의 번호가 1번 학생부터 5번 학생까지는 다 같고
            System.out.println(Find(2));
            System.out.println(Find(3));
            System.out.println(Find(4));
            System.out.println(Find(5));
            System.out.println("--------------------------------------");
            System.out.println(Find(6));  // 6번 학생부터 9번 학생까지의 집합의 번호가 다 같다.
            System.out.println(Find(7));
            System.out.println(Find(8));
            System.out.println(Find(9));
        }
    }
