package th.mfu;

import java.util.Collection;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class productController {
    @Autowired
    private productRepository productRepository;
    
    //select all employeee
    @GetMapping("/products")
    public Collection<product> getAllProducts(){
        return productRepository.findAll();
    }

     //create new product
     @PostMapping("/products")
    public ResponseEntity<String> createProducts(@RequestBody product product){

        // add product to repository
        productRepository.save(product);

        //return created success message
        return ResponseEntity.ok("product created");
    }

     //update product
    @PutMapping("/products/")
    public ResponseEntity<String> updateProducts( @RequestBody product product){
         //check if id not exists
        if(!productRepository.existsById(product.getId())){
            //return error message
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("products not found");
        }

        //update employee
        productRepository.save(product);

        //return success message
        return ResponseEntity.ok("product updated");
    }

    //delete product
   @DeleteMapping("/products/{id}")
   public ResponseEntity<String> deleteProducts(@PathVariable long id){
        //check if id not exists
        if(!productRepository.existsById(id)){
            //return error message
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("products not found");
        }

       //delete employee
         productRepository.deleteById(id);

       //return success message
       return ResponseEntity.ok("products deleted");
   }
}
