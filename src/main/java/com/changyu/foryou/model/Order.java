package com.changyu.foryou.model;

import java.util.Date;

public class Order {
    private Long orderId;

    private String phone;

    private Date createTime;

    private Short status;

    private Float price;

    private Integer orderCount;

    private Short isRemarked;

    private Short tag;

    private Integer foodSpecial;

    private Long foodId;

    private String togetherId;
    
    private String rank;
    
    public Order(){
    	
    }
    
    public Order(String phoneId, Long foodId2, Integer foodCount,
			Integer foodSpecial2) {
    	this.phone=phoneId;
    	foodId=foodId2;
    	orderCount=foodCount;
    	foodSpecial=foodSpecial2;
    	tag=1;
    	createTime=new Date();
    	status=0;
    	isRemarked=0;
    	orderId=createTime.getTime();
	}

	public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(Integer orderCount) {
        this.orderCount = orderCount;
    }

    public Short getIsRemarked() {
        return isRemarked;
    }

    public void setIsRemarked(Short isRemarked) {
        this.isRemarked = isRemarked;
    }

    public Short getTag() {
        return tag;
    }

    public void setTag(Short tag) {
        this.tag = tag;
    }

    public Integer getFoodSpecial() {
        return foodSpecial;
    }

    public void setFoodSpecial(Integer foodSpecial) {
        this.foodSpecial = foodSpecial;
    }

    public Long getFoodId() {
        return foodId;
    }

    public void setFoodId(Long foodId) {
        this.foodId = foodId;
    }

	public String getTogetherId() {
		return togetherId;
	}

	public void setTogetherId(String togetherId) {
		this.togetherId = togetherId;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}
}