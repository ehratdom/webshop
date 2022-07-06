package ch.zhaw.sml.iwi.meng.leantodo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import ch.zhaw.sml.iwi.meng.leantodo.entity.Product;
import ch.zhaw.sml.iwi.meng.leantodo.entity.ProductRepository;
import ch.zhaw.sml.iwi.meng.leantodo.entity.ShoppingCart;
import ch.zhaw.sml.iwi.meng.leantodo.entity.ShoppingCartRepository;
import ch.zhaw.sml.iwi.meng.leantodo.entity.Role;
import ch.zhaw.sml.iwi.meng.leantodo.entity.RoleRepository;
import ch.zhaw.sml.iwi.meng.leantodo.entity.ToDo;
import ch.zhaw.sml.iwi.meng.leantodo.entity.ToDoRepository;
import ch.zhaw.sml.iwi.meng.leantodo.entity.User;
import ch.zhaw.sml.iwi.meng.leantodo.entity.UserRepository;

@SpringBootApplication
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class LeanToDo implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(LeanToDo.class, args);
        
    }

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;
    
    @Autowired
    private ToDoRepository toDoRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                    // This is only really relevant for development, where we have different servers for frontend and backend
                    .allowedOrigins("http://localhost:8100")
                    .allowedMethods("GET", "PUT", "POST", "DELETE")
                    // AllowCredentials is necessary, as it sets 'Access-Control-Allow-Credentials'. 
                    // Otherwise Angular's HttpClient will not pass the Cookie back.
                    .allowCredentials(true);
            }
        };
    }

    @Override
    public void run(String... args) throws Exception {
        User u = new User();
        u.setLoginName("user");
        u.setPasswordHash(new BCryptPasswordEncoder().encode("user"));

        /*User u2 = new User();
        u2.setLoginName("user2");
        u2.setPasswordHash(new BCryptPasswordEncoder().encode("user2"));*/

        Role r = new Role();
        r.setRoleName("ROLE_USER");
        roleRepository.save(r);
        u.getRoles().add(r);
        userRepository.save(u);

        ToDo toDo = new ToDo();
        toDo.setTitle("Finish This app");
        toDo.setOwner("user");
        toDoRepository.save(toDo);

        toDo = new ToDo();
        toDo.setTitle("Reply to student");
        toDo.setOwner("user");
        toDoRepository.save(toDo);

        Product product = new Product();
        product.setName("T-Shirt");
        product.setDescription("langwiligs tshirt");
        product.setPrice(25);
        product.setImg("00003aeb-ace5-43bf-9a0c-dc31a03e9cd2.jpg");
        productRepository.save(product);

        product = new Product();
        product.setName("Hoodie");
        product.setDescription("langwilige hoodie");
        product.setPrice(55);
        product.setImg("000d31f6-44b5-4758-8d86-c4fcfb234392.jpg");
        productRepository.save(product);

        product = new Product();
        product.setName("Polo");
        product.setDescription("langwiligs Polo-Shirt");
        product.setPrice(35);
        product.setImg("001068a8-86c3-4029-a9d9-1e27015e7e64.jpg");
        productRepository.save(product);


    }
}
