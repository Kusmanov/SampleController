package org.example;

import org.example.entity.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

// вешаем аннотации, говорящие, что это REST-контроллер,
// который сконфигурируется сам
@RestController
@EnableAutoConfiguration
public class SampleController {
    private Student student = new Student();

    // сообщаем сервису, что он должен работать по URL-адресу /hello
    // например, http://localhost:8080/hello
    // и говорим, что у него должно быть тело ответа (т.е. ответ не пустой)
    @GetMapping("/hello")
    String helloCourse() {
        return "Hello SkillFactory!";
    }

    @GetMapping("/student")
    public Student getStudent() {
        return student;
    }

    @PostMapping("/data")
    public ResponseEntity<String> createStudent(@RequestBody Student student) {
        this.student = student;
        // Возвращаем ответ клиенту
        return ResponseEntity.status(HttpStatus.CREATED).body("Студент создан!");
    }

    public static void main(String[] args) {
        // метод, который запускает наше Spring-приложение,
        // от main больше ничего не надо
        SpringApplication.run(SampleController.class, args);
    }
}