package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class HomeController {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    CarRepository carRepository;

    @RequestMapping("/")
    public String home(Model model) {
        model.addAttribute("categorys", categoryRepository.findAll());
        model.addAttribute("cars", carRepository.findAll());

        return "index";
    }

    @GetMapping("/addcategory")
    public String processCategoryForm(Model model) {
        model.addAttribute("category", new Category());
        return "categoryform";
    }

    @PostMapping("/process_category")
    public String processCategoryForm(@Valid Category category, BindingResult result) {
        if (result.hasErrors()) {
            return "categoryform";
        }
        categoryRepository.save(category);

        return "redirect:/categorylist";
    }

    @PostMapping("/processCategoryByName")
    public String processCatNameSearch(Model model, @RequestParam(name="search") String search) {
        model.addAttribute("categorys", categoryRepository.findCategoryByCategoryNameContaining(search));
        return "/categorylist";
    }

    @RequestMapping("/categorylist")
    public String categoryList(Model model) {
        model.addAttribute("categorys", categoryRepository.findAll());

        return "categorylist";
    }

    @GetMapping("/addcar")
    public String carForm(Model model) {
        model.addAttribute("categorys", categoryRepository.findAll());
        model.addAttribute("car", new Car());
        return "carform";
    }

    @PostMapping("/process_car")
    public String processCarForm(@Valid Car car, BindingResult result) {
        if (result.hasErrors()) {
            return "carform";
        }
        carRepository.save(car);

        return "redirect:/carlist";
    }

    @PostMapping("/processCarByMake")
    public String processCarByMakeSearch(Model model, @RequestParam(name="search") String search) {
        model.addAttribute("cars", carRepository.findCarsByCarMakeContains(search));
        return "/carlist";
    }

    @RequestMapping("/carlist")
    public String carList(Model model) {
        model.addAttribute("cars", carRepository.findAll());

        return "carlist";
    }

    @RequestMapping("detail_category/{id}")
    public String showCategory(@PathVariable("id") long id, Model model) {
        if (categoryRepository.findById(id).isPresent()) {
            model.addAttribute("category", categoryRepository.findById(id).get());
        }
        return "showcategory";
    }

    @RequestMapping("/update_category/{id}")
    public String updateCategory(@PathVariable("id") long id, Model model) {
        if (categoryRepository.findById(id).isPresent()) {
            model.addAttribute("category", categoryRepository.findById(id).get());
        }
        return "categoryform";
    }

    @RequestMapping("/delete_category/{id}")
    public String deleteCategory(@PathVariable("id") long id, Model model) {
        categoryRepository.deleteById(id);
        model.addAttribute("cars", carRepository.findAll());
        model.addAttribute("categorys", categoryRepository.findAll());
        return "index";
    }

    @RequestMapping("detail_car/{id}")
    public String showCar(@PathVariable("id") long id, Model model) {
        if (carRepository.findById(id).isPresent()) {
            model.addAttribute("car", carRepository.findById(id).get());
        }
        return "showcar";
    }

    @RequestMapping("/update_car/{id}")
    public String updateCar(@PathVariable("id") long id, Model model) {
        if (carRepository.findById(id).isPresent()) {
            model.addAttribute("car", carRepository.findById(id).get());
        }
        return "carform";
    }

    @RequestMapping("/delete_car/{id}")
    public String deleteCar(@PathVariable("id") long id, Model model) {
        carRepository.deleteById(id);

        System.out.println("ID: " + id);
        model.addAttribute("cars", carRepository.findAll());
        model.addAttribute("categorys", categoryRepository.findAll());
        return "redirect:/";
    }
}
