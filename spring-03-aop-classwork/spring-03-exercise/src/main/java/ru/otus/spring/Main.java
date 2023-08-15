package ru.otus.spring;

import org.springframework.context.annotation.*;
import ru.otus.spring.domain.Person;
import ru.otus.spring.service.PersonService;

import java.util.Optional;

@EnableAspectJAutoProxy
@Configuration
@ComponentScan
public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(Main.class);

        PersonService service = context.getBean(PersonService.class);

        Optional<Person> ivan = Optional.ofNullable(service.getByName("Ivan"));
        System.out.println(ivan.map(p->"name: " + p.getName() + " age: " + p.getAge()).
                orElse("Empty result"));
    }
}
