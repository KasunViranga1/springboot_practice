package com.iitposs.pos.service;

import com.iitposs.pos.dto.request.ItemSaveRequestDTO;
import com.iitposs.pos.dto.response.ItemResponseDTO;

import java.util.List;

public interface ItemService {


    List<ItemResponseDTO> getItemByName(String itemName);

    String save(ItemSaveRequestDTO requestDTO);
}
