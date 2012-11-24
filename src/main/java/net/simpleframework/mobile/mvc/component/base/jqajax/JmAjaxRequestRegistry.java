package net.simpleframework.mobile.mvc.component.base.jqajax;

import net.simpleframework.mvc.component.AbstractComponentRegistry;
import net.simpleframework.mvc.component.ComponentBean;
import net.simpleframework.mvc.component.ComponentName;
import net.simpleframework.mvc.component.ComponentRender;
import net.simpleframework.mvc.component.ComponentResourceProvider;

/**
 * 
 * @description TODO(异步组件注册类)
 * @version 0.0.1
 * @author shihb(shihaibin.sea@gmail.com, 13466609192)
 *         http://code.google.com/p/simpleframework/
 *         http://www.simpleframework.net
 * @update 2012-8-23 下午3:49:31
 */
@ComponentName(JmAjaxRequestRegistry.jmAjax)
@ComponentBean(JmAjaxRequestBean.class)
@ComponentRender(JmAjaxRequestRender.class)
@ComponentResourceProvider(JmAjaxRequestResourceProvider.class)
public class JmAjaxRequestRegistry extends AbstractComponentRegistry {
	public static final String jmAjax = "jmAjax";

}
