package canonical.service;

import canonical.dao.IDao;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *  @Description: 基础服务
 *  @author: zhao_yd
 *  @Date: 2020/12/21 10:07 上午
 *
 */

public class BaseService<T> {

    @Autowired
    private IDao<T> iDao;

    public IDao<T> getiDao() {
        return iDao;
    }

    public void setiDao(IDao<T> iDao) {
        this.iDao = iDao;
    }

    @Override
    public String toString() {
        return "BaseService{" +
                "iDao=" + iDao +
                '}';
    }
}
