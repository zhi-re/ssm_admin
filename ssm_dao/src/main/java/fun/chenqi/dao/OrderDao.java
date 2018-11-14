package fun.chenqi.dao;

import fun.chenqi.domain.Order;
import fun.chenqi.domain.Product;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface OrderDao {

    @Select("select * from orders")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "product", column = "productId", javaType = Product.class,
                    one = @One(
                            select = "fun.chenqi.dao.ProductDao.findProductByid",
                             fetchType = FetchType.LAZY
                    ))
    }
    )
    List<Order> findAllOrder();

}
