package xyz.zerxoi.covemidiff.service;

import com.baomidou.mybatisplus.extension.service.IService;
import xyz.zerxoi.covemidiff.entity.Diff;
import xyz.zerxoi.covemidiff.vo.ContentVo;
import xyz.zerxoi.covemidiff.vo.DiffVo;

import java.util.List;

public interface DiffService extends IService<Diff> {
    List<Diff> list(DiffVo diffVo);

    ContentVo contents(DiffVo diffVo);
}
