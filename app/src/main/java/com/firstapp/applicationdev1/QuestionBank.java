package com.firstapp.applicationdev1;

import java.util.ArrayList;
import java.util.List;

public class QuestionBank {

    private static List<QuestionList> javaQuestions()
    {
        final List<QuestionList> questionLists = new ArrayList<>();

        final QuestionList question1 = new QuestionList("Choose the appropriate data type for this type of field: weightInKilos","Char","String","Bolean","Double","Double","");
        final QuestionList question2 = new QuestionList("How to print hellow world in java","print(helloworld)","Helloworld","Helloworld!!!","Double","print(helloworld)","");
        final QuestionList question3 = new QuestionList("How to print hellow world in java","print(helloworld)","Helloworld","Helloworld!!!","Double","print(helloworld)","");
        final QuestionList question4 = new QuestionList("How to print hellow world in java","print(helloworld)","Helloworld","Helloworld!!!","Double","print(helloworld)","");
        final QuestionList question5 = new QuestionList("When was the python created?", "February 20, 1991", "March 27, 1995", "February 19,1991", "January 1, 2000", "February 20,19991","");



        questionLists.add(question1);
        questionLists.add(question2);
        questionLists.add(question3);
        questionLists.add(question4);
        questionLists.add(question5);

        return questionLists;
    }

    private static List<QuestionList> pythonQuestions()
    {
        final List<QuestionList> questionLists = new ArrayList<>();

        final QuestionList question1 = new QuestionList("Creator of python programming language","Dennis Ritchie","Guido van Rossum","James Gosling","Bjarne Stroustrup","Guido van Rossum","");

        final QuestionList question2 = new QuestionList("Best variable for full name","Char","String","Bolean","Double","String","");
        final QuestionList question3 = new QuestionList("Best variable for full name","Char","String","Bolean","Double","String","");
        final QuestionList question4 = new QuestionList("Best variable for full name","Char","String","Bolean","Double","String","");
        final QuestionList question5 = new QuestionList("Best variable for full name","Char","String","Bolean","Double","String","");
        final QuestionList question6 = new QuestionList("When was the python created?", "February 20, 1991", "March 27, 1995", "February 19,1991", "January 1, 2000", "February 20,19991","");


        questionLists.add(question1);
        questionLists.add(question2);
        questionLists.add(question3);
        questionLists.add(question4);
        questionLists.add(question5);
        questionLists.add((question6));


        return questionLists;
    }

    private static List<QuestionList> cpluplus()
    {
        final List<QuestionList> questionLists = new ArrayList<>();

        final QuestionList question1 = new QuestionList("Creator of python programming language","Dennis Ritchie","Guido van Rossum","James Gosling","Bjarne Stroustrup","Guido van Rossum","");

        final QuestionList question2 = new QuestionList("Best variable for full name","Char","String","Bolean","Double","String","");
        final QuestionList question3 = new QuestionList("Best variable for full name","Char","String","Bolean","Double","String","");
        final QuestionList question4 = new QuestionList("Best variable for full name","Char","String","Bolean","Double","String","");
        final QuestionList question5 = new QuestionList("Best variable for full name","Char","String","Bolean","Double","String","");
        final QuestionList question6 = new QuestionList("Best variable for full name","Char","String","Bolean","Double","String","");

        questionLists.add(question1);
        questionLists.add(question2);
        questionLists.add(question3);
        questionLists.add(question4);
        questionLists.add(question5);
        questionLists.add(question6);


        return questionLists;
    }
    private static List<QuestionList> webprog()
    {
        final List<QuestionList> questionLists = new ArrayList<>();

        final QuestionList question1 = new QuestionList("Creator of python programming language","Dennis Ritchie","Guido van Rossum","James Gosling","Bjarne Stroustrup","Guido van Rossum","");

        final QuestionList question2 = new QuestionList("Best variable for full name","Char","String","Bolean","Double","String","");
        final QuestionList question3 = new QuestionList("Best variable for full name","Char","String","Bolean","Double","String","");
        final QuestionList question4 = new QuestionList("Best variable for full name","Char","String","Bolean","Double","String","");
        final QuestionList question5 = new QuestionList("Best variable for full name","Char","String","Bolean","Double","String","");
        final QuestionList question6 = new QuestionList("Best variable for full name","Char","String","Bolean","Double","String","");

        questionLists.add(question1);
        questionLists.add(question2);
        questionLists.add(question3);
        questionLists.add(question4);
        questionLists.add(question5);
        questionLists.add(question6);


        return questionLists;
    }




    public static List<QuestionList> getQuestions(String selectedTopicName){
        switch (selectedTopicName){
            case "java":
                return javaQuestions();
            case "cplusplus":
                return cpluplus();
            case "webprog":
                return webprog();
            default:
                return pythonQuestions();
        }
    }


}
