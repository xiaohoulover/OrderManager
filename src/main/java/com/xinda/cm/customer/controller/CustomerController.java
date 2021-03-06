package com.xinda.cm.customer.controller;

import com.xinda.cm.customer.dto.Customer;
import com.xinda.cm.customer.dto.CustomerType;
import com.xinda.cm.customer.service.ICustomerService;
import com.xinda.om.order.dto.LineCustomer;
import com.xinda.system.sys.contant.BaseConstants;
import com.xinda.system.sys.controller.BaseController;
import com.xinda.system.sys.dto.ResponseJsonData;
import com.xinda.system.sys.exception.CustomerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 客户处理Controller.
 *
 * @Author Coundy.
 * @Date 2017/4/6
 */
@Controller
@RequestMapping("/customer")
public class CustomerController extends BaseController {

    @Autowired
    private ICustomerService customerService;

    /**
     * 查询所有的客户信息.
     *
     * @return
     */
    @RequestMapping(value = "/queryAllCustomers", method = RequestMethod.POST)
    @ResponseBody
    public List<Customer> queryCustomersByParams(HttpServletRequest request,
                                                 HttpServletResponse response,
                                                 Customer customer) {
        return customerService.queryCustomersByParams(customer);
    }

    /**
     * 保存客户信息.
     *
     * @param customer 客户对象信息
     * @return
     */
    @RequestMapping(value = "/saveCustomer", method = RequestMethod.POST)
    @ResponseBody
    public ResponseJsonData saveCustomer(@RequestBody Customer customer) {
        return new ResponseJsonData(customerService.saveCustomer(customer));
    }

    /**
     * 根据customerId获取Customer详情.
     *
     * @param customerId
     * @return
     * @throws CustomerException 客户统一异常
     */
    @RequestMapping(value = "/getCustomerDetails", method = RequestMethod.GET)
    @ResponseBody
    public Customer getCustomerDetails(Integer customerId) throws CustomerException {
        return customerService.getCustomerDetails(customerId);
    }

    /**
     * 根据参数条件查询客户信息.
     *
     * @param customerType 客户类型参数对象
     * @return
     */
    @RequestMapping(value = "/selectCustomerByParms", method = RequestMethod.POST)
    @ResponseBody
    public ResponseJsonData selectCustomerByParms(@RequestParam(defaultValue = BaseConstants.DEFAULT_PAGE_NUM) int page,
                                                  @RequestParam(defaultValue = BaseConstants.DEFAULT_PAGE_SIZE) int pagesize,
                                                  CustomerType customerType) {
        return new ResponseJsonData(customerService.selectCustomerByParms(page, pagesize, customerType));
    }

    /**
     * 删除客户类型信息.
     *
     * @param customerTypes 参数对象
     * @return
     */
    @RequestMapping(value = "/deleteCustomerType", method = RequestMethod.POST)
    @ResponseBody
    public ResponseJsonData deleteCustomerType(@RequestBody List<CustomerType> customerTypes) {
        customerService.deleteCustomerType(customerTypes);
        return new ResponseJsonData(true);
    }

    /**
     * 删除客户信息.
     *
     * @param customerId 对象Id
     * @return
     */
    @RequestMapping(value = "/deleteCustomer", method = RequestMethod.POST)
    @ResponseBody
    public ResponseJsonData deleteCustomer(Integer customerId) {
        customerService.deleteCustomer(customerId);
        return new ResponseJsonData(true);
    }

    /**
     * 查询所有的订单上客户名称.
     *
     * @return
     */
    @RequestMapping(value = "/queryAllLineCustomers", method = RequestMethod.POST)
    @ResponseBody
    public List<LineCustomer> queryAllLineCustomers(HttpServletRequest request,
                                                    HttpServletResponse response,
                                                    LineCustomer lineCustomer) {
        return customerService.queryAllLineCustomers(lineCustomer);
    }

}
