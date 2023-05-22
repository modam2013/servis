package com.example.servis.servis;

import com.example.servis.exception.DivByZeroException;
import org.assertj.core.api.Assertions;
import org.assertj.core.data.Offset;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class CalculatorServisParameterTest {

    private final CalculatorServis calculatorServis=new CalculatorServis();

    public static Stream<Arguments>plusTestParams(){
        return Stream.of(Arguments.of(1,2,3),
                         Arguments.of(-1,2,1),
                          Arguments.of(0,0,0 ));
    }

    public static Stream<Arguments>minusTestParams(){
        return Stream.of(Arguments.of(1,2,-1),
                Arguments.of(-1,2,-3),
                Arguments.of(0,0,0 ));
    }
    public static Stream<Arguments>umnogitTestParams(){
        return Stream.of(Arguments.of(1,2,2),
                Arguments.of(-1,2,-2),
                Arguments.of(0,0,0 ));
    }
    public static Stream<Arguments>podelitTestParams(){
        return Stream.of(Arguments.of(1,2,0.5),
                Arguments.of(-1,2,-0.5),
                Arguments.of(0,5,0 ));
    }
    public static Stream<Arguments>podelitNegativTestParams(){
        return Stream.of(Arguments.of(1,0),
                Arguments.of(-1,0));

    }
    @ParameterizedTest
    @MethodSource("plusTestParams")
    public void plusTest(int a,int b, int expected ){
       Assertions.assertThat(calculatorServis.plus(a,b))
               .isEqualTo(expected);
    }
    @ParameterizedTest
    @MethodSource("minusTestParams")
    public void minusTest(int a,int b, int expected ){
        Assertions.assertThat(calculatorServis.minus(a,b))
                .isEqualTo(expected);
    }
    @ParameterizedTest
    @MethodSource("umnogitTestParams")
    public void umnogitTest(int a,int b, int expected ){
        Assertions.assertThat(calculatorServis.umnogit(a,b))
                .isEqualTo(expected);
    }
    @ParameterizedTest
    @MethodSource("podelitTestParams")
    public void podelitTest(int a,int b, Number expected ){
        Assertions.assertThat(calculatorServis.podelit(a,b).doubleValue())
                .isEqualTo(expected.doubleValue(), Offset.offset(0D));
    }



    @ParameterizedTest
    @MethodSource("podelitNegativTestParams")
    public void podelitNegativTest(int a,int b ){
        Assertions.assertThatExceptionOfType(DivByZeroException.class)
                .isThrownBy(()->calculatorServis.podelit(a,b));

    }
}
