package com.example.quizoncovid_19

object Const {

    const val USER_NAME : String = "user_name"
    const val TOTAL_QUESTIONS: String = "total_question"
    const val CORRECT_ANSWERS: String = "correct_answers"
    fun getQuestions(): ArrayList<Question>{
        val questionsList = ArrayList<Question>()
            val q1 = Question(1,"In which country was COVID 19 first reported?","America","Italy","China",
                "India",3)
        questionsList.add(q1)
        val q2 = Question(2,"How does Coronavirus transmit?","Droplets spread - When a person sneezes or cough",
            "Constant touching of face, eyes or mouth in public place","Close contact with a Covid19 infected person",
            "All the above",4)
        questionsList.add(q2)
        val q3 = Question(3," In which age group the COVID-19 spreads?","COVID-19 occur in all age groups.", "Coronavirus infection is mild in children.",
         "Older person and persons with pre-existing medical conditions are at high risk to develop serious illness.",
        "All the above are correct",4)
        questionsList.add(q3)
        val q4 = Question(4,"World Health Organisation on 11 February 2020 announced an official name for the disease that is causing the 2019 novel coronavirus outbreak? What is the new name of the disease?",
             "COVID-19", "COVn-19",
        "COnV-20",
        "COnVID-19",1)
        questionsList.add(q4)
        val q5 = Question(5,"The first case of novel coronavirus was identified in .....",
                "Beijing",
                "Shanghai",
                "Wuhan, Hubei",
                "Tianjin",3)
        questionsList.add(q5)
        val q6 = Question(6," Which of the following diseases are related to coronavirus?",
                "MERS",
                "SARS",
                "Both A and B",
                "Neither A nor B",3)
        questionsList.add(q6)
        val q7 = Question(7,"From where coronavirus got its name?",
                "Due to their crown-like projections.",
                "Due to their leaf-like projections.",
                "Due to their surface structure of bricks.",
                "None of the above",1)
        questionsList.add(q7)
        val q8 = Question(8,"Name a clinical trial in which blood is transfused from recovered COVID-19 patients to a coronavirus patient who is in critical condition?",
                "Plasma Therapy",
                "Solidarity",
                "Remdesivir",
                "Hydroxychloroquine",1)
        questionsList.add(q8)
        val q9 = Question(9," What is Coronavirus?",
                "It is a large family of viruses.",
                "It belongs to the family of Nidovirus.",
                "Both A and B are correct",
                "None of these.",3)
        questionsList.add(q9)
        val q10 = Question(10,"What are the most common symptoms of COVID-19",
                "Fever",
                "Dry cough",
                "Tiredness",
                "All the above",4)
        questionsList.add(q10)
        return questionsList
    }
}