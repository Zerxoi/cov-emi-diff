package xyz.zerxoi.covemidiff.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import xyz.zerxoi.covemidiff.config.EMIConfig;
import xyz.zerxoi.covemidiff.entity.Emi;
import xyz.zerxoi.covemidiff.mapper.EmiMapper;
import xyz.zerxoi.covemidiff.service.EmiService;
import xyz.zerxoi.covemidiff.utils.Query;
import xyz.zerxoi.covemidiff.vo.EmiVo;
import xyz.zerxoi.covemidiff.vo.PageVo;

@Service
public class EmiServiceImpl extends ServiceImpl<EmiMapper, Emi> implements EmiService{
    private final EMIConfig emiConfig;

    public EmiServiceImpl(EMIConfig emiConfig) {
        this.emiConfig = emiConfig;
    }

    @Override
    public IPage<Emi> list(EmiVo emiVo, PageVo pageVo) {
        return page(new Query<Emi>().getPage(pageVo), new LambdaQueryWrapper<Emi>()
                .eq(emiVo.getTaskId() != null, Emi::getTaskId, emiVo.getTaskId())
                .eq(emiVo.getMethod() != null, Emi::getMethod, emiVo.getMethod())
                .eq(emiVo.getStatus() != null, Emi::getStatus, emiVo.getStatus()));
    }
}




