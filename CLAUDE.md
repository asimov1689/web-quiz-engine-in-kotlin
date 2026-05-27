# Web Quiz Engine (Kotlin) — Claude Context

## Project Overview
Hyperskill project: multi-user web quiz REST API built with Spring Boot + Kotlin.
6 stages total. Currently working on **stage-001**.

## Repository
- **GitHub**: `git@github.com:asimov1689/web-quiz-engine-in-kotlin.git`
- **Local EduTools project** (Hyperskill plugin): `/Users/oliverjaramillo/Local Documents/Hyperskill/Web Quiz Engine (Kotlin)/`
- **main**: clean Spring Boot scaffold — do not implement here
- **edutools**: archived EduTools course content — do not touch
- **stage-001**: current working branch — implement here

## Stack
- Spring Boot 3.4.1
- Kotlin 2.1.0
- Java 21
- Gradle Kotlin DSL (`build.gradle.kts`)

## Production Architecture
All implementation lives in `src/main/kotlin/engine/`:
```
engine/
  WebQuizEngineApplication.kt   ← entry point (exists)
  controller/
    QuizController.kt           ← HTTP only, no logic
  service/
    QuizService.kt              ← all business logic
  model/
    Quiz.kt                     ← domain model
    AnswerResponse.kt           ← response DTO
```

Tests in `src/test/kotlin/engine/`:
```
engine/
  controller/
    QuizControllerTest.kt       ← @WebMvcTest + MockMvc
  service/
    QuizServiceTest.kt          ← unit, no Spring context
```

## Per-Stage Workflow
1. Implement on the stage branch (`git checkout stage-001`)
2. Write own unit + integration tests
3. Copy Kotlin source files into EduTools task folder for Hyperskill checker:
   `Web Quiz Engine (Kotlin)/task/src/engine/`
4. Run Hyperskill checker locally via IntelliJ EduTools plugin
5. Push stage branch to GitHub once green

## application.properties
- `application.properties` — production config only (port 8889)
- `application-test.properties` — actuator/shutdown for Hyperskill test harness

## Stage-001 Requirements
**GET /api/quiz** → hardcoded quiz JSON:
```json
{"title": "...", "text": "...", "options": ["A","B","C","D"]}
```
- Must have exactly 4 options
- Correct answer is index 2

**POST /api/quiz?answer=N** → answer check:
```json
{"success": true,  "feedback": "Congratulations, you're right!"}
{"success": false, "feedback": "Wrong answer! Please, try again."}
```

**Hyperskill tester checks:**
- GET: title/text non-blank, options array has 4 non-blank strings
- POST answer=2 → success=true
- POST answer=1 → success=false

## Stage Map
| Stage | Name | Status |
|---|---|---|
| stage-001 | Solving a simple quiz | 🔄 In progress |
| stage-002 | Making quizzes more interesting | ⏳ Pending |
| stage-003 | Lots of quizzes | ⏳ Pending |
| stage-004 | Moving quizzes to DB | ⏳ Pending |
| stage-005 | User authorization | ⏳ Pending |
| stage-006 | Advanced queries | ⏳ Pending |

## Portfolio Philosophy
All Hyperskill repos follow the same pattern — see global memory for full details.
Clean production code on stage branches, EduTools stays local only.
