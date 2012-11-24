package net.simpleframework.mobile.mvc.component.ui.listview;

import net.simpleframework.common.xml.XmlElement;
import net.simpleframework.mvc.PageDocument;
import net.simpleframework.mvc.component.AbstractContainerBean;

/**
 * 这是一个开源的软件，请在LGPLv3下合法使用、修改或重新发布。
 * 
 * @title ListviewBean.java
 * @package net.simpleframework.mobile.mvc.component.ui.listview
 * @description TODO(列表视图bean)
 * @author shihb(shihaibin.sea@gmail.com, 13466609192)
 *         http://code.google.com/p/simpleframework/
 *         http://www.simpleframework.net
 * @update 2012-8-31 上午10:28:26
 * @version 0.0.1
 */

public class ListviewBean extends AbstractContainerBean {

	public ListviewBean(final PageDocument pageDocument, final XmlElement xmlElement) {
		super(pageDocument, xmlElement);
		// TODO Auto-generated constructor stub
	}

	private Items items;// 列表

	private String countTheme;// 统计样式 (a-z) 对应于item中bubble_Text的样式

	private String headerTheme;// 官方列出该属性但没看出效果,官方没找到相关效果实例.

	private String dividerTheme; // 分割栏样式 (a-z)

	private Boolean filter;// 是否带过滤条

	private String filterPlaceholder;// 过滤框初始提示

	private String filterTheme;// 过滤条样式

	private String splitIcon;// 分隔按钮图标 覆盖item.button下icon

	private String splitTheme;// 分隔按钮样式

	private String theme;// 样式

	private Boolean inset;// 嵌入

	private Boolean isRead;// 是否只读

	private String jsonUri;// 异步url 返回Items的json数据

	private String jsonUriData;// 异步url参数如:first=1&max=10

	private String offset;// 滚动程度 如 100% 滚动目标高度100% 后出发

	public Items getItems() {
		if (items == null) {
			items = Items.of();
		}
		return items;
	}

	public ListviewBean setItems(final Items items) {
		this.items = items;
		return this;
	}

	public String getTheme() {
		return theme;
	}

	public ListviewBean setTheme(final String theme) {
		this.theme = theme;
		return this;
	}

	public Boolean getInset() {
		return inset;
	}

	public ListviewBean setInset(final Boolean inset) {
		this.inset = inset;
		return this;
	}

	public Boolean getIsRead() {
		return isRead;
	}

	public ListviewBean setIsRead(final Boolean isRead) {
		this.isRead = isRead;
		return this;
	}

	public Boolean getFilter() {
		return filter;
	}

	public ListviewBean setFilter(final Boolean filter) {
		this.filter = filter;
		return this;
	}

	public String getCountTheme() {
		return countTheme;
	}

	public ListviewBean setCountTheme(final String theme) {
		this.countTheme = theme;
		return this;
	}

	public String getDividerTheme() {
		return dividerTheme;
	}

	public ListviewBean setDividerTheme(final String theme) {
		this.dividerTheme = theme;
		return this;
	}

	public String getFilterPlaceholder() {
		return filterPlaceholder;
	}

	public ListviewBean setFilterPlaceholder(final String filterPlaceholder) {
		this.filterPlaceholder = filterPlaceholder;
		return this;
	}

	public String getFilterTheme() {
		return filterTheme;
	}

	public ListviewBean setFilterTheme(final String theme) {
		this.filterTheme = theme;
		return this;
	}

	public String getHeaderTheme() {
		return headerTheme;
	}

	public ListviewBean setHeaderTheme(final String headerTheme) {
		this.headerTheme = headerTheme;
		return this;
	}

	public String getSplitIcon() {
		return splitIcon;
	}

	public ListviewBean setSplitIcon(final String icon) {
		this.splitIcon = icon;
		return this;
	}

	public String getSplitTheme() {
		return splitTheme;
	}

	public ListviewBean setSplitTheme(final String theme) {
		this.splitTheme = theme;
		return this;
	}

	public String getJsonUri() {
		return jsonUri;
	}

	public String getOffset() {
		return offset;
	}

	public ListviewBean setOffset(final String offset) {
		this.offset = offset;
		return this;
	}

	/**
	 * 
	 * @param jsonUri
	 * @return
	 * @description TODO(异步url 连接结果Items的json数据 )
	 * @version 0.0.1
	 * @author shihb
	 * @update 2012-9-10 下午12:53:57
	 */
	public ListviewBean setJsonUri(final String jsonUri) {
		this.jsonUri = jsonUri;
		return this;
	}

	public String getJsonUriData() {
		return jsonUriData;
	}

	/**
	 * 
	 * @param jsonUriData
	 * @return
	 * @description TODO(异步url参数如:first=1&max=10)
	 * @version 0.0.1
	 * @author shihb
	 * @update 2012-9-10 下午12:54:00
	 */

	public ListviewBean setJsonUriData(final String jsonUriData) {
		this.jsonUriData = jsonUriData;
		return this;
	}

}
