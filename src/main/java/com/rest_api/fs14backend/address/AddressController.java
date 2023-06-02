package com.rest_api.fs14backend.address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.rest_api.fs14backend.exceptions.NotFoundException;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins ={"http://127.0.0.1:5173", "https://front-end-project-liart.vercel.app/products"})
@RestController
@RequestMapping("api/v1/addresses")
public class AddressController {
    @Autowired
    private AddressService addressService;

    @GetMapping
    public List<Address> findAll() {
        return addressService.findAll();
    }

    @GetMapping("/user/{id}")
    public List<Address> findAddressesByUserId(@PathVariable UUID id) {
        return addressService.findAddressesByUserId(id);
    }

    @GetMapping("/{id}")
    public Address findById(@PathVariable UUID id) {
        return addressService.findById(id);
    }

    @PostMapping
    public Address createOne(@RequestBody Address address) {
        return addressService.createOne(address);
    }

    @PutMapping
    public Address updateOne(@RequestBody Address address) {
        return addressService.updateOne(address);
    }

    @DeleteMapping("/{id}")
    public  void deleteOne(@PathVariable UUID id) {
        addressService.deleteById(id);
    }


}