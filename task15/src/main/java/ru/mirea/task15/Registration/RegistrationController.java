package ru.mirea.task15.Registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.mirea.task15.User.UserDto;
import ru.mirea.task15.User.UserService;

@RestController
@RequestMapping("/registration")
public class RegistrationController {
    private final UserService userService;

    @Autowired
    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("")
    public void registrationPage(@RequestBody UserDto userDto) {
        userService.saveNewUser(userDto.getUsername(), userDto.getPassword());
    }
}
