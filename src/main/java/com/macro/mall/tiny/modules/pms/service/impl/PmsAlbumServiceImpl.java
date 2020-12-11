package com.macro.mall.tiny.modules.pms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.macro.mall.tiny.modules.pms.dao.PmsAlbumDao;
import com.macro.mall.tiny.modules.pms.entity.PmsAlbum;
import com.macro.mall.tiny.modules.pms.service.PmsAlbumService;
import org.springframework.stereotype.Service;

/**
 * 相册表(PmsAlbum)表服务实现类
 *
 * @author makejava
 * @since 2020-12-11 13:40:26
 */
@Service("pmsAlbumService")
public class PmsAlbumServiceImpl extends ServiceImpl<PmsAlbumDao, PmsAlbum> implements PmsAlbumService {

}