package com.festival.festival.service;

import com.festival.festival.dto.ExpDTO;
import com.festival.festival.dto.PageRequestDTO;
import com.festival.festival.dto.PageResultDTO;
import com.festival.festival.entity.Exp;
import com.festival.festival.entity.Festival;
import com.festival.festival.repository.ExpRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
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
public class ExpServiceImpl implements ExpService {

        private final ExpRepository expRepository;

        public PageResultDTO<ExpDTO, Exp> getList(PageRequestDTO requestDTO){
            Pageable pageable = requestDTO.getPageable(Sort.by("idx").descending());
            Page<Exp> result = expRepository.findAll((pageable));
            Function<Exp, ExpDTO> fn = (entity -> entityToDto(entity));
            return new PageResultDTO<>(result, fn);

        }

    @Override
    public List<Exp> getList(String zone) {
        List<Exp> dto = null;
        if (zone.equals("전체")) {
            dto = expRepository.findAll(Sort.by(Sort.Direction.DESC, "idx"));
        }
        else {
            dto = expRepository.getAllByZone(zone);
        }
        return dto;
    }

    @Override
    public Long update(Long idx, ExpDTO dto, MultipartFile file) throws IOException {
//        String projectPath = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\files\\exp";
        // 맥북 경로
        String projectPath = System.getProperty("user.dir") + "/src/main/resources/static/files/exp";
        String fileName;
        File saveFile;

        // 기존 파일이 있을 경우 삭제
        Exp existingFestival = expRepository.findById(idx).orElse(null);
        if (existingFestival != null && existingFestival.getFilename() != null) {
            File oldFile = new File(projectPath + existingFestival.getFilepath());
            if (oldFile.exists()) {
                oldFile.delete();
            }
        }

        // 새 파일 업로드
        UUID uuid = UUID.randomUUID();
        fileName = uuid + "_" + file.getOriginalFilename();
        saveFile = new File(projectPath, fileName);
        file.transferTo(saveFile);

        // DTO 업데이트
        dto.setFilename(fileName);
        dto.setFilepath("/files/exp/" + fileName);

        // 엔티티 업데이트
        Exp entity = dtoToEntity(dto);
        entity.setIdx(idx); // 기존 엔티티의 ID를 유지하기 위해 설정

        expRepository.modifyById(dto);

        return dto.getIdx();
    }

    @Override
    public void modifyCount(Long count, Long idx) {
        expRepository.modifyCount(count, idx);
    }

    @Override
    public Long count() {
        Long userCount = expRepository.count();

        return userCount;
    }

    @Override
    public Long join(ExpDTO dto, MultipartFile file) throws IOException {
        /*우리의 프로젝트경로를 담아주게 된다 - 저장할 경로를 지정*/
//        String projectPath = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\files\\exp";
        // 맥북 경로
        String projectPath = System.getProperty("user.dir") + "/src/main/resources/static/files/exp";

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

        Exp entity = dtoToEntity(dto);

        log.info("회원가입정보entity: " + entity);

        expRepository.save(entity);

        return entity.getIdx();
    }

    @Override
        public ExpDTO read(Long idx) {
            Optional<Exp> result = expRepository.findById(idx);

            return result.isPresent()? entityToDto(result.get()): null;
        }

        @Override
        public void insertExp(Exp exp) {

            expRepository.save(exp);
        }

        @Override
        public void deleteExp(Long idx) {

            expRepository.deleteById(idx);
        }

        @Override
        public void modifyExp(ExpDTO dto){
            expRepository.modifyById(dto);
        }

    @Override
    public List<Exp> getTop3List() {
        List<Exp> dto = null;

        dto = expRepository.findTop3ByOrderByIdDesc();

        return dto;
    }


}
