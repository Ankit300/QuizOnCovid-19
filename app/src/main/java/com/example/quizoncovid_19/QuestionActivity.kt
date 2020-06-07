package com.example.quizoncovid_19

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.widget.TintableCompoundDrawablesView
import kotlinx.android.synthetic.main.activity_question.*

class QuestionActivity : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition:Int = 1
    private var mQuestionsList: ArrayList<Question>? = null
    private var mSelectedOptionPosition:Int = 0
    private var mCorrectAnswers: Int = 0
    private var mUserName: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)
        mUserName = intent.getStringExtra(Const.USER_NAME)
        mQuestionsList = Const.getQuestions()
        setQuestion()

        qz_opA.setOnClickListener(this)
        qz_opB.setOnClickListener(this)
        qz_opC.setOnClickListener(this)
        qz_opD.setOnClickListener(this)
        btn_submit.setOnClickListener(this)

    }

    private fun setQuestion(){


        val question = mQuestionsList!![mCurrentPosition-1]
        defaultOptionsView()
        if(mCurrentPosition == mQuestionsList!!.size){
            btn_submit.text = "FINISH"
        }else{
            btn_submit.text = "SUBMIT"
        }

        progressBar.progress = mCurrentPosition
        qz_progress.text = "$mCurrentPosition" + "/" + progressBar.max

        qz_question.text = question!!.question
        qz_opA.text = question.opA
        qz_opB.text = question.opB
        qz_opC.text = question.opC
        qz_opD.text = question.opD
    }
    private fun defaultOptionsView(){
        val options = ArrayList<TextView>()
        options.add(0,qz_opA)
        options.add(1,qz_opB)
        options.add(2,qz_opC)
        options.add(3,qz_opD)

        for (option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this,
            R.drawable.default_option_border_bg)
        }
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.qz_opA ->{
                selectedOptionView(qz_opA,1)
            }
            R.id.qz_opB ->{
                selectedOptionView(qz_opB,2)
            }
            R.id.qz_opC ->{
                selectedOptionView(qz_opC,3)
            }
            R.id.qz_opD ->{
                selectedOptionView(qz_opD,4)
            }
            R.id.btn_submit ->{
               if(mSelectedOptionPosition == 0){
                   mCurrentPosition++

                   when{
                   mCurrentPosition <= mQuestionsList!!.size ->{
                       setQuestion()
                   }else->{
                      val intent = Intent(this,ResultActivity::class.java)
                       intent.putExtra(Const.USER_NAME, mUserName)
                       intent.putExtra(Const.CORRECT_ANSWERS, mCorrectAnswers)
                       intent.putExtra(Const.TOTAL_QUESTIONS, mQuestionsList!!.size)
                       startActivity(intent)
                       finish()
                   }
                   }
               }else{
                   val question = mQuestionsList?.get(mCurrentPosition-1)
                   if(question!!.correct != mSelectedOptionPosition){
                       answerView(mSelectedOptionPosition,R.drawable.wrong_option_border_bg)
                   }else{
                       mCorrectAnswers++
                   }
                   answerView(question.correct, R.drawable.correct_option_border_bg)
               if(mCurrentPosition == mQuestionsList!!.size){
                   btn_submit.text = "FINISH"
               }else{
                   btn_submit.text = "GO TO NEXT QUESTION"
               }
               mSelectedOptionPosition = 0
               }
            }
        }

    }

    private fun answerView(answer: Int, drawablesView: Int){
        when(answer){
            1->{
                qz_opA.background = ContextCompat.getDrawable(this,drawablesView)
            }
            2->{
                qz_opB.background = ContextCompat.getDrawable(this,drawablesView)
            }
            3->{
                qz_opC.background = ContextCompat.getDrawable(this,drawablesView)
            }
            4->{
                qz_opD.background = ContextCompat.getDrawable(this,drawablesView)
            }
        }
    }

    private fun selectedOptionView(qz: TextView, selectedOptionNum:Int){
        defaultOptionsView()
        mSelectedOptionPosition = selectedOptionNum

        qz.setTextColor(Color.parseColor("#363A43"))
        qz.setTypeface( qz.typeface, Typeface.BOLD)
        qz.background = ContextCompat.getDrawable(this,
            R.drawable.selected_option_border_bg)
    }
}