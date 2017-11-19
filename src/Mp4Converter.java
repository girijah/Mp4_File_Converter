import javax.swing.*;
import java.io.File;


public class Mp4Converter {

	public static void main(String[] args) {
		boolean isConverted = false;
		int userResult = JOptionPane.showConfirmDialog(null, "Do you allow accessing New folder in your computer desktop?", "Easy Mp4 Converter", JOptionPane.YES_NO_OPTION);

		if(userResult==0) {

			String userHomePath = System.getProperty("user.home");
			userHomePath = userHomePath + "\\Desktop\\New folder";

			File folder = new File(userHomePath);

			if (folder.exists()) {

				File[] fileArray = folder.listFiles();

				if (fileArray.length > 0) {

					for (int i = 0; i < fileArray.length; i++) {
						if (fileArray[i].isFile()) {

							File oldFile = fileArray[i];
							String fileName = oldFile.getName();

							if (fileName.contains(".")) {

								if (fileName.contains("mp4")) {
									System.out.println("not renamed file: " + fileName);
								}
							} else {
								isConverted = true;
								String renamedFilename = fileName.replace(fileName, fileName + ".mp4");
								File newFileDestination = new File(userHomePath + "\\" + renamedFilename);
								oldFile.renameTo(newFileDestination);
								System.out.println("renamed file: " + renamedFilename);
							}

						}
					}
					if (isConverted) {
						JOptionPane.showMessageDialog(null, fileArray.length + " files converted to .mp4 files. Thanks for using our service!");
					} else {
						JOptionPane.showMessageDialog(null, "No raw files found!");
					}
				}
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "Application stopped!");
		}
	}

}
