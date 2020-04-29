package dtapi.data.testSettings;

import dtapi.data.enums.QuestionLvl;

public class TestSettingsRepository {
    public static TestSettings getSettings1() {
        return new TestSettings(
                QuestionLvl.FIRST_LVL,
                "1",
                "10"
                );



    }
    public static TestSettings getSetting2() {
        return new TestSettings(
                QuestionLvl.SECOND_LVL,
                "1",
                "20"
        );


    }
    public static TestSettings getSetting3() {
        return new TestSettings(
                QuestionLvl.THIRD_LVL,
                "1",
                "30"
        );


    } public static TestSettings getSetting4() {
        return new TestSettings(
                QuestionLvl.FOURTH_LVL,
                "1",
                "40"
        );


    } public static TestSettings getSetting5() {
        return new TestSettings(
                QuestionLvl.FIFTH_LVL,
                "1",
                "50"
        );


    }


}
