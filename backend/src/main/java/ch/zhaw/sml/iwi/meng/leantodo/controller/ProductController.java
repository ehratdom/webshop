package ch.zhaw.sml.iwi.meng.leantodo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ch.zhaw.sml.iwi.meng.leantodo.entity.Project;
import ch.zhaw.sml.iwi.meng.leantodo.entity.ProjectRepository;
import ch.zhaw.sml.iwi.meng.leantodo.entity.ToDo;

@Component
public class ProductController {


    @Autowired
    private ProjectRepository projectRepository;



    public List<Product> listAllProducts(String loginName) {
        return productRepository.findByOwner(loginName);
    }

    
    
}
