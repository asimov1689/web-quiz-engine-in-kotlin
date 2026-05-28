package engine.service

import engine.model.AnswerResponse
import engine.model.Quiz
import org.springframework.stereotype.Service

@Service
class QuizService {
    private val quiz =
        Quiz(
            title = "The Java Logo",
            text = "What is depicted on the Java logo?",
            options = listOf("Robot", "Tea leaf", "Cup of coffee", "Bug"),
        )

    fun getQuiz(): Quiz = quiz

    fun checkAnswer(answer: Int): AnswerResponse =
        if (answer == CORRECT_ANSWER) {
            AnswerResponse(true, "Congratulations, you're right!")
        } else {
            AnswerResponse(false, "Wrong answer! Please, try again.")
        }

    companion object {
        private const val CORRECT_ANSWER = 2
    }
}
