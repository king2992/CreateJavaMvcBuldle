
import lombok.*;
import javax.persistence.*;
import java.util.Date;

import java.sql.Timestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
/**
 * @Class Name : BizMst
 * Description : 사업마스터 도메인 객체
 *
 * @author : 이진우
 * @Since : 2023-05-30
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
@Table(name="UFSD_BIZ_MST")
public class BizMst {
    @EmbeddedId
    private BizMstPK bizMstPK;
    // Ctrl + ALT + L 누르면 자동 정렬
    /** 사업코드 */@Column(nullable = false) private String bizCd;/** 상위사업코드 */@Column(nullable = true) private String upBizCd;/** 사업명 */@Column(nullable = false) private String bizNm;/** 사업명 영문 */@Column(nullable = true) private String bizNmEng;/** 사업약칭 */@Column(nullable = true) private String bizAbb;/** 사업시작일 */@Column(nullable = true) private String bizStrYmd;/** 사업종료일 */@Column(nullable = true) private String bizEndYmd;/** 사업시작년도 */@Column(nullable = true) private String bizStrYr;/** 총사업년수 */@Column(nullable = true) private BigDecimal totBizYrs;/** 사업구성미확정여부 */@Column(nullable = true) private String bizCmpsCnfrYn;/** 관리부서코드 */@Column(nullable = true) private String mngDeptCd;/** 정산대상여부 */@Column(nullable = true) private String adjustTrgtYn;/** 사업관리대상여부 */@Column(nullable = true) private String bizMngTrgtYn;/** 순서 */@Column(nullable = true) private BigDecimal ordr;/** 사용여부 */@Column(nullable = true) private String useYn;/** 최초등록자ID */@Column(nullable = true) private String frstRegId;/** 최초등록일자 */@Column(nullable = true)@CreatedDate private Timestamp frstRegDt;/** 최종수정자ID */@Column(nullable = true) private String lastModId;/** 최종수정일자 */@Column(nullable = true)@LastModifiedDate private Timestamp lastModDt;/** 범주사용여부 */@Column(nullable = true) private String catgrUseYn;/** 포탈상단공개여부 */@Column(nullable = true) private String portalOpnYn;
}
