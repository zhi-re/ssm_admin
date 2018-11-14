package fun.chenqi.domain;

import fun.chenqi.util.DateUtil;

import java.io.Serializable;
import java.util.Date;

public class Order {
    private Long id;
    private String orderNum;
    private Date orderTime;

    private String orderTimeStr;

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderNum='" + orderNum + '\'' +
                ", orderTime=" + orderTime +
                ", orderTimeStr='" + orderTimeStr + '\'' +
                ", peopleCount=" + peopleCount +
                ", orderDesc='" + orderDesc + '\'' +
                ", payType=" + payType +
                ", orderStatus=" + orderStatus +
                ", productId=" + productId +
                ", product=" + product +
                '}';
    }

    public String getOrderTimeStr() {
        return DateUtil.date(orderTime);
    }

    public void setOrderTimeStr(String orderTimeStr) {
        this.orderTimeStr = orderTimeStr;
    }

    private Integer peopleCount;
    private String orderDesc;
    private Integer payType;
    private Integer orderStatus;
    // 外键
    private Long productId;
    private Product product;


    public Order(Long id, String orderNum, Date orderTime, Integer peopleCount, String orderDesc, Integer payType, Integer orderStatus, Long productId, Product product) {
        this.id = id;
        this.orderNum = orderNum;
        this.orderTime = orderTime;
        this.peopleCount = peopleCount;
        this.orderDesc = orderDesc;
        this.payType = payType;
        this.orderStatus = orderStatus;
        this.productId = productId;
        this.product = product;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public Integer getPeopleCount() {
        return peopleCount;
    }

    public void setPeopleCount(Integer peopleCount) {
        this.peopleCount = peopleCount;
    }

    public String getOrderDesc() {
        return orderDesc;
    }

    public void setOrderDesc(String orderDesc) {
        this.orderDesc = orderDesc;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Order() {
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}
