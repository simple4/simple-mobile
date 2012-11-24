package net.simpleframework.mobile.mvc.template;

@SuppressWarnings("unchecked")
public class JmTextInput<T extends JmTextInput<T>> extends JmInput<T> {
	private static final long serialVersionUID = 1L;

	private String label;

	public JmTextInput(final String name) {
		super(Type.text, name);
	}

	public JmTextInput(final String name, final String label) {
		super(Type.text, name);
		this.setLabel(label);
	}

	protected JmTextInput(final Type type, final String name, final String label) {
		super(type, name);
		this.setLabel(label);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		final StringBuilder sb = new StringBuilder();
		sb.append("<label>");
		sb.append(label);
		sb.append("</label>");
		sb.append(super.toString());
		return sb.toString();
	}

	public T setLabel(final String label) {
		this.label = label;
		return (T) this;
	}

	public String getLabel() {
		return label;
	}

}
