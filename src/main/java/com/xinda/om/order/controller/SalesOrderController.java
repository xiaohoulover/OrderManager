package com.xinda.om.order.controller;

import com.xinda.om.order.dto.SalesOrder;
import com.xinda.om.order.service.ISalesOrderService;
import com.xinda.system.sys.contant.BaseConstants;
import com.xinda.system.sys.controller.BaseController;
import com.xinda.system.sys.dto.ResponseJsonData;
import com.xinda.system.sys.exception.OrderException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 订单管理Controller.
 *
 * @Author Coundy.
 * @Date 2017/3/21 17:09
 */
@Controller
public class SalesOrderController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(SalesOrderController.class);

    @Autowired
    private ISalesOrderService salesOrderService;

    @RequestMapping("/home.html")
    public ModelAndView seletOrderNumFromHome() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/home");
        mv.addObject("orders", salesOrderService.selectOrderNumFromHome());
        return mv;
    }

    /**
     * 保存订单信息.
     *
     * @param order    订单对象.
     * @param isSubmit 是否是提交
     * @return 保存或提交订单信息
     */
    @RequestMapping("/om/saveOrder")
    @ResponseBody
    public ResponseJsonData saveOrSubmitOrder(HttpServletRequest request,
                                              HttpServletResponse response,
                                              @RequestBody SalesOrder order,
                                              boolean isSubmit) throws OrderException {
        return new ResponseJsonData(salesOrderService.saveSalesOrder(order, isSubmit));
    }

    /**
     * 查询页-根据参数条件查询订单信息(带分页).
     *
     * @param page     页码
     * @param pagesize 每页显示条数
     * @param order    订单对象
     * @return
     */
    @RequestMapping("/om/selectOrdersByParms")
    @ResponseBody
    public ResponseJsonData selectOrdersByParms(@RequestParam(defaultValue = BaseConstants.DEFAULT_PAGE_NUM) int page,
                                                @RequestParam(defaultValue = BaseConstants.DEFAULT_PAGE_SIZE) int pagesize,
                                                SalesOrder order) throws OrderException {
        return new ResponseJsonData(salesOrderService.selectOrdersByParms(page, pagesize, order));
    }

    /**
     * 获取订单详情.
     *
     * @param orderId 订单Id
     * @return
     */
    @RequestMapping("/om/getOrderDetails")
    @ResponseBody
    public SalesOrder getOrderDetails(Integer orderId) throws OrderException {
        return salesOrderService.selectOrderDetails(orderId);
    }

    /**
     * 删除订单.
     *
     * @param request
     * @param response
     * @param orders
     */
    @RequestMapping("/om/deleteOrder")
    @ResponseBody
    public ResponseJsonData deleteOrder(HttpServletRequest request, HttpServletResponse response,
                                        @RequestBody List<SalesOrder> orders) throws Exception {
        salesOrderService.deleteOrders(orders);
        return new ResponseJsonData(true);
    }

    /**
     * 根据参数条件查询订单信息.
     *
     * @param order 订单对象
     * @return
     */
    @RequestMapping("/om/queryOrdersByParms")
    @ResponseBody
    public List<SalesOrder> queryOrdersByParms(SalesOrder order) throws OrderException {
        return salesOrderService.queryOrdersByParms(order);
    }

}
