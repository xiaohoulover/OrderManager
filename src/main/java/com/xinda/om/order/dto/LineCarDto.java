package com.xinda.om.order.dto;

import com.xinda.system.sys.dto.BaseDto;

import java.math.BigDecimal;

/**
 * 订单行上-车辆信息.
 *
 * @Author Coundy.
 * @Date 2017/3/21 16:44.
 */
public class LineCarDto extends BaseDto {
    /**
     * 主键Id.
     */
    private Integer lineCarId;
    /**
     * 订单头Id.
     */
    private Integer salesOrderId;
    /**
     * 车头编号.
     */
    private String carFrontNo;
    /**
     * 车板编号.
     */
    private String carPlateNo;
    /**
     * 司机姓名.
     */
    private String driverName;
    /**
     * 押运人姓名.
     */
    private String escortName;
    /**
     * 运输路径.
     */
    private String shipPath;
    /**
     * 区间路程.
     */
    private BigDecimal distance;
    /**
     * 区间路桥费.
     */
    private BigDecimal roadBridgeFee;
    /**
     * 核定油耗.
     */
    private BigDecimal fuelCosts;
    /**
     * 备注.
     */
    private String remark;
    /**
     * 油耗比.
     */
    private BigDecimal fuelConsumptionRatio;

    public Integer getLineCarId() {
        return lineCarId;
    }

    public void setLineCarId(Integer lineCarId) {
        this.lineCarId = lineCarId;
    }

    public Integer getSalesOrderId() {
        return salesOrderId;
    }

    public void setSalesOrderId(Integer salesOrderId) {
        this.salesOrderId = salesOrderId;
    }

    public String getCarFrontNo() {
        return carFrontNo;
    }

    public void setCarFrontNo(String carFrontNo) {
        this.carFrontNo = carFrontNo == null ? null : carFrontNo.trim();
    }

    public String getCarPlateNo() {
        return carPlateNo;
    }

    public void setCarPlateNo(String carPlateNo) {
        this.carPlateNo = carPlateNo == null ? null : carPlateNo.trim();
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName == null ? null : driverName.trim();
    }

    public String getEscortName() {
        return escortName;
    }

    public void setEscortName(String escortName) {
        this.escortName = escortName == null ? null : escortName.trim();
    }

    public String getShipPath() {
        return shipPath;
    }

    public void setShipPath(String shipPath) {
        this.shipPath = shipPath == null ? null : shipPath.trim();
    }

    public BigDecimal getDistance() {
        return distance;
    }

    public void setDistance(BigDecimal distance) {
        this.distance = distance;
    }

    public BigDecimal getRoadBridgeFee() {
        return roadBridgeFee;
    }

    public void setRoadBridgeFee(BigDecimal roadBridgeFee) {
        this.roadBridgeFee = roadBridgeFee;
    }

    public BigDecimal getFuelCosts() {
        return fuelCosts;
    }

    public void setFuelCosts(BigDecimal fuelCosts) {
        this.fuelCosts = fuelCosts;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public BigDecimal getFuelConsumptionRatio() {
        return fuelConsumptionRatio;
    }

    public void setFuelConsumptionRatio(BigDecimal fuelConsumptionRatio) {
        this.fuelConsumptionRatio = fuelConsumptionRatio;
    }
}
