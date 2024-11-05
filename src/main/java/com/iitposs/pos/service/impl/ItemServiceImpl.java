package com.iitposs.pos.service.impl;

import com.iitposs.pos.dto.request.ItemSaveRequestDTO;
import com.iitposs.pos.dto.response.ItemResponseDTO;
import com.iitposs.pos.entity.Item;
import com.iitposs.pos.repo.ItemRepo;
import com.iitposs.pos.service.ItemService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private ModelMapper modelMapper;



    @Override
    public String save(ItemSaveRequestDTO requestDTO) {
//        Item item = new Item(
//                requestDTO.getItemName(),
//                requestDTO.getMeasuringType(),
//                requestDTO.getSupplierPrice(),
//                requestDTO.getDisplayPrice(),
//                requestDTO.getSellingPrice(),
//                requestDTO.getQtyOnHand(),
//                requestDTO.isActiveState()
//
//        );

//        or
//        Item item = new Item();
//        item.setItemName(requestDTO.getItemName());

//        or use model mapper

        Item item = modelMapper.map(requestDTO, Item.class);


        if(!itemRepo.existsById(item.getItemID())) {
            itemRepo.save(item);
            return "Saved..!";
        } else {
            return "Item already exists!";
        }


    }

    @Override
    public List<ItemResponseDTO> getItemByName(String itemName) {
        List<Item> items = itemRepo.findAllByItemNameEqualsAndActiveStateEquals(itemName, true);

        if(!items.isEmpty()) {
            List<ItemResponseDTO> itemResponseDTOS = modelMapper.map(
                    items, new TypeToken<List<ItemResponseDTO>>() {}.getType()
            );
            return itemResponseDTOS;
        } else {
            return null;
        }
    }
}
