package nrf.ufsp.member;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import nrf.ufsp.eval.domain.EvalSpclPay;
import nrf.ufsp.eval.dto.EvalSpclPayDto;
import nrf.ufsp.eval.dto.EvalSpclPaySearchDto;
import nrf.ufsp.eval.service.EvalSpclPayService;

import org.springframework.web.bind.annotation.*;

/**
 * @author : 이진우
 * @version : 1.0
 * @Class Name : EvalSpclPayController
 * Description : 평가전문가수당정보 컨트롤 클래스
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

@Api(tags = "평가전문가수당정보")
@RequiredArgsConstructor
@RestController
public class EvalSpclPayController {
    private final EvalSpclPayService evalSpclPayService;

    @ApiImplicitParams({
            @ApiImplicitParam(name = "X-AUTH-TOKEN", required = false, dataType = "String", paramType = "header")
    })
    @ApiOperation(value = "평가전문가수당정보를 생성한다.")
    @PostMapping("/api/common/eval/evalSpclPayRegistExec")
    public ResultStatus<EvalSpclPay> evalSpclPayRegistExec(@RequestBody EvalSpclPayDto evalSpclPayDto){
        return evalSpclPayService.evalSpclPayRegistExec(evalSpclPayDto);
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "X-AUTH-TOKEN", required = false, dataType = "String", paramType = "header")
    })
    @ApiOperation(value = "평가전문가수당정보를 수정한다.")
    @PostMapping("/api/common/eval/evalSpclPayUpdtExec/{jobId}")
    public ResultStatus<EvalSpclPay> evalSpclPayUpdtExec(@PathVariable String jobId, @RequestBody EvalSpclPayDto evalSpclPayDto){
        return evalSpclPayService.evalSpclPayUpdtExec(jobId, evalSpclPayDto);
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "X-AUTH-TOKEN", required = false, dataType = "String", paramType = "header")
    })
    @ApiOperation(value = "평가전문가수당정보를 삭제한다.")
    @PostMapping("/api/common/eval/evalSpclPayDeleteExec/{jobId}")
    public ResultStatus<String> evalSpclPayDeleteExec(@PathVariable String jobId){
        return evalSpclPayService.evalSpclPayDeleteExec(jobId);
    }
    
    @ApiImplicitParams({
            @ApiImplicitParam(name = "X-AUTH-TOKEN", required = false, dataType = "String", paramType = "header")
    })
    @ApiOperation(value = "평가전문가수당정보 목록을 검색조건에 따라 조회한다")
    @PostMapping("/api/common/eval/getEvalSpclPaySearchList")
    public ResultStatus<String> getEvalSpclPaySearchList(@RequestBody EvalSpclPaySearchDto evalSpclPaySearchDto) {

        return evalSpclPayService.getEvalSpclPaySearchList(evalSpclPaySearchDto);
    }
}
