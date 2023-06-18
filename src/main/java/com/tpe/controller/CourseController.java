package com.tpe.controller;


import com.tpe.domain.Course;
import com.tpe.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping("/courses") //gelen requestleri bu path altinda karsilar
public class CourseController {

    @Autowired
    private CourseService courseService;


    @GetMapping("/form") //kullanici /courses/form yazarsa calisacak
    public String showCoursesForm(@ModelAttribute("course") Course course){
        return "courseForm";
    }

    @PostMapping("/saveCourse")
    public String createCourse(@Valid @ModelAttribute Course course, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "courseForm";
        }

        courseService.saveCourse(course);
        return "redirect:/courses"; //save isleminden sonra tum courselar goruntulensin
    }

    @GetMapping
    public ModelAndView getCourses(){ //modelandview le hem datayi he de jsp yi donmus oluyoruz
        List<Course> courseList = courseService.getAllCourse();
        ModelAndView mav = new ModelAndView();
        mav.addObject("courses",courseList);
        mav.setViewName("courses");
        return mav;
    }


    @GetMapping("/update")
    public String showUpdateForm(@RequestParam("id") Long id, Model model){
        Course course = courseService.findCourseById(id);
        model.addAttribute("course",course);
        return "courseForm";
    }

    @GetMapping("/delete/{id}")
    public String deleteCourse(@PathVariable("id") Long id){
        courseService.deleteCourse(id);
        return "redirect:/courses";
    }



}
