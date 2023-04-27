package com.Project.SpringAngular.CustomerController;

import com.Project.SpringAngular.DTO.CustomerDTO;
import com.Project.SpringAngular.DTO.CustomerSaveDTO;
import com.Project.SpringAngular.DTO.CustomerUpdateDTO;
import com.Project.SpringAngular.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //REST endpoint'leri üretmeyi sağlar
@CrossOrigin //Bu anotasyon, bir web servisine erişen isteklerin kökenlerinin kontrol edilmesine izin verir.
@RequestMapping("api/v1/customer") // bir web uygulamasında bir HTTP isteğinin alınacağı URL yolunu belirtmek için kullanılan bir anotasyondur.
public class CustomerController {


    @Autowired //bir nesnenin otomatik olarak oluşturulmasını ve enjekte edilmesini sağlar.
    private CustomerService customerService;

    @PostMapping(path = "/save")

    //HTTP isteği gövdesindeki verilerin bir nesne olarak alınmasını sağlayan bir anotasyondur.
    public String saveCustomer(@RequestBody CustomerSaveDTO customerSaveDTO)
    {
      String id = customerService.addCustomer(customerSaveDTO);
      return id;
    }

    @GetMapping(path = "/getAllCustomer")

    public List<CustomerDTO> getAllCustomer()
    {
        List<CustomerDTO>allCustomers = customerService.getAllCustomer();
        return allCustomers;
    }



    @PutMapping(path = "/update")

    //HTTP isteği gövdesindeki verilerin bir nesne olarak alınmasını sağlayan bir anotasyondur.
    public String updateCustomer(@RequestBody CustomerUpdateDTO customerUpdateDTO)
    {
        String id = customerService.updateCustomers(customerUpdateDTO);
        return id;
    }

    @DeleteMapping(path = "/deleteCustomer/{id}")

    //Spring tabanlı bir web uygulamasında URL'deki değişkenleri işaretlemek için kullanılır.
    public String deleteCustomer(@PathVariable(value = "id") int id)
    {
        boolean deleteCustomer = customerService.deleteCustomer(id);
        return "deleted";
    }

}
