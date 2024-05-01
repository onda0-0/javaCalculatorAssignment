package Level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Level1calc_Collection {
    public static void main(String[] args) {

        /*
         * 1~6번 동일
         * 7. 연산 결과가 10개로 고정되지 않고 무한이 저장될 수 있도록 소스 코드를 수정합니다.
         *       - JCF(Java Collection Framework)를 사용합니다. (e.g. List, Set …)
         *       - “remove”라는 문자열을 입력받으면 가장 먼저 저장된 결과가 삭제될 수 있도록 구현합니다.
         * 8. “inquiry”라는 문자열이 입력되면 저장된 연산 결과 전부를 출력합니다.
         *       - foreach(향상된 for문)을 활용하여 구현 해봅니다.
         *
         *
         * */

        Scanner sc = new Scanner(System.in);
        String continueOrNot="";

        List<Integer> results= new ArrayList<Integer>();
        int index=0;

        // 4) “exit” 문자열을 입력하기 전까지 무한으로 계산을 진행
        while (!(continueOrNot.equals("exit"))){
            System.out.print("첫 번째 숫자를 입력하세요: ");
            int num1=sc.nextInt(); // Scanner를 사용하여 양의 정수를 입력받고 적합한 타입의 변수에 저장

            System.out.print("두 번째 숫자를 입력하세요: ");
            int num2=sc.nextInt(); // Scanner를 사용하여 양의 정수를 입력받고 적합한 타입의 변수에 저장

            System.out.print("사칙연산 기호를 입력하세요: ");
            char operator=(sc.next()).charAt(0); // 사칙연산 기호를 적합한 타입으로 선언한 변수에 저장. charAt(0)

            int result = 0;

            switch (operator){
                case '+':  result=num1+num2;
                    break;
                case '-':  result=num1-num2;
                    break;
                case '*':  result=num1*num2;
                    break;
                case '/':
                    if(num2==0){
                        System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다."); //입력안된다고 나오고 다시 돌아갈수 있게 해야함.
                        continue;
                    }else{
                        result=num1/num2;
                        break;}
            }

            results.add(result);

            System.out.println("결과: " + result);
            System.out.println("배열(리스트)결과: " + Arrays.toString(results.toArray(new Integer[results.size()])));
            System.out.println("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제)");
            String wannaRemove=sc.next();
            System.out.println("배열(리스트)결과: " + Arrays.toString(results.toArray(new Integer[results.size()])));

            if(wannaRemove.equals("remove")){
                results.remove(0);//remove안해도 List에 0번째 객체가 들어가진 않겠지만 객체 자체는 여전히 남아 있으니까 지워야 할듯.
               /*
               results.remove(0);//remove안해도 List에 0번째 객체가 들어가진 않겠지만 객체 자체는 여전히 남아 있으니까 지워야 할듯.
               *  for(int i = 0; i<results.size()-1; i++){
                    results.set(i, results.get(i + 1));//
                } //이렇게 구현하고 확인해보니 지워지는게 이상했다. 그래서 인덱스를 당기는 과정없이 그냥 remove하니까 잘된다. remove를 쓰면자동으로 자리이동이된다.
               * */
            }
            System.out.println("저장된 연산결과를 조회하시겠습니까? (inquiry 입력 시 조회)");
            String wannaInquiry=sc.next();

            if(wannaInquiry.equals("inquiry")){
                for (Integer resultt : results) {
                    System.out.print(resultt);
                }
            }

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            continueOrNot=sc.next(); // exit을 입력 받으면 반복 종료되게 하기 위해 변수에 넣음
        }

    }
}
