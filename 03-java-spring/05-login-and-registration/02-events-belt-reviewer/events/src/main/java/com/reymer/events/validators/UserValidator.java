package com.reymer.events.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.reymer.events.models.User;
import com.reymer.events.repositories.UserRepository;

@Component
public class UserValidator implements Validator {
	private final UserRepository userRepo;
	public UserValidator(UserRepository userRepo) {
		this.userRepo = userRepo;
	}
	
	@Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }
    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        
        if (!user.getPasswordConfirmation().equals(user.getPassword())) {
            errors.rejectValue("passwordConfirmation", "Match", "Password does not match!");
        }
        if (this.userRepo.findByEmail(user.getEmail()) != null) {
        	errors.rejectValue("email", "Unique", "Email already exists!");
        }
    }
}
