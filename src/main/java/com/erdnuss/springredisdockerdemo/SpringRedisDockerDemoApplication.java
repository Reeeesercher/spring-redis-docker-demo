package com.erdnuss.springredisdockerdemo;

import com.erdnuss.springredisdockerdemo.redis.entity.Product;
import com.erdnuss.springredisdockerdemo.redis.repository.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/product")
public class SpringRedisDockerDemoApplication {

	@Autowired
	private ProductDao productDao;

	public static void main(String[] args) {
		SpringApplication.run(SpringRedisDockerDemoApplication.class, args);
	}

	@PostMapping
	public Product save(@RequestBody Product product){
		return productDao.save(product);
	}

	@GetMapping
	public List<Product> getAllProducts(){
		return productDao.findAll();
	}

	@GetMapping("/{id}")
	public Product findProduct(@PathVariable int id){
		return productDao.findProductById(id);
	}

	@DeleteMapping("/{id}")
	public String remove(@PathVariable int id){
		return productDao.deleteProduct(id);
	}

}
