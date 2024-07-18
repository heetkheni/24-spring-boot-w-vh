package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.bean.EProductBean;
import com.dao.EProductDao;
import com.services.FileUploadService;

@Controller
public class EcomProductController {
    
    @Autowired
    EProductDao productDao;
    
    @Autowired
    FileUploadService fileUploadService; 
    
    @GetMapping("/newproduct")
    public String newProduct() {
        return "EcomNewProduct";
    }
    
    @PostMapping("/saveproduct")
    public String addProduct(EProductBean bean,@RequestParam("masterImage") MultipartFile masterImage) {   
        
        fileUploadService.uploadProductImage(masterImage);
        bean.setProductImagePath("images//products//"+masterImage.getOriginalFilename());
        productDao.addProduct(bean);   
        return "EcomNewProduct";   
    }
    
    @GetMapping("/userproducts")
    public String getProduct(Model model) {
        
        List<EProductBean> productList = productDao.getAllProduct();
        model.addAttribute("products",productList);
        return "EcomListProductDB";
    }   
    
    @GetMapping("/deleteproduct")
    public  String deleteProduct(EProductBean productBean) {
        
        productDao.deleteProduct(productBean.getProductId());
        return "redirect:/userproducts";
    }

    
    @GetMapping("/viewproduct")
    public String viewProduct(@RequestParam("productId") Integer productId, Model model) {

        EProductBean productBean = productDao.getProductById(productId);
        model.addAttribute("product", productBean);

        return "EcomViewProduct";
    }
}
