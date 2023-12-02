package com.festival.festival.service;

import com.festival.festival.dto.NoticeDTO;
import com.festival.festival.dto.PageRequestDTO;
import com.festival.festival.dto.PageResultDTO;
import com.festival.festival.entity.Notice;
import com.festival.festival.repository.NoticeRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;

@Service
@Log4j2
@RequiredArgsConstructor
@Transactional
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    private final NoticeRepository noticeRepository;

    @Override
    public NoticeDTO read(Long idx) {
        Optional<Notice> result = noticeRepository.findById(idx);

        return result.isPresent()? entityToDto(result.get()): null;
    }

    @Override
    public Long join(NoticeDTO dto, MultipartFile file) throws IOException {
        /*우리의 프로젝트경로를 담아주게 된다 - 저장할 경로를 지정*/
        // 윈도우 경로
//        String projectPath = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\files";
        // 맥북 경로
        String projectPath = System.getProperty("user.dir") + "/src/main/resources/static/files/";

        /*식별자 . 랜덤으로 이름 만들어줌*/
        UUID uuid = UUID.randomUUID();

        /*랜덤식별자_원래파일이름 = 저장될 파일이름 지정*/
        String fileName = uuid + "_" + file.getOriginalFilename();

        /*빈 껍데기 생성*/
        /*File을 생성할건데, 이름은 "name" 으로할거고, projectPath 라는 경로에 담긴다는 뜻*/
        File saveFile = new File(projectPath, fileName);

        file.transferTo(saveFile);

        /*디비에 파일 넣기*/
        dto.setFilename(fileName);
        /*저장되는 경로*/
        dto.setFilepath("/files/" + fileName); /*저장된파일의이름,저장된파일의경로*/

        log.info("회원가입정보DTO: "+dto);

        Notice entity = dtoToEntity(dto);

        log.info("회원가입정보entity: " + entity);

        noticeRepository.save(entity);

        return entity.getIdx();
    }

    @Override
    public PageResultDTO<NoticeDTO, Notice> getList(PageRequestDTO requestDTO) {
        Pageable pageable = requestDTO.getPageable(Sort.by("idx").descending());
        Page<Notice> result = noticeRepository.findAll( pageable);
        Function<Notice, NoticeDTO> fn = (entity -> entityToDto(entity));
        return new PageResultDTO<>(result, fn );
    }

    @Override
    public Long count() {
        long count = noticeRepository.count();
        return count;
    }

    @Override
    public void insertNotice(Notice notice)
        {

            noticeRepository.save(notice);
    }

    @Override
    public void deleteNotice(Long idx){

        noticeRepository.deleteById(idx);
    }


    public void modifyNotice(NoticeDTO dto){
        noticeRepository.modifyById(dto);
    }

}
