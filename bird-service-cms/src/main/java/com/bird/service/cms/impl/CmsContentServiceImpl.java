package com.bird.service.cms.impl;

import com.bird.core.Check;
import com.bird.core.service.AbstractServiceImpl;
import com.bird.core.utils.DozerHelper;
import com.bird.service.cms.CmsContentService;
import com.bird.service.cms.dto.CmsFullContentDTO;
import com.bird.service.cms.mapper.CmsContentMapper;
import com.bird.service.cms.model.CmsContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@CacheConfig(cacheNames = "cms_content")
@com.alibaba.dubbo.config.annotation.Service(interfaceName = "com.bird.service.cms.CmsContentService")
public class CmsContentServiceImpl extends AbstractServiceImpl<CmsContent> implements CmsContentService {

    @Autowired
    private CmsContentMapper contentMapper;

    @Autowired
    private DozerHelper dozerHelper;

    /**
     * 保存文章信息（包括自定义属性）
     *
     * @param fullContentDTO
     */
    @Override
    public void saveContent(CmsFullContentDTO fullContentDTO) {
        Check.NotNull(fullContentDTO, "fullContentDTO");

        CmsContent content = dozerHelper.map(fullContentDTO.getContent(), CmsContent.class);
        save(content);

        //编辑模式下，删除现有的属性再重新保存
        if (fullContentDTO.getContent().getId() > 0) {
            contentMapper.deleteAttribute(content.getId());
        }
        Map<String, String> attribute = fullContentDTO.getAttribute();
        contentMapper.saveAttribute(content.getId(), attribute);
    }
}
