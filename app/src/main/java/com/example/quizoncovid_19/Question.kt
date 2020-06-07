package com.example.quizoncovid_19

data class Question (
    val id: Int,
    val question : String,
     val opA : String,
    val opB : String,
    val opC : String,
    val opD : String,
    val correct : Int
    )