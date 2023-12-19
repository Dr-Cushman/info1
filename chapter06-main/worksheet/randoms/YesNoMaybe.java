import java.util.*;

public class YesNoMaybe
{
    Random random = new Random();
    List<String> answers = new ArrayList<>();
    public YesNoMaybe()
    {
        answers.add("yes");
        answers.add("no");
        answers.add("maybe");
    }

    public String randomAnswer()
    {
        return answers.get(random.nextInt(answers.size()));
    }

    public static void demo(){
        YesNoMaybe ynm = new YesNoMaybe();
        for(int i = 0; i<100; i++){
            System.out.println(ynm.randomAnswer());
        }
    }
}
