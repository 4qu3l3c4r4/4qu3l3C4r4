package report;


import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import com.aspose.words.Document;
import com.aspose.words.DocumentBuilder;
import com.aspose.words.WrapType;

import managers.FileReaderManager;
import util.Constants;

public class Doc {

	public Doc(ArrayList<?> array) throws Exception {
		int verticalPosition = 0;
		String dataPath = Constants.DOC_PATH;
		DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH-mm-ss");
		Date date = new Date();
		Document doc = new Document();
		DocumentBuilder builder = new DocumentBuilder(doc);

		
		for (int i = 0; i < array.size(); i++) {
			String imagePath = (String) array.get(i);
			//builder.insertImage(imagePath, -1000, -40, 0, verticalPosition, 500, 300, WrapType.SQUARE);
			FileInputStream in = new FileInputStream(imagePath);
			builder.insertImage(in,500,200);

			verticalPosition = verticalPosition + 400;
		}
		doc.save(dataPath + dateFormat.format(date) + ".docx");
	}
}
