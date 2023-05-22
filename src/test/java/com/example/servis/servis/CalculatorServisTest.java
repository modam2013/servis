package com.example.servis.servis;

import com.example.servis.exception.DivByZeroException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.security.DigestException;

public class CalculatorServisTest{
    private final CalculatorServis calculatorServis=new CalculatorServis();
    @Test
    public void plusTest(){
       Number actual=calculatorServis.plus(1,2) ;
       Number expected =3;
       Assertions.assertEquals(expected,actual);
       actual=calculatorServis.plus(-1,2);
       expected=1;
        Assertions.assertEquals(expected,actual);

    }


    @Test
    public void minusTest(){
        Number actual=calculatorServis.minus(1,2) ;
        Number expected =-1;
        Assertions.assertEquals(expected,actual);
        actual=calculatorServis.minus(-1,2);
        expected=-3;
        Assertions.assertEquals(expected,actual);

    }

    @Test
    public void umnogitTest(){
        Number actual=calculatorServis.umnogit(1,2) ;
        Number expected =2;
        Assertions.assertEquals(expected,actual);
        actual=calculatorServis.umnogit(-1,2);
        expected=-2;
        Assertions.assertEquals(expected,actual);

    }
    @Test
    public void podelitTest(){
        Number actual=calculatorServis.podelit(1,2) ;
        Number expected =0.5;
        Assertions.assertEquals(expected,actual);
        actual=calculatorServis.podelit(-1,2);
        expected=-0.5;
        Assertions.assertEquals(expected,actual);

    }
    @Test
    public void podelitNegativTest(){
        Assertions.assertThrows(DivByZeroException.class,()->calculatorServis.podelit(1,0));
        Assertions.assertThrows(DivByZeroException.class,()->calculatorServis.podelit(-1,0));

    }


}
