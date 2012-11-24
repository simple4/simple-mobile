package net.simpleframework.mobile.mvc.component.ui.listview;

import net.simpleframework.common.coll.ArrayListEx;

/**
 * 这是一个开源的软件，请在LGPLv3下合法使用、修改或重新发布。
 * 
 * @title Items.java
 * @package net.simpleframework.mobile.mvc.component.ui.listview
 * @description TODO(列表项集合)
 * @author shihb(shihaibin.sea@gmail.com, 13466609192)
 *         http://code.google.com/p/simpleframework/
 *         http://www.simpleframework.net
 * @update 2012-8-31 上午11:45:47
 * @version 0.0.1
 */

public class Items extends ArrayListEx<Items, ItemBean> {

	public static Items of(final ItemBean... items) {
		return new Items().append(items);
	}

	/**
	 * @fields serialVersionUID
	 * @author shihb
	 * @update 2012-8-31 上午11:47:05
	 */

	private static final long serialVersionUID = -2665611316766466949L;

}
