package com.cst8277.usermanagementservice.service;

import com.cst8277.usermanagementservice.entity.User;
import com.cst8277.usermanagementservice.repository.UserRepository;
import com.cst8277.usermanagementservice.security.AuthenticationRequest;
import com.cst8277.usermanagementservice.security.AuthenticationResponse;
import com.cst8277.usermanagementservice.security.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.cst8277.usermanagementservice.entity.AccountRole.USER;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {
        var user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .accountRole(USER)
                .created(1504249224)
                .build();
        repository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .accessToken(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = repository.findByEmail(request.getEmail())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .accessToken(jwtToken)
                .build();
    }

    public AuthenticationResponse githubAuthenticate(OAuth2User principal) {
        String githubLogin = principal.getAttribute("login");
        String githubEmail = principal.getAttribute("email");
        Optional<User> existingUser = repository.findByEmail(githubEmail);
        if (existingUser.isPresent()) {
            var jwtToken = jwtService.generateToken(existingUser.get());
            return AuthenticationResponse.builder().accessToken(jwtToken).build();
        } else {
            var newUser = User.builder()
                    .name(githubLogin)
                    .email(githubEmail)
                    .password("")
                    .accountRole(USER)
                    .created(1504249224)
                    .build();
            repository.save(newUser);
            var jwtToken = jwtService.generateToken(newUser);
            return AuthenticationResponse.builder().accessToken(jwtToken).build();
        }
    }
}
