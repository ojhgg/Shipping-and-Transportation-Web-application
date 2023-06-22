package com;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mapper.BillingMapper;
import com.mapper.ParcelMapper;
import com.mapper.ShipmentMapper;
import com.pojo.Billing;
import com.pojo.Parcel;
import com.pojo.Shipment;
import com.service.OrderService;
import com.vo.R;
import com.vo.param.CreateOrderParam;
import com.vo.param.Parcels;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
@RunWith(MockitoJUnitRunner.class)
class OrderServiceTest {

    @Mock
    private ParcelMapper parcelMapper;

    @Mock
    private ShipmentMapper shipmentMapper;

    @Mock
    private BillingMapper billingMapper;

    @InjectMocks
    private OrderService orderService;

    @Test
    public void testCreateOrderWithExistingParcel() {
        // 准备数据
        CreateOrderParam createOrderParam = new CreateOrderParam();
        Parcels parcels = new Parcels();
        parcels.setParcelsid("123");
        createOrderParam.setParcels(parcels);

        QueryWrapper<Parcel> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("parcelsid", "123");
        when(parcelMapper.exists(queryWrapper)).thenReturn(true);

        // 执行方法
        R result = orderService.createOrder(createOrderParam, "123");

        // 验证结果
        assertFalse((Boolean) result.getData().get("status_code"));
        assertEquals("包裹已存在", result.getMessage());
    }

    @Test
    public void testCreateOrder() {
        // 准备数据
        CreateOrderParam createOrderParam = new CreateOrderParam();
        Parcels parcels = new Parcels();
        Parcel parcel=new Parcel();
        parcels.setParcelsid("123");
        parcels.setDescription("test");
        parcels.setWeight("1.0");
        parcels.setQuantity("1");
        parcels.setBoxtype("box");
        parcel.setParcelsid("123");
        parcel.setDescription("test");
        parcel.setWeight("1.0");
        parcel.setQuantity("1");
        parcel.setBoxtype("box");
        createOrderParam.setParcels(parcels);
        createOrderParam.setReturnto("returnto");
        createOrderParam.setShipfrom("shipfrom");
        createOrderParam.setShipto("shipto");
        createOrderParam.setType("type");

        Billing billing = new Billing();
        billing.setAccountNumber("123");
        billing.setType("type");
        billing.setPaidBy("123");

        Shipment shipment = new Shipment();
        shipment.setParcels("123");
        shipment.setReturnTo("returnto");
        shipment.setShipfrom("shipfrom");
        shipment.setShipto("shipto");
        shipment.setServicetype("type");

        when(shipmentMapper.insert(shipment)).thenReturn(1);
        when(billingMapper.insert(billing)).thenReturn(1);
        when(parcelMapper.insert(parcel)).thenReturn(1);

        // 执行方法
        R result = orderService.createOrder(createOrderParam, "123");

        // 验证结果
        assertTrue((Boolean) result.getData().get("status_code"));
    }
}
