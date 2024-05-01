package Level2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Calculator {
    /* 연산 결과를 저장하는 컬렉션 타입 필드 선언 및 생성 */
    private List<Double> results= new ArrayList<Double>();
    //7.원의 넓이 결과를 저장하는 컬렉션 타입의 필드 선언 및 생성
    private List<Double> areas= new ArrayList<Double>();

    //6. calculator 인스턴스를 생성(new)할 때 생성자를 통해 연산 결과를 저장하고 있는 컬렉션 필드가 초기화 되도록 수정
    public Calculator() {
        this.results = new ArrayList<Double>();
    }

    Scanner sc = new Scanner(System.in);
    // 나눗셈 메서드, 분모가 0일 때 예외 발생
    public double divide(int num1, int num2) throws BadInputException {
        if (num2 == 0) {
            throw new BadInputException("분모가 0이 될 수 없으니, 분모에 0을 제외한 수"); // 분모가 0일 때 예외 발생
        }
        return num1 / num2; // 정상적인 나눗셈
    }
    //1. 양의 정수 2개(0 포함)와 연산 기호를 매개변수로 받아 사칙연산(+,-,*,/) 기능을 수행한 후 결과 값을 반환하는 메서드
    public Double calculate(int num1, int num2, char operator) throws BadInputException{
        double outcome=0;

        switch (operator){
            case '+':
                outcome = num1 + num2;
                return outcome;
            case '-':
                outcome = num1 - num2;
                return  outcome;
            case '*':
                outcome = num1 * num2;
                return outcome;
            case '/':
                return divide(num1,num2);
            default:
                throw new BadInputException("+,-,/,*중 하나");

        }

        /*double outcome=0;

        if(operator=='+'){
            outcome = num1 + num2;
        }else if(operator=='-'){
            outcome = num1 - num2;
        }else if(operator=='*'){
            outcome = num1 * num2;
        }else if(operator=='/'){
            outcome = num1 / num2;
        }
        return outcome;*/
    }

    //5.저장된 연산 결과들을 조회하는 기능을 가진 메서드
    public void inquiryResults() {
        for (double resultsItems : results) {
            System.out.print(resultsItems);
        }
    }

    //4.가장 먼저 저장된 데이터를 삭제하는 기능을 가진 메서드
    public void removeResult() {
        results.remove(0);
    }

    //3. getter
    public List<Double> getResults(){
            return results;
    }

    //3. setter
    public void setResults(List<Double> results){
        this.results=results;
    }

    public void addResults(Double result){
        this.results.add(result);
    }


    //7.반지름을 매개변수로 전달받아 원의 넓이를 계산하여 반환해주는 메서드를 구현
    public double calculateCircleArea(int radius) {
        /* 원의 넓이 계산 구현 */
        return (double)radius*(double)radius*3.14;
    }

    //7. 원의 넓이 저장 필드 Getter
    public List<Double> getAreas(){
        return areas;
    }

    //7.원의 넓이 저장 필드 Setter
    public void setAreas(List<Double> areas){
        this.areas=areas;
    }

    //5.저장된 원 연산 결과들을 조회하는 기능을 가진 메서드
    public void inquiryAreas() {
        for (double areasItems : areas) {
            System.out.print(areasItems);
        }
    }
}
