package com.example.hdfp_11_2;

public class McqQuestions {
    //for drinks
    public String mQuestions[] = {
            "What is your purpose of searching for healthy drinks?"
    };
    private String mChoices[][] = {
            {"Lose Weight", "Metabolism Boosting", "Gut cleanser"}
    };
    //for food
    public String mQuestionsForFood[] = {
            "What is your choice out of these?"
    };
    private String mChoicesForFood[][] = {
            {"Pure Vegetables", "Pure Fruits", "Other Food"}
    };
    //for drinks
    public String getQuestion(int q){
        String question = mQuestions[q];
        return question;
    }

    public String getChoice1(int a){
        String choice = mChoices[a][0];
        return choice;
    }
    public String getChoice2(int a){
        String choice = mChoices[a][1];
        return choice;
    }
    public String getChoice3(int a){
        String choice = mChoices[a][2];
        return choice;
    }
    public String getChoice4(int a){
        String choice = mChoices[a][3];
        return choice;
    }
    public String getChoice5(int a){
        String choice = mChoices[a][4];
        return choice;
    }

    //for food
    public String getQuestionFood(int q){
        String question = mQuestionsForFood[q];
        return question;
    }

    public String getFoodChoice1(int a){
        String choice = mChoicesForFood[a][0];
        return choice;
    }
    public String getFoodChoice2(int a){
        String choice = mChoicesForFood[a][1];
        return choice;
    }
    public String getFoodChoice3(int a){
        String choice = mChoicesForFood[a][2];
        return choice;
    }
}
