package HashMap_TreeSet;
import java.util.HashMap;
import java.util.Scanner;

// 설명 : S문자열에서 T문자열과 아나그램이 되는 S의 부분문자열의 개수를 구하는 프로그램을 작성하세요.
//       아나그램 판별시 대소문자가 구분됩니다. 부분문자열은 연속된 문자열이어야 합니다.
// 입력 예시 : bacaAacba
//           abc
// 출력 예시 : 3

public class 모든아나그램찾기 {
    public int solution(String a, String b) {
        int answer = 0;
        HashMap<Character,Integer> am = new HashMap<>();  // 입력받은 a에 대한 HashMap 객체 생성
        HashMap<Character,Integer> bm = new HashMap<>();  // 입력받은 b에 대한 HashMap 객체 생성
        for(char x : b.toCharArray()) {  //  먼저 b에 대한 값을 bm에 넣어준다.
            bm.put(x,bm.getOrDefault(x,0)+1);
        }
        int lt = 0;  // 시작 index지정
        int L = b.length()-1;  // a의 세팅을 위한 변수
        for(int i = 0; i < L; i++) {  // b의 길이보다 1작은 값으로 am의 데이터를 먼저 세팅한다.
            am.put(a.charAt(i), am.getOrDefault(a.charAt(i),0)+1);
        }
        for(int rt = L; rt < a.length(); rt++) {
            // 먼저 세팅된 am의 값에 rt index의 값을 추가하여 rt와 lt의 index에 대한 변화를 주면서 문장이 b와 아나그램이 되는지 확인한다.
            am.put(a.charAt(rt),am.getOrDefault(a.charAt(rt),0)+1);
            if(am.equals(bm)) {
                answer++;
            }
            am.put(a.charAt(lt),am.get(a.charAt(lt))-1);
            if(am.get(a.charAt(lt)) == 0) {  // 0의 값이 있으면 value값이 0으로 된다고 생각하므로 지워준다.
                am.remove(a.charAt(lt));
            }
            lt++;
        }

        return answer;
    }
    public static void main(String[] args) {
        모든아나그램찾기  m = new 모든아나그램찾기();
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        System.out.println(m.solution(a,b));
    }
}
