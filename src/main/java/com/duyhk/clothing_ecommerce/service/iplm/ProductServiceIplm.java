package com.duyhk.clothing_ecommerce.service.iplm;

import com.duyhk.clothing_ecommerce.dto.*;
import com.duyhk.clothing_ecommerce.entity.Product;
import com.duyhk.clothing_ecommerce.entity.ProductDetail;
import com.duyhk.clothing_ecommerce.reponsitory.ProductReponsitory;
import com.duyhk.clothing_ecommerce.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceIplm implements ProductService {
    @Autowired
    private ProductReponsitory productRepo;

    @Override
    public Product convertToEntity(ProductDTO productDTO) {
        return new ModelMapper().map(productDTO,Product.class);
    }

    @Override
    public ProductDTO convertToDto(Product product) {
        return new ModelMapper().map(product,ProductDTO.class);
    }
    @Override
    public List<ProductDTO> getAll() {
        return productRepo.findAll().stream().map(u -> convertToDto(u)).collect(Collectors.toList());
    }
    @Override
    public PageDTO<List<ProductDTO>> getByPageRequest(PageRequestDTO pageRequestDTO) {
        pageRequestDTO.setPage(pageRequestDTO.getPage() == null ? 0 : pageRequestDTO.getPage());
        pageRequestDTO.setSize(pageRequestDTO.getSize() == null ? 5 : pageRequestDTO.getSize());
        Page<Product> pageEntity = productRepo.findAll(
                PageRequest.of(
                        pageRequestDTO.getPage(),
                        pageRequestDTO.getSize()));
        List<ProductDTO> listDto = pageEntity.get().map(a -> convertToDto(a)).collect(Collectors.toList());
        return  PageDTO.<List<ProductDTO>>builder()
                .data(listDto)
                .totalElements(pageEntity.getTotalElements())
                .totalPages(pageEntity.getTotalPages())
                .build();
    }

    @Override
    public ProductDTO getById(Long id) {
        return convertToDto(productRepo.findById(id).orElseThrow(IllegalArgumentException::new));
    }

    @Override
    public void create(ProductDTO productDTO) {
        productRepo.save(convertToEntity(productDTO));
    }

    @Override
    public void update(ProductDTO productDTO) {
        Product product = productRepo.findById(productDTO.getId()).orElseThrow(IllegalArgumentException::new);
        if (product != null) {
            product = convertToEntity(productDTO);
            productRepo.save(product);
        }

    }

    @Override
    public void delete(Long id) {
        Product product = productRepo.findById(id).orElseThrow(IllegalArgumentException::new);
        if (product != null) {
            productRepo.deleteById(id);
        }
    }
}
