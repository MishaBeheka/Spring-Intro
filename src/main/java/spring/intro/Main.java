package spring.intro;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.intro.config.AppConfig;
import spring.intro.model.User;
import spring.intro.service.UserService;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        final UserService userService = context.getBean(UserService.class);

        User user = new User();
        user.setFirstName("Ivan");
        user.setLastName("Ivanov");
        user.setEmail("Ivanovich@gmail.com");
        userService.add(user);

        user.setFirstName("Nikolay");
        user.setLastName("Nikolaev");
        user.setEmail("Nikolaevich@gmail.com");
        userService.add(user);

        user.setFirstName("Vladimir");
        user.setLastName("Vladimirov");
        user.setEmail("Vladimirovich@gmail.com");
        userService.add(user);

        List<User> users = userService.listUsers();
        for (User person : users) {
            System.out.println("ID: " + person.getId());
            System.out.println("First name: " + person.getFirstName());
            System.out.println("Last name: " + person.getLastName());
            System.out.println("Email: " + person.getEmail());
            System.out.println();
        }
    }
}
