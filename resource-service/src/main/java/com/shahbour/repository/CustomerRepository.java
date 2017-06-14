package com.shahbour.repository;

import com.shahbour.domain.Customer;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by shahbour on 14/06/17.
 */
public interface CustomerRepository extends CrudRepository<Customer,Integer> {
}
