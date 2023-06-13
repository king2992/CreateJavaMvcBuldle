
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
/**
 * @Class Name : EvalSpclPayRepository
 * Description : 평가전문가수당정보 JPA 인터페이스 
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
public interface EvalSpclPayRepository extends JpaRepository<EvalSpclPay, String> {


}
