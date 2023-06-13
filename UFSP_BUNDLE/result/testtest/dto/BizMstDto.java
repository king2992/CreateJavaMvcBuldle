
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
 * @Class Name : BizMstDto
 * Description : 사업마스터  DTO 클래스
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
@Data
@EqualsAndHashCode(callSuper=false)
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class BizMstDto extends CommDto{

    // Ctrl + ALT + L 누르면 자동 정렬
    /** 사업코드 */private String bizCd;/** 상위사업코드 */private String upBizCd;/** 사업명 */private String bizNm;/** 사업명 영문 */private String bizNmEng;/** 사업약칭 */private String bizAbb;/** 사업시작일 */private String bizStrYmd;/** 사업종료일 */private String bizEndYmd;/** 사업시작년도 */private String bizStrYr;/** 총사업년수 */private BigDecimal totBizYrs;/** 사업구성미확정여부 */private String bizCmpsCnfrYn;/** 관리부서코드 */private String mngDeptCd;/** 정산대상여부 */private String adjustTrgtYn;/** 사업관리대상여부 */private String bizMngTrgtYn;/** 순서 */private BigDecimal ordr;/** 사용여부 */private String useYn;/** 최초등록자ID */private String frstRegId;/** 최초등록일자 */private Timestamp frstRegDt;/** 최종수정자ID */private String lastModId;/** 최종수정일자 */private Timestamp lastModDt;/** 범주사용여부 */private String catgrUseYn;/** 포털사용여부 */private String portalOpnYn;

}
