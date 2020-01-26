/**
 * 
 */
package nachos.proj1;

/**
 * @author JOELwindows7
 *
 */
public class File implements Runnable{
	String fileName;
	Integer fileSize;
	String type;
	String content;
	
	public File(String fileName, Integer fileSize, String type) {
		//alt + shift + S + O to auto complete
		super();
		this.fileName = fileName;
		this.fileSize = fileSize;
		this.type = type;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("File Name : " + fileName); //tampilan tidak dinilai
		System.out.println("File Size : " + fileSize);
		System.out.println("Type : " + type);
		System.out.println();
	}
	
	
}
