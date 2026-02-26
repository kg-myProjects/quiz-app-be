package kg.quiz_app.config;

import kg.quiz_app.model.quiz.Category;
import kg.quiz_app.model.quiz.Question;
import kg.quiz_app.model.quiz.User;
import kg.quiz_app.repository.CategoryRepository;
import kg.quiz_app.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DataInitializer {

    public static final String TEST_USER_NAME = "Kevin";

    @Bean
    CommandLineRunner initData(CategoryRepository categoryRepo, UserRepository userRepo) {

        return args -> {

            Category javaCategory = createJavaCategory();
            categoryRepo.save(javaCategory);

            Category springCategory = createSpringCategory();
            categoryRepo.save(springCategory);

            Category boatingCategory = createBoatingCategory();
            categoryRepo.save(boatingCategory);

            User testUser = new User();
            testUser.setName(TEST_USER_NAME);
            userRepo.save(testUser);
        };
    }

    private Category createJavaCategory() {
        Category javaCategory = new Category();
        javaCategory.setTitle("Java");

        Question q1 = new Question(
                "What is JVM?",
                List.of("Java Virtual Machine",
                        "Just Very Mad",
                        "Java Version Manager",
                        "Juicy Vanilla Muffin"),
                0,
                javaCategory
        );

        Question q2 = new Question(
                "Which keyword is used to inherit a class in Java?",
                List.of("implement",
                        "extends",
                        "inherits",
                        "super"),
                1,
                javaCategory
        );

        Question q3 = new Question(
                "Which of these is a valid Java primitive type?",
                List.of("String",
                        "int",
                        "ArrayList",
                        "Integer"),
                1,
                javaCategory
        );

        Question q4 = new Question(
                "What does 'static' mean in Java?",
                List.of("Belongs to the class, not instance",
                        "Cannot be changed",
                        "Used for constants only",
                        "Method overloading"),
                0,
                javaCategory
        );

        Question q5 = new Question(
                "Which of these is NOT a Java access modifier?",
                List.of("public",
                        "private",
                        "protected",
                        "friendly"),
                3,
                javaCategory
        );

        javaCategory.setQuestions(List.of(q1, q2, q3, q4, q5));
        return javaCategory;
    }

    private Category createSpringCategory() {
        Category springCategory = new Category();
        springCategory.setTitle("Spring");

        Question q6 = new Question(
                "What does @Autowired do?",
                List.of("Creates object manually",
                        "Dependency injection",
                        "Deletes a bean",
                        "Closes application"),
                1,
                springCategory
        );

        Question q7 = new Question(
                "Which annotation marks a class as a Spring component?",
                List.of("@Component",
                        "@Bean",
                        "@Configuration",
                        "@Autowired"),
                0,
                springCategory
        );

        Question q8 = new Question(
                "What is the main purpose of Spring Boot?",
                List.of("Simplify dependency injection",
                        "Provide a servlet container",
                        "Simplify application setup and configuration",
                        "Replace Hibernate"),
                2,
                springCategory
        );

        Question q9 = new Question(
                "Which Spring annotation is used for REST controllers?",
                List.of("@RestController",
                        "@Service",
                        "@Repository",
                        "@Controller"),
                0,
                springCategory
        );

        Question q10 = new Question(
                "What does Spring @RequestMapping do?",
                List.of("Maps HTTP requests to handler methods",
                        "Creates a bean",
                        "Injects dependencies",
                        "Configures database"),
                0,
                springCategory
        );

        springCategory.setQuestions(List.of(q6, q7, q8, q9, q10));
        return springCategory;
    }

    private Category createBoatingCategory() {
        Category boatingCategory = new Category();
        boatingCategory.setTitle("Boating");

        Question q11 = new Question(
                "What does a red buoy indicate when sailing?",
                List.of("Port side of channel",
                        "Starboard side of channel",
                        "Safe water",
                        "Danger ahead"),
                0,
                boatingCategory
        );

        Question q12 = new Question(
                "What is the purpose of a life jacket?",
                List.of("Decorative",
                        "Keeps you afloat in water",
                        "Navigation aid",
                        "Anchoring"),
                1,
                boatingCategory
        );

        Question q13 = new Question(
                "What does a green buoy indicate when sailing?",
                List.of("Port side of channel",
                        "Starboard side of channel",
                        "Danger area",
                        "Safe harbor"),
                1,
                boatingCategory
        );

        Question q14 = new Question(
                "What flag signals 'I require assistance'?",
                List.of("Red Cross",
                        "Alpha",
                        "Bravo",
                        "Oscar"),
                3,
                boatingCategory
        );

        Question q15 = new Question(
                "What is the correct action when approaching a narrow channel?",
                List.of("Speed up", "Keep right, pass carefully", "Turn off engine", "Anchor immediately"),
                1,
                boatingCategory
        );

        boatingCategory.setQuestions(List.of(q11, q12, q13, q14, q15));
        return boatingCategory;
    }
}