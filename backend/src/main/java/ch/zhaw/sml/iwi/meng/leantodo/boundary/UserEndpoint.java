package ch.zhaw.sml.iwi.meng.leantodo.boundary;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ch.zhaw.sml.iwi.meng.leantodo.controller.UserController;
import ch.zhaw.sml.iwi.meng.leantodo.entity.User;

@RestController
public class UserEndpoint {

    @Autowired
    private UserController userController;

    @RequestMapping(path = "/api/user", method = RequestMethod.GET, produces = "application/json")
    @PreAuthorize("isAuthenticated() AND hasRole('USER')")
    public List<User> me(Principal principal) {
        return userController.listAllUsers();
    }

    @RequestMapping(path = "/api/currentUser", method = RequestMethod.GET, produces = "application/json")
    @PreAuthorize("isAuthenticated() AND hasRole('USER')")
    public User currentUser(Principal principal) {
        return userController.findById(principal.getName());
    }
}