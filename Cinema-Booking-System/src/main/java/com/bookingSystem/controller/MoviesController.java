package com.bookingSystem.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import com.bookingSystem.entity.Movies;
import com.bookingSystem.entity.MyMovies;
import com.bookingSystem.entity.User;
import com.bookingSystem.service.MoviesService;
import com.bookingSystem.service.MyMoviesService;
import com.bookingSystem.service.UserService;
import java.util.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

@Controller
public class MoviesController {
	
	@Autowired
	private MoviesService service;
	

   @Autowired
    private UserService userService;

	@Autowired
	private MyMoviesService mymovieService;

	
	@GetMapping("/")
    public String home(Model model, Authentication authentication) {
    if (authentication != null && authentication.isAuthenticated()) {
        Object principal = authentication.getPrincipal();
        if (principal instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) principal;
            String email = userDetails.getUsername();
            User user = userService.findByEmail(email); 
            model.addAttribute("user", user);
            if (userDetails.getAuthorities().stream()
                .anyMatch(a -> a.getAuthority().equals("ADMIN"))) {
                return "admin";
            } else {
                return "user";
            }
        }
    }
    return "home";
}

@GetMapping("/movie_register")
public String bookRegister(Model model) {
    // Add an empty description to the model to prevent Thymeleaf parsing error
    model.addAttribute("description", "");
    return "movieRegister";
}

	
	@GetMapping("/available_movies")
    public ModelAndView getAllmovie() {
    List<Movies> list = service.getAllmovie();
    
    ModelAndView modelAndView;
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    if (authentication != null && authentication.getAuthorities().stream()
            .anyMatch(a -> a.getAuthority().equals("ADMIN"))) {
        modelAndView = new ModelAndView("movieListAdmin");
    } else {
        modelAndView = new ModelAndView("movieListUser");
    }
    
    modelAndView.addObject("movie", list); 
    return modelAndView;
}
	
	@PostMapping("/save")
	public String addmovie(@ModelAttribute Movies b) {
		service.save(b);
		return "redirect:/available_movies";
	}
    @GetMapping("/my_movies")
    public String getMymovies(Model model)
    {
        List<MyMovies>myMoviesList =mymovieService.getAllMymovies();
        model.addAttribute("movie",myMoviesList );
        return "myMovies";
    }
    @RequestMapping("/mylist/{id}")
    public String getMyList(@PathVariable("id") int id) {
        Movies b=service.getmovieById(id);
        MyMovies mb = new MyMovies(b.getId(), b.getImageUrl(), b.getName(), b.getDirector(), b.getWriter());
        mymovieService.saveMymovies(mb);
        return "redirect:/my_movies";
    }

@GetMapping("/editmovie/{id}")
public String showEditMovieForm(@PathVariable("id") int id, Model model) {
    Movies movie = service.getmovieById(id);
    model.addAttribute("movie", movie);
    
    return "movieEdit";
}

	@RequestMapping("/deletemovie/{id}")
	public String deletemovie(@PathVariable("id")int id) {
		service.deleteById(id);
		return "redirect:/available_movies";
	}
	@GetMapping("/moviedetails/{id}")
    public String movieDetails(@PathVariable("id") int id, Model model) {
        Movies movie = service.getmovieById(id);
        model.addAttribute("movie", movie);
         return "movieDetails";
}
@ExceptionHandler(IllegalArgumentException.class)
public String handleValidationException(IllegalArgumentException ex, Model model) {
    model.addAttribute("error", ex.getMessage());
    return "movieRegister";
}


}
