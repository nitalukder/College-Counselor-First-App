package com.example.collegecounselor


//import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.collegecounselor.databinding.FragmentQuestionBinding
import kotlinx.android.synthetic.main.fragment_question.*

/**
 * A simple [Fragment] subclass.
 */
class QuestionFragment : Fragment() {
    private lateinit var binding: FragmentQuestionBinding


    lateinit var options: ArrayList<String>
    lateinit var currentQuestion: Question
    lateinit var correctAnswer: String
//    lateinit var sharedPreferences: SharedPreferences

    private var questions = ArrayList<Question>()
    private var maxQuestion: Int = 5
    private var questionIndex: Int = 0
    var questionNumber: String = ""
    private var hint: Int = 0
    private var usedHint: String = ""
    private var maxHint: Int = 2
    var scoreProgress: Int = 0
    var showScoreProgress: String = ""
//    var Level: Int = 0


    data class Question(
        var theQuestion: String,
        var theOptions: ArrayList<String>,
        var theDifficulty: String
    )

    private fun funQuestions() {
        questions = arrayListOf(
            Question(
                "In which view Headers and Footers are visible?",
                arrayListOf("Print Layout View", "Normal View", "Page Layout Viewl", "Draft View"),
                "Easy"
            ),
            Question(
                "The process of removing unwanted part of an image is called?",
                arrayListOf("Cropping", "Hiding", "Bordering", "Cutting"),
                "Easy"
            ),
            Question(
                "To apply center alignment to a paragraph we can press",
                arrayListOf("Ctrl + E", "Ctrl + C", "Ctrl + C + A", "Ctrl + S"),
                "Easy"

            ),
            Question(
                "The space left between the margin and the start of a paragraph is called?",
                arrayListOf("Indentation", "Spacing", "Gutter", "Alignment"),
                "Easy"

            ),
            Question(
                "Text-styling feature of MS word is? ",
                arrayListOf("WordArt", "WordColor", "WordFont", "WordFill"),
                "Easy"

            ),
            Question(
                "Which items are placed at the end of a document? ",
                arrayListOf(
                    "End Note", "Footer", "Foot Note", "eader"
                ),
                "Easy"

            ),
            Question(
                "To change line height to 1.5 we use shortcut key : ",
                arrayListOf("Ctrl + 5", "Ctrl + 2", "Ctrl+1", "Ctrl + 3"),
                "Easy"

            ),
            Question(
                "A number of letter that appears little above the normal text is called : ",
                arrayListOf("Superscript", "GREECESubscript", "Supertext", "Toptext"),
                "Easy"

            ),
            Question(
                "A number of letter that appears little below the normal text is called :",
                arrayListOf("Subscript", "Superscript", "Supertext", "Toptext"),
                "Easy"
            ),
            Question(
                "e can insert a page number at",
                arrayListOf("Header and Footer Both", "Footer", "Header", "None"),
                "Easy"

            )
        )
    }

    //
//    private fun getScore() {
//
//    }

    private fun submitAnswer(Answer: String) {
        if (Answer == currentQuestion.theOptions[0]) {
            scoreProgress += 10
            showScoreProgress = "Score :" + (scoreProgress).toString()
        } else {
            if (Answer == "") {
                scoreProgress == scoreProgress
                showScoreProgress = "Score :" + (scoreProgress).toString()
            } else {
                scoreProgress -= 5
                showScoreProgress = "Score :" + (scoreProgress).toString()
            }
        }
        questionIndex++
        if (questionIndex < maxQuestion) {
            setQuestion()
            binding.invalidateAll()
        } else {
//            getScore()
        }
    }


    private fun setQuestion() {
        Thread.sleep(1000)
        questionNumber =
            (questionIndex + 1).toString() + "/" + (maxQuestion).toString() + "\n Question"
        currentQuestion = questions[questionIndex]
//        CorrectAnswer = CurrentQuestion.theOptions[0]
        options = ArrayList(currentQuestion.theOptions)
        options.shuffle()
        binding.btnOption1.setBackgroundResource(R.drawable.bg_option)
        binding.btnOption2.setBackgroundResource(R.drawable.bg_option)
        binding.btnOption3.setBackgroundResource(R.drawable.bg_option)
        binding.btnOption4.setBackgroundResource(R.drawable.bg_option)
        if (hint == maxHint) {
            binding.btnHints.setOnClickListener(null)
        }
    }

    private fun shuffleQuestion() {
        questions.shuffle()
        setQuestion()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_question, container, false)
        funQuestions()
        shuffleQuestion()
        binding.question = this
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        btn_option_1.setOnClickListener {
            if (currentQuestion.theOptions[0] == btn_option_1.text.toString()) {
                btn_option_1.setBackgroundResource(R.drawable.bg_correct_ans)
            } else {
                btn_option_1.setBackgroundResource(R.drawable.bg_wrong_ans)
            }
            submitAnswer(btn_option_1.text.toString())
        }
        btn_option_2.setOnClickListener {
            if (currentQuestion.theOptions[0] == btn_option_2.text.toString()) {
                btn_option_2.setBackgroundResource(R.drawable.bg_correct_ans)
            } else {
                btn_option_2.setBackgroundResource(R.drawable.bg_wrong_ans)
            }
            submitAnswer(btn_option_2.text.toString())
        }
        btn_option_3.setOnClickListener {
            if (currentQuestion.theOptions[0] == btn_option_3.text.toString()) {
                btn_option_3.setBackgroundResource(R.drawable.bg_correct_ans)
            } else {
                btn_option_3.setBackgroundResource(R.drawable.bg_wrong_ans)
            }
            submitAnswer(btn_option_3.text.toString())
        }
        btn_option_4.setOnClickListener {
            if (currentQuestion.theOptions[0] == btn_option_4.text.toString()) {
                btn_option_4.setBackgroundResource(R.drawable.bg_correct_ans)
            } else {
                btn_option_4.setBackgroundResource(R.drawable.bg_wrong_ans)
            }
            submitAnswer(btn_option_4.text.toString())
        }

        if (hint < maxHint) {
            btn_hints.setOnClickListener {

                if (currentQuestion.theOptions[2] == btn_option_1.text.toString() || currentQuestion.theOptions[3] == btn_option_1.text.toString()) {
                    btn_option_1.setBackgroundResource(R.drawable.bg_wrong_ans)
                }
                if (currentQuestion.theOptions[2] == btn_option_2.text.toString() || currentQuestion.theOptions[3] == btn_option_2.text.toString()) {
                    btn_option_2.setBackgroundResource(R.drawable.bg_wrong_ans)
                }
                if (currentQuestion.theOptions[2] == btn_option_3.text.toString() || currentQuestion.theOptions[3] == btn_option_3.text.toString()) {
                    btn_option_3.setBackgroundResource(R.drawable.bg_wrong_ans)
                }
                if (currentQuestion.theOptions[2] == btn_option_4.text.toString() || currentQuestion.theOptions[3] == btn_option_4.text.toString()) {
                    btn_option_4.setBackgroundResource(R.drawable.bg_wrong_ans)
                }

                hint++

                usedHint = hint.toString()
            }
        }
        btn_skip.setOnClickListener {
            submitAnswer("")
        }
    }
}
