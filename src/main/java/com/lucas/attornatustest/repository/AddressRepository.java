package com.lucas.attornatustest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lucas.attornatustest.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {}
