package engine.service

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class QuizServiceTest {
    private val service = QuizService()

    @Test
    fun `getQuiz returns non-blank title and text`() {
        val quiz = service.getQuiz()
        assertTrue(quiz.title.isNotBlank())
        assertTrue(quiz.text.isNotBlank())
    }

    @Test
    fun `getQuiz returns exactly four options`() {
        assertEquals(4, service.getQuiz().options.size)
    }

    @Test
    fun `getQuiz all options are non-blank`() {
        service.getQuiz().options.forEach { assertTrue(it.isNotBlank()) }
    }

    @Test
    fun `checkAnswer with index 2 returns success true`() {
        val response = service.checkAnswer(2)
        assertTrue(response.success)
        assertTrue(response.feedback.isNotBlank())
    }

    @Test
    fun `checkAnswer with wrong indices returns success false`() {
        listOf(0, 1, 3, -1, 99).forEach { idx ->
            assertFalse(service.checkAnswer(idx).success, "Expected false for answer=$idx")
            assertTrue(service.checkAnswer(idx).feedback.isNotBlank(), "Feedback must not be blank for answer=$idx")
        }
    }
}
