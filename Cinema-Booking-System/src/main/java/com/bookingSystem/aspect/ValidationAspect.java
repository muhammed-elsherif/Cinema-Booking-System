package com.bookingSystem.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.bookingSystem.entity.Movies;
import com.bookingSystem.entity.User;

@Aspect
@Component
public class ValidationAspect {


    @Before("execution(* com.bookingSystem.controller.UserController.saveUser(..)) && args(user, ..)")
    public void validateUser(User user) {
        if (!isValidName(user.getFullname())) {
            throw new IllegalArgumentException("Name should not contain numbers.");
        }
        if (!isValidPassword(user.getPassword())) {
            throw new IllegalArgumentException("Password should have at least one uppercase letter, one lowercase letter, one digit, and minimum 8 characters.");
        }
    }

    @Pointcut("(execution(* com.bookingSystem.controller.MoviesController.addmovie(..)) && args(movie))")
public void movieOperationPointcut(Movies movie) {}

@Before("movieOperationPointcut(movie)")
public void validateMovieDescription(Movies movie) {
    if (movie.getDescription() != null && movie.getDescription().length() > 20) {
        throw new IllegalArgumentException("Movie description should not exceed 20 characters.");
    }
}

    
    
    private boolean isValidName(String name) {
       
        return !name.matches(".*\\d.*");
    }

    private boolean isValidPassword(String password) {
       
        return password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).{8,}$");
    }


}
