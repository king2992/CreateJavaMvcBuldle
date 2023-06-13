
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
/**
 * @Class Name : BizteamCostTempRepository
 * Description : 포뮬러가배정액 JPA 인터페이스 
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
public interface BizteamCostTempRepository extends JpaRepository<BizteamCostTemp, String> {


}
