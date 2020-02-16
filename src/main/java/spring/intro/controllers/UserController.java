package spring.intro.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import spring.intro.model.User;
import spring.intro.service.UserService;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @ResponseBody
    @GetMapping("user/inject")
    public void injectToDB(){
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

        user.setFirstName("Vladimir");
        user.setLastName("Vladimirov");
        user.setEmail("Vladimirovich@gmail.com");
        userService.add(user);
    }
}
