package net.simpleframework.mobile.mvc.component.base.jqajax;

import net.simpleframework.common.coll.KVMap;
import net.simpleframework.mvc.IForward;
import net.simpleframework.mvc.JavascriptForward;
import net.simpleframework.mvc.JsonForward;
import net.simpleframework.mvc.component.ComponentParameter;

/**
 * 
 * @description TODO(异步)
 * @version 0.0.1
 * @author shihb(shihaibin.sea@gmail.com, 13466609192)
 *         http://code.google.com/p/simpleframework/
 *         http://www.simpleframework.net
 * @update 2012-8-23 下午3:56:37
 */
public class JmAjaxRequestUtils extends AbstractRequestUtils {

	public final static JmAjaxRequestUtils ajaxRequestUtils = new JmAjaxRequestUtils();

	@Override
	public String jsonString(IForward forward, final ComponentParameter compParameter,
			final boolean callback, final KVMap json) {
		if (forward == null) {
			final IJmAjaxRequestHandler ajaxRequestHandle = (IJmAjaxRequestHandler) compParameter
					.getComponentHandler();
			if (ajaxRequestHandle != null) {
				forward = ajaxRequestHandle.ajaxProcess(compParameter);
			}
		}
		final String responseText = forward != null ? forward.getResponseText(compParameter) : "";
		json.add("rt", responseText.replace("\t", ""));
		json.add("cb", callback);
		json.add("isJSON", forward instanceof JsonForward);
		json.add("isJavascript", forward instanceof JavascriptForward);
		return json.toJSON();

	}

	public static AbstractRequestUtils getRequestUtils() {
		return ajaxRequestUtils;
	}

}
