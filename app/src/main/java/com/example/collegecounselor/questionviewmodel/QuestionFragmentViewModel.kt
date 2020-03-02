package com.example.collegecounselor.questionviewmodel

import androidx.lifecycle.ViewModel

class QuestionFragmentViewModel : ViewModel() {

    data class Question(
        var theQuestion: String,
        var theOptions: ArrayList<String>,
        var theDifficulty: String
    )

    var questions = ArrayList<Question>()


    var maxHint: Int = 2
    var usedHint: Int = 0


    fun currentScore() {
        var startingScore: Int = 0
        var ScoreProgress: Int = 0


    }

    fun hintChecker(): Boolean {
        return (maxHint > 0)
    }

    fun useHint() {
        usedHint++


    }

    fun wrongAnswer() {
    }


    fun funQuestions() {
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


}