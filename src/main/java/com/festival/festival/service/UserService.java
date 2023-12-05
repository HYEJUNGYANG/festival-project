package com.festival.festival.service;


import com.festival.festival.dto.UserDTO;
import com.festival.festival.dto.PageRequestDTO;
import com.festival.festival.dto.PageResultDTO;
import com.festival.festival.entity.User;

public interface UserService {
    UserDTO read(String id);
    PageResultDTO<UserDTO, User> getList(PageRequestDTO requestDTO);
    Long count();

    default User dtoToEntity(UserDTO dto) {
        User entity = User.builder()
                .id(dto.getId())
                .pw(dto.getPw())
                .name(dto.getName())
                .nick(dto.getNick())
                .gender(dto.getGender())
                .tel(dto.getTel())
                .birth(dto.getBirth())
                .join_date(dto.getJoin_date())
                .build();
        return entity;
    }

    //entity -> dto 변환
    default UserDTO entityToDto(User entity) {
        UserDTO dto = UserDTO.builder()
                .id(entity.getId())
                .pw(entity.getPw())
                .name(entity.getName())
                .nick(entity.getNick())
                .gender(entity.getGender())
                .tel(entity.getTel())
                .birth(entity.getBirth())
                .join_date(entity.getJoin_date())
                .build();
        return dto;
    }

    void modify_nick_tel(String id, String nick, String tel);

}
