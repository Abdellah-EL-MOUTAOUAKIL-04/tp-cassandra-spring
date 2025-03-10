package ma.abdellah.tpcassandraspring.web;

import ma.abdellah.tpcassandraspring.entities.User;
import ma.abdellah.tpcassandraspring.metier.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping
    public User addUser(@RequestParam String name, @RequestParam String email) {
        return userService.createUser(name, email);
    }
    @GetMapping("/{id}")
    public User getUser(@PathVariable UUID id) {
        return userService.getUser(id);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable UUID id) {
        userService.deleteUser(id);
        return "User deleted successfully";
    }
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
}
