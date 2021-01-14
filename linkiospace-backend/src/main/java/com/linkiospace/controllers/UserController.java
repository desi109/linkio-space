package com.linkiospace.controllers;

import com.linkiospace.entities.Connection;
import com.linkiospace.entities.User;
import com.linkiospace.entities.UsersConnections;
import com.linkiospace.repositories.ConnectionRepository;
import com.linkiospace.repositories.UserRepository;
import com.linkiospace.repositories.UsersConnectionsRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/v1")
public class UserController {

    private final UserRepository userRepository;
    private final ConnectionRepository connectionRepository;
    private final UsersConnectionsRepository usersConnectionsRepository;

    UserController(UserRepository userRepository,
                   ConnectionRepository connectionRepository,
                   UsersConnectionsRepository usersConnectionsRepository) {
        this.userRepository = userRepository;
        this.connectionRepository = connectionRepository;
        this.usersConnectionsRepository = usersConnectionsRepository;
    }


    // user - return all connections of user
    @GetMapping("/user/connections")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> getConnections() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserEmail = authentication.getName();

        Long userOneId = userRepository.findUserIdByEmail(currentUserEmail);
        Set<Connection> userOneConnections = connectionRepository.findAllConnectionsOfUserWhoIsOne(userOneId);
        Set<User> usersResult = new HashSet<>();

        for (Connection c : userOneConnections) {
            User user = userRepository.findUserByUserId(c.getUserTwoId());

            usersResult.add(user);
        }

        List<User> result = new ArrayList<>(usersResult);
        result.sort(Comparator.comparing(a -> a.getFullName()));

        return result.stream().findAny().isPresent() ? ResponseEntity.ok(result) : ResponseEntity.ok("No friends found!");
    }


    // user - add new connection to user
    @PostMapping("/user/search/{userCode}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> addNewConnection(@PathVariable @RequestBody String userCode) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserEmail = authentication.getName();

        User userOne = userRepository.findUserByEmail(currentUserEmail);
        Long userOneId = userOne.getId();
        Long userTwoId = userRepository.findUserIdByUserCode(userCode.toLowerCase());

        List<Connection> userOneConnections = new ArrayList<>(connectionRepository.findAllConnectionsOfUserWhoIsOne(userOneId));
        userOneConnections.sort(Comparator.comparing(a -> a.getUserTwoId()));

        boolean isNew = true;

        for (Connection c : userOneConnections) {
            if (c.getUserTwoId() == userTwoId) {
                isNew = false;
            }
        }

        Map<String, Object> response = new HashMap<>();

        if (userCode.equals(userRepository.findUserCodeByEmail(currentUserEmail))) {
            response.put("message", "This is your user code!");
        } else if (userCode.equals(null) || userCode.isEmpty() || userCode.isBlank()) {
            response.put("message", "You have not entered a user code!");
        } else {
            if (isNew) {
                Connection connection = new Connection(userOneId, userTwoId, LocalDate.now());
                connection = connectionRepository.save(connection);

                UsersConnections usersConnections = new UsersConnections(connection.getUserOneId(), connection.getId());
                usersConnections = usersConnectionsRepository.save(usersConnections);

                response.put("connectionId", connection.getId());
                response.put("userOneId", connection.getUserOne());
                response.put("userTwoId", connection.getUserTwoId());
                response.put("connectionDate", connection.getConnectionDate());
                response.put("usersConnections->UserId", usersConnections.getUserId());
                response.put("usersConnectionsId->ConnectionId", usersConnections.getConnectionId());
                response.put("message", "Successfully saved!");
            } else {
                response.put("message", "It is already saved!");
            }
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    // user - search (by user code) for new user as connection
    @GetMapping("/user/search/{userCode}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> findConnectionByUserCode(@PathVariable("userCode") String userCode) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserEmail = authentication.getName();
        if (userCode == userRepository.findUserCodeByEmail(currentUserEmail)) {
            return ResponseEntity.ok().body("This is your user code!");
        }

        if (userCode == null || userCode.isBlank()) {
            return ResponseEntity.ok().body("You have not entered a user code!");
        }

        Optional<User> result = userRepository.findUserByUserCode(userCode.toLowerCase());
        return result.isPresent() ? ResponseEntity.ok(result.get()) : ResponseEntity.ok("No user found!");
    }


    // user - delete connection of user
    @DeleteMapping("/user/connections/{id}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<HttpStatus> deleteConnection(@PathVariable("id") Long userTwoId) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserEmail = authentication.getName();

        User userOne = userRepository.findUserByEmail(currentUserEmail);
        Long userOneId = userOne.getId();

        Connection c = connectionRepository.findConnectionByUserOneIdAndUserIdTwo(userOneId, userTwoId);

        try {
            connectionRepository.deleteById(c.getId());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    // user - delete all connections of user
    @DeleteMapping("/user/connections/all/{id}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<HttpStatus> deleteAllConnection(@PathVariable("id") Long userOneId) {

        Set<Connection> connections = connectionRepository.findAllConnectionsOfUserWhoIsOne(userOneId);

        try {
            for (Connection c: connections){
                connectionRepository.deleteById(c.getId());
            }

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    // user - show user information
    @GetMapping("user/details/{userCode}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> getUserInfoByUserCode(@PathVariable("userCode") String userCode) {

        Optional<User> result = userRepository.findUserByUserCode(userCode);
        return result.isPresent() ? ResponseEntity.ok(result.get()) : ResponseEntity.ok("No user found!");
    }


    // admin - show user information
    @GetMapping("admin/details/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> getUserInfoByUserId(@PathVariable("id") Long id) {

        Optional<User> result = userRepository.findUserById(id);
        return result.isPresent() ? ResponseEntity.ok(result.get()) : ResponseEntity.ok("No user found!");
    }


    //  admin/user - show profile
    @GetMapping("profile/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public ResponseEntity<?> getUserInfo(@PathVariable("id") Long id) {

        Optional<User> result = userRepository.findUserById(id);
        return result.isPresent() ? ResponseEntity.ok(result.get()) : ResponseEntity.ok("No user found!");
    }


    // admin/user - update profile
    @PutMapping("/profile/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public ResponseEntity<User> updateUserInfo(@PathVariable("id") Long id, @RequestBody User user) {
        Optional<User> userData = userRepository.findById(id);

        if (userData.isPresent()) {
            User _user = userData.get();
            _user.setEmail(user.getEmail());
            _user.setFirstName(user.getFirstName());
            _user.setLastName(user.getLastName());
            _user.setPhoneNumber(user.getPhoneNumber());
            _user.setJobTitle(user.getJobTitle());
            _user.setCompanyName(user.getCompanyName());
            _user.setBio(user.getBio());
            _user.setWebsitePortfolioLink(user.getWebsitePortfolioLink());

            return new ResponseEntity<>(userRepository.save(_user), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    // admin - show all existing users
    @GetMapping("/admin/users")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> showAllUsers() {
        Set<User> usersResult = userRepository.showAllUsers();

        List<User> result = new ArrayList<>(usersResult);
        result.sort(Comparator.comparing(a -> a.getId()));

        return result.stream().findAny().isPresent() ? ResponseEntity.ok(result) : ResponseEntity.ok("No users!");
    }


    // admin - delete user profile persistently
    @DeleteMapping("/admin/users/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<HttpStatus> deleteUserProfile(@PathVariable("id") Long id) {

        User user = userRepository.findUserByUserId(id);
        List<Connection> userConnectionsWhoIsOne = new ArrayList<>(connectionRepository.findAllConnectionsOfUserWhoIsOne(user.getId()));
        List<Connection> userConnectionsWhoIsTwo = new ArrayList<>(connectionRepository.findAllConnectionsOfUserWhoIsTwo(user.getId()));

        try {
            for (Connection c : userConnectionsWhoIsOne) {
                connectionRepository.deleteById(c.getId());
            }

            for (Connection c : userConnectionsWhoIsTwo) {
                connectionRepository.deleteById(c.getId());
            }

            userRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
