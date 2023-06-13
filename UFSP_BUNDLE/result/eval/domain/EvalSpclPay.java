
import lombok.*;
import javax.persistence.*;
import java.util.Date;

import java.sql.Timestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
/**
 * @Class Name : EvalSpclPay
 * Description : 평가전문가수당정보 도메인 객체
 *
 * @author : 이진우
 * @Since : 2023-04-17
 * @version : 1.0
 * @see
 * <pre>
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
@Entity
@Table(name="UFSD_EVAL_SPCL_PAY")
public class EvalSpclPay {
    @EmbeddedId
    private EvalSpclPayPK evalSpclPayPK;
    // Ctrl + ALT + L 누르면 자동 정렬
    /** 업무ID */@Column(nullable = false) private String jobId;/** 평가ID */@Column(nullable = false) private BigDecimal evalId;/** 전문가풀고유ID */@Column(nullable = false) private String spclPoolUniqId;/** 지급번호 */@Column(nullable = false) private String payNo;/** 동의서약여부 */@Column(nullable = false) private String pldgAgreYn;/** 동의서약일시 */@Column(nullable = true) private Timestamp pldgDt;/** 평가시작일시 */@Column(nullable = true) private String evalStrDt;/** 평가종료일시 */@Column(nullable = true) private String evalEndDt;/** 평가일수 */@Column(nullable = true) private BigDecimal evalDayCnt;/** 은행코드 */@Column(nullable = true) private String bankCd;/** 계좌번호 */@Column(nullable = true) private String accntNo;/** 계좌예금주 */@Column(nullable = true) private String accntDpstr;/** 수당금액 */@Column(nullable = true) private BigDecimal payAmt;/** 패널장수당 */@Column(nullable = true) private BigDecimal pannLdrFee;/** 여비지급액 */@Column(nullable = true) private BigDecimal travCostPay;/** 지급금합계 */@Column(nullable = true) private BigDecimal paySum;/** 최초등록자ID */@Column(nullable = true) private String frstRegId;/** 최초등록일자 */@Column(nullable = true)@CreatedDate private Timestamp frstRegDt;/** 최종수정자ID */@Column(nullable = true) private String lastModId;/** 최종수정일자 */@Column(nullable = true)@LastModifiedDate private Timestamp lastModDt;
}
