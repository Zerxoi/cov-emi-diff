package xyz.zerxoi.covemidiff.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.zerxoi.covemidiff.service.DiffService;
import xyz.zerxoi.covemidiff.utils.R;
import xyz.zerxoi.covemidiff.vo.DiffVo;

import javax.validation.Valid;

@RestController
@RequestMapping("diff")
public class DiffController {
    private final DiffService diffService;

    public DiffController(DiffService diffService) {
        this.diffService = diffService;
    }

    @GetMapping("/list")
    public R list(@Valid DiffVo diffVo) {
        return R.ok().data(diffService.list(diffVo));
    }

    @GetMapping("/contents")
    public R contents(@Valid DiffVo diffVo) {
        return R.ok().data(diffService.contents(diffVo));
    }
}
