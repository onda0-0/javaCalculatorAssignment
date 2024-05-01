package Level2;

import java.util.Arrays;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {


        /* Calculator 인스턴스 생성 */
        Calculator calc=new Calculator();
        Scanner sc = new Scanner(System.in);
        String continueOrNot="";

        while (!(continueOrNot.equals("exit"))) {
            /* 반복문 시작 */
            System.out.print("첫 번째 숫자를 입력하세요:");
            int num1 = sc.nextInt();
            System.out.print("두 번째 숫자를 입력하세요:");
            int num2 = sc.nextInt();
            System.out.print("사칙연산 기호를 입력하세요: ");
            char operator = sc.next().charAt(0);


            //Calculator 클래스가 활용될 수 있도록 수정
            //직접접근 calc.results.add(calc.calculate(num1,num2,operator));
            //3. 간접접근 -> private으로 필드 만들고 getter/setter함수를 통해 접근


            //5.저장된 연산 결과들을 조회하는 기능을 가진 메서드 활용
            System.out.println("저장된 연산결과를 조회하시겠습니까? (inquiry 입력 시 조회)");
            String wannaInquiry=sc.next();

            if(wannaInquiry.equals("inquiry")){
                calc.inquiryResults();
            }
            //4.가장 먼저 저장된 데이터를 삭제하는 기능을 가진 메서드 활용
            System.out.println("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제)");
            String wannaRemove=sc.next();

            if(wannaRemove.equals("remove")){
              calc.removeResult();
            }

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            continueOrNot = sc.next(); // exit을 입력 받으면 반복 종료되게 하기 위해 변수에 넣음
        }
    }
}
