package com.festival.festival.service;

import com.festival.festival.dto.PageRequestDTO;
import com.festival.festival.dto.UserDTO;
import com.festival.festival.dto.PageResultDTO;
import com.festival.festival.entity.User;
import com.festival.festival.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.function.Function;

@Service
@Log4j2
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    @Override
    public PageResultDTO<UserDTO, User> getList(PageRequestDTO requestDTO) {
        Pageable pageable = requestDTO.getPageable(Sort.by("id").descending());
        Page<User> result = userRepository.findAll( pageable);
        Function<User, UserDTO> fn = (entity -> entityToDto(entity));
        return new PageResultDTO<>(result, fn );
    }

    @Override
    public UserDTO read(String id) {
        Optional<User> result = userRepository.findById(id);

        return result.isPresent()? entityToDto(result.get()): null;
    }

}
