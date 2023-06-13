
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * @author : 이진우
 * @version : 1.0
 * @Class Name : AgrmSignTrgtMapper
 * Description : 협약서명대상 Mapper 클래스
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
@Mapper
@Repository
public interface AgrmSignTrgtMapper {
    List<AgrmSignTrgtDto> getAgrmSignTrgtSearchList(AgrmSignTrgtSearchDto agrmSignTrgtSearchDto);
    int getAgrmSignTrgtSearchListCount(AgrmSignTrgtSearchDto agrmSignTrgtSearchDto);
}
