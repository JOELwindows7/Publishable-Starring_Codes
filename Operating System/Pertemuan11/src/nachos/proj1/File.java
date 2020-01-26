package nachos.proj1;

public class File implements Runnable{

	String fileName;
	Integer fileSize;
	String type;
	
	//alt + shift + s + o
	public File(String fileName, Integer fileSize, String type) {
		super();
		this.fileName = fileName;
		this.fileSize = fileSize;
		this.type = type;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("File Name : " + fileName);
		System.out.println("File Size : " + fileSize);
		System.out.println("Type : " + type);
		System.out.println();
	}
	
	
	
}
