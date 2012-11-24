package net.simpleframework.mobile.mvc.component.ui.listview;

import net.simpleframework.mvc.PageParameter;
import net.simpleframework.mvc.component.IComponentHandler;

/**
 * 这是一个开源的软件，请在LGPLv3下合法使用、修改或重新发布。
 * 
 * @title IListviewHandle.java
 * @package net.simpleframework.mobile.mvc.component.ui.listview
 * @description TODO(列表视图处理接口)
 * @author shihb(shihaibin.sea@gmail.com, 13466609192)
 *         http://code.google.com/p/simpleframework/
 *         http://www.simpleframework.net
 * @update 2012-8-31 上午11:35:41
 * @version 0.0.1
 */

public interface IListviewHandler extends IComponentHandler {
	/**
	 * 
	 * @param cParameter
	 * @return
	 * @description TODO(生成列表项)
	 * @version 0.0.1
	 * @author shihb
	 * @update 2012-9-6 下午4:17:27
	 */
	Items getItems(PageParameter pParameter);

}
