package com.fsse2305.eshop_project.api;

import com.fsse2305.eshop_project.data.product.domainObject.ProductDetailsData;
import com.fsse2305.eshop_project.data.product.dto.GetAllProductResponseDto;
import com.fsse2305.eshop_project.data.product.dto.ProductDetailsResponseDto;
import com.fsse2305.eshop_project.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductApi {

    private final ProductService productService;
    @Autowired
    public ProductApi(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/public/product")
    public List<GetAllProductResponseDto> getAllProduct(){
        List<GetAllProductResponseDto> getAllProductResponseDtoList = new ArrayList<>();
        for(ProductDetailsData productDetailsData : productService.getAllProduct()){
            getAllProductResponseDtoList.add(new GetAllProductResponseDto(productDetailsData));
        }
        return getAllProductResponseDtoList;
    }

    @GetMapping("/public/product/{id}")
    public ProductDetailsResponseDto getProduct(@PathVariable("id") Integer productId){
        return new ProductDetailsResponseDto(productService.getOneProduct(productId));
    }
}
