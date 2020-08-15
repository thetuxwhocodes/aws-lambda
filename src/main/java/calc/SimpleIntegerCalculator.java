package calc;

public class SimpleIntegerCalculator {

    public int calculate(CalcInput calcInput) {
        switch (calcInput.getFunction()){
            case 1: return calcInput.getFirstInteger() + calcInput.getSecondInteger();
            case 2: return calcInput.getFirstInteger() - calcInput.getSecondInteger();
            case 3: return calcInput.getFirstInteger() * calcInput.getSecondInteger();
            case 4: return calcInput.getFirstInteger() / calcInput.getSecondInteger();
            default: throw new IllegalArgumentException("Invalid Function!");
        }
    }
}
