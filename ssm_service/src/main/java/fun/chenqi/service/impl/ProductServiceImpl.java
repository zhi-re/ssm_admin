package fun.chenqi.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import fun.chenqi.dao.ProductDao;
import fun.chenqi.domain.Product;
import fun.chenqi.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private ProductDao dao;

    // 查询所有路线
    @Override
    public List<Product> findAll() throws Exception {
        return dao.findAll();
    }

    // 保存路线
    @Override
    public void save(Product product) {
        dao.save(product);
    }

    // 按ID查询路线
    @Override
    public Product findProductByid(Long id) {
        Product product = dao.findProductByid(id);
        return product;
    }

    // 更新路线
    @Override
    public void update(Product product) {
        dao.update(product);
    }

    // 删除路线
    @Override
    public void deleteById(Long id) {
        dao.deleteById(id);
    }

    // 查询所有路线带分页
    @Override
    public PageInfo findByPageHelper(int pageNum, int pageSize) throws Exception {
        // 开始分页 设置第几页 每次查询的条数
        PageHelper.startPage(pageNum, pageSize);
        //紧跟着的第一个select方法会被分页
        List<Product> list = dao.findAll();

        // 创建PageInfo类
        PageInfo<Product> page = new PageInfo<>(list);
        return page;
    }
}
