package GUI;

import java.io.File; 
import java.util.Hashtable; 
import com.google.zxing.BarcodeFormat; 
import com.google.zxing.EncodeHintType; 
import com.google.zxing.MultiFormatWriter; 
import com.google.zxing.common.BitMatrix; 

public class testQR {
	   
    /**
     * @param args
     * @throws Exception 
     */ 
    public static void main(String[] args) throws Exception { 
        String text = "you need 3 yuan"; 
        int width = 300; 
        int height = 300; 
        //二维码的图片格式 
        String format = "jpg"; 
        Hashtable hints = new Hashtable(); 
        //内容所使用编码 
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8"); 
        BitMatrix bitMatrix = new MultiFormatWriter().encode(text, 
                BarcodeFormat.QR_CODE, width, height, hints); 
        //生成二维码 
        File outputFile = new File("C:\\Users\\dccif\\Documents\\Work"+File.separator+"new.jpg"); 
        QRUtil.writeToFile(bitMatrix, format, outputFile); 
    } 
}
