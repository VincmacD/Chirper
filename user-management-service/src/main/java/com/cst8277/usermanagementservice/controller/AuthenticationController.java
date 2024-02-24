package com.cst8277.usermanagementservice.controller;

import com.cst8277.usermanagementservice.security.AuthenticationRequest;
import com.cst8277.usermanagementservice.security.AuthenticationResponse;
import com.cst8277.usermanagementservice.security.RegisterRequest;
import com.cst8277.usermanagementservice.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService service;


    @GetMapping(value="/user")
    public OAuth2User user(@AuthenticationPrincipal OAuth2User principal) {

        return principal;
    }
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request){
        return ResponseEntity.ok(service.register(request));
    }
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody AuthenticationRequest request){
        return ResponseEntity.ok(service.authenticate(request));
    }
    @GetMapping("/github-authenticate")
    public ResponseEntity<AuthenticationResponse> githubAuthenticate(
            @AuthenticationPrincipal OAuth2User principal) {
        return ResponseEntity.ok(service.githubAuthenticate(principal));
    }
}
