package Level1;

import java.util.Arrays;
import java.util.Scanner;

public class Level1calc {
    public static void main(String[] args) {

        /*
        * 1. Scanner를 사용하여 양의 정수 2개(0 포함)를 전달 받을 수 있습니다.
        * 2. Scanner를 사용하여 사칙연산 기호를 전달 받을 수 있습니다. (charAt(0))
        * 3. 입력받은 양의 정수 2개와 사칙연산 기호를 사용하여 연산을 진행한 후 결과값을 출력합니다.
        *       3-1) 사칙연산 기호에 맞는 연산자를 사용하여 연산을 진행합니다.
        *       3-2) 입력받은 연산 기호를 구분하기 위해 제어문을 사용합니다. (e.g.if, switch)
        *       3-3) 연산 오류가 발생할 경우 해당 오류에 대한 내용을 정제하여 출력합니다.
        *           - e.g. “나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다. “
        * 4. 반복문을 사용하여 반복의 종료를 알려주는 “exit” 문자열을 입력하기 전까지 무한으로 계산을 진행할 수 있도록 소스 코드를 수정합니다.
        *       - 반복문을 사용합니다. (e.g. for, while …)
        * 5. 연산 결과 10개를 저장할 수 있는 배열을 선언 및 생성하고 연산의 결과를 저장합니다.
        *       5-1) 연산의 결과를 저장할 수 있도록 적합한 타입의 배열을 생성합니다.
        *       5-2) 연산의 결과를 비어있는 곳에 저장하기 위해 저장할 때마다 count 합니다.
        * 6. 연산 결과가 10개를 초과하는 경우 가장 먼저 저장된 결과를 삭제하고 새로운 연산 결과가 저장될 수 있도록 소스 코드를 수정합니다.
        *       - 현재 저장된 index가 마지막(9)라면 가장 먼저 저장된 결과 값이 삭제 되고 새로운 결과 값이 마지막 index에 저장될 수 있도록 구현합니다.
        *       - (결과 값들이 한칸씩 앞으로 이동되게 how??)
        *
        *
        *
        *
        *
        * */

        Scanner sc = new Scanner(System.in);
        String continueOrNot="";
        // 5-1)연산 결과 10개를 저장할 수 있는 배열을 선언 및 생성 & 연산의 결과를 저장할 수 있도록 적합한 타입의 배열을 생성
        int[] results= new int[10];
        // 5-2)연산의 결과가 저장된 배열의 마지막 index를 저장하는 변수를 선언
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

            //index=index%10; 가장 먼저 저장된 결과 값이 삭제 되고 새로운 결과 값이 마지막 index에 저장될 수 있도록 구현하려면 이렇게 하면 안됨

            /*이 방식의 문제를 발견했다.
            * 이렇게 하고 배열에 어떻게 담기는지 출력해봤더니
            * results[8]와 results[9]에 이중저장된다.
            * if(index==9){
                results[index]=result;
                for(int i = 0; i<results.length-1; i++){
                    results[i]=results[i+1];//
                }
            }
            * if(index==9){
                for(int i = 0; i<results.length-1; i++){
                    results[i]=results[i+1];
                }results[index]=result;
            }//results[8]에 저장이 안되고 results[9]로 넘어가버린다.
            *
            *
            *  if(index>9){
                index--;
                for(int i = 0; i<results.length-1; i++){
                    results[i]=results[i+1];//
                }results[index]=result;

            }else{
                results[index]=result;
                index++; //이렇게 했더니 한번 돌고나면 갱신이 안됨-> 왜냐면 index++의 과정을 이제 안겪거든.
            }
            *
            *  if(index>9){
                for(int i = 0; i<results.length-1; i++){
                    results[i]=results[i+1];//
                }results[index]=result;

            }else{
                results[index]=result;
                index++; //연산의 결과를 비어있는 곳에 저장하기 위해 저장할 때마다 count 하면 index10초과되어 오류발생
            * */
            if(index>9){
                for(int i = 0; i<results.length-1; i++){
                    results[i]=results[i+1];//
                }
                index--;
                results[index]=result;
                index++;

            }else{
                results[index]=result;
                index++; //연산의 결과를 비어있는 곳에 저장하기 위해 저장할 때마다 count
            }


            System.out.println("결과: " + result);
            System.out.println("배열에담긴것결과: " + Arrays.toString(results));
            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");

            continueOrNot=sc.next(); // exit을 입력 받으면 반복 종료되게 하기 위해 변수에 넣음
        }

    }
}
