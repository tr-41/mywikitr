package com.zhuanye.wiki.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhuanye.wiki.domain.Manager;
import com.zhuanye.wiki.domain.ManagerExample;
import com.zhuanye.wiki.exception.BusinessException;
import com.zhuanye.wiki.exception.BusinessExceptionCode;
import com.zhuanye.wiki.mapper.ManagerMapper;
import com.zhuanye.wiki.req.ManagerLoginReq;
import com.zhuanye.wiki.req.ManagerQueryReq;
import com.zhuanye.wiki.req.ManagerResetPasswordReq;
import com.zhuanye.wiki.req.ManagerSaveReq;
import com.zhuanye.wiki.resp.PageResp;
import com.zhuanye.wiki.resp.ManagerLoginResp;
import com.zhuanye.wiki.resp.ManagerQueryResp;
import com.zhuanye.wiki.util.CopyUtil;
import com.zhuanye.wiki.util.SnowFlake;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ManagerService {

    private static final Logger LOG = LoggerFactory.getLogger(ManagerService.class);

    @Resource
    private ManagerMapper managerMapper;

    @Resource
    private SnowFlake snowFlake;

    public PageResp<ManagerQueryResp> list(ManagerQueryReq req) {
        ManagerExample managerExample = new ManagerExample();
        ManagerExample.Criteria criteria = managerExample.createCriteria();
        if (!ObjectUtils.isEmpty(req.getName())) {
            criteria.andNameEqualTo(req.getName());
        }
        PageHelper.startPage(req.getPage(), req.getSize());
        List<Manager> managerList = managerMapper.selectByExample(managerExample);

        PageInfo<Manager> pageInfo = new PageInfo<>(managerList);
        LOG.info("总行数：{}", pageInfo.getTotal());
        LOG.info("总页数：{}", pageInfo.getPages());
        // 列表复制
        List<ManagerQueryResp> list = CopyUtil.copyList(managerList, ManagerQueryResp.class);

        PageResp<ManagerQueryResp> pageResp = new PageResp();
        pageResp.setTotal(pageInfo.getTotal());
        pageResp.setList(list);

        return pageResp;
    }

    /**
     * 保存
     */
    public void save(ManagerSaveReq req) {
        Manager manager = CopyUtil.copy(req, Manager.class);
        if (ObjectUtils.isEmpty(req.getManagerId())) {
            Manager managerDB = selectByLoginName(req.getName());
            if (ObjectUtils.isEmpty(managerDB)) {
                // 新增
                manager.setManagerId(snowFlake.nextId());
                managerMapper.insert(manager);
            } else {
                // 用户名已存在
                throw new BusinessException(BusinessExceptionCode.USER_LOGIN_NAME_EXIST);
            }
        } else {
            // 更新
            manager.setName(null);
            manager.setPassword(null);
            managerMapper.updateByPrimaryKeySelective(manager);
        }
    }

    public void delete(Long id) {
        managerMapper.deleteByPrimaryKey(id);
    }

    public Manager selectByLoginName(String LoginName) {
        ManagerExample managerExample = new ManagerExample();
        ManagerExample.Criteria criteria = managerExample.createCriteria();
        criteria.andNameEqualTo(LoginName);
        List<Manager> managerList = managerMapper.selectByExample(managerExample);
        if (CollectionUtils.isEmpty(managerList)) {
            return null;
        } else {
            return managerList.get(0);
        }
    }

    /**
     * 修改密码
     */
    public void resetPassword(ManagerResetPasswordReq req) {
        Manager manager = CopyUtil.copy(req, Manager.class);
        managerMapper.updateByPrimaryKeySelective(manager);
    }

    /**
     * 登录
     */
    public ManagerLoginResp login(ManagerLoginReq req) {
        Manager managerDb = selectByLoginName(req.getName());
        if (ObjectUtils.isEmpty(managerDb)) {
            // 用户名不存在
            LOG.info("用户名不存在, {}", req.getName());
            throw new BusinessException(BusinessExceptionCode.LOGIN_USER_ERROR);
        } else {
            if (managerDb.getPassword().equals(req.getPassword())) {
                // 登录成功
                ManagerLoginResp managerLoginResp = CopyUtil.copy(managerDb, ManagerLoginResp.class);
                return managerLoginResp;
            } else {
                // 密码不对
                LOG.info("密码不对, 输入密码：{}, 数据库密码：{}", req.getPassword(), managerDb.getPassword());
                throw new BusinessException(BusinessExceptionCode.LOGIN_USER_ERROR);
            }
        }
    }
}
