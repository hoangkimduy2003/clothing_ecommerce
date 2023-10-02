package com.duyhk.clothing_ecommerce.service.iplm;

import com.duyhk.clothing_ecommerce.dto.*;
import com.duyhk.clothing_ecommerce.entity.CategoryDetail;
import com.duyhk.clothing_ecommerce.reponsitory.CategoryDetailReponsitory;
import com.duyhk.clothing_ecommerce.service.CategoryDetailService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryDetailServiceIplm implements CategoryDetailService {

    @Autowired
    private CategoryDetailReponsitory categoryRepo;

    @Override
    public CategoryDetail convertToEntity(CategoryDetailDTO categoryDetail) {
        return new ModelMapper().map(categoryDetail, CategoryDetail.class);
    }

    @Override
    public CategoryDetailDTO convertToDto(CategoryDetail categoryDetail) {
        return new ModelMapper().map(categoryDetail, CategoryDetailDTO.class);
    }

    @Override
    public List<CategoryDetailDTO> getAll() {
        return categoryRepo.findAll().stream().map(u -> convertToDto(u)).collect(Collectors.toList());
    }

    @Override
    public PageDTO<List<CategoryDetailDTO>> getByPageRequest(PageRequestDTO pageRequestDTO) {
        pageRequestDTO.setPage(pageRequestDTO.getPage() == null ? 0 : pageRequestDTO.getPage());
        pageRequestDTO.setSize(pageRequestDTO.getSize() == null ? 5 : pageRequestDTO.getSize());
        Page<CategoryDetail> pageEntity = categoryRepo.findAll(
                PageRequest.of(
                        pageRequestDTO.getPage(),
                        pageRequestDTO.getSize()));
        List<CategoryDetailDTO> listDto = pageEntity.get().map(a -> convertToDto(a)).collect(Collectors.toList());
        return PageDTO.<List<CategoryDetailDTO>>builder()
                .data(listDto)
                .totalElements(pageEntity.getTotalElements())
                .totalPages(pageEntity.getTotalPages())
                .build();
    }

    @Override
    public CategoryDetailDTO getById(Long id) {
        return convertToDto(categoryRepo.findById(id).orElseThrow(IllegalArgumentException::new));
    }

    @Override
    public void create(CategoryDetailDTO categoryDetail) {
        categoryRepo.save(convertToEntity(categoryDetail));
    }

    @Override
    public void update(CategoryDetailDTO categoryDTO) {
        CategoryDetail categoryDetail = categoryRepo.findById(categoryDTO.getId()).orElseThrow(IllegalArgumentException::new);
        if (categoryDetail != null) {
            categoryDetail = convertToEntity(categoryDTO);
            categoryRepo.save(categoryDetail);
        }

    }

    @Override
    public void delete(Long id) {
        CategoryDetail categoryDetail = categoryRepo.findById(id).orElseThrow(IllegalArgumentException::new);
        if (categoryDetail != null) {
            categoryRepo.deleteById(id);
        }
    }
}
