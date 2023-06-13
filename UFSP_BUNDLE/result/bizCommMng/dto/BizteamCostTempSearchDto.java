import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : 이진우
 * @version : 1.0
 * @Class Name : BizteamCostTempSearchDto
 * Description : BizteamCostTemp 검색 DTO 클래스
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
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BizteamCostTempSearchDto {
    private int currentPage;
    private int pageSize;
}
