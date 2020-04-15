package com.project.spacehub.controller.userAuth;

import java.util.HashSet;


import java.util.Set;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.spacehub.DTO.LoginDTO;
import com.project.spacehub.DTO.RegisterDTO;
import com.project.spacehub.models.RoleName;
import com.project.spacehub.models.SpaceHubRole;
import com.project.spacehub.models.SpaceHubUser;
import com.project.spacehub.repository.RoleRepository;
import com.project.spacehub.repository.SpacehubUserRepository;
import com.project.spacehub.security.jwt.JwtProvider;
import com.project.spacehub.security.jwt.JwtResponse;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/user")
public class SpaceHubUserController {

    Logger logger = Logger.getLogger(getClass().getName());
    
    @Autowired
    AuthenticationManager authenticationManager;

   
    
    @Autowired
    private SpacehubUserRepository userRepository;
    
    @Autowired
    RoleRepository roleRepository;
    
    
    @Autowired
    PasswordEncoder encoder;
    
    @Autowired
    private JavaMailSender javaMailSender;
    
    
    @Autowired
    JwtProvider jwtProvider;


    @GetMapping("/")
    public String test() {
        return "Application is live and running";
    }
    
    
    @PostMapping("/signin")
    public ResponseEntity<?> authenticateuser(@Valid @RequestBody LoginDTO loginDTO){
    	
    	Authentication authentication = authenticationManager.authenticate(
    			new UsernamePasswordAuthenticationToken(
    					loginDTO.getEmail(),
    					loginDTO.getPassword()
    					)
    			);
    	
    	SecurityContextHolder.getContext().setAuthentication(authentication);
    	
    	String jwt = jwtProvider.generateJwtToken(authentication);
    	
    	return ResponseEntity.ok(new JwtResponse(jwt));
    	
    }


    @PostMapping("/signup")
    public ResponseEntity<String> registerUserAccount(@RequestBody RegisterDTO registerDTO){

        logger.info("Registration user account with information: {}"+ registerDTO);

        if(userRepository.existsByEmail(registerDTO.getEmail())) {
			System.out.println("Error");
         return new ResponseEntity<String>("Fail -> Email is already in use!",
                 HttpStatus.BAD_REQUEST);
         
     }
        SpaceHubUser user = new SpaceHubUser(registerDTO.getEmail(), 
   			 encoder.encode(registerDTO.getPassword()),
   			registerDTO.getFirstName(),
   			registerDTO.getLastName(),
   			registerDTO.getPhoneNumber());
   		
   	 Set<String> strRoles = registerDTO.getRoles();
   	 Set<SpaceHubRole> roles =  new HashSet<>();
   	 
   	 strRoles.forEach(role -> {
            switch(role) {
            case "admin":
            	SpaceHubRole adminRole = roleRepository.findByName(RoleName.ROLE_ADMIN)
                    .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
              roles.add(adminRole);
              
              break;
            case "user":
            	SpaceHubRole userRole = roleRepository.findByName(RoleName.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
                  roles.add(userRole);
                  
                    
            }
          });

       
   	user.setRoles(roles);
    userRepository.save(user);
 
    
    SimpleMailMessage msg = new SimpleMailMessage();
    msg.setTo(registerDTO.getEmail());
    
    msg.setSubject(" Registered Successful");
    msg.setText("Thank You For Registering with us");

    javaMailSender.send(msg);

        return ResponseEntity.ok().body("User registered successfully!");

    }
    
   

}
