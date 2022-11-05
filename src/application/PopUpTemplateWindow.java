package application;

public class PopUpTemplateWindow {
	protected String title = "Pop up";
	protected String message = "Are you sure?";
	protected Runnable onConfirm = ()->{};
	protected Runnable onDecline= ()->{};
	public PopUpTemplateWindow() {
		this.title = "Pop up";
		this.message = "Are you sure?";
	}
	public PopUpTemplateWindow(String title, String message) {
		this.title = title;
		this.message = message;
	}
	public void setOnConfirm(Runnable onCofirmRunnable) {
		onConfirm = onCofirmRunnable;
	}
	public void setOnDecline(Runnable onDeclineRunnable) {
		onDecline = onDeclineRunnable;
	}
	public Runnable getOnConfirm() {
		return onConfirm;
	}
	public Runnable getOnDecline() {
		return onDecline;
	}
	public String getTitle() {
		return this.title;
	}
	public String getMessage() {
		return this.message;
	}
}
