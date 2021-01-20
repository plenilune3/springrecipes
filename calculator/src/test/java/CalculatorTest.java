import com.apress.springrecipes.calculator.ArithmeticCalculator;
import com.apress.springrecipes.calculator.CalculatorConfiguration;
import com.apress.springrecipes.calculator.UnitCalculator;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CalculatorTest {

    ApplicationContext context = new AnnotationConfigApplicationContext(CalculatorConfiguration.class);
    ArithmeticCalculator arithmeticCalculator = context.getBean("arithmeticCalculator", ArithmeticCalculator.class);

    @Test
    public void arithmeticCalculatorTest() {
        arithmeticCalculator.add(1, 2);
        arithmeticCalculator.sub(4, 3);
        arithmeticCalculator.mul(2, 3);
        arithmeticCalculator.div(4, 2);

        UnitCalculator unitCalculator = context.getBean("unitCalculator", UnitCalculator.class);
        unitCalculator.kilogramToPound(10);
        unitCalculator.kilometerToMile(5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void divisionByZeroShouldBeThrown() {
        arithmeticCalculator.div(1, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void negativeNumbersShouldBeThrown() {
        arithmeticCalculator.add(1, -1);
        arithmeticCalculator.add(-1, -1);
    }
}
