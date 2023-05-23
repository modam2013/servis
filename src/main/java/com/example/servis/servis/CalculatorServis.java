package com.example.servis.servis;

import com.example.servis.exception.DivByZeroException;

public class CalculatorServis {
     public  Number plus(int a, int b){
        return a+b;
    }
     public Number minus( int a, int b){
        return a-b;
    }
     public Number umnogit(int a, int b){
        return a*b;
    }
     public Number podelit( int a, int b){
        if (b==0){
            throw new DivByZeroException();

        }
        return (double)a/b;
    }


}

