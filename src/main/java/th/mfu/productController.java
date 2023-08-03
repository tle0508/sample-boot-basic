package th.mfu;

import java.util.Collection;
import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class productController {
     private HashMap<Long, product> productDB = new HashMap<Long, product>();

     //select all product
    @GetMapping("/product")
    public Collection<product> getAllproducts(){
        return productDB.values();
    }
     //create new product
    @PostMapping("/product")
    public ResponseEntity<String> createproduct(@RequestBody product product){
        //check if id exists
        if(productDB.containsKey(product.getId())){
            //return error message
            return ResponseEntity.status(HttpStatus.CONFLICT).body("product id already exists");
        }

        // add product to hashmap
        productDB.put(product.getId(), product);

        //return created success message
        return ResponseEntity.ok("product created");
    }
}
