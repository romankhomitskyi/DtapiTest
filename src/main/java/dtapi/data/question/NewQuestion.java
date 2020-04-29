package dtapi.data.question;

import dtapi.data.enums.QuestionLvl;
import dtapi.data.enums.QuestionType;

import java.util.HashMap;
import java.util.Map;

public class NewQuestion {
    private String questionName;
    private QuestionType questionType;
    private QuestionLvl questionLvl;
    private Map<String, Boolean> answers;




    public NewQuestion(String questionName, QuestionType questionType, QuestionLvl questionLvl) {
        this.questionName = questionName;
        this.questionType = questionType;
        this.questionLvl = questionLvl;
        answers = new HashMap<>();
    }

    public QuestionType getQuestionType() {
        return questionType;
    }

    public void setQuestionType(QuestionType questionType) {
        this.questionType = questionType;
    }

    public QuestionLvl getQuestionLvl() {
        return questionLvl;
    }

    public void setQuestionLvl(QuestionLvl questionLvl) {
        this.questionLvl = questionLvl;
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

