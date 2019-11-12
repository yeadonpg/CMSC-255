package Labs.Lab_3;

import java.lang.Math;

public class Expressions {

    public static void main(String[] args){
        int a = 3;
        int b = 4;
        int c = 5;
        int d = 17;
        
        /**********************************************************
         * 3 and 4 are added with sum 7       
         * 7 is divided by 5 with 1 the result of integer division
         * The value displayed is 1
         ***********************************************************/
        System.out.println((a + b) / c);

        /**********************************************************
         * Because division has higher precedence, 4 is divided by 5 with 0 the result of integer division       
         * 3 is added to 0 with sum 3
         *  The value displayed is 3
         ***********************************************************/
        System.out.println(a + b / c);

        /**********************************************************
         * 1 is added to 3 with sum 4
         * The value displayed is 4
         ***********************************************************/
        System.out.println(++a);

        /**********************************************************
         * 1 is subtracted from 4 with sum 3
         * The value displayed is 3
         ***********************************************************/
        System.out.println(--a);

        /**********************************************************
         * 1 is added to 3 with sum 4
         * The value displayed is 3
         ***********************************************************/
        System.out.println(a++);

        /**********************************************************
         * 1 is subtracted from 4 with sum 3
         * The value displayed is 4
         ***********************************************************/
        System.out.println(a--);

        /**********************************************************
         * 3 is added to 1 with sum 4
         * The value displayed is 4
         ***********************************************************/
        System.out.println(a + 1);

        /**********************************************************
         * 17 modulus 5 evaluates to 2
         * The value displayed is 2
         ***********************************************************/
        System.out.println(d % c);

        /**********************************************************
         * 17 is divided by 5 with 3 the result of integer division
         * The value displayed is 3
         ***********************************************************/
        System.out.println(d / c);

        /**********************************************************
         * 17 modulus 4 evaluates to 1
         * The value displayed is 1
         ***********************************************************/
        System.out.println(d % b);

        /**********************************************************
         * 17 is divided by 4 with 4 the result of integer division
         * The value displayed is 4
         ***********************************************************/
        System.out.println(d / b);

        /**********************************************************
         * Because division has higher precedence, 3 is divided by 17 with 0 a result of integer division
         * integer division 17 is added to 0 with sum 17 17 is added to 4 with sum 21
         * The value displayed is 21
         ***********************************************************/
        System.out.println(d + a / d + b);

        /**********************************************************
         * Because the operation is in parenthesis, 17 is added to 3 with sum 20
         * Because the operation is in parenthesis, 17 is added to 4 with sum 21
         * 20 is divided by 21 with 0 a result of integer division
         * The value displayed is 0
         ***********************************************************/
        System.out.println((d + a) / (d + b));

        /**********************************************************
         * The square root of 4 is 2
         * The value displayed is 2.0
         ***********************************************************/
        System.out.println(Math.sqrt(b));

        /**********************************************************
         * 3 to the power of 4 evaluates to 81
         * The value displayed is 81.0
         ***********************************************************/
        System.out.println(Math.pow(a, b));

        /**********************************************************
         * The absolute value of -3 is 3
         * The value displayed is 3.0
         ***********************************************************/
        System.out.println(Math.abs(-a));

        /**********************************************************
         * 3 and 4 are compared, and 4 is of greater magnitude
         * The value displayed is 4
         ***********************************************************/
        System.out.println(Math.max(a, b));
  } 
} 