package com.rest_api.fs14backend.address;


import com.rest_api.fs14backend.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface AddressRepository extends JpaRepository<Address, UUID> {
    List<Address> findAddressesByUserId(UUID id);

}
