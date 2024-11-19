package com.example.example.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.example.example.dto.UserRequest;
import com.example.example.dto.UserResponse;
import com.example.example.entitiy.UserEntity;
import com.example.example.service.UserService;
import com.example.example.util.JwtTokenUtil;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import com.example.example.entitiy.AuthResponse;


//package com.example.microservice.entitiy.AuthResponse;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {

    private Logger logger = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    JwtTokenUtil jwtTokenUtil;

    @Autowired
    UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<String> signup(HttpServletRequest request, HttpServletResponse response, @RequestBody UserRequest userRequest) {
        logger.info("User username: {}", userRequest.getUsername());

        // Check if the user already exists
        if (userService.userExists(userRequest.getUsername())) {
            logger.warn("User already exists: {}", userRequest.getUsername());
            return ResponseEntity.status(HttpStatus.CONFLICT).body("User already exists");
        }

        // Save the user details to the database
        userService.saveUser(userRequest.getUsername(), userRequest.getPassword(), userRequest.getAddress(), userRequest.getEmail(), userRequest.getRoles());

        return ResponseEntity.ok("Signup successful");
    }


    @PostMapping("/login") // Use POST for login
    public ResponseEntity<UserResponse> login(HttpServletRequest request, HttpServletResponse response, @RequestBody UserRequest userRequest) {
        // Log the user's username from the request body
        logger.info("User username: {}", userRequest.getUsername());

        // Validate the user's credentials
        UserEntity user = userService.findByUsername(userRequest.getUsername()); // Get user from the database
        if (user == null) {
            logger.warn("User not found: {}", userRequest.getUsername());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }

        // Check if the provided password matches the stored password
        if (!userService.validatePassword(userRequest.getPassword(), user.getPassword())) {
            logger.warn("Invalid password for user: {}", userRequest.getUsername());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }

        // Generate the JWT token
        String token = jwtTokenUtil.generateToken(userRequest.getUsername());
        UserResponse resp= new UserResponse();
        resp.setToken(token);
        resp.setUsername(user.getUsername());
        resp.setRoles(user.getRoles());

        return ResponseEntity.ok(resp);
    }




    @GetMapping("/authenticate")
    public ResponseEntity<String> authenticate(HttpServletRequest request, HttpServletResponse response, @RequestBody UserRequest userRequest) {
        // Log the user's email ID from the request body
        logger.info("User username: {}", userRequest.getUsername());

        // Retrieve the JWT token from cookies
        String token = null;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("token".equals(cookie.getName())) {
                    token = cookie.getValue();
                    break;
                }
            }
        }

        if (token != null) {
            // Verify the JWT token
            if (jwtTokenUtil.validateToken(token, userRequest.getUsername())) {
                // Optionally, extract user details from the token
                logger.info("User authenticated: {}", userRequest.getUsername());
                return ResponseEntity.ok("SUCCESS");
            } else {
                logger.warn("Invalid JWT token");
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid token");
            }
        } else {
            logger.warn("No JWT token found in cookies");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("No token provided");
        }
    }

    @GetMapping("/health")
    private String health() {
        // Implement your JWT generation logic here

//        return jwtTokenUtil.createToken(user.getUsername());// Placeholder
        return "Running";// Placeholder
    }
}
