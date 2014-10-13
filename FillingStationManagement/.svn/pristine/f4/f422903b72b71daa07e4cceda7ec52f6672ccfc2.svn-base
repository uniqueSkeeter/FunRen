

package com.fr.station.component.system.action;


import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;


/**
 * The Class mainly used to check whether the login URL is authorized. Must
 * implements the struts default intercepter.
 * @author henry
 */
public class UserLoginInterceptor implements Interceptor {

    // ------- Constants (static final) ----------------------------------------

    private static final long serialVersionUID = 1593745236481514166L;


    // ------- Static Variables (static) ---------------------------------------

    // ------- Instance Variables (private) ------------------------------------

    // ------- Constructors ----------------------------------------------------

    // ------- Instance Methods (public) ---------------------------------------

    public void destroy() {
    }


    public void init() {
    }


    /**
     * Override the struts default intercept method to implements our own logic
     * to check the input URL whether it's authorized. user only need to login
     * one time if session is not closed. Put the first time login info to
     * session map.
     * @param invocation invocation is the struts default invocation.
     * @return return the execute result
     */
    public String intercept(ActionInvocation invocation) throws Exception {

        ActionContext context = invocation.getInvocationContext();
        HttpServletRequest request = ServletActionContext.getRequest();
        Map<String, Object> session = context.getSession();
        
        String name = context.getName();
        String prePath = null;
        boolean allow = name.equals("customInit");
        if (name.equals("userLogin") || allow) {
            return invocation.invoke();
        }else if(session.isEmpty() || session == null){
            return "login";
        }else if (session.get("userId") != null){
            return invocation.invoke();
        }else {
            // retrieve pre-link
             if (request != null) {
             prePath = request.getScheme() + "://" + request.getServerName()
             + ":" + request.getServerPort() + request.getContextPath()
             + "/";
             }
            session.put("prePage", prePath);
            return "login";
        }
    }

    // ------- Instance Methods (protected) ------------------------------------

    // ------- Instance Methods (private) --------------------------------------

}
