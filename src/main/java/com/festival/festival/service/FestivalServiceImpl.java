package com.festival.festival.service;

import com.festival.festival.dto.FestivalDTO;
import com.festival.festival.dto.PageRequestDTO;
import com.festival.festival.dto.PageResultDTO;
import com.festival.festival.entity.Festival;
import com.festival.festival.repository.FestivalRepository;
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
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;

@Service
@Log4j2
@RequiredArgsConstructor
@Transactional
public class FestivalServiceImpl implements FestivalService {

    @Autowired
    private final FestivalRepository festivalRepository;

    // 페이지 필요 없는 LIST 전체 가져오기 (지역별로)
    public List<Festival> getList(String zone) {
        List<Festival> dto = null;
        if (zone.equals("전체")) {
            dto = festivalRepository.findAll(Sort.by(Sort.Direction.DESC, "idx"));
        }
        else {
            dto = festivalRepository.getAllByZone(zone);
        }
        return dto;
    }

    public PageResultDTO<FestivalDTO, Festival> getList(PageRequestDTO requestDTO) {
        Pageable pageable = requestDTO.getPageable(Sort.by("idx").descending());
        Page<Festival> result = festivalRepository.findAll((pageable));
        Function<Festival, FestivalDTO> fn = (entity -> entityToDto(entity));
        return new PageResultDTO<>(result, fn);

    }

    @Override
    public FestivalDTO read(Long idx) {
        Optional<Festival> result = festivalRepository.findById(idx);

        return result.isPresent() ? entityToDto(result.get()) : null;
    }

    @Override
    public void insertFestival(Festival festival) {

        festivalRepository.save(festival);
    }

    public void deleteFestival(Long idx) {

        festivalRepository.deleteById(idx);
    }

    public void modifyFestival(FestivalDTO dto){
        festivalRepository.modifyById(dto.getIdx(), dto);
    }

    @Override
    public Long join(FestivalDTO dto, MultipartFile file) throws IOException {

        /*우리의 프로젝트경로를 담아주게 된다 - 저장할 경로를 지정*/
//        윈도우 경로
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

        Festival entity = dtoToEntity(dto);

        log.info("회원가입정보entity: " + entity);

        festivalRepository.save(entity);

        return entity.getIdx();
    }

}
