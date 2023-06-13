package nrf.ufsp.member;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import nrf.ufsp.test.domain.BizMst;
import nrf.ufsp.test.dto.BizMstDto;
import nrf.ufsp.test.dto.BizMstSearchDto;
import nrf.ufsp.test.service.BizMstService;

import org.springframework.web.bind.annotation.*;

/**
 * @author : 이진우
 * @version : 1.0
 * @Class Name : BizMstController
 * Description : 사업마스터 컨트롤 클래스
 * @Since : 2023-05-30
 * @see <pre>
 * ------------------------------------------------------------
 * Modification Information
 * ------------------------------------------------------------
 * 수정일        수정자               수정내용
 *
 * ------------------------------------------------------------
 * </pre>
 */

@Api(tags = "사업마스터")
@RequiredArgsConstructor
@RestController
public class BizMstController {
    private final BizMstService bizMstService;

    @ApiImplicitParams({
            @ApiImplicitParam(name = "X-AUTH-TOKEN", required = false, dataType = "String", paramType = "header")
    })
    @ApiOperation(value = "사업마스터를 생성한다.")
    @PostMapping("/api/admin/test/bizMstRegistExec")
    public ResultStatus<BizMst> bizMstRegistExec(@RequestBody BizMstDto bizMstDto){
        return bizMstService.bizMstRegistExec(bizMstDto);
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "X-AUTH-TOKEN", required = false, dataType = "String", paramType = "header")
    })
    @ApiOperation(value = "사업마스터를 수정한다.")
    @PostMapping("/api/admin/test/bizMstUpdtExec/{bizCd}")
    public ResultStatus<BizMst> bizMstUpdtExec(@PathVariable String bizCd, @RequestBody BizMstDto bizMstDto){
        return bizMstService.bizMstUpdtExec(bizCd, bizMstDto);
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "X-AUTH-TOKEN", required = false, dataType = "String", paramType = "header")
    })
    @ApiOperation(value = "사업마스터를 삭제한다.")
    @PostMapping("/api/admin/test/bizMstDeleteExec/{bizCd}")
    public ResultStatus<String> bizMstDeleteExec(@PathVariable String bizCd){
        return bizMstService.bizMstDeleteExec(bizCd);
    }
    
    @ApiImplicitParams({
            @ApiImplicitParam(name = "X-AUTH-TOKEN", required = false, dataType = "String", paramType = "header")
    })
    @ApiOperation(value = "사업마스터 목록을 검색조건에 따라 조회한다")
    @PostMapping("/api/admin/test/getBizMstSearchList")
    public ResultStatus<String> getBizMstSearchList(@RequestBody BizMstSearchDto bizMstSearchDto) {

        return bizMstService.getBizMstSearchList(bizMstSearchDto);
    }
}
