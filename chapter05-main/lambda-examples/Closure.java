import java.util.function.*;
public class Closure
{
    IntUnaryOperator adder = a -> a + 3;

    IntUnaryOperator createAdder(int n){
        return a -> a + n;        
    }

    public void adderDemo(){
        System.out.println("adder: "+ adder.applyAsInt(2));
    }

    public void bindingDemo(){
        IntUnaryOperator add5 = createAdder(5);
        IntUnaryOperator add10 = createAdder(10);

        System.out.println("add5: "+ add5.applyAsInt(2));
        System.out.println("add10: "+ add10.applyAsInt(2));

    }

}
