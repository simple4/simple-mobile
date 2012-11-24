package net.simpleframework.mobile.mvc.component.ui.listview;

import java.util.Iterator;

import net.simpleframework.common.xml.XmlElement;
import net.simpleframework.mvc.PageParameter;
import net.simpleframework.mvc.component.AbstractComponentRegistry;
import net.simpleframework.mvc.component.ComponentBean;
import net.simpleframework.mvc.component.ComponentName;
import net.simpleframework.mvc.component.ComponentRender;
import net.simpleframework.mvc.component.ComponentResourceProvider;

/**
 * 这是一个开源的软件，请在LGPLv3下合法使用、修改或重新发布。
 * 
 * @title ListviewRegistry.java
 * @package net.simpleframework.mobile.mvc.component.ui.listview
 * @description TODO(列表视图注册类)
 * @author shihb(shihaibin.sea@gmail.com, 13466609192)
 *         http://code.google.com/p/simpleframework/
 *         http://www.simpleframework.net
 * @update 2012-8-31 下午12:10:14
 * @version 0.0.1
 */
@ComponentName(ListviewRegistry.listview)
@ComponentBean(ListviewBean.class)
@ComponentRender(ListviewRender.class)
@ComponentResourceProvider(ListviewResourceProvider.class)
public class ListviewRegistry extends AbstractComponentRegistry {

	public static final String listview = "listview";

	@Override
	public ListviewBean createComponentBean(final PageParameter pParameter, final Object data) {
		// TODO Auto-generated method stub
		final ListviewBean listviewBean = (ListviewBean) super.createComponentBean(pParameter, data);
		if (data instanceof XmlElement) {
			final Iterator<?> it = ((XmlElement) data).elementIterator("item");
			while (it.hasNext()) {
				final XmlElement xmlElement = (XmlElement) it.next();
				final ItemBean item = new ItemBean(xmlElement);
				if (ItemBean.Divider.class.getSimpleName().equals(
						xmlElement.attributeValue("className"))) {
					for (final ItemBean.Divider divider : ItemBean.Divider.values()) {
						item.setAttr(divider.name(), xmlElement.attributeValue(divider.name()));
					}
				}
				if (ItemBean.Button.class.getSimpleName()
						.equals(xmlElement.attributeValue("className"))) {
					for (final ItemBean.Button button : ItemBean.Button.values()) {
						item.setAttr(button.name(), xmlElement.attributeValue(button.name()));
					}
				}
				listviewBean.getItems().add(item);
			}
		}
		return listviewBean;
	}

}
