import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import nrf.ufsp.common.Paging;
import nrf.ufsp.support.ResultStatus;
import nrf.ufsp.support.StatusEnum;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import nrf.ufsp.agrm.domain.AgrmSignTrgt;
import nrf.ufsp.agrm.domain.AgrmSignTrgtRepository;
import nrf.ufsp.agrm.dto.AgrmSignTrgtDto;
import nrf.ufsp.agrm.dto.AgrmSignTrgtSearchDto;
import nrf.ufsp.agrm.mapper.AgrmSignTrgtMapper;


/**
 * @author : 이진우
 * @version : 1.0
 * @Class Name : AgrmSignTrgtService
 * Description : 협약서명대상 서비스 클래스
 * @Since : 2023-05-13
 * @see <pre>
 * ------------------------------------------------------------
 * Modification Information
 * ------------------------------------------------------------
 * 수정일        수정자               수정내용
 *
 * ------------------------------------------------------------
 * </pre>
 */
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class AgrmSignTrgtService {
    private final ModelMapper modelMapper;
    private final AgrmSignTrgtRepository agrmSignTrgtRepository;

    private final AgrmSignTrgtMapper agrmSignTrgtMapper;
    /**
     * 협약서명대상를 등록한다.
     * @param agrmSignTrgtSaveDto
     * @return AgrmSignTrgt ( 협약서명대상)
     * @exception
     */
    @Transactional
    public  ResultStatus<AgrmSignTrgt> agrmSignTrgtRegistExec(AgrmSignTrgtDto agrmSignTrgtSaveDto) {
        Timestamp nowTimeStamp = Timestamp.valueOf(LocalDateTime.now());

        AgrmSignTrgt agrmSignTrgt = modelMapper.map(agrmSignTrgtSaveDto, AgrmSignTrgt.class);

        AgrmSignTrgt savedAgrmSignTrgt = agrmSignTrgtRepository.save(agrmSignTrgt);

        ResultStatus<AgrmSignTrgt> resultStatus = ResultStatus.<AgrmSignTrgt>builder()
                .status(StatusEnum.SUCCESS)
                .message("저장이 완료되었습니다.")
                .resultData(savedAgrmSignTrgt).build();
        
        return resultStatus;

    }

    /**
     * 협약서명대상 수정
     * @param agrmId : 협약ID
     * @param agrmSignTrgtSaveDto : 입력된 협약서명대상
     * @return AgrmSignTrgtDto (변경된 협약서명대상)
     * @exception IllegalArgumentException
     */
    @Transactional
    public ResultStatus<AgrmSignTrgt> agrmSignTrgtUpdtExec(String agrmId, AgrmSignTrgtDto agrmSignTrgtSaveDto) {
        Timestamp nowTimeStamp = Timestamp.valueOf(LocalDateTime.now());

        AgrmSignTrgt agrmSignTrgt = agrmSignTrgtRepository.findById(agrmId)
                .orElseThrow(() -> new IllegalArgumentException("등록된 정보가 없습니다."));

        agrmSignTrgtSaveDto.setLastModDt(nowTimeStamp);

        modelMapper.map(agrmSignTrgtSaveDto, agrmSignTrgt);
        modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
          
        AgrmSignTrgt savedAgrmSignTrgt = agrmSignTrgtRepository.save(agrmSignTrgt);

        ResultStatus<AgrmSignTrgt> resultStatus = ResultStatus.<AgrmSignTrgt>builder()
        .status(StatusEnum.SUCCESS)
        .message("수정이 완료되었습니다.")
        .resultData(savedAgrmSignTrgt).build();          

        return resultStatus;
    }

    /**
     * 협약서명대상 삭제
     * @param agrmId : 협약ID
     * @return 삭제된 행의 키값
     * @exception IllegalArgumentException
     */
    @Transactional
    public ResultStatus<AgrmSignTrgt> agrmSignTrgtDeleteExec(String agrmId) {
        AgrmSignTrgt agrmSignTrgt = agrmSignTrgtRepository.findById(agrmId)
                .orElseThrow(()->new IllegalArgumentException("등록된 정보가 없습니다."));
        agrmSignTrgtRepository.delete(agrmSignTrgt);
        
        ResultStatus<AgrmSignTrgt> resultStatus = ResultStatus.<AgrmSignTrgt>builder()
            .status(StatusEnum.SUCCESS)
            .message("삭제가 완료되었습니다.")
            .resultData("리턴 데이터 넣어주세요.").build();  
        
        return resultStatus;
    }
    
    /**
     * 협약서명대상 목록 조회(검색)
     * @param agrmSignTrgtSearchDto : 검색 DTO
     * @return 목록 Json Data
     * @exception JsonProcessingException
     */
    public ResultStatus<String> getAgrmSignTrgtSearchList(AgrmSignTrgtSearchDto agrmSignTrgtSearchDto) {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> data = new HashMap<String, Object>();

        int totalCount = agrmSignTrgtMapper.getAgrmSignTrgtSearchListCount(agrmSignTrgtSearchDto);

        Paging paging = new Paging(agrmSignTrgtSearchDto.getCurrentPage(), agrmSignTrgtSearchDto.getPageSize(), totalCount);

        data.put("agrmSignTrgtList", agrmSignTrgtMapper.getAgrmSignTrgtSearchList(agrmSignTrgtSearchDto));
        data.put("pageable",paging);

        String jsonList = null;
        try {
            jsonList = mapper.writeValueAsString(data);
        } catch (JsonProcessingException e) {

        }
        ResultStatus<String> resultStatus = ResultStatus.<String>builder()
            .status(StatusEnum.SUCCESS)
            .message("조회완료.")
            .resultData(jsonList).build();  
        
        return resultStatus;
    }
}
