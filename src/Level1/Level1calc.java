package Level1;

import java.util.Scanner;

public class Level1calc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String continueOrNot="";

        while (!(continueOrNot.equals("exit"))){
            System.out.print("첫 번째 숫자를 입력하세요: ");
            // Scanner를 사용하여 양의 정수를 입력받고 적합한 타입의 변수에 저장합니다.
            int num1=sc.nextInt();

            System.out.print("두 번째 숫자를 입력하세요: ");
            // Scanner를 사용하여 양의 정수를 입력받고 적합한 타입의 변수에 저장합니다.
            int num2=sc.nextInt();

            System.out.print("사칙연산 기호를 입력하세요: ");
            // 사칙연산 기호를 적합한 타입으로 선언한 변수에 저장합니다.  charAt(0)
            String operator=sc.next();
            //char charAt(0)
            int result = 0;
            switch (operator){
                case "+":  result=num1+num2;
                    break;
                case "-":  result=num1-num2;
                    break;
                case "*":  result=num1*num2;
                    break;
                case "/":  if(num2==0){
                    System.out.print("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                    break;
                }else{result=num1/num2;
                    break;}
            }
            /* 제어문을 활용하여 위 요구사항을 만족할 수 있게 구현합니다.*/
            System.out.println("결과: " + result);
            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            /* exit을 입력 받으면 반복 종료 */
            continueOrNot=sc.next();
        }



    }
}
