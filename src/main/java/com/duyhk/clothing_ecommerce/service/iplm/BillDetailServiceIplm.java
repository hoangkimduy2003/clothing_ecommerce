package com.duyhk.clothing_ecommerce.service.iplm;

import com.duyhk.clothing_ecommerce.dto.BillDTO;
import com.duyhk.clothing_ecommerce.dto.BillDetailDTO;
import com.duyhk.clothing_ecommerce.dto.PageDTO;
import com.duyhk.clothing_ecommerce.dto.PageRequestDTO;
import com.duyhk.clothing_ecommerce.entity.BillDetail;
import com.duyhk.clothing_ecommerce.reponsitory.BillDetailReponsitory;
import com.duyhk.clothing_ecommerce.service.BillDetailService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BillDetailServiceIplm implements BillDetailService {
    @Autowired
    private BillDetailReponsitory billDetailReponsitory;

    @Override
    public BillDetail convertToEntity(BillDetailDTO billDetailDTO) {
        return new ModelMapper().map(billDetailDTO, BillDetail.class);
    }

    @Override
    public BillDetailDTO convertToDto(BillDetail billDetail) {
        return new ModelMapper().map(billDetail, BillDetailDTO.class);
    }
    @Override
    public List<BillDetailDTO> getAll() {
        return billDetailReponsitory.findAll().stream().map(u -> convertToDto(u)).collect(Collectors.toList());
    }
    @Override
    public PageDTO<List<BillDetailDTO>> getByPageRequest(PageRequestDTO pageRequestDTO) {
        pageRequestDTO.setPage(pageRequestDTO.getPage() == null ? 0 : pageRequestDTO.getPage());
        pageRequestDTO.setSize(pageRequestDTO.getSize() == null ? 5 : pageRequestDTO.getSize());
        Page<BillDetail> pageEntity = billDetailReponsitory.findAll(
                PageRequest.of(pageRequestDTO.getPage(),
                        pageRequestDTO.getSize()));
        List<BillDetailDTO> listDto = pageEntity.get().map(b -> convertToDto(b)).collect(Collectors.toList());
        return PageDTO.<List<BillDetailDTO>>builder()
                .data(listDto)
                .totalPages(pageEntity.getTotalPages())
                .totalElements(pageEntity.getTotalElements())
                .build();
    }

    @Override
    public BillDetailDTO getById(Long id) {
        return convertToDto(billDetailReponsitory.findById(id).orElseThrow(IllegalArgumentException::new));
    }

    @Override
    public void create(BillDetailDTO billDetailDTO) {
        billDetailReponsitory.save(convertToEntity(billDetailDTO));
    }

    @Override
    public void update(BillDetailDTO billDetailDTO) {
        BillDetail billDetail = billDetailReponsitory.findById(billDetailDTO.getId()).orElseThrow(IllegalArgumentException::new);
        if (billDetail != null) {
            billDetail = convertToEntity(billDetailDTO);
            billDetailReponsitory.save(billDetail);
        }

    }

    @Override
    public void delete(Long id) {
        BillDetail billDetail = billDetailReponsitory.findById(id).orElseThrow(IllegalArgumentException::new);
        if (billDetail != null) {
            billDetailReponsitory.deleteById(id);
        }
    }
}
