package dtapi.data.question;

import java.util.HashMap;
import java.util.Map;

public class NewQuestion {
    private String questionName;
    private Map<String, Boolean> answers;


    public NewQuestion(String questionName) {
        this.questionName = questionName;
        answers = new HashMap<>();
    }



    public String getQuestionName() {
        return questionName;
    }

    public void setQuestionName(String questionName) {
        this.questionName = questionName;
    }

    public Map<String, Boolean> getAnswers() {
        return answers;
    }


    public NewQuestion addAnswer(String answer, Boolean isRight) {
        answers.put(answer, isRight);
        return this;
    }


}

