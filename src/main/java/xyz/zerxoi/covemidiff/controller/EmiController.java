package xyz.zerxoi.covemidiff.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.zerxoi.covemidiff.service.EmiService;
import xyz.zerxoi.covemidiff.utils.R;
import xyz.zerxoi.covemidiff.vo.EmiVo;
import xyz.zerxoi.covemidiff.vo.PageVo;

@RestController
@RequestMapping("emi")
public class EmiController {
    private final EmiService emiService;

    public EmiController(EmiService emiService) {
        this.emiService = emiService;
    }

    @GetMapping("/list")
    public R list(EmiVo emiVo, PageVo pageVo) {
        return R.ok().data(emiService.list(emiVo, pageVo));
    }
}
