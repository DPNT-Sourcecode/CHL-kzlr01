package befaster;

import befaster.solutions.ARRS.ArraySumSolution;
import befaster.solutions.CHK.CheckoutSolution;
import befaster.solutions.CHL.CheckliteSolution;
import befaster.solutions.FIZ.FizzBuzzSolution;
import befaster.solutions.HLO.HelloSolution;
import befaster.solutions.IRNG.IntRangeSolution;
import befaster.solutions.SUM.SumSolution;
import befaster.solutions.exceptions.InvalidComputeParamException;
import com.google.gson.JsonElement;

import java.util.ArrayList;
import java.util.List;

/**
 * This class maps an RPC event to a method call.
 * It converts the parameters into the right format.
 *
 * We have chosen to map events to instance methods
 * to allow for better test coverage computation.
 *
 * Mapping events to static methods might have also worked but
 * that would have resulted in uncovered default constructors.
 */
class EntryPointMapping {
    private final SumSolution sumSolution;
    private final HelloSolution helloSolution;
    private final ArraySumSolution arraySumSolution;
    private final IntRangeSolution intRangeSolution;
    private final FizzBuzzSolution fizzBuzzSolution;
    private final CheckoutSolution checkoutSolution;
    private final CheckliteSolution checkliteSolution;

    EntryPointMapping() {
        sumSolution = new SumSolution();
        helloSolution = new HelloSolution();
        arraySumSolution = new ArraySumSolution();
        intRangeSolution = new IntRangeSolution();
        fizzBuzzSolution = new FizzBuzzSolution();
        checkoutSolution = new CheckoutSolution();
        checkliteSolution = new CheckliteSolution();
    }

    Object sum(List<JsonElement> p) {
        return sumSolution.sum(p.get(0).getAsInt(), p.get(1).getAsInt());
    }

    Object hello(List<JsonElement> p) {
        return helloSolution.hello(p.get(0).getAsString());
    }

    Object arraySum(List<JsonElement> p) {
        ArrayList<Integer> intArray = new ArrayList<>();
        for (JsonElement jsonElement : p.get(0).getAsJsonArray()) {
            intArray.add(jsonElement.getAsInt());
        }
        return arraySumSolution.compute(intArray);
    }

    Object intRange(List<JsonElement> p) {
        return intRangeSolution.generate(p.get(0).getAsInt(), p.get(1).getAsInt());
    }

    Object fizzBuzz(List<JsonElement> p) {
        return fizzBuzzSolution.fizzBuzz(p.get(0).getAsInt());
    }

    Object checkout(List<JsonElement> p) {
        return checkoutSolution.checklite(p.get(0).getAsString());
    }

    Object checklite(List<JsonElement> p) {
        return checkliteSolution.checklite(p.get(0).getAsString());
    }
}
