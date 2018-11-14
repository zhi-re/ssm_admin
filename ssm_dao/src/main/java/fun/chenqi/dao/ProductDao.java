package fun.chenqi.dao;

import fun.chenqi.domain.Product;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface ProductDao {
    @Select("select * from product")
    List<Product> findAll() throws Exception;

    @Insert("insert into product (id,productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus) values(common_sequence.nextval,#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void save(Product product);

    @Select("select * from product where id = #{productid}")
    Product findProductByid(Long id);

    @Update("update product set productNum = #{productNum},productName = #{productName},cityName = #{cityName},departureTime = #{departureTime},productPrice = #{productPrice},productDesc = #{productDesc},productStatus = #{productStatus} where id = #{id}")
    void update(Product product);

    @Delete("delete from product where id = #{id}")
    void deleteById(Long id);
}
