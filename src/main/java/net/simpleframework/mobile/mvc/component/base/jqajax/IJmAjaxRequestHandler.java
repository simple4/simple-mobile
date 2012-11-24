package net.simpleframework.mobile.mvc.component.base.jqajax;

import net.simpleframework.mvc.IForward;
import net.simpleframework.mvc.component.ComponentParameter;
import net.simpleframework.mvc.component.IComponentHandler;

/**
 * 
 * @description TODO(异步处理类)
 * @version 0.0.1
 * @author shihb(shihaibin.sea@gmail.com, 13466609192)
 *         http://code.google.com/p/simpleframework/
 *         http://www.simpleframework.net
 * @update 2012-8-23 下午3:50:26
 */
public interface IJmAjaxRequestHandler extends IComponentHandler {

	IForward ajaxProcess(ComponentParameter compParameter);

}
