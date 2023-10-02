package com.duyhk.clothing_ecommerce.service.iplm;

import com.duyhk.clothing_ecommerce.dto.PageDTO;
import com.duyhk.clothing_ecommerce.dto.PageRequestDTO;
import com.duyhk.clothing_ecommerce.dto.UserDTO;
import com.duyhk.clothing_ecommerce.entity.Users;
import com.duyhk.clothing_ecommerce.reponsitory.UserReponsitory;
import com.duyhk.clothing_ecommerce.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceIplm implements UserService, UserDetailsService {
    @Autowired
    private UserReponsitory userRepo;

    @Override
    public Users convertToEntity(UserDTO userDTO) {
        return new ModelMapper().map(userDTO, Users.class);
    }

    @Override
    public UserDTO convertToDto(Users user) {
        return new ModelMapper().map(user, UserDTO.class);
    }

    @Override
    public List<UserDTO> getAll() {
        return userRepo.findAll().stream().map(u -> convertToDto(u)).collect(Collectors.toList());
    }

    @Override
    public PageDTO<List<UserDTO>> getByPageRequest(PageRequestDTO pageRequestDTO) {
        pageRequestDTO.setPage(pageRequestDTO.getPage() == null ? 0 : pageRequestDTO.getPage());
        pageRequestDTO.setSize(pageRequestDTO.getSize() == null ? 5 : pageRequestDTO.getSize());
        Page<Users> pageEntity = userRepo.findAll(
                PageRequest.of(
                        pageRequestDTO.getPage(),
                        pageRequestDTO.getSize()));
        List<UserDTO> listDto = pageEntity.get().map(a -> convertToDto(a)).collect(Collectors.toList());
        return PageDTO.<List<UserDTO>>builder()
                .data(listDto)
                .totalElements(pageEntity.getTotalElements())
                .totalPages(pageEntity.getTotalPages())
                .build();
    }

    @Override
    public UserDTO getById(Long id) {
        return convertToDto(userRepo.findById(id).orElseThrow(IllegalArgumentException::new));
    }

    @Override
    public Users findByEmail(String email) {
        return userRepo.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    @Override
    public void create(UserDTO userDTO) {
        Users users = convertToEntity(userDTO);
        users.setPassword(new BCryptPasswordEncoder().encode(userDTO.getPassword()));
        userRepo.save(users);
    }

    @Override
    public void update(UserDTO userDTO) {
        Users user = userRepo.findById(userDTO.getId()).orElseThrow(IllegalArgumentException::new);
        if (user != null) {
            user = convertToEntity(userDTO);
            userRepo.save(user);
        }

    }

    @Override
    public void delete(Long id) {
        Users user = userRepo.findById(id).orElseThrow(IllegalArgumentException::new);
        if (user != null) {
            userRepo.deleteById(id);
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepo.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}
