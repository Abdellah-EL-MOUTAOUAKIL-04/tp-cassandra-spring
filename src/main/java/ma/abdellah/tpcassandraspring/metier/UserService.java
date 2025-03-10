package ma.abdellah.tpcassandraspring.metier;

import ma.abdellah.tpcassandraspring.entities.User;
import ma.abdellah.tpcassandraspring.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    private UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(String name, String email) {
        return userRepository.save(new User(UUID.randomUUID(),name,email));
    }

    public void deleteUser(UUID id) {
        userRepository.deleteById(id);
    }

    public User getUser(UUID uuid){
        return userRepository.findById(uuid).orElse(null);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

}
