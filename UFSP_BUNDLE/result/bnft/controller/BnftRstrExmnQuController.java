package nrf.ufsp.member;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import nrf.ufsp.bnft.domain.BnftRstrExmnQu;
import nrf.ufsp.bnft.dto.BnftRstrExmnQuDto;
import nrf.ufsp.bnft.dto.BnftRstrExmnQuSearchDto;
import nrf.ufsp.bnft.service.BnftRstrExmnQuService;

import org.springframework.web.bind.annotation.*;

/**
 * @author : 이진우
 * @version : 1.0
 * @Class Name : BnftRstrExmnQuController
 * Description : 수혜제한조사분기 컨트롤 클래스
 * @Since : 2023-05-04
 * @see <pre>
 * ------------------------------------------------------------
 * Modification Information
 * ------------------------------------------------------------
 * 수정일        수정자               수정내용
 *
 * ------------------------------------------------------------
 * </pre>
 */

@Api(tags = "수혜제한조사분기")
@RequiredArgsConstructor
@RestController
public class BnftRstrExmnQuController {
    private final BnftRstrExmnQuService bnftRstrExmnQuService;

    @ApiImplicitParams({
            @ApiImplicitParam(name = "X-AUTH-TOKEN", required = false, dataType = "String", paramType = "header")
    })
    @ApiOperation(value = "수혜제한조사분기를 생성한다.")
    @PostMapping("/api/admin/bnft/bnftRstrExmnQuRegistExec")
    public ResultStatus<BnftRstrExmnQu> bnftRstrExmnQuRegistExec(@RequestBody BnftRstrExmnQuDto bnftRstrExmnQuDto){
        return bnftRstrExmnQuService.bnftRstrExmnQuRegistExec(bnftRstrExmnQuDto);
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "X-AUTH-TOKEN", required = false, dataType = "String", paramType = "header")
    })
    @ApiOperation(value = "수혜제한조사분기를 수정한다.")
    @PostMapping("/api/admin/bnft/bnftRstrExmnQuUpdtExec/{bnftRstrId}")
    public ResultStatus<BnftRstrExmnQu> bnftRstrExmnQuUpdtExec(@PathVariable String bnftRstrId, @RequestBody BnftRstrExmnQuDto bnftRstrExmnQuDto){
        return bnftRstrExmnQuService.bnftRstrExmnQuUpdtExec(bnftRstrId, bnftRstrExmnQuDto);
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "X-AUTH-TOKEN", required = false, dataType = "String", paramType = "header")
    })
    @ApiOperation(value = "수혜제한조사분기를 삭제한다.")
    @PostMapping("/api/admin/bnft/bnftRstrExmnQuDeleteExec/{bnftRstrId}")
    public ResultStatus<String> bnftRstrExmnQuDeleteExec(@PathVariable String bnftRstrId){
        return bnftRstrExmnQuService.bnftRstrExmnQuDeleteExec(bnftRstrId);
    }
    
    @ApiImplicitParams({
            @ApiImplicitParam(name = "X-AUTH-TOKEN", required = false, dataType = "String", paramType = "header")
    })
    @ApiOperation(value = "수혜제한조사분기 목록을 검색조건에 따라 조회한다")
    @PostMapping("/api/admin/bnft/getBnftRstrExmnQuSearchList")
    public ResultStatus<String> getBnftRstrExmnQuSearchList(@RequestBody BnftRstrExmnQuSearchDto bnftRstrExmnQuSearchDto) {

        return bnftRstrExmnQuService.getBnftRstrExmnQuSearchList(bnftRstrExmnQuSearchDto);
    }
}
