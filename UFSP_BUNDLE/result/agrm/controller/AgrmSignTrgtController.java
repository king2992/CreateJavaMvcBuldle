package nrf.ufsp.member;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import nrf.ufsp.agrm.domain.AgrmSignTrgt;
import nrf.ufsp.agrm.dto.AgrmSignTrgtDto;
import nrf.ufsp.agrm.dto.AgrmSignTrgtSearchDto;
import nrf.ufsp.agrm.service.AgrmSignTrgtService;

import org.springframework.web.bind.annotation.*;

/**
 * @author : 이진우
 * @version : 1.0
 * @Class Name : AgrmSignTrgtController
 * Description : 협약서명대상 컨트롤 클래스
 * @Since : 2023-05-13
 * @see <pre>
 * ------------------------------------------------------------
 * Modification Information
 * ------------------------------------------------------------
 * 수정일        수정자               수정내용
 *
 * ------------------------------------------------------------
 * </pre>
 */

@Api(tags = "협약서명대상")
@RequiredArgsConstructor
@RestController
public class AgrmSignTrgtController {
    private final AgrmSignTrgtService agrmSignTrgtService;

    @ApiImplicitParams({
            @ApiImplicitParam(name = "X-AUTH-TOKEN", required = false, dataType = "String", paramType = "header")
    })
    @ApiOperation(value = "협약서명대상를 생성한다.")
    @PostMapping("/api/common/agrm/agrmSignTrgtRegistExec")
    public ResultStatus<AgrmSignTrgt> agrmSignTrgtRegistExec(@RequestBody AgrmSignTrgtDto agrmSignTrgtDto){
        return agrmSignTrgtService.agrmSignTrgtRegistExec(agrmSignTrgtDto);
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "X-AUTH-TOKEN", required = false, dataType = "String", paramType = "header")
    })
    @ApiOperation(value = "협약서명대상를 수정한다.")
    @PostMapping("/api/common/agrm/agrmSignTrgtUpdtExec/{agrmId}")
    public ResultStatus<AgrmSignTrgt> agrmSignTrgtUpdtExec(@PathVariable String agrmId, @RequestBody AgrmSignTrgtDto agrmSignTrgtDto){
        return agrmSignTrgtService.agrmSignTrgtUpdtExec(agrmId, agrmSignTrgtDto);
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "X-AUTH-TOKEN", required = false, dataType = "String", paramType = "header")
    })
    @ApiOperation(value = "협약서명대상를 삭제한다.")
    @PostMapping("/api/common/agrm/agrmSignTrgtDeleteExec/{agrmId}")
    public ResultStatus<String> agrmSignTrgtDeleteExec(@PathVariable String agrmId){
        return agrmSignTrgtService.agrmSignTrgtDeleteExec(agrmId);
    }
    
    @ApiImplicitParams({
            @ApiImplicitParam(name = "X-AUTH-TOKEN", required = false, dataType = "String", paramType = "header")
    })
    @ApiOperation(value = "협약서명대상 목록을 검색조건에 따라 조회한다")
    @PostMapping("/api/common/agrm/getAgrmSignTrgtSearchList")
    public ResultStatus<String> getAgrmSignTrgtSearchList(@RequestBody AgrmSignTrgtSearchDto agrmSignTrgtSearchDto) {

        return agrmSignTrgtService.getAgrmSignTrgtSearchList(agrmSignTrgtSearchDto);
    }
}
