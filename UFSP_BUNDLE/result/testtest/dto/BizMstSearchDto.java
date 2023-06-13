import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : 이진우
 * @version : 1.0
 * @Class Name : BizMstSearchDto
 * Description : BizMst 검색 DTO 클래스
 * @Since : 2023-06-13
 * @see <pre>
 * ------------------------------------------------------------
 * Modification Information
 * ------------------------------------------------------------
 * 수정일        수정자               수정내용
 *
 * ------------------------------------------------------------
 * </pre>
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BizMstSearchDto {
    private int currentPage;
    private int pageSize;
}
