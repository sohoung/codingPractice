package Array;
import java.util.ArrayList;
import java.util.Scanner;

// 설명 : N개의 자연수가 입력되면 각 자연수를 뒤집은 후 그 뒤집은 수가 소수이면 그 소수를 출력하는 프로그램을 작성하세요.
//       예를 들어 32를 뒤집으면 23이고, 23은 소수이다. 그러면 23을 출력한다. 단 910를 뒤집으면 19로 숫자화 해야 한다.
//       첫 자리부터의 연속된 0은 무시한다.
// 입력 예시 : 9
//          32 55 62 20 250 370 200 30 100
// 출력 예시 : 23 2 73 2 3
public class 뒤집은소수 {
    public boolean isPrime(int num) {  // 뒤집은 수가 소수인지 확인하는 메서드
        if(num == 1) return false;  // 1은 소수가 아니므로 바로 return 값을 false로 해준다.
        for(int i = 2; i < num; i++) {
            if(num%i == 0) {  // 만약 나머지가 0이라면 나누어 떨어진다는 소리이므로 약수가 있다는 소리이다. 이것은 소수가 아니므로 return 값을 false로 해준다.
                return false;
            }
        }
        return true;
    }
    public ArrayList<Integer> solution(int[] arr, int n) {
        ArrayList<Integer> answer = new ArrayList<>();
        for(int i = 0; i < arr.length; i++) {
            int tmp = arr[i];    // 뒤집을 수를 tmp에 넣어준다.
            int res = 0;
            while(tmp>0) {       // while문으로 tmp가 0이상일 때까지만 수행하도록해준다.
                int t = tmp % 10;  // 일의자리를 구한다.
                res = res * 10 + t;  // res에 값을 넣어준다. 일의 자리부터 차례대로 넣어준다.
                tmp = tmp / 10;  // 순서를 바꾸기 위해 res에 넣어진 수를 제외한 숫자를 다시 tmp에 넣어준다.
            }
            if(isPrime(res)) {  // isPrime의 메서드대로 뒤집어진 숫자가 만약 소수이면 answer.add로 값을 넣어준다.
                answer.add(res);
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        뒤집은소수 m = new 뒤집은소수();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for(int x : m.solution(arr,n)) {
            System.out.print(x + " ");
        }
    }
}
