package com.muntasir.myapplication;

public class QuestionLibrary {

    public String mQuestions [] = {
            "How long do you drive a car per day?",
            "How long do you use a microwave oven per day?",
            "How long do you use oven per day?",
            "How long do you use electronic stove?",
            "How long do you use kettle per day?",
            "How long do you use TV per day?",
            "How long do you iron per day?",
            "How long do you use hair dryer per day?",
            "How long do you use air conditioner/heater per day?",
            "Thank you for you inputs. They will be stored in the database."
    };


    public String getQuestion(int a) {
        String question = mQuestions[a];
        return question;
    }

}
