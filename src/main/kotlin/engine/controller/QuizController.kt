package engine.controller

import engine.model.AnswerResponse
import engine.model.Quiz
import engine.service.QuizService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/quiz")
class QuizController(
    private val quizService: QuizService,
) {
    @GetMapping
    fun getQuiz(): Quiz = quizService.getQuiz()

    @PostMapping
    fun solveQuiz(
        @RequestParam answer: Int,
    ): AnswerResponse = quizService.checkAnswer(answer)
}
