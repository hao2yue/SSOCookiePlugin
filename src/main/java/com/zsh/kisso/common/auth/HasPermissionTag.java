
package com.zsh.kisso.common.auth;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

import com.zsh.kisso.SSOConfig;
import com.zsh.kisso.SSOHelper;
import com.zsh.kisso.security.token.SSOToken;

/**
 * <p>
 * JSP 权限判断标签
 * </p>
 * <p>
 * 使用 JSP 引用：<%@ taglib prefix="kisso" uri="http://kisso.baomidou.com/tags"%><br>
 * <kisso:hasPermission name="需要验证的内容">判断内容<kisso:hasPermission><br>
 * </p>
 *
 * @author zhaoshihao
 * @since 2016-12-15
 */
public class HasPermissionTag extends BodyTagSupport {

    private String name; // 权限码名称

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int doStartTag() throws JspException {
        // 在标签开始处出发该方法
        HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
        SSOToken token = SSOHelper.getSSOToken(request);
        // 如果 token 或者 name 为空
        if (token != null && this.getName() != null && !"".equals(this.getName().trim())) {
            boolean result = SSOConfig.getInstance().getAuthorization().isPermitted(token, this.getName());
            if (result) {
                // 权限验证通过
                // 返回此则执行标签body中内容，SKIP_BODY则不执行
                return BodyTagSupport.EVAL_BODY_INCLUDE;
            }
        }
        return BodyTagSupport.SKIP_BODY;
    }

}
