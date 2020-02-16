package spring.intro.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.intro.dto.UserResponseDto;
import spring.intro.model.User;
import spring.intro.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/inject")
    public void injectToDB() {
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

    @GetMapping("/")
    public List<UserResponseDto> getAll() {
        List<UserResponseDto> allUsers = new ArrayList<>();
        for (User user : userService.listUsers()) {
            UserResponseDto userDto = new UserResponseDto();
            userDto.setId(user.getId());
            userDto.setFirstName(user.getFirstName());
            userDto.setLastName(user.getLastName());
            userDto.setEmail(user.getEmail());
            allUsers.add(userDto);
        }
        return allUsers;
    }

    @RequestMapping("/{id}")
    public UserResponseDto get(@PathVariable Long id) {
        UserResponseDto userDto = new UserResponseDto();
        User user = userService.get(id);
        userDto.setId(user.getId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setEmail(user.getEmail());
        return userDto;
    }
}
