package com.muntasir.myapplication;

public class PamphletQuestions {

    private String pamphletQuestions [] = {
            "Do you turn out the lights in empty rooms?",
            "Do you open the blind or curtain in the morning?",
            "Do you use lights for small jobs?",
            "Do you dust the bulb and shade to give more light?",
            "Do you use energy saving light bulbs?",
            "While cooking do you have well fitting lids in the saucepans?",
            "While cooking do you match the pots to the size of the hotplate?",
            "While cooking do you simmer the food rather than boil it?",
            "While cooking do you avoid opening the door to peek in the oven?",
            "While cooking do you thaw the food before cooking it?",
            "In winter do you put on a warm sweater instead of the heater?",
            "In winter do you keep doors closed and use draught stoppers?",
            "In winter do you wrap up your windows with curtains?",
            "In winter do you let let in the sunlight to heat the rooms?",
            "In winter do you curl up in bed with a hot water bottle and book?",
            "In summer do you wear light, loose clothing on hot days?",
            "In summer do you open doors and windows to create cooling cross draughts?",
            "In summer do you turn on a fan instead of air conditioning?",
            "In summer do you suggest planting shade trees?",
            "In summer do you cool off with a quick, barely warm shower?",
            "To save energy do you have 3 minute showers?",
            "To save energy do you switch off the hot water when you go away?",
            "Are you concerned about leaking taps or pipes?",
            "To save energy do you have a water saving shower head?",
            "To save energy do you have a shower instead of a bath?",
            "While washing do you make sure your party gear is washed and dried ahead of time?",
            "While washing do you check if the water level is right for the load?",
            "While washing do you wash clothes in cold water?",
            "While washing do you like the smell of sun dried clothes?",
            "While washing do you help folding the nappies to save using disposables?",
            "While using a fridge do you only open the door to take something out?",
            "While using a fridge do you keep the thermostat set at 3 degrees?",
            "Do you turn the fridge off when ypu go for a holiday?",
            "While using a fridge do you cool down hot food before putting it in?",
            "Do you have your fridge well away from the wall?",
            "Do you take your own bags to the shops?",
            "Do you take your own containers back for refilling?",
            "Do you buy goods that come in reusable packaging?",
            "Do you try to buy goods that are not packaged?",
            "Do you help your family to sort the recyclable garbage?",
            "While going somewhere do you find your own way rather than being driven?",
            "While going somewhere do you ride your bike, take a bus or walk?",
            "While going somewhere do you offer to share a lift with others?",
            "Do you suggest family adventures on a bus, train or ferry?",
            "Do you walk to the nearby shops and carry the bags instead of taking a car?"
    };


//    private String pamphletChoices [][] = {
//            {"2", "3", "4"},
//            {"1", "2", "3"},
//            {"2 or less", "4 or less", "8 or less"},
//            {"1-4", "5-8", "9 or more"}
//    };



    //private String mCorrectAnswers[] = {"Roots", "Leaves", "Flower", "Stem"};




    public String getQuestion(int a) {
        String question = pamphletQuestions[a];
        return question;
    }

    //QUESTIONS returns the array
    public String[] getQuestions()
    {
        return pamphletQuestions;
    }


//    public String getChoice1(int a) {
//        String choice0 = pamphletChoices[a][0];
//        return choice0;
//    }


//    public String getChoice2(int a) {
//        String choice1 = pamphletChoices[a][1];
//        return choice1;
//    }

//    public String getChoice3(int a) {
//        String choice2 = pamphletChoices[a][2];
//        return choice2;
//    }

//    public String getCorrectAnswer(int a) {
//        String answer = mCorrectAnswers[a];
//        return answer;
//    }
}