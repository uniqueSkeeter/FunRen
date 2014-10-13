package com.fr.station.component.system.action;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.fr.station.common.bean.report.EmployeeBean;
import com.fr.station.common.data.DataCollections;
import com.fr.station.common.utility.DateJsonValueProcessor;
import com.fr.station.common.utility.DateUtil;
import com.fr.station.common.utility.ErrorLogUtil;
import com.fr.station.component.system.service.EmployeeService;

/**
 * The action for dashboard. It handles the user request from the web page.
 * 
 * 
 * @author henry
 */
@Namespace("/employee")
@ParentPackage("custom-default")
public class EmployeeAction extends AbstractAction implements SessionAware{
	
	// ------- Constants (static final) ----------------------------------------
	
	private static final long serialVersionUID = 1L;
	
	private static Logger log = Logger.getLogger(EmployeeAction.class);
	
	// ------- Static Variables (static) ---------------------------------------

	// ------- Instance Variables (private) ------------------------------------

	private List<EmployeeBean> employeeList = new ArrayList<EmployeeBean>();
	
	@Autowired
	private Properties properties;
	
    @Autowired
    protected EmployeeService employeeService;
	
	private Map<String, Object> session;
	
	private EmployeeBean employeeBean = new EmployeeBean();
	
    private String jsonData;
    
	// ------- Constructors ----------------------------------------------------
    
	public EmployeeAction() {
		super();
	}
    
	// ------- Instance Methods (public) ---------------------------------------
	
    @Action(value = "employeeInit", results = {
            @Result(name = "success", location = "/view/card/employee/employeeList.jsp"),
            @Result(name = "error", location = "/view/login.jsp") })
        public String employeeInit() {
		try {
		} catch (Exception e) {
			log.info(ErrorLogUtil.printInfo(e));
		}
        return SUCCESS;
        }

	/**
	 * 
	 * receive the request from http and handle the request to dispatch different ways based on the parameters
	 * 
	 * @param 
	 * @return dashboard jsp
	 * @throws com.fr.station.card.ICCard.exception.ICCardException 
	 */
	@Action(value="showUser", results={
				@Result(name="success",  type = "json"),
	           })
	public String showUser() {
		log.info("Starting to load employee infomation from DB");
		Map<String,Object> map=new HashMap<String,Object>();
		boolean flag = false;
		try {
			employeeList = this.employeeService.getEmplByFormCondition(this.employeeBean);
			if(!employeeList.isEmpty()){
				JsonConfig config = new JsonConfig();
				config.registerJsonValueProcessor(Timestamp.class, new DateJsonValueProcessor(
			            DateUtil.DATE_PATTERN_2));
				map.put("total", employeeList.size());
				map.put("rows", employeeList);
				this.jsonData = JSONObject.fromObject(map).toString();
			}else{
				this.jsonData = null;
			}
			flag = true;
		}catch (net.sf.json.JSONException e) {
			log.info("Convert to Json object occured error, please references the detail log\n " + "["
					+  e + "]\n" + ErrorLogUtil.printInfo(e));
		}catch (Exception e) {
			log.info("Loading employee data from DB occured error, please references the detail log\n " + "[" 
					+  e + "]\n" + ErrorLogUtil.printInfo(e));
			return ERROR;
		}
		if(flag){
			log.info("Successfully load employee data from DB");
			return SUCCESS;
		}
		return ERROR;
	}
	
	/**
	 * 
	 * receive the request from http and handle the request to dispatch different ways based on the parameters
	 * 
	 * @param 
	 * @return dashboard jsp
	 * @throws com.fr.station.card.ICCard.exception.ICCardException 
	 */
	@Action(value="saveUser", results={
				@Result(name = "success",type = "json"),
	           })
	public String saveUser() {
		log.info("Starting to save employee infomation into DB");
		boolean flag = true;
		try {
			this.employeeService.addEmployee(this.employeeBean);
		} catch (Exception e) {
			log.info("Loading employee data from DB occured error, please references the detail log\n " + "[" 
					+  e + "]\n" + ErrorLogUtil.printInfo(e));
			return ERROR;
		}
		if(flag){
			log.info("Successfully save employee data into DB");
			return SUCCESS;
		}
		return ERROR;
	}
	
	/**
	 * 
	 * receive the request from http and handle the request to dispatch different ways based on the parameters
	 * 
	 * @param 
	 * @return dashboard jsp
	 * @throws com.fr.station.card.ICCard.exception.ICCardException 
	 */
	@Action(value = "refreshUserData", results = {
            @Result(name = "success", location = "/view/card/employee/employeeAdd.jsp"),
            })
	public String refreshUserData() {
		log.info("Starting to transfer employee data");
		boolean flag = false;
		try {
			employeeList = this.employeeService.getEmplByFormCondition(this.getEmployeeBean());
			if(employeeList.size() > 0){
				employeeBean = employeeList.get(0);
			}
			flag = true;
		} catch (Exception e) {
			log.info("transfer employee data occured error, please references the detail log\n "
					+ "[" +  e + "]\n" + ErrorLogUtil.printInfo(e));
			return ERROR;
		}
		if(flag){
			log.info("Successfully transfer employee data");
			return SUCCESS;
		}
		return ERROR;
	}
	
	/**
	 * 
	 * receive the request from http and handle the request to dispatch different ways based on the parameters
	 * mainly to receive the requst to handle employee role info
	 * @param 
	 * @return dashboard jsp
	 * @throws com.fr.station.card.ICCard.exception.ICCardException 
	 */
	@Action(value = "transferData", results = {
            @Result(name = "success", location = "/view/card/employee/employeeRole.jsp"),
            })
	public String transferData() {
		log.info("Starting to transfer employee data");
		boolean flag = false;
		try {
			String shiftType = new String(this.getEmployeeBean().getShiftType().getBytes("iso-8859-1"),"utf-8");
			this.getEmployeeBean().setShiftType(shiftType);
			flag = true;
		} catch (Exception e) {
			log.info("transfer employee data occured error, please references the detail log\n "
					+ "[" +  e + "]\n" + ErrorLogUtil.printInfo(e));
			return ERROR;
		}
		if(flag){
			log.info("Successfully transfer employee data");
			return SUCCESS;
		}
		return ERROR;
	}
	
	/**
	 * 
	 * receive the request from http and handle the request to dispatch different ways based on the parameters
	 * 
	 * @param 
	 * @return dashboard jsp
	 * @throws com.fr.station.card.ICCard.exception.ICCardException 
	 */
	@Action(value = "updateUser", results={@Result(name="success",  type = "json"),
										   @Result(name = "error", location = "/view/card/employee/employeeRole.jsp")})
	public String updateUser() {
		log.info("Starting to update employee data");
		boolean flag = false;
		try {
			this.employeeService.updateEmployee(employeeBean, this.getEmployeeBean().getShiftType(),
					this.getEmployeeBean().getId());
			flag = true;
		} catch (Exception e) {
			log.info("update employee data occured error, please references the detail log\n "
					+ "[" +  e + "]\n" + ErrorLogUtil.printInfo(e));
			return ERROR;
		}
		if(flag){
			log.info("Successfully update employee data");
			return SUCCESS;
		}
		return ERROR;
	}
	
	public List<EmployeeBean> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List<EmployeeBean> employeeList) {
		this.employeeList = employeeList;
	}

	public EmployeeBean getEmployeeBean() {
		return employeeBean;
	}

	public void setEmployeeBean(EmployeeBean employeeBean) {
		this.employeeBean = employeeBean;
	}

	public String getJsonData() {
		return jsonData;
	}

	public void setJsonData(String jsonData) {
		this.jsonData = jsonData;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
		
	}

	// ------- Instance Methods (protected) ------------------------------------

	// ------- Instance Methods (private) --------------------------------------
	
}