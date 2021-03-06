class Phone {
	private String manaCom;
	private int price;
	private String dataComuType;
	
	public Phone(String manaCom, int price, String dataComuType) {
		super();
		this.manaCom = manaCom;
		this.price = price;
		this.dataComuType = dataComuType;
	}

	public String getManaCom() {
		return manaCom;
	}

	public void setManaCom(String manaCom) {
		this.manaCom = manaCom;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDataComuType() {
		return dataComuType;
	}

	public void setDataComuType(String dataComuType) {
		this.dataComuType = dataComuType;
	}
	
}

class SmartPhone extends Phone {
	private String osType;
	private Double osVer;
	private int memorySize;
	private boolean camera;
	private boolean Bluetooth;
	
	public SmartPhone(String manaCom, int price, String dataComuType, String osType, Double osVer, int memorySize,
			boolean camera, boolean bluetooth) {
		super(manaCom, price, dataComuType);
		this.osType = osType;
		this.osVer = osVer;
		this.memorySize = memorySize;
		this.camera = camera;
		Bluetooth = bluetooth;
	}

	public String getOsType() {
		return osType;
	}

	public void setOsType(String osType) {
		this.osType = osType;
	}

	public Double getOsVer() {
		return osVer;
	}

	public void setOsVer(Double osVer) {
		this.osVer = osVer;
	}

	public int getMemorySize() {
		return memorySize;
	}

	public void setMemorySize(int memorySize) {
		this.memorySize = memorySize;
	}

	public boolean isCamera() {
		return camera;
	}

	public void setCamera(boolean camera) {
		this.camera = camera;
	}

	public boolean isBluetooth() {
		return Bluetooth;
	}

	public void setBluetooth(boolean bluetooth) {
		Bluetooth = bluetooth;
	}
	
}
public class Ex4_264p_6 {
//	(String manaCom, int price, String dataComuType, String osType, Double osVer, int memorySize,
//			boolean camera, boolean bluetooth)
	public void printAll(Phone a) {
		System.out.println("?????????: "+a.getManaCom());
		System.out.println("??????: "+a.getPrice());
		System.out.println("?????? ??????: "+a.getDataComuType());
		
	}
	
	public void printAll(SmartPhone a) {
		System.out.println("?????????: "+a.getManaCom());
		System.out.println("??????: "+a.getPrice());
		System.out.println("?????? ??????: "+a.getDataComuType());
		System.out.println("???????????? ??????: "+a.getOsType());
		System.out.println("???????????? ??????: "+a.getOsVer());
		System.out.println("????????? ??????: "+a.getMemorySize());
		System.out.println("????????? ??????: "+a.isCamera());
		System.out.println("???????????? ??????: "+a.isBluetooth());
		
	}
	public static void main(String[] args) {
		SmartPhone a=new SmartPhone("a", 10, "a", "a", 3.4, 128, true, true);
		Ex4_264p_6 b=new Ex4_264p_6();
		b.printAll(a);
	}
}
