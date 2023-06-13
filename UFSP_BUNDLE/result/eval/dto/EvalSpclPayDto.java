
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
 * @Class Name : EvalSpclPayDto
 * Description : 평가전문가수당정보  DTO 클래스
 * @Since : 2023-04-17
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
public class EvalSpclPayDto extends CommDto{

    // Ctrl + ALT + L 누르면 자동 정렬
    /** 업무ID */private String jobId;/** 평가ID */private BigDecimal evalId;/** 전문가풀고유ID */private String spclPoolUniqId;/** 지급번호 */private String payNo;/** 동의서약여부 */private String pldgAgreYn;/** 동의서약일시 */private Timestamp pldgDt;/** 평가시작일시 */private String evalStrDt;/** 평가종료일시 */private String evalEndDt;/** 평가일수 */private BigDecimal evalDayCnt;/** 은행코드 */private String bankCd;/** 계좌번호 */private String accntNo;/** 계좌예금주 */private String accntDpstr;/** 수당금액 */private BigDecimal payAmt;/** 패널장수당 */private BigDecimal pannLdrFee;/** 여비지급액 */private BigDecimal travCostPay;/** 지급금합계 */private BigDecimal paySum;/** 최초등록자ID */private String frstRegId;/** 최초등록일자 */private Timestamp frstRegDt;/** 최종수정자ID */private String lastModId;/** 최종수정일자 */private Timestamp lastModDt;

}
