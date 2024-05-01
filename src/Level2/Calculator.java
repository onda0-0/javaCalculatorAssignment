package Level2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Calculator {
    /* 연산 결과를 저장하는 컬렉션 타입 필드 선언 및 생성 */
    Scanner sc = new Scanner(System.in);
    List<Integer> results= new ArrayList<Integer>();

    public Double calculate(int num1, int num2, char operator) {
        double outcome=0;
        /* 위 요구사항에 맞게 구현 */
        if(operator=='+'){
            outcome = num1 + num2;
        }else if(operator=='-'){
            outcome = num1 - num2;
        }else if(operator=='*'){
            outcome = num1 * num2;
        }else if(operator=='/'){
            outcome = num1 / num2;
        }
        return outcome;
    }

    //results.add(outcome);

}
