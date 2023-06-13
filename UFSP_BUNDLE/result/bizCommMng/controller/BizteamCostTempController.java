package nrf.ufsp.member;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import nrf.ufsp.bizCommMng.domain.BizteamCostTemp;
import nrf.ufsp.bizCommMng.dto.BizteamCostTempDto;
import nrf.ufsp.bizCommMng.dto.BizteamCostTempSearchDto;
import nrf.ufsp.bizCommMng.service.BizteamCostTempService;

import org.springframework.web.bind.annotation.*;

/**
 * @author : 이진우
 * @version : 1.0
 * @Class Name : BizteamCostTempController
 * Description : 포뮬러가배정액 컨트롤 클래스
 * @Since : 2023-04-12
 * @see <pre>
 * ------------------------------------------------------------
 * Modification Information
 * ------------------------------------------------------------
 * 수정일        수정자               수정내용
 *
 * ------------------------------------------------------------
 * </pre>
 */

@Api(tags = "포뮬러가배정액")
@RequiredArgsConstructor
@RestController
public class BizteamCostTempController {
    private final BizteamCostTempService bizteamCostTempService;

    @ApiImplicitParams({
            @ApiImplicitParam(name = "X-AUTH-TOKEN", required = false, dataType = "String", paramType = "header")
    })
    @ApiOperation(value = "포뮬러가배정액를 생성한다.")
    @PostMapping("/api/common/bizCommMng/bizteamCostTempRegistExec")
    public ResultStatus<BizteamCostTemp> bizteamCostTempRegistExec(@RequestBody BizteamCostTempDto bizteamCostTempDto){
        return bizteamCostTempService.bizteamCostTempRegistExec(bizteamCostTempDto);
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "X-AUTH-TOKEN", required = false, dataType = "String", paramType = "header")
    })
    @ApiOperation(value = "포뮬러가배정액를 수정한다.")
    @PostMapping("/api/common/bizCommMng/bizteamCostTempUpdtExec/{jobId}")
    public ResultStatus<BizteamCostTemp> bizteamCostTempUpdtExec(@PathVariable String jobId, @RequestBody BizteamCostTempDto bizteamCostTempDto){
        return bizteamCostTempService.bizteamCostTempUpdtExec(jobId, bizteamCostTempDto);
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "X-AUTH-TOKEN", required = false, dataType = "String", paramType = "header")
    })
    @ApiOperation(value = "포뮬러가배정액를 삭제한다.")
    @PostMapping("/api/common/bizCommMng/bizteamCostTempDeleteExec/{jobId}")
    public ResultStatus<String> bizteamCostTempDeleteExec(@PathVariable String jobId){
        return bizteamCostTempService.bizteamCostTempDeleteExec(jobId);
    }
    
    @ApiImplicitParams({
            @ApiImplicitParam(name = "X-AUTH-TOKEN", required = false, dataType = "String", paramType = "header")
    })
    @ApiOperation(value = "포뮬러가배정액 목록을 검색조건에 따라 조회한다")
    @PostMapping("/api/common/bizCommMng/getBizteamCostTempSearchList")
    public ResultStatus<String> getBizteamCostTempSearchList(@RequestBody BizteamCostTempSearchDto bizteamCostTempSearchDto) {

        return bizteamCostTempService.getBizteamCostTempSearchList(bizteamCostTempSearchDto);
    }
}
