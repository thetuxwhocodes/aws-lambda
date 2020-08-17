package calc;

import calc.dto.CalcInput;
import calc.dto.CalcOutput;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.google.gson.Gson;

public class SimpleIntegerCalculator {

    public APIGatewayProxyResponseEvent calculate(APIGatewayProxyRequestEvent request) {
        CalcInput calcInput = new Gson().fromJson(request.getBody(), CalcInput.class);
        CalcOutput calcOutput = new CalcOutput();
        switch (calcInput.getFunction()) {
            case 1:
                calcOutput.setResult(calcInput.getFirstInteger() + calcInput.getSecondInteger());
                break;
            case 2:
                calcOutput.setResult(calcInput.getFirstInteger() - calcInput.getSecondInteger());
                break;
            case 3:
                calcOutput.setResult(calcInput.getFirstInteger() * calcInput.getSecondInteger());
                break;
            case 4:
                calcOutput.setResult(calcInput.getFirstInteger() / calcInput.getSecondInteger());
                break;
            default:
                throw new IllegalArgumentException("Invalid Function!");
        }

        APIGatewayProxyResponseEvent response = new APIGatewayProxyResponseEvent();
        response.setBody(new Gson().toJson(calcOutput));

        return response;
    }
}
