
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * @author : 이진우
 * @version : 1.0
 * @Class Name : BizMstMapper
 * Description : 사업마스터 Mapper 클래스
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
@Mapper
@Repository
public interface BizMstMapper {
    List<BizMstDto> getBizMstSearchList(BizMstSearchDto bizMstSearchDto);
    int getBizMstSearchListCount(BizMstSearchDto bizMstSearchDto);
}
