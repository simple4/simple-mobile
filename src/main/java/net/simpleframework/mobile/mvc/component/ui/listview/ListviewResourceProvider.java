package net.simpleframework.mobile.mvc.component.ui.listview;

import net.simpleframework.mvc.PageParameter;
import net.simpleframework.mvc.component.IComponentRegistry;
import net.simpleframework.mvc.component.IComponentResourceProvider.AbstractComponentResourceProvider;

/**
 * 这是一个开源的软件，请在LGPLv3下合法使用、修改或重新发布。
 * 
 * @title ListviewResourceProvate.java
 * @package net.simpleframework.mobile.mvc.component.ui.listview
 * @description TODO(列表视图资源提供)
 * @author shihb(shihaibin.sea@gmail.com, 13466609192)
 *         http://code.google.com/p/simpleframework/
 *         http://www.simpleframework.net
 * @update 2012-8-31 下午12:26:53
 * @version 0.0.1
 */

public class ListviewResourceProvider extends AbstractComponentResourceProvider {

	public ListviewResourceProvider(final IComponentRegistry componentRegistry) {
		super(componentRegistry);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String[] getCssPath(final PageParameter pParameter) {
		// TODO Auto-generated method stub
		return new String[] { getResourceHomePath() + "/css/listview.css" };
	}

	/**
	 * 组件用的js
	 */
	@Override
	public String[] getJavascriptPath(final PageParameter pParameter) {
		return new String[] { getResourceHomePath() + "/js/waypoints.min.js" };
	}

}
