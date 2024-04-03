package com.turkcell.pair6.customerservice.services.concretes;
import com.turkcell.pair6.customerservice.entities.IndividualCustomer;
import com.turkcell.pair6.customerservice.repositories.CustomerRepository;
import com.turkcell.pair6.customerservice.services.abstracts.CustomerService;
import com.turkcell.pair6.customerservice.services.dtos.requests.AddDemographicRequest;
import com.turkcell.pair6.customerservice.services.dtos.requests.SearchCustomerRequest;
import com.turkcell.pair6.customerservice.services.dtos.requests.UpdateCustomerRequest;
import com.turkcell.pair6.customerservice.services.dtos.responses.AddCustomerResponse;
import com.turkcell.pair6.customerservice.services.dtos.responses.SearchCustomerResponse;
import com.turkcell.pair6.customerservice.services.mappers.CustomerMapper;
import com.turkcell.pair6.customerservice.services.rules.CustomerBusinessRules;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerBusinessRules customerBusinessRules;

    @Override
    public List<AddCustomerResponse> getAll(Pageable pageable) {
        Page<IndividualCustomer> customerPage = customerRepository.findAll(pageable);
        return customerPage.map(CustomerMapper.INSTANCE::customerResponseFromCustomer).getContent();
    }

    @Override
    public List<SearchCustomerResponse> search(SearchCustomerRequest request) {
        customerBusinessRules.customerNoExist(request);
        return customerRepository.search(request);
    }

    @Override
    public AddCustomerResponse add(AddDemographicRequest request) {
        customerBusinessRules.customerWithSameNationalityIdCanNotExist(request.getNationalityId());

        IndividualCustomer customer = CustomerMapper.INSTANCE.customerFromAddDemographicRequest(request);
        customerRepository.save(customer);

        return CustomerMapper.INSTANCE.customerResponseFromAddDemographicRequest(request);
    }

    @Override
    public void delete(int id) {
        customerRepository.deleteById(id);
    }

    @Override
    public AddCustomerResponse update(UpdateCustomerRequest request) {
        customerBusinessRules.customerNatIdExist(request.getNationalityId());

        Optional<IndividualCustomer> optionalCustomer = customerRepository.findByNationalityId(request.getNationalityId());
        IndividualCustomer individualCustomer = optionalCustomer.orElse(null);

        IndividualCustomer updatedCustomer = CustomerMapper.INSTANCE.customerFromUpdateRequest(request, individualCustomer);
        customerRepository.save(updatedCustomer);

        return CustomerMapper.INSTANCE.customerResponseFromCustomer(updatedCustomer);
    }



}
