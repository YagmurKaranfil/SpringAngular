package com.Project.SpringAngular.CustomerRepo;

import com.Project.SpringAngular.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories // JPA tabanlı repository'leri bulup, arka planda gereken veritabanı işlemlerini gerçekleştirmek için gerekli altyapıyı oluşturur.
@Repository //Spring Framework'ün veritabanı işlemleri için sunduğu özellikleri kullanarak, veritabanı işlemlerini daha kolay, güvenli ve tutarlı bir şekilde yönetmeyi sağlar.

public interface CustomerRepo extends JpaRepository<Customer,Integer> {

}
