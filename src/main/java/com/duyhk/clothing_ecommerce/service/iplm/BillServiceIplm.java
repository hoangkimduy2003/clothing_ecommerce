package com.duyhk.clothing_ecommerce.service.iplm;

import com.duyhk.clothing_ecommerce.dto.BillDTO;
import com.duyhk.clothing_ecommerce.dto.ColorDTO;
import com.duyhk.clothing_ecommerce.dto.PageDTO;
import com.duyhk.clothing_ecommerce.dto.PageRequestDTO;
import com.duyhk.clothing_ecommerce.entity.Bill;
import com.duyhk.clothing_ecommerce.entity.Color;
import com.duyhk.clothing_ecommerce.reponsitory.BillReponsitory;
import com.duyhk.clothing_ecommerce.service.BillService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BillServiceIplm implements BillService {
    @Autowired
    private BillReponsitory billReponsitory;

    @Override
    public Bill convertToEntity(BillDTO billDTO) {
        return new ModelMapper().map(billDTO,Bill.class);
    }

    @Override
    public BillDTO convertToDto(Bill bill) {
        return new ModelMapper().map(bill,BillDTO.class);
    }

    @Override
    public PageDTO<List<BillDTO>> getAll(PageRequestDTO pageRequestDTO) {
        pageRequestDTO.setPage(pageRequestDTO.getPage() == null ? 0 : pageRequestDTO.getPage());
        pageRequestDTO.setSize(pageRequestDTO.getSize() == null ? 5 : pageRequestDTO.getSize());
        Page<Bill> pageEntity = billReponsitory.findAll(
                PageRequest.of(
                        pageRequestDTO.getPage(),
                        pageRequestDTO.getSize()));
        List<BillDTO> listDto = pageEntity.get().map(a -> convertToDto(a)).collect(Collectors.toList());
        return  PageDTO.<List<BillDTO>>builder()
                .data(listDto)
                .totalElements(pageEntity.getTotalElements())
                .totalPages(pageEntity.getTotalPages())
                .build();
    }

    @Override
    public BillDTO getById(Long id) {
        return convertToDto(billReponsitory.findById(id).orElseThrow(IllegalArgumentException::new));
    }

    @Override
    public void create(BillDTO billDTO) {
        billReponsitory.save(convertToEntity(billDTO));
    }

    @Override
    public void update(BillDTO billDTO) {
        Bill bill = billReponsitory.findById(billDTO.getId()).orElseThrow(IllegalArgumentException::new);
        if (bill != null) {
            bill = convertToEntity(billDTO);
            billReponsitory.save(bill);
        }

    }

    @Override
    public void delete(Long id) {
        Bill bill = billReponsitory.findById(id).orElseThrow(IllegalArgumentException::new);
        if (bill != null) {
            billReponsitory.deleteById(id);
        }
    }
}
