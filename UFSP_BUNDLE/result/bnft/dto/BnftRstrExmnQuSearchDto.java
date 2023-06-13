import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : 이진우
 * @version : 1.0
 * @Class Name : BnftRstrExmnQuSearchDto
 * Description : BnftRstrExmnQu 검색 DTO 클래스
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
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BnftRstrExmnQuSearchDto {
    private int currentPage;
    private int pageSize;
}
