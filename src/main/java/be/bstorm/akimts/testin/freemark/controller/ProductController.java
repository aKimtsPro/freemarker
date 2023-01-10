package be.bstorm.akimts.testin.freemark.controller;

import be.bstorm.akimts.testin.freemark.models.form.ProductInsertForm;
import be.bstorm.akimts.testin.freemark.models.form.ProductUpdateForm;
import be.bstorm.akimts.testin.freemark.service.CategoryService;
import be.bstorm.akimts.testin.freemark.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class ProductController {

    private final ProductService service;
    private final CategoryService categoryService;

    public ProductController(ProductService service, CategoryService categoryService) {
        this.service = service;
        this.categoryService = categoryService;
    }

    @GetMapping("/all")
    public String getAll(Model model){
        model.addAttribute("products", service.getAllProduct());
        return "product/list";
    }

    @GetMapping("/details/{id:[0-9]+}")
    public String getOne(@PathVariable long id, Model model){
        model.addAttribute("product", service.getOne(id));
        return "product/details";
    }

    @GetMapping("/insert")
    public String insert(Model model){
        model.addAttribute("form", new ProductInsertForm());
        model.addAttribute(
                "categories",
                categoryService.getCategories()
        );
        return "product/insert_form";
    }

    @PostMapping("/insert")
    public String insert(@Valid ProductInsertForm productForm, BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("form", productForm);
            model.addAttribute(
                    "categories",
                    categoryService.getCategories()
            );
            return "product/insert_form";
        }
        service.insert(productForm);
        return "redirect:all";
    }

    @GetMapping("/update/{id:[0-9]+}")
    public String update(@PathVariable long id, Model model){
        model.addAttribute("product_data", service.getOne(id));
        model.addAttribute("form", new ProductInsertForm());
        model.addAttribute(
                "categories",
                categoryService.getCategories()
        );
        return "product/update_form";
    }

    @PostMapping("/update/{id:[0-9]+}")
    public String update(@PathVariable long id, @Valid ProductUpdateForm form, BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("form", form);
            return "product/update_form";
        }
        service.update(id, form);
        return "redirect:/product/details/"+id;
    }

    @GetMapping("/delete/{id:[0-9]+}")
    public String delete(@PathVariable long id){
        service.delete(id);
        return "redirect:all";
    }

}
