package net.simpleframework.mobile.mvc.component.base.jqajax;

import net.simpleframework.mvc.IForward;
import net.simpleframework.mvc.MVCUtils;
import net.simpleframework.mvc.UrlForward;
import net.simpleframework.mvc.component.AbstractComponentHandler;
import net.simpleframework.mvc.component.ComponentParameter;

/**
 * 
 * @description TODO(默认异步处理类)
 * @version 0.0.1
 * @author shihb(shihaibin.sea@gmail.com, 13466609192)
 *         http://code.google.com/p/simpleframework/
 *         http://www.simpleframework.net
 * @update 2012-8-23 下午3:51:30
 */
public class DefaultJmAjaxRequestHandler extends AbstractComponentHandler implements
		IJmAjaxRequestHandler {
	public static final String JK_ERROR = "error";

	@Override
	public IForward ajaxProcess(final ComponentParameter cParameter) {
		return null;
	}

	public IForward doUrlForward(final ComponentParameter cParameter) {
		return new UrlForward(MVCUtils.doPageUrl(cParameter,
				((JmAjaxRequestBean) cParameter.componentBean).getUrlForward()));
	}
}
