package fun.chenqi.service;

import com.github.pagehelper.PageInfo;
import fun.chenqi.domain.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll() throws Exception;

    void save(Product product);

    Product findProductByid(Long id);

    void update(Product product);

    void deleteById(Long id);

    PageInfo findByPageHelper(int pageNum, int pageSize) throws Exception;
}
