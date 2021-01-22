import com.apress.springrecipes.calculator.*;
import com.jayway.jsonpath.internal.function.numeric.Min;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.*;
import static org.junit.jupiter.api.Assertions.*;


public class CalculatorTest {

    ApplicationContext context = new AnnotationConfigApplicationContext(CalculatorConfiguration.class);
    ArithmeticCalculator arithmeticCalculator = context.getBean("arithmeticCalculator", ArithmeticCalculator.class);

    @Test
    public void arithmeticCalculatorTest() {

        assertThat(arithmeticCalculator.add(1, 2), is(3.0));
        assertThat(arithmeticCalculator.sub(4, 3), is(1.0));
        assertThat(arithmeticCalculator.mul(2, 3), is(6.0));
        assertThat(arithmeticCalculator.div(4, 2), is(2.0));

        UnitCalculator unitCalculator = context.getBean("unitCalculator", UnitCalculator.class);
        unitCalculator.kilogramToPound(10);
        unitCalculator.kilometerToMile(5);

        Counter arithmeticCounter = (Counter) arithmeticCalculator;
        System.out.println(arithmeticCounter.getCount());

        Counter unitCounter = (Counter) unitCalculator;
        System.out.println(unitCounter.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void divisionByZeroShouldBeThrown() {
        assertThat(arithmeticCalculator.div(1, 0), is(1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void negativeNumbersShouldBeThrown() {
        arithmeticCalculator.add(1, -1);
        arithmeticCalculator.add(-1, -1);
    }

    @Test
    public void maxAndMinCalculatorTest() {
        MaxCalculator maxCalculator = (MaxCalculator) arithmeticCalculator;
        assertThat(maxCalculator.max(1, 2), is(2.0));

        MinCalculator minCalculator = (MinCalculator) arithmeticCalculator;
        assertThat(minCalculator.min(1, 2), is(1.0));
    }

}
