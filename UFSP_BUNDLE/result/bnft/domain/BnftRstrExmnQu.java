
import lombok.*;
import javax.persistence.*;
import java.util.Date;

import java.sql.Timestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
/**
 * @Class Name : BnftRstrExmnQu
 * Description : 수혜제한조사분기 도메인 객체
 *
 * @author : 이진우
 * @Since : 2023-05-04
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
@Table(name="UFSD_BNFT_RSTR_EXMN_QU")
public class BnftRstrExmnQu {
    @EmbeddedId
    private BnftRstrExmnQuPK bnftRstrExmnQuPK;
    // Ctrl + ALT + L 누르면 자동 정렬
    /** 수혜제한ID */@Column(nullable = false) private String bnftRstrId;/** 조사년도 */@Column(nullable = false) private String exmnYr;/** 조사분기 */@Column(nullable = false) private BigDecimal exmnQu;/** 최초등록자ID */@Column(nullable = true) private String frstRegId;/** 최초등록일자 */@Column(nullable = true)@CreatedDate private Timestamp frstRegDt;/** 최종수정자ID */@Column(nullable = true) private String lastModId;/** 최종수정일자 */@Column(nullable = true)@LastModifiedDate private Timestamp lastModDt;
}
