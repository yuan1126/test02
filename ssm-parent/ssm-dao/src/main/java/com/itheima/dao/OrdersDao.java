package com.itheima.dao;

import com.itheima.domain.Orders;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrdersDao {
    /**
     * 查询所有订单
     * @return
     */
    @Select("select o.id oid,o.orderNum,o.orderTime,o.peopleCount,o.orderDesc,o.payType,o.orderStatus," +
            "p.* from orders o,product p where o.productid=p.id")
    @Results(value={
            @Result(id = true, property = "id", column = "oid"),
            @Result(property = "orderNum", column = "orderNum"),
            @Result(property = "orderTime", column = "orderTime"),
            @Result(property = "peopleCount", column = "peopleCount"),
            @Result(property = "orderDesc", column = "orderDesc"),
            @Result(property = "payType", column = "payType"),
            @Result(property = "orderStatus", column = "orderStatus"),
            @Result(column = "id",property = "product.id"),
            @Result(column = "productNum",property = "product.productNum"),
            @Result(column = "productName",property = "product.productName"),
            @Result(column = "cityName",property = "product.cityName"),
            @Result(column = "departureTime",property = "product.departureTime"),
            @Result(column = "productPrice",property = "product.productPrice"),
            @Result(column = "productDesc",property = "product.productDesc"),
            @Result(column = "productStatus",property = "product.productStatus")
    })
    List<Orders> getList();

    /**
     * 添加新订单
     * @param orders
     * @return
     */
    @Insert("insert into orders (id,orderNum,orderTime,peopleCount,orderDesc,payType,orderStatus,productId) values (ORDERS_SEQ.NEXTVAL,#{orderNum},#{orderTime},#{peopleCount},#{orderDesc},#{payType},#{orderStatus},#{product.id})")
    int add(Orders orders);
}
