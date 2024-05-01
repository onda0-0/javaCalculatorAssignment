package Level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        /* Calculator 인스턴스 생성 */
        //Calculator calc=new Calculator();
        Scanner sc = new Scanner(System.in);
        Calculator calc=new Calculator(new ArrayList<>(),new ArrayList<>());
        String continueOrNot="";


        while (!(continueOrNot.equals("exit"))) {
            System.out.println("어떤 계산을 하시겠습니가? (1: 사칙연산, 2: 원의 넚이)");
            int choice = sc.nextInt();
            if(choice==1){

                System.out.print("첫 번째 숫자를 입력하세요:");
                int num1 = sc.nextInt();
                System.out.print("두 번째 숫자를 입력하세요:");
                int num2 = sc.nextInt();
                System.out.print("사칙연산 기호를 입력하세요: ");
                char operator = sc.next().charAt(0);

                double result=calc.calculate(num1,num2,operator);
                //calc.results.add(result); -직접접근
                calc.getResults().add(result);


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
            }else{
                System.out.println("원의 반지름을 입력하세요: ");
                int radius = sc.nextInt();

                double area = calc.calculateCircleArea(radius);
                calc.getAreas().add(area);

                System.out.println("반지름이 " + radius + "인 원의 넓이는 : " + area);

                System.out.println("저장된 원의 넓이 전체 조회: ");
                calc.inquiryAreas();
            }



           /* try {
                result=calc.calculate(num1,num2,operator);
            } catch (BadInputException e) {
                System.out.println(e.getMessage()); // 예외 메시지 출력
            }*/

            //Calculator 클래스가 활용될 수 있도록 수정
            //직접접근 calc.results.add(calc.calculate(num1,num2,operator));
            //3. 간접접근 -> private으로 필드 만들고 getter/setter함수를 통해 접근- results에 추가하는 것을 setter로 하는건지 아니면 별도의 함수를 만드는 건지,,




            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            continueOrNot = sc.next(); // exit을 입력 받으면 반복 종료되게 하기 위해 변수에 넣음
        }
    }
}
