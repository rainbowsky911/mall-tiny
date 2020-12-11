package com.macro.mall.tiny.modules.pms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.macro.mall.tiny.modules.pms.dao.PmsAlbumPicDao;
import com.macro.mall.tiny.modules.pms.entity.PmsAlbumPic;
import com.macro.mall.tiny.modules.pms.service.PmsAlbumPicService;
import org.springframework.stereotype.Service;

/**
 * 画册图片表(PmsAlbumPic)表服务实现类
 *
 * @author makejava
 * @since 2020-12-11 13:40:28
 */
@Service("pmsAlbumPicService")
public class PmsAlbumPicServiceImpl extends ServiceImpl<PmsAlbumPicDao, PmsAlbumPic> implements PmsAlbumPicService {

}