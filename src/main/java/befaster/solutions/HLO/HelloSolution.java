package befaster.solutions.HLO;

import befaster.runner.SolutionNotImplementedException;

public class HelloSolution {

   // private String helloMessage = "Hello, World!";
   private String helloPrefix = "Hello, ";

    public String hello(String friendName) {
        return helloPrefix + friendName + "!";
    }
}

