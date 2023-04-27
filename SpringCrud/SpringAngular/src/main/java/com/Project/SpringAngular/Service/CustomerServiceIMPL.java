package com.Project.SpringAngular.Service;

import com.Project.SpringAngular.CustomerRepo.CustomerRepo;
import com.Project.SpringAngular.DTO.CustomerDTO;
import com.Project.SpringAngular.DTO.CustomerSaveDTO;
import com.Project.SpringAngular.DTO.CustomerUpdateDTO;
import com.Project.SpringAngular.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service //servis bileşenlerinin yönetilmesi ve kullanımının kolaylaştırılması için kullanılır
public class CustomerServiceIMPL implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;


    @Override
    public String addCustomer(CustomerSaveDTO customerSaveDTO) {

        Customer customer = new Customer(
                customerSaveDTO.getCustomerName(),
                customerSaveDTO.getCustomerAddress(),
                customerSaveDTO.getMobile()
        );
        customerRepo.save(customer);
        return customer.getCustomerName();
    }

    @Override
    public List<CustomerDTO> getAllCustomer() {
        List<Customer> getCustomers = customerRepo.findAll();
        List<CustomerDTO> customerDTOList = new ArrayList<>();
        for (Customer a : getCustomers) {
            CustomerDTO customerDTO = new CustomerDTO(

                    a.getCustomerId(),
                    a.getCustomerName(),
                    a.getCustomerAddress(),
                    a.getMobile()

            );
            customerDTOList.add(customerDTO);
        }
        return customerDTOList;
    }

    @Override
    public String updateCustomers(CustomerUpdateDTO customerUpdateDTO) {
        if (customerRepo.existsById(customerUpdateDTO.getCustomerId())) {
            Customer customer = customerRepo.getById(customerUpdateDTO.getCustomerId());

            customer.setCustomerName(customerUpdateDTO.getCustomerName());
            customer.setCustomerAddress(customerUpdateDTO.getCustomerAddress());
            customer.setMobile(customerUpdateDTO.getMobile());

            customerRepo.save(customer);
        } else {
            System.out.println("Customer ID do not Exist");
        }

        return  null;
    }

    @Override
    public boolean deleteCustomer(int id) {
        if(customerRepo.existsById(id))
        {
            customerRepo.deleteById(id);
        }
        else{
            System.out.println("Customer ID do not Exist");
        }

        return false;
    }

}

