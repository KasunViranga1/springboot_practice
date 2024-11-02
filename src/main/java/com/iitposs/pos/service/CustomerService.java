package com.iitposs.pos.service;

import com.iitposs.pos.dto.request.CustomerSaveRequestDTO;
import com.iitposs.pos.dto.response.CustomerAllDetailsResponseDto;
import com.iitposs.pos.dto.response.CustomerResponseDTO;

import java.util.List;

public interface CustomerService {
    String saveCustomer(CustomerSaveRequestDTO saveRequestDTO);

    String updateCustomer(CustomerSaveRequestDTO requestDTO);

    CustomerResponseDTO getCustomerById(int customerID);

    List<CustomerResponseDTO> getAllCustomers();


    String deleteCustomer(int customerID);

    List<CustomerAllDetailsResponseDto> getAllCustomerByState(boolean state);
}
