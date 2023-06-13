
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
 * @Class Name : AgrmSignTrgtDto
 * Description : 협약서명대상  DTO 클래스
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
@Data
@EqualsAndHashCode(callSuper=false)
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class AgrmSignTrgtDto extends CommDto{

    // Ctrl + ALT + L 누르면 자동 정렬
    /** 협약ID */private String agrmId;/** 협약서명대상CD */private String agrmSignTrgtCd;/** 최초등록자ID */private String frstRegId;/** 최초등록일자 */private Timestamp frstRegDt;

}
