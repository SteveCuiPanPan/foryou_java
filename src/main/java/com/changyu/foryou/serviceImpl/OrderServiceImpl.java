package com.changyu.foryou.serviceImpl;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.changyu.foryou.mapper.OrderMapper;
import com.changyu.foryou.model.CartGood;
import com.changyu.foryou.model.DeliverChildOrder;
import com.changyu.foryou.model.DeliverOrder;
import com.changyu.foryou.model.Order;
import com.changyu.foryou.model.PCOrder;
import com.changyu.foryou.model.SmallOrder;
import com.changyu.foryou.model.SuperAdminOrder;
import com.changyu.foryou.service.OrderService;

@Service("orderService")
public class OrderServiceImpl implements OrderService {
	private OrderMapper orderMapper;

	public OrderMapper getOrderMapper() {
		return orderMapper;
	}

	@Autowired
	public void setOrderMapper(OrderMapper orderMapper) {
		this.orderMapper = orderMapper;
	}

	public List<CartGood> getOrderList(String phoneId) {
		return orderMapper.getOrderListByPhone(phoneId);
	}

	public List<Order> getOrderSuccessList(String phoneId) {
		return orderMapper.getSuccessOrder(phoneId);
	}

	public int deleteUserOrder(Long orderId, String phoneId) {
		return orderMapper.deleteByPrimaryKey(orderId,phoneId);
	}
	public int editUserOrder(Long orderId, String phoneId,Integer orderCount) {
		return orderMapper.updateOrderCount(orderId,phoneId,orderCount);
	}

	public int insertSelectiveOrder(Order order) {
		return orderMapper.insertSelective(order);
	}

	public int changeOrderStatus2Buy(String phoneId, String orderId,String togetherId,String rank,String reserveTime,String message) {

		return orderMapper.changeOrderStatus2Buy(Long.valueOf(orderId),phoneId,togetherId,rank,reserveTime,message);
	}

	public int changeOrderStatus2Deliver(String phoneId, String togetherId) {
		return orderMapper.changeOrderStatus2Deliver(togetherId, phoneId);
	}

	public int changeOrderStatus2Finish(String phoneId, String orderId) {
		return orderMapper.changeOrderStatus2Finish(orderId, phoneId);
	}

	public int deleteAllUserOrder(String phoneId) {	
		return orderMapper.deleteAllUserOrder(phoneId);
	}

	public List<SmallOrder> getOrderListInMine(String phoneId,String togetherId,Short status) {	
		return orderMapper.getOrderListInMine(phoneId,togetherId,status);
	}

	public List<SmallOrder> getOrderListInMineWait2Deliver(String phoneId) {
		return orderMapper.getOrderListInMineWait2Deliver(phoneId);
	}

	public List<SmallOrder> getOrderListInMineDeliver(String phoneId) {
		return orderMapper.getOrderListInMineDeliver(phoneId);
	}

	public List<SmallOrder> getOrderListInMineFinish(String phoneId) {
		return orderMapper.getOrderListInMineFinish(phoneId);
	}

	public List<String> getTogetherId(String phoneId, Short status) {
		return orderMapper.getTogetherId(phoneId,status);
	}

	public Map<String, Object> getOrderSummaryCount(String phone) {
		List<String> waitToDeliver=orderMapper.getTogetherId(phone,(short) 1); 
		List<String> deliver=orderMapper.getTogetherId(phone, (short)2);
		List<String> waitComment=orderMapper.getTogetherId(phone, (short)3);

		Map<String, Object> map=new HashMap<String, Object>();

		map.put("wait",waitToDeliver.size());
		map.put("deliver", deliver.size());
		map.put("comment", waitComment.size());
		return map;
	}

	public List<Order> selectOrder(Order order) {
		return orderMapper.selectOrder(order);
	}

	public void deleteCartGood(Order order) {
		orderMapper.deleteCartGood(order);		
	}

	public Order selectPersonOrder(String phoneId, Long orderId) {
		return orderMapper.selectPersonOrder(phoneId,orderId);
	}

	public void updateOrderRemarked(String phoneId, Long orderId) {
		orderMapper.updateOrderRemarked(phoneId,orderId);		
	}

	public List<SuperAdminOrder> superAdminGetOrder(Integer isSelected) {
		return orderMapper.superAdminGetOrder(isSelected);
	}

	//弃用，因为现在删除只是将其置为无效
	//删除收货人地址时，检查该地址是否在订单中已使用，否者不能删除
	public int getExitOrderUserRank(String phoneId, String rank) {
		return orderMapper.getExitOrderUserRank(phoneId,rank);
	}

	//设置配送员
	public int setDeliverAdmin(String togetherId, String adminPhone) {
		return orderMapper.setDeliverAdmin(togetherId,adminPhone);
	}

	public Order selectOneOrder(String phoneId, String orderId) {
		return orderMapper.selectByPrimaryKey(Long.valueOf(orderId),phoneId);
	}


	//配送员获取配送订单
	public List<DeliverOrder> deliverGetOrder(String phoneId) {
		return orderMapper.deliverGetOrder(phoneId);
	}

	public List<DeliverChildOrder> getDeliverChildOrders(String togetherId) {
		return orderMapper.getDeliverChildOrders(togetherId);
	}

	public List<PCOrder> getPCOrders(Short status,Integer limit,Integer offset,String search) {
		Calendar calendar=Calendar.getInstance();

		if(status!=1){
			calendar.add(Calendar.MONTH, -1);
			calendar.set(Calendar.DAY_OF_MONTH, 1);            //设定默认只显示近两个月的数据
			return orderMapper.getPCOrders(status,calendar.getTime(),limit,offset,search);
		}else{
			calendar.add(Calendar.DAY_OF_MONTH, -14);        //代发货订单默认显示两周内订单
			return orderMapper.getPCOrdersWithOutAdmin(status, calendar.getTime(),limit,offset,search);
		}
	}

	public Long getPCOrdersCount(Short status, String search) {
		Calendar calendar=Calendar.getInstance();

		if(status!=1){
			calendar.add(Calendar.MONTH, -1);
			calendar.set(Calendar.DAY_OF_MONTH, 1);            //设定默认只显示近两个月的数据		
		}else{
			calendar.add(Calendar.DAY_OF_MONTH, -14);        //代发货订单默认显示两周内订单
		}
		
		return orderMapper.getPCOrdersCount(status,calendar.getTime(),search);
	}

	public int setOrderInvalid(Map<String, Object> parameterMap) {
		return orderMapper.setOrderInvalid(parameterMap);
	}

	@Override
	public List<DeliverOrder> selectOrdersByDate(Map<String, Object> paramMap) {
		return orderMapper.selectOrdersByDate(paramMap);
	}

	@Override
	public List<DeliverChildOrder> getAllChildOrders(
			Map<String, Object> paramMap) {
		return orderMapper.getAllChildOrder(paramMap);
	}

	











}
