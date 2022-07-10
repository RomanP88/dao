package ru.gb.daoSecurity.dao.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gb.daoSecurity.dao.entities.User;
import ru.gb.daoSecurity.dao.services.UserService;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
public class DemoController {
    private final UserService userService;

    @GetMapping("/")
    public String homePage() {
        return "home";
    }

    @GetMapping("/unsecured")
    public String unsecuredPage() {
        return "unsecured";
    }

    @GetMapping("/auth_page")
    public String authenticatedPage() {
        return "authenticated";
    }

    @GetMapping("/admin")
    public String adminPage() {
        return "admin";
    }

    @GetMapping("/user_info")
    public String daoTestPage(Principal principal) {
        User user = userService.findByUsername(principal.getName()).orElseThrow(()
                -> new RuntimeException("Unable to find user by username: " + principal.getName()));

        return "Authenticated user info: " + user.getUsername() + " : " + user.getEmail();
    }

    @GetMapping("/users_read")
    public String usersRead(Principal principal){
        User user = userService.findByUsername(principal.getName()).orElseThrow(()
                -> new RuntimeException("Unable to find user by username: " + principal.getName()));

        return "Authenticated user info: " + user.getUsername() + " : " + user.getEmail() + " , " + user.getEnthusiasm();
    }

    @GetMapping("/admin_msg")
    public String adminAuthority() {
        return "administrator";
    }
}
