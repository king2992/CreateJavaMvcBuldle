
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * @author : 이진우
 * @version : 1.0
 * @Class Name : BizteamCostTempMapper
 * Description : 포뮬러가배정액 Mapper 클래스
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
@Mapper
@Repository
public interface BizteamCostTempMapper {
    List<BizteamCostTempDto> getBizteamCostTempSearchList(BizteamCostTempSearchDto bizteamCostTempSearchDto);
    int getBizteamCostTempSearchListCount(BizteamCostTempSearchDto bizteamCostTempSearchDto);
}
