package com.turkcell.pair6.customerservice.controllers;

import com.turkcell.pair6.customerservice.entities.Address;
import com.turkcell.pair6.customerservice.services.abstracts.AddressService;
import com.turkcell.pair6.customerservice.services.dtos.requests.AddAddressRequest;
import com.turkcell.pair6.customerservice.services.dtos.requests.UpdateAddressRequest;
import com.turkcell.pair6.customerservice.services.dtos.responses.AddressResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/addresses")
@AllArgsConstructor
public class AddressController {
    private final AddressService addressService;

    @GetMapping
    public Page<AddressResponse> getAll(@RequestParam(defaultValue = "0") int pageNumber,
                                        @RequestParam(defaultValue = "10") int pageSize) {
        return addressService.getAll(PageRequest.of(pageNumber, pageSize));
    }

    @GetMapping("getById")
    public Optional<Address> getById(int id){
        return addressService.getById(id);
    }

    @PostMapping
    public void add(@RequestBody @Valid AddAddressRequest request)
    {
        addressService.add(request);
    }

    @DeleteMapping
    public void delete(int id){
        addressService.delete(id);
    }

    @PutMapping
    public void update(@RequestBody @Valid UpdateAddressRequest updateAddressRequest) {
        addressService.update(updateAddressRequest);
    }
}
