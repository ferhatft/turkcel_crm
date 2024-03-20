package com.turkcell.pair6.customerservice.services.concretes;

import com.turkcell.pair6.customerservice.clients.OrderServiceClient;
import com.turkcell.pair6.customerservice.core.exception.types.BusinessException;
import com.turkcell.pair6.customerservice.entities.Customer;
import com.turkcell.pair6.customerservice.repositories.CustomerRepository;
import com.turkcell.pair6.customerservice.services.dtos.requests.AddCustomerRequest;
import com.turkcell.pair6.customerservice.services.dtos.requests.SearchCustomerRequest;
import com.turkcell.pair6.customerservice.services.dtos.responses.SearchCustomerResponse;
import com.turkcell.pair6.customerservice.services.mappers.CustomerMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.turkcell.pair6.customerservice.services.abstracts.CustomerService;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private  final CustomerRepository customerRepository;

    //DOĞRu mu eklendi kontrol
    private final WebClient.Builder webClient;

    private final OrderServiceClient orderServiceClient;
    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    @Override
    public List<SearchCustomerResponse> search(SearchCustomerRequest request) {
      /*  var result = webClient.build()
                .get()
                .uri("htttp://localhost:8079/api/orders?orderId="+request.getOrderNumber())
                .retrieve()
                .bodyToMono(Integer.class)
                .block(); // async durumu sync hale getiren fonkk
       */

        int result = orderServiceClient.getCustomerIdByOrderId(request.getOrderNumber());

        if (customerRepository.search(request).isEmpty()){
            throw new BusinessException("No customer found! Would you like to create the customer?");
        }

        return customerRepository.search(request);
    }

    @Override
    public void add(AddCustomerRequest request) {
        Customer customer = CustomerMapper.INSTANCE.customerFromAddRequest(request);

        customerRepository.save(customer);
    }


}
