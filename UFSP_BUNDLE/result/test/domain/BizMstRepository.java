
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
/**
 * @Class Name : BizMstRepository
 * Description : 사업마스터 JPA 인터페이스 
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
public interface BizMstRepository extends JpaRepository<BizMst, String> {


}
