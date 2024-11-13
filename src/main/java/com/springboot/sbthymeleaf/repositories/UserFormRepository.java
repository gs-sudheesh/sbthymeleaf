package com.springboot.sbthymeleaf.repositories;

import com.springboot.sbthymeleaf.models.Registration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserFormRepository extends JpaRepository< Registration, Long > {

}
