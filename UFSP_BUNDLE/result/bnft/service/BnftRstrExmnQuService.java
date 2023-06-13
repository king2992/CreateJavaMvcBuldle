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

import nrf.ufsp.bnft.domain.BnftRstrExmnQu;
import nrf.ufsp.bnft.domain.BnftRstrExmnQuRepository;
import nrf.ufsp.bnft.dto.BnftRstrExmnQuDto;
import nrf.ufsp.bnft.dto.BnftRstrExmnQuSearchDto;
import nrf.ufsp.bnft.mapper.BnftRstrExmnQuMapper;


/**
 * @author : 이진우
 * @version : 1.0
 * @Class Name : BnftRstrExmnQuService
 * Description : 수혜제한조사분기 서비스 클래스
 * @Since : 2023-05-04
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
public class BnftRstrExmnQuService {
    private final ModelMapper modelMapper;
    private final BnftRstrExmnQuRepository bnftRstrExmnQuRepository;

    private final BnftRstrExmnQuMapper bnftRstrExmnQuMapper;
    /**
     * 수혜제한조사분기를 등록한다.
     * @param bnftRstrExmnQuSaveDto
     * @return BnftRstrExmnQu ( 수혜제한조사분기)
     * @exception
     */
    @Transactional
    public  ResultStatus<BnftRstrExmnQu> bnftRstrExmnQuRegistExec(BnftRstrExmnQuDto bnftRstrExmnQuSaveDto) {
        Timestamp nowTimeStamp = Timestamp.valueOf(LocalDateTime.now());

        BnftRstrExmnQu bnftRstrExmnQu = modelMapper.map(bnftRstrExmnQuSaveDto, BnftRstrExmnQu.class);

        BnftRstrExmnQu savedBnftRstrExmnQu = bnftRstrExmnQuRepository.save(bnftRstrExmnQu);

        ResultStatus<BnftRstrExmnQu> resultStatus = ResultStatus.<BnftRstrExmnQu>builder()
                .status(StatusEnum.SUCCESS)
                .message("저장이 완료되었습니다.")
                .resultData(savedBnftRstrExmnQu).build();
        
        return resultStatus;

    }

    /**
     * 수혜제한조사분기 수정
     * @param bnftRstrId : 수혜제한ID
     * @param bnftRstrExmnQuSaveDto : 입력된 수혜제한조사분기
     * @return BnftRstrExmnQuDto (변경된 수혜제한조사분기)
     * @exception IllegalArgumentException
     */
    @Transactional
    public ResultStatus<BnftRstrExmnQu> bnftRstrExmnQuUpdtExec(String bnftRstrId, BnftRstrExmnQuDto bnftRstrExmnQuSaveDto) {
        Timestamp nowTimeStamp = Timestamp.valueOf(LocalDateTime.now());

        BnftRstrExmnQu bnftRstrExmnQu = bnftRstrExmnQuRepository.findById(bnftRstrId)
                .orElseThrow(() -> new IllegalArgumentException("등록된 정보가 없습니다."));

        bnftRstrExmnQuSaveDto.setLastModDt(nowTimeStamp);

        modelMapper.map(bnftRstrExmnQuSaveDto, bnftRstrExmnQu);
        modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
          
        BnftRstrExmnQu savedBnftRstrExmnQu = bnftRstrExmnQuRepository.save(bnftRstrExmnQu);

        ResultStatus<BnftRstrExmnQu> resultStatus = ResultStatus.<BnftRstrExmnQu>builder()
        .status(StatusEnum.SUCCESS)
        .message("수정이 완료되었습니다.")
        .resultData(savedBnftRstrExmnQu).build();          

        return resultStatus;
    }

    /**
     * 수혜제한조사분기 삭제
     * @param bnftRstrId : 수혜제한ID
     * @return 삭제된 행의 키값
     * @exception IllegalArgumentException
     */
    @Transactional
    public ResultStatus<BnftRstrExmnQu> bnftRstrExmnQuDeleteExec(String bnftRstrId) {
        BnftRstrExmnQu bnftRstrExmnQu = bnftRstrExmnQuRepository.findById(bnftRstrId)
                .orElseThrow(()->new IllegalArgumentException("등록된 정보가 없습니다."));
        bnftRstrExmnQuRepository.delete(bnftRstrExmnQu);
        
        ResultStatus<BnftRstrExmnQu> resultStatus = ResultStatus.<BnftRstrExmnQu>builder()
            .status(StatusEnum.SUCCESS)
            .message("삭제가 완료되었습니다.")
            .resultData("리턴 데이터 넣어주세요.").build();  
        
        return resultStatus;
    }
    
    /**
     * 수혜제한조사분기 목록 조회(검색)
     * @param bnftRstrExmnQuSearchDto : 검색 DTO
     * @return 목록 Json Data
     * @exception JsonProcessingException
     */
    public ResultStatus<String> getBnftRstrExmnQuSearchList(BnftRstrExmnQuSearchDto bnftRstrExmnQuSearchDto) {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> data = new HashMap<String, Object>();

        int totalCount = bnftRstrExmnQuMapper.getBnftRstrExmnQuSearchListCount(bnftRstrExmnQuSearchDto);

        Paging paging = new Paging(bnftRstrExmnQuSearchDto.getCurrentPage(), bnftRstrExmnQuSearchDto.getPageSize(), totalCount);

        data.put("bnftRstrExmnQuList", bnftRstrExmnQuMapper.getBnftRstrExmnQuSearchList(bnftRstrExmnQuSearchDto));
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
