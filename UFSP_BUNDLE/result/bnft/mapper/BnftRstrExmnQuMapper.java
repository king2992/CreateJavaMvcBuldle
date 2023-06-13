
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * @author : 이진우
 * @version : 1.0
 * @Class Name : BnftRstrExmnQuMapper
 * Description : 수혜제한조사분기 Mapper 클래스
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
@Mapper
@Repository
public interface BnftRstrExmnQuMapper {
    List<BnftRstrExmnQuDto> getBnftRstrExmnQuSearchList(BnftRstrExmnQuSearchDto bnftRstrExmnQuSearchDto);
    int getBnftRstrExmnQuSearchListCount(BnftRstrExmnQuSearchDto bnftRstrExmnQuSearchDto);
}
