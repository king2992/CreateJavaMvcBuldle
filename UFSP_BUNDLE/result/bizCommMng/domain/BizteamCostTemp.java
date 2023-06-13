
import lombok.*;
import javax.persistence.*;
import java.util.Date;

import java.sql.Timestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
/**
 * @Class Name : BizteamCostTemp
 * Description : 포뮬러가배정액 도메인 객체
 *
 * @author : 이진우
 * @Since : 2023-04-12
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
@Table(name="UFSD_BIZTEAM_COST_TEMP")
public class BizteamCostTemp {
    @EmbeddedId
    private BizteamCostTempPK bizteamCostTempPK;
    // Ctrl + ALT + L 누르면 자동 정렬
    /** 업무ID */@Column(nullable = false) private String jobId;/** 사업단ID */@Column(nullable = false) private String bizteamId;/** 지급차수 */@Column(nullable = false) private String payDeg;/** 가배정액 */@Column(nullable = true) private BigDecimal tempFund;/** 최초등록자ID */@Column(nullable = true) private String frstRegId;/** 최초등록일자 */@Column(nullable = true)@CreatedDate private Timestamp frstRegDt;/** 최종수정자ID */@Column(nullable = true) private String lastModId;/** 최종수정일자 */@Column(nullable = true)@LastModifiedDate private Timestamp lastModDt;
}
