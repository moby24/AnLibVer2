package video_package;

/**
 * ����� ��������� ������ � ������ MainVideo
 */
public class Plane {
	private String make;

	private int iconID;
	private String condition;

	public Plane(int iconID, String condition) {
		super();

		this.iconID = iconID;
		this.condition = condition;
	}

	public String getMake() {
		return make;
	}

	public int getIconID() {
		return iconID;
	}

	public String getCondition() {
		return condition;
	}
}
