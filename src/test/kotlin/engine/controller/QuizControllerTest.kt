package engine.controller

import engine.service.QuizService
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.context.annotation.Import
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.post

@WebMvcTest(QuizController::class)
@Import(QuizService::class)
class QuizControllerTest {
    @Autowired
    private lateinit var mockMvc: MockMvc

    @Test
    fun `GET api quiz returns 200 with title, text, and four options`() {
        mockMvc
            .get("/api/quiz")
            .andExpect {
                status { isOk() }
                jsonPath("$.title") { isNotEmpty() }
                jsonPath("$.text") { isNotEmpty() }
                jsonPath("$.options") { isArray() }
                jsonPath("$.options.length()") { value(4) }
            }
    }

    @Test
    fun `POST api quiz with correct answer returns success true`() {
        mockMvc
            .post("/api/quiz?answer=2")
            .andExpect {
                status { isOk() }
                jsonPath("$.success") { value(true) }
                jsonPath("$.feedback") { isNotEmpty() }
            }
    }

    @Test
    fun `POST api quiz with wrong answer returns success false`() {
        mockMvc
            .post("/api/quiz?answer=1")
            .andExpect {
                status { isOk() }
                jsonPath("$.success") { value(false) }
                jsonPath("$.feedback") { isNotEmpty() }
            }
    }

    @Test
    fun `POST api quiz with answer zero returns success false`() {
        mockMvc
            .post("/api/quiz?answer=0")
            .andExpect {
                status { isOk() }
                jsonPath("$.success") { value(false) }
            }
    }
}
