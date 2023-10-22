package com.example.lesson46_2.valid;

import com.example.lesson46_2.dto.Role;
import com.example.lesson46_2.dto.UserDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UserValidator implements ConstraintValidator<UserConstraint, UserDto> {
    @Override
    public void initialize(UserConstraint constraintAnnotation) {
    }

    @Override
    public boolean isValid(UserDto dto, ConstraintValidatorContext context) {
        Role role = dto.getRole();
        String password = dto.getPassword();
        if (role.equals(Role.ADMIN)) {
            return true;
        }
        if (role.equals(Role.USER) && password.length() > 10){
            return true;
        }
            return false;
    }
}
