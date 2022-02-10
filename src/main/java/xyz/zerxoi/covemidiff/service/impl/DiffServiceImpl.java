package xyz.zerxoi.covemidiff.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import xyz.zerxoi.covemidiff.config.EMIConfig;
import xyz.zerxoi.covemidiff.constant.EmiMethod;
import xyz.zerxoi.covemidiff.entity.Diff;
import xyz.zerxoi.covemidiff.mapper.DiffMapper;
import xyz.zerxoi.covemidiff.service.DiffService;
import xyz.zerxoi.covemidiff.vo.ContentVo;
import xyz.zerxoi.covemidiff.vo.DiffVo;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class DiffServiceImpl extends ServiceImpl<DiffMapper, Diff> implements DiffService {
    private final EMIConfig emiConfig;

    public DiffServiceImpl(EMIConfig emiConfig) {
        this.emiConfig = emiConfig;
    }

    @Override
    public List<Diff> list(DiffVo diffVo) {
        return list(new LambdaQueryWrapper<Diff>()
                .eq(Diff::getTaskId, diffVo.getTaskId())
                .eq(Diff::getMethod, diffVo.getMethod())
        );
    }

    @Override
    public ContentVo contents(DiffVo diffVo) {
        Path parent = Paths.get(emiConfig.getParentLocation(), EmiMethod.valueOf(diffVo.getMethod()).getDesc(), diffVo.getTaskId().toString(), "emi");
        Path gcov = parent.resolve("main.gcov.c");
        Path llvmcov = parent.resolve("main.llvm-cov.c");
        ContentVo contentVo = new ContentVo();
        try {
            contentVo.setGcov(FileUtils.readFileToString(gcov.toFile(), StandardCharsets.UTF_8));
            contentVo.setLlvmcov(FileUtils.readFileToString(llvmcov.toFile(), StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contentVo;
    }
}




