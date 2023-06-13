
import lombok.*;
import javax.persistence.*;
import java.util.Date;

import java.sql.Timestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
/**
 * @Class Name : AgrmSignTrgt
 * Description : 협약서명대상 도메인 객체
 *
 * @author : 이진우
 * @Since : 2023-05-13
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
@Table(name="UFSD_AGRM_SIGN_TRGT")
public class AgrmSignTrgt {
    @EmbeddedId
    private AgrmSignTrgtPK agrmSignTrgtPK;
    // Ctrl + ALT + L 누르면 자동 정렬
    /** 협약ID */@Column(nullable = false) private String agrmId;/** 협약서명대상CD */@Column(nullable = false) private String agrmSignTrgtCd;/** 최초등록자ID */@Column(nullable = true) private String frstRegId;/** 최초등록일자 */@Column(nullable = true)@CreatedDate private Timestamp frstRegDt;
}
