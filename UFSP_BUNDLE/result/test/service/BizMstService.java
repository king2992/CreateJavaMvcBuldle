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

import nrf.ufsp.test.domain.BizMst;
import nrf.ufsp.test.domain.BizMstRepository;
import nrf.ufsp.test.dto.BizMstDto;
import nrf.ufsp.test.dto.BizMstSearchDto;
import nrf.ufsp.test.mapper.BizMstMapper;


/**
 * @author : 이진우
 * @version : 1.0
 * @Class Name : BizMstService
 * Description : 사업마스터 서비스 클래스
 * @Since : 2023-05-30
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
public class BizMstService {
    private final ModelMapper modelMapper;
    private final BizMstRepository bizMstRepository;

    private final BizMstMapper bizMstMapper;
    /**
     * 사업마스터를 등록한다.
     * @param bizMstSaveDto
     * @return BizMst ( 사업마스터)
     * @exception
     */
    @Transactional
    public  ResultStatus<BizMst> bizMstRegistExec(BizMstDto bizMstSaveDto) {
        Timestamp nowTimeStamp = Timestamp.valueOf(LocalDateTime.now());

        BizMst bizMst = modelMapper.map(bizMstSaveDto, BizMst.class);

        BizMst savedBizMst = bizMstRepository.save(bizMst);

        ResultStatus<BizMst> resultStatus = ResultStatus.<BizMst>builder()
                .status(StatusEnum.SUCCESS)
                .message("저장이 완료되었습니다.")
                .resultData(savedBizMst).build();
        
        return resultStatus;

    }

    /**
     * 사업마스터 수정
     * @param bizCd : 사업코드
     * @param bizMstSaveDto : 입력된 사업마스터
     * @return BizMstDto (변경된 사업마스터)
     * @exception IllegalArgumentException
     */
    @Transactional
    public ResultStatus<BizMst> bizMstUpdtExec(String bizCd, BizMstDto bizMstSaveDto) {
        Timestamp nowTimeStamp = Timestamp.valueOf(LocalDateTime.now());

        BizMst bizMst = bizMstRepository.findById(bizCd)
                .orElseThrow(() -> new IllegalArgumentException("등록된 정보가 없습니다."));

        bizMstSaveDto.setLastModDt(nowTimeStamp);

        modelMapper.map(bizMstSaveDto, bizMst);
        modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
          
        BizMst savedBizMst = bizMstRepository.save(bizMst);

        ResultStatus<BizMst> resultStatus = ResultStatus.<BizMst>builder()
        .status(StatusEnum.SUCCESS)
        .message("수정이 완료되었습니다.")
        .resultData(savedBizMst).build();          

        return resultStatus;
    }

    /**
     * 사업마스터 삭제
     * @param bizCd : 사업코드
     * @return 삭제된 행의 키값
     * @exception IllegalArgumentException
     */
    @Transactional
    public ResultStatus<BizMst> bizMstDeleteExec(String bizCd) {
        BizMst bizMst = bizMstRepository.findById(bizCd)
                .orElseThrow(()->new IllegalArgumentException("등록된 정보가 없습니다."));
        bizMstRepository.delete(bizMst);
        
        ResultStatus<BizMst> resultStatus = ResultStatus.<BizMst>builder()
            .status(StatusEnum.SUCCESS)
            .message("삭제가 완료되었습니다.")
            .resultData("리턴 데이터 넣어주세요.").build();  
        
        return resultStatus;
    }
    
    /**
     * 사업마스터 목록 조회(검색)
     * @param bizMstSearchDto : 검색 DTO
     * @return 목록 Json Data
     * @exception JsonProcessingException
     */
    public ResultStatus<String> getBizMstSearchList(BizMstSearchDto bizMstSearchDto) {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> data = new HashMap<String, Object>();

        int totalCount = bizMstMapper.getBizMstSearchListCount(bizMstSearchDto);

        Paging paging = new Paging(bizMstSearchDto.getCurrentPage(), bizMstSearchDto.getPageSize(), totalCount);

        data.put("bizMstList", bizMstMapper.getBizMstSearchList(bizMstSearchDto));
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
