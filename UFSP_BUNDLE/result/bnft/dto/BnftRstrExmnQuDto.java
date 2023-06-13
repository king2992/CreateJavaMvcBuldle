
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import nrf.ufsp.common.dto.CommDto;
import java.util.Date;

/**
 * @author : 이진우
 * @version : 1.0
 * @Class Name : BnftRstrExmnQuDto
 * Description : 수혜제한조사분기  DTO 클래스
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
@Data
@EqualsAndHashCode(callSuper=false)
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class BnftRstrExmnQuDto extends CommDto{

    // Ctrl + ALT + L 누르면 자동 정렬
    /** 수혜제한ID */private String bnftRstrId;/** 조사년도 */private String exmnYr;/** 조사분기 */private BigDecimal exmnQu;/** 최초등록자ID */private String frstRegId;/** 최초등록일자 */private Timestamp frstRegDt;/** 최종수정자ID */private String lastModId;/** 최종수정일자 */private Timestamp lastModDt;

}
