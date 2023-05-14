package com.rest_api.fs14backend.user;

import com.rest_api.fs14backend.Authentication.AuthRequest;
import com.rest_api.fs14backend.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("api/v1/users")
public class UserController {

  @Autowired
  private UserService userService;
  @Autowired
  private AuthenticationManager authenticationManager;
  @Autowired
  private PasswordEncoder passwordEncoder;
  @Autowired
  private JwtUtils JwtUtils;

  @GetMapping()
  public List<User> findAll() {
    return userService.findAll();
  }

  @GetMapping("/{id}")
  public User findById(@PathVariable UUID id) {
    return userService.findById(id);
  }

  @PostMapping
  public User createOne(@RequestBody User user) {
    return userService.createOne(user);
  }

  @PostMapping("/signup")
  public String signup(@RequestBody User user) {
    User existingUser = userService.findUserByEmail(user.getEmail());
    if (existingUser != null) {
      return null;
   }
    user.setUsername(user.getUsername());
    user.setFirstname(user.getFirstname());
    user.setLastname(user.getLastname());
    user.setPhone(user.getPhone());
    user.setEmail(user.getEmail());
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    user.setRole(Role.ADMIN);
    userService.createOne(user);
    return JwtUtils.generateToken(user);
  }

  @PostMapping("/signin")
  public String login(@RequestBody AuthRequest authRequest) {
    authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                    authRequest.getUsername(),
                    authRequest.getPassword()
            )
    );
    User user = userService.findUserName(authRequest.getUsername());
    return JwtUtils.generateToken(user);

  }

  @PutMapping
  public User updateOne(@RequestBody User user) {
    return userService.updateOne(user);
  }

  @DeleteMapping("/{id}")
  public void deleteOne(@PathVariable UUID id) {
    userService.deleteById(id);
  }
}