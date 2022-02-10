package xyz.zerxoi.covemidiff.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import xyz.zerxoi.covemidiff.entity.Emi;
import xyz.zerxoi.covemidiff.vo.EmiVo;
import xyz.zerxoi.covemidiff.vo.PageVo;

public interface EmiService extends IService<Emi> {
    IPage<Emi> list(EmiVo emiVo, PageVo pageVo);
}
