
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
 * @Class Name : BizteamCostTempDto
 * Description : 포뮬러가배정액  DTO 클래스
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
@Data
@EqualsAndHashCode(callSuper=false)
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class BizteamCostTempDto extends CommDto{

    // Ctrl + ALT + L 누르면 자동 정렬
    /** 업무ID */private String jobId;/** 사업단ID */private String bizteamId;/** 지급차수 */private String payDeg;/** 가배정액 */private BigDecimal tempFund;/** 최초등록자ID */private String frstRegId;/** 최초등록일자 */private Timestamp frstRegDt;/** 최종수정자ID */private String lastModId;/** 최종수정일자 */private Timestamp lastModDt;

}
