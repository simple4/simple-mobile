package net.simpleframework.mobile.mvc.component.base.jqajax;

import net.simpleframework.mvc.PageParameter;
import net.simpleframework.mvc.component.IComponentRegistry;
import net.simpleframework.mvc.component.IComponentResourceProvider.AbstractComponentResourceProvider;

/**
 * 
 * @description TODO(异步组件资源提供类)
 * @version 0.0.1
 * @author shihb(shihaibin.sea@gmail.com, 13466609192)
 *         http://code.google.com/p/simpleframework/
 *         http://www.simpleframework.net
 * @update 2012-8-23 下午3:55:57
 */
public class JmAjaxRequestResourceProvider extends AbstractComponentResourceProvider {

	public JmAjaxRequestResourceProvider(final IComponentRegistry componentRegistry) {
		super(componentRegistry);
	}

	/**
	 * 组件用的js
	 */
	@Override
	public String[] getJavascriptPath(final PageParameter pParameter) {
		return new String[] { getResourceHomePath() + "/js/map.js",
				getResourceHomePath() + "/js/ajaxrequest.js" };
	}

}
