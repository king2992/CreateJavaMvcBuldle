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

import nrf.ufsp.bizCommMng.domain.BizteamCostTemp;
import nrf.ufsp.bizCommMng.domain.BizteamCostTempRepository;
import nrf.ufsp.bizCommMng.dto.BizteamCostTempDto;
import nrf.ufsp.bizCommMng.dto.BizteamCostTempSearchDto;
import nrf.ufsp.bizCommMng.mapper.BizteamCostTempMapper;


/**
 * @author : 이진우
 * @version : 1.0
 * @Class Name : BizteamCostTempService
 * Description : 포뮬러가배정액 서비스 클래스
 * @Since : 2023-04-12
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
public class BizteamCostTempService {
    private final ModelMapper modelMapper;
    private final BizteamCostTempRepository bizteamCostTempRepository;

    private final BizteamCostTempMapper bizteamCostTempMapper;
    /**
     * 포뮬러가배정액를 등록한다.
     * @param bizteamCostTempSaveDto
     * @return BizteamCostTemp ( 포뮬러가배정액)
     * @exception
     */
    @Transactional
    public  ResultStatus<BizteamCostTemp> bizteamCostTempRegistExec(BizteamCostTempDto bizteamCostTempSaveDto) {
        Timestamp nowTimeStamp = Timestamp.valueOf(LocalDateTime.now());

        BizteamCostTemp bizteamCostTemp = modelMapper.map(bizteamCostTempSaveDto, BizteamCostTemp.class);

        BizteamCostTemp savedBizteamCostTemp = bizteamCostTempRepository.save(bizteamCostTemp);

        ResultStatus<BizteamCostTemp> resultStatus = ResultStatus.<BizteamCostTemp>builder()
                .status(StatusEnum.SUCCESS)
                .message("저장이 완료되었습니다.")
                .resultData(savedBizteamCostTemp).build();
        
        return resultStatus;

    }

    /**
     * 포뮬러가배정액 수정
     * @param jobId : 업무ID
     * @param bizteamCostTempSaveDto : 입력된 포뮬러가배정액
     * @return BizteamCostTempDto (변경된 포뮬러가배정액)
     * @exception IllegalArgumentException
     */
    @Transactional
    public ResultStatus<BizteamCostTemp> bizteamCostTempUpdtExec(String jobId, BizteamCostTempDto bizteamCostTempSaveDto) {
        Timestamp nowTimeStamp = Timestamp.valueOf(LocalDateTime.now());

        BizteamCostTemp bizteamCostTemp = bizteamCostTempRepository.findById(jobId)
                .orElseThrow(() -> new IllegalArgumentException("등록된 정보가 없습니다."));

        bizteamCostTempSaveDto.setLastModDt(nowTimeStamp);

        modelMapper.map(bizteamCostTempSaveDto, bizteamCostTemp);
        modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
          
        BizteamCostTemp savedBizteamCostTemp = bizteamCostTempRepository.save(bizteamCostTemp);

        ResultStatus<BizteamCostTemp> resultStatus = ResultStatus.<BizteamCostTemp>builder()
        .status(StatusEnum.SUCCESS)
        .message("수정이 완료되었습니다.")
        .resultData(savedBizteamCostTemp).build();          

        return resultStatus;
    }

    /**
     * 포뮬러가배정액 삭제
     * @param jobId : 업무ID
     * @return 삭제된 행의 키값
     * @exception IllegalArgumentException
     */
    @Transactional
    public ResultStatus<BizteamCostTemp> bizteamCostTempDeleteExec(String jobId) {
        BizteamCostTemp bizteamCostTemp = bizteamCostTempRepository.findById(jobId)
                .orElseThrow(()->new IllegalArgumentException("등록된 정보가 없습니다."));
        bizteamCostTempRepository.delete(bizteamCostTemp);
        
        ResultStatus<BizteamCostTemp> resultStatus = ResultStatus.<BizteamCostTemp>builder()
            .status(StatusEnum.SUCCESS)
            .message("삭제가 완료되었습니다.")
            .resultData("리턴 데이터 넣어주세요.").build();  
        
        return resultStatus;
    }
    
    /**
     * 포뮬러가배정액 목록 조회(검색)
     * @param bizteamCostTempSearchDto : 검색 DTO
     * @return 목록 Json Data
     * @exception JsonProcessingException
     */
    public ResultStatus<String> getBizteamCostTempSearchList(BizteamCostTempSearchDto bizteamCostTempSearchDto) {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> data = new HashMap<String, Object>();

        int totalCount = bizteamCostTempMapper.getBizteamCostTempSearchListCount(bizteamCostTempSearchDto);

        Paging paging = new Paging(bizteamCostTempSearchDto.getCurrentPage(), bizteamCostTempSearchDto.getPageSize(), totalCount);

        data.put("bizteamCostTempList", bizteamCostTempMapper.getBizteamCostTempSearchList(bizteamCostTempSearchDto));
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
